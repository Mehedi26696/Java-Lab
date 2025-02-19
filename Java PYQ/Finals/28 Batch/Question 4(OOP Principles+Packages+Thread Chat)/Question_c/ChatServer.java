import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 7777;
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat Server started...");
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            new ServerInputHandler().start(); // Start server-side input handling
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles messages from clients
    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);
                    broadcast("Client: " + message);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected.");
            } finally {
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }

    // Server can send messages to all clients
    static class ServerInputHandler extends Thread {
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String serverMessage = scanner.nextLine();
                broadcastFromServer("Server: " + serverMessage);
            }
        }

        private void broadcastFromServer(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }


    }
}

