import java.util.*;

public class Student {
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 18));

        // Creating a Comparator to sort students based on their ages
        Comparator<Student> ageComparator = Comparator.comparing(Student::getAge);

        // Sorting the list of students using the Comparator
        Collections.sort(students, ageComparator);

        // Displaying the sorted list of students
        System.out.println("Sorted list of students based on age:");
        for (Student student : students) {
            System.out.println(student.getName() + " - Age: " + student.getAge());
        }
    }
}
