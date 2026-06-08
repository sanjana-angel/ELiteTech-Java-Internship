import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*
 * Chat Client
 * Connects to server and
 * sends/receives messages.
 */

public class Task3_ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket =
                    new Socket("localhost", 5000);

            System.out.println(
                    "Connected to Chat Server");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter writer =
                    new PrintWriter(
                            socket.getOutputStream(), true);

            Scanner scanner =
                    new Scanner(System.in);

            // Thread for receiving messages
            Thread receiveThread =
                    new Thread(() -> {

                        try {

                            String message;

                            while ((message =
                                    reader.readLine()) != null) {

                                System.out.println(message);

                            }

                        } catch (IOException e) {

                            e.printStackTrace();

                        }
                    });

            receiveThread.start();

            // Send messages
            while (true) {

                String msg = scanner.nextLine();

                writer.println(msg);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}