import java.io.*;
import java.net.Socket;

/*
 * Handles each client connection
 * using a separate thread.
 */

public class Task3_ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Task3_ClientHandler(Socket socket) {

        try {

            this.socket = socket;

            reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            writer = new PrintWriter(
                    socket.getOutputStream(), true);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    @Override
    public void run() {

        String message;

        try {

            while ((message = reader.readLine()) != null) {

                System.out.println("Message: " + message);

                broadcast(message);

            }

        } catch (IOException e) {

            System.out.println("Client disconnected.");

        }
    }

    private void broadcast(String message) {

        for (Task3_ClientHandler client :
                Task3_ChatServer.clients) {

            client.writer.println(message);

        }
    }
}