
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 5000; // Port number for communication
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is waiting for a connection...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Read file content
            File file = new File("A.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }

            // Close resources
            reader.close();
            out.close();
            socket.close();
            System.out.println("File sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
