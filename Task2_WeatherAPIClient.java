import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Task 2: REST API Client
 *
 * Objective:
 * Consume a public REST API and display
 * weather information in a structured format.
 */

public class Task2_WeatherAPIClient {

    public static void main(String[] args) {

        try {

            // Open-Meteo API URL
            String apiUrl =
                "https://api.open-meteo.com/v1/forecast?latitude=17.3850&longitude=78.4867&current_weather=true";

            // Create URL object
            URL url = new URL(apiUrl);

            // Open HTTP connection
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get response code
            int responseCode = connection.getResponseCode();

            System.out.println("HTTP Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        connection.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }

                reader.close();

                System.out.println("\nWeather Data:");
                System.out.println("--------------------------------");
                System.out.println(response.toString());

            } else {

                System.out.println("Failed to fetch data.");

            }

            connection.disconnect();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }
    }
}