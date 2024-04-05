import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> names = new ArrayList<>();

        // Adding elements to the ArrayList
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Accessing elements by index
        System.out.println("First name: " + names.get(0));

        // Iterating over the ArrayList
        System.out.println("All names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}