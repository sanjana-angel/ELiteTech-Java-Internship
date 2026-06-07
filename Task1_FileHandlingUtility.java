import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Task 1: File Handling Utility
 * Objective:
 * Create a Java program to read, write, and modify text files.
 */

public class FileHandlingUtility {

    public static void main(String[] args) {

        String fileName = "sample.txt";

        try {

            // Step 1: Write data to the file
            FileWriter writer = new FileWriter(fileName);

            writer.write("Welcome to Java File Handling.\n");
            writer.write("This file demonstrates write operation.");

            writer.close();

            System.out.println("Data written successfully.\n");

            // Step 2: Read file contents
            System.out.println("Original File Content:");

            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

            // Step 3: Modify the file by appending data
            FileWriter modifier = new FileWriter(fileName, true);

            modifier.write("\nThis line was added during modification.");

            modifier.close();

            System.out.println("\nFile modified successfully.\n");

            // Step 4: Read modified file
            System.out.println("Updated File Content:");

            BufferedReader updatedReader =
                    new BufferedReader(new FileReader(fileName));

            while ((line = updatedReader.readLine()) != null) {
                System.out.println(line);
            }

            updatedReader.close();

        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}
