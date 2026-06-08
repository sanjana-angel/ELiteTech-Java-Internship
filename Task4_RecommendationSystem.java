import java.util.*;

/*
 * Task 4: AI-Based Recommendation System
 *
 * Objective:
 * Recommend products based on user ratings.
 */

public class Task4_RecommendationSystem {

    public static void main(String[] args) {

        // Sample product ratings
        Map<String, Integer> productRatings = new HashMap<>();

        productRatings.put("Laptop", 5);
        productRatings.put("Smartphone", 4);
        productRatings.put("Headphones", 3);
        productRatings.put("Smart Watch", 5);
        productRatings.put("Tablet", 2);

        System.out.println("User Preferences");
        System.out.println("----------------");

        for (Map.Entry<String, Integer> entry :
                productRatings.entrySet()) {

            System.out.println(entry.getKey()
                    + " -> Rating: "
                    + entry.getValue());
        }

        System.out.println("\nRecommended Products");
        System.out.println("--------------------");

        // Recommend products with rating >= 4
        for (Map.Entry<String, Integer> entry :
                productRatings.entrySet()) {

            if (entry.getValue() >= 4) {

                System.out.println(entry.getKey());

            }
        }
    }
}