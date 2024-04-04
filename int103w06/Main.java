package int103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import market.ShoppingCart;

public class Int103w06 {

    public static void main(String[] args) {
        testList();
        testMap();
        testShoppingCart();
    }

    static void testShoppingCart() {
        System.out.println("\n------ TEST Shopping Cart ------");
        String x = "eirweoriyuoiefjpasoefjpoefjwepiuoiwery";
        ShoppingCart<Character> s = new ShoppingCart<>();
        for (int i = 0; i < x.length(); i++) {
            s.add(x.charAt(i));
        }
        for (var o : s.getAll()) {
            System.out.println("Contains '" + o + "' " + s.get(o) + " times.");
        }
    }

    static void testMap() {
        System.out.println("\n------ TEST MAP ------");

        Map<String, String> m = new TreeMap<>();
        m.put("Mono", "One");
        m.put("Single", "One");
        m.put("Double", "Two");
        m.put("Tri", "Three");
        m.put("Binary", "Two");
        m.put("Binary", "Twin");
        for (var s : m.keySet()) {
            System.out.println("key: " + s + " ... value: " + m.get(s));
        }

    }

    static void testList() {
        System.out.println("------ TEST LIST ------");

        List<String> ls1 = new ArrayList<>(5);
        List<String> ls2 = new LinkedList<>();
        System.out.println("ls1 size = " + ls1.size());
        System.out.println("ls2 size = " + ls2.size());
        ls1.add("One");
        ls2.add("One");
        ls1.add(0,"Two");
        ls2.add(0,"Two");
        ls1.add(2,"Three");
        ls2.add(2,"null");

        System.out.print("list 1 :");
        for (var s: ls1)
            System.out.print(" " + s);

        System.out.print("\nlist 2 :");
        for (var s: ls2)
            System.out.print(" " + s);

        System.out.println("\n--- Queue ---");
        Queue<String> q = new LinkedList<>();
        System.out.println("offer null : " + q.offer(null));
        System.out.println("poll null : " + q.poll()); // return object null
        System.out.println("poll null : " + q.poll()); // return null cuz don't have object


    }

}
