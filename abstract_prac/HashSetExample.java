import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet of integers
        HashSet<Integer> numbers = new HashSet<>();

        // Adding elements to the HashSet
        numbers.add(5);
        numbers.add(10);
        numbers.add(15);

        // Adding duplicate element
        numbers.add(5); // Will not be added

        // Displaying elements of the HashSet
        System.out.println("Elements of the HashSet:");
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
