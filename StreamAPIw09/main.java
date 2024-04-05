package int103;

import java.util.*;
import school.*;

public class Int103w09 {

    public static void main(String[] args) {
        //testStudent();
        testStream();
    }
    public static void testStream() {
        Collection<String> sc = List.of("Zero", "One", "Two", "Three", "Four", "Five","Six","Seven","Eight");
        String[] as = {"One", "Two", "Three", "Four"};
        int[] ai = {10, 20, 50, 30, 66, 99, 31};
        System.out.println("Print Collection Stream: ");
        Arrays.stream(as)
                .peek(s -> System.out.println("[" + s + "]"))
                .map(s -> s + "(" + Thread.currentThread().getId() + ")")
                .forEachOrdered(System.out::println);
    }

    private static void testStudent() {
        var s = new Student(1,"First",Level.UNDERGRAD);
        var s2 = new Student(2,"Second",Level.MASTER);
        System.out.println("student: " + s);
        var cr = new Classroom(ArrayList<Student>::new);
        cr.add(s);
        cr.add((Student) null);
        //cr.add(Optional.empty());
        //cr.add(Optional.of(s2));
        cr.stream().forEach(System.out::println);
        cr.add(new Student(100,"Century",Level.PHD));
        cr.add(new Student(50,"Fifty",Level.MASTER));
        cr.add(new Student(10,"Ten",Level.UNDERGRAD));
        cr.add(new Student(101,"Basic",Level.UNDERGRAD));
        cr.add(new Student(500,"InternalError",Level.PHD));
        cr.add(new Student(404,"NotFound",Level.MASTER));
        System.out.println("Find C");
        cr.find(x->x.getName().contains("C"))
                .ifPresentOrElse(
                        x -> System.out.println("C: " + x),
                        () -> System.out.println("NOT FOUND"));
        
    }
    
}