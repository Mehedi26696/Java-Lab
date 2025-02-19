
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change if needed
        int port = 5000; // Same port as server

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(new FileWriter("B.txt"))) {

            System.out.println("Connected to the server. Receiving file...");

            String line;
            while ((line = in.readLine()) != null) {
                writer.println(line);
            }

            System.out.println("File received and saved as B.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
