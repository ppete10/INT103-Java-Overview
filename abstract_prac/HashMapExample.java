import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap of String keys and Integer values
        HashMap<String, Integer> scores = new HashMap<>();

        // Adding key-value pairs to the HashMap
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        // Retrieving value associated with a key
        System.out.println("Score of Bob: " + scores.get("Bob"));

        // Iterating over the HashMap
        System.out.println("All scores:");
        for (String name : scores.keySet()) {
            System.out.println(name + ": " + scores.get(name));
        }
    }
}
