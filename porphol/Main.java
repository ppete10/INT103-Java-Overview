import business.Data;
import lab.Group;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       testGroup();
    }

    private static void testGroup() {
//        var g = new Group<Data>();
//        var g = new Group<Data>(true);
//        var g = new Group<Data>(new LinkedList<Data>());
//        var g = new Group<Data>(ArrayList<Data>::new); // type of constructor is Supplier
//        don't accept parameter and return Obj
//        var g = new Group<Data>(ArrayList<Data>::new, 100); // type of constructor is IntFunction
//        accept parameter and return Int
          var g = new Group<Data>(ArrayList<Data>::new,
                List.of(new Data(100, "Century", 101.01),
                        new Data(1000, "Millinium", 1010.101)));
        // List.of(new ...) -> create Collection(type collection) now and add to list

        g.add(new Data(10,"Ten", 10.101));
        g.add(new Data(2,"Two", 2.2));
        g.add(new Data(0,"Zero", 0.01));
        g.add(new Data(1,"One", 1.1));
//        g.add(new Data(-1, null, -1.0)); // fuse cann't null
//        g.add(null); // data cann't null
//        // Error because process cann't raed null
        System.out.println("Group: " + g);
        System.out.println("Group:");
        for (var v : g) System.out.println(" " + v); // null => error
        System.out.println("Group after removeing e:");

//        g.removeIf(x -> !x.getName().contains("e")); // remove by lambda expression
//        g.forEach(x -> System.out.println(" " + x)); // accept by functional interface
//        // It is functional programming don't should remove

        // Real functional programming should stream
        /* Java Stream API have 2 type
            I/O Stream: read = input stream, write = output stream
            Stream for functional programming: use type collection
            Stream collection have process = create stream -> process stream -> terminate stream
            parallelStream = will be processed in parts
         */

//        g.stream() // create stream
//                .filter(x -> x.getName().contains("e")) // process stream
//                .map(y -> "  " + y.toString()) // process stream
//                .forEach(System.out::println); // terminate stream
        /*  Output look at the sequence.
            Data{id=100, name=Century, value=101.01}
            Data{id=10, name=Ten, value=10.101}
            Data{id=0, name=Zero, value=0.01}
            Data{id=1, name=One, value=1.1}
         */

        g.stream().parallel() // parallelStream
                .filter(x -> x.getName().contains("e")) // process stream
                .map(y -> "  " + y.toString()) // process stream
//                .forEach(System.out::println); // terminate stream
                .forEachOrdered(System.out::println); // terminate stream
        /*  Output look at the sequence.
            Data{id=0, name=Zero, value=0.01}
            Data{id=1, name=One, value=1.1}
            Data{id=100, name=Century, value=101.01}
            Data{id=10, name=Ten, value=10.101}

            can use .forEachOrdered(); // Ordered can help arrange sequence
            Output after use .forEachOrdered() look at the sequence.
             Data{id=100, name=Century, value=101.01}
             Data{id=10, name=Ten, value=10.101}
             Data{id=0, name=Zero, value=0.01}
             Data{id=1, name=One, value=1.1}
         */
    }
}