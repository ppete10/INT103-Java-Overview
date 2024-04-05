package school;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Classroom {
    private final List<Student> members;
    
    public Classroom() { members = new LinkedList<>(); }
    public Classroom(Supplier<List<Student>> constructor) { members = constructor.get(); }
    // dependency injection , inversion of control
    
    public boolean add(Student s) { /*if (s == null) return false;*/ members.add(s); return true; }
    
    public Stream<Student> stream() { return members.stream(); }

    public boolean remove(Student s) { return members.remove(s); }
    
}
