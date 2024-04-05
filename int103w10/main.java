package int103;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import school.*;

public class Int103w10 {

    public static void main(String[] args) {
        //testStream();
        //testClassroom();
        testTerminal();
    }
    public static void testTerminal() {
        System.out.println("empty: " + Stream.empty().findAny().orElse("[NOTHING]"));
        System.out.println("any: " + Stream.of("one", "two", "three").findAny().orElse("[NOTHING]"));
        System.out.println("forAll: " + Stream.of("one", "two", "thr").allMatch(x->x.length()==3));
        Stream<String> s = Stream.empty();
        System.out.println("forSome: " + s.anyMatch(x->x.length()==3));
        System.out.println("toArray: " + Stream.of("one", "two", "three").toArray(String[]::new));
        System.out.println("reduce identity: " + Stream.of(1,2,3,4,5).reduce(1,(acc , each) -> acc * each));
        Stream<Integer> is = Stream.ofNullable(null);
        IntBinaryOperator sumSqr = (acc , each) -> acc * each;
        System.out.println("reduce identity: " + (IntStream.empty()).reduce(1000,sumSqr));
        System.out.println("reduce: " + IntStream.of(10,2,3).reduce(sumSqr));
        System.out.println("reduce: " + IntStream.of(10,2,3).reduce(0, sumSqr));
        System.out.println("reduce: " + is.reduce((acc,each) -> acc * each));
        System.out.println("super reduce: " + Stream.of(2,3,4,5).parallel().reduce(0, (acc , each) -> acc + each * each , (x,y)->  x + y));
    }
    public static void testClassroom() {
        var cr = new Classroom(LinkedList<Student>::new);
        cr.add(new Student(30, "First", Level.MASTER));
        cr.add(new Student(5, "Zero", Level.PHD));
        cr.add(new Student(127, "Second", Level.UNDERGRAD));
        cr.add(new Student(45, "Infinity", Level.PHD));
        cr.add(new Student(22, null, Level.UNDERGRAD));
        cr.add(new Student(11, "Seven", null));
        cr.add(null);
        cr.add(new Student(3, "Tenth", Level.MASTER));
        cr.add(new Student(0, "OOP", Level.PHD));
        cr.add(new Student(9, "FP", Level.UNDERGRAD));
        System.out.println("1. forEach ==================");
        cr.stream().forEach(System.out::println);
        System.out.println("2. skip, limit ==================");
        cr.stream().limit(6).skip(2).forEach(System.out::println);
        System.out.println("3. sorted ==================");
        cr.stream()
                .sorted(Comparator.nullsLast(
                        Comparator.comparing(Student::getLevel, 
                                Comparator.nullsFirst(Comparator.naturalOrder()))
                                .thenComparing(Student::getId)))
                .forEach(System.out::println);
        System.out.println("4. filter ==================");
        cr.stream().filter(x -> x != null).filter(Student::isComplete).forEach(System.out::println);
        Predicate<Student> isNotNull = x -> x != null;
        cr.stream().filter(isNotNull).filter(Student::isComplete).forEach(System.out::println);
        System.out.println("5. map ==================");
        cr.stream()
                .filter(isNotNull)
                .filter(Student::isComplete)
                .map(x -> x.getName().length())
                .forEach(System.out::println);
    }

    private static void testStream() {
        System.out.println("Generate ==================");
        Stream.generate(Math::random).limit(1).forEach(System.out::println);
        System.out.println("Iterate ==================");
        IntStream.iterate(5, x -> x + 3).limit(10).forEach(System.out::println);
        System.out.println("Iterate with Predicate ==================");
        IntStream.iterate(5, x -> x < 25, x -> x + 3).forEach(System.out::println);
        System.out.println("Stream.of(varargs) ==================");
        Stream.of("One", "Two", "Three", "Four").forEach(System.out::println);
        System.out.println("Stream.of(array) ==================");
        String[] arr = {"One", "Two", "Three", "Four"};
        Stream.of(arr).forEach(System.out::println);
        System.out.println("Arrays.stream(array) ==================");
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("Stream.ofNullable(T t) ==================");
        arr = null;
        Stream.ofNullable(arr).forEach(System.out::println);
        System.out.println("Stream.empty() ==================");
        Stream.empty().forEach(System.out::println);
    }
}
