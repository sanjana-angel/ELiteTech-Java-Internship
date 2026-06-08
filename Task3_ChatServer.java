import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * Chat Server
 * Accepts multiple client connections.
 */

public class Task3_ChatServer {

    public static ArrayList<Task3_ClientHandler> clients =
            new ArrayList<>();

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket =
                    new ServerSocket(5000);

            System.out.println("Server Started...");
            System.out.println("Waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New Client Connected");

                Task3_ClientHandler clientHandler =
                        new Task3_ClientHandler(socket);

                clients.add(clientHandler);

                Thread thread =
                        new Thread(clientHandler);

                thread.start();
            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}