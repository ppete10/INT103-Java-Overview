package int103;

import java.util.Comparator;

import util.ArrayBox;
import util.Box;
import util.SimpleIterator;
import world.Person;

public class Int103w05 {

    public static void main(String[] args) {
        testArrayBox();
    }

    static void testArrayBox() {
        Box<Person> box = new ArrayBox(10);
        box.append(new Person(30, "Somsak"));
        box.append(new Person(60, "Sompong"));
        box.append(new Person(20, "Somsri"));
        box.append(new Person(60, null));
        box.append(new Person(80, "Somchai"));
        box.append(new Person(10, "Somsak"));
        System.out.println("Lising Box's content:");
        for (int i = 0; i < box.size(); i++) {
            System.out.println(" person: " + box.getAt(i));
        }
        box.sort();
        System.out.println("After Sorting");
        SimpleIterator<Person> it = box.simpleIterator();
        Person p;
        while ((p = it.fetch()) != null) {
            System.out.println(" person: " + p);
        }
        System.out.println("Person with sak: " + box.get(Person.nameContains("sak")));
        System.out.println("Person with sri: " + box.get(q -> q.getName().contains("sri")));
        box.sort(Comparator.comparing((Person r) -> r.getName(), Comparator.nullsLast(Comparator.reverseOrder())));
        System.out.println("After Sorting by name");
        it = box.simpleIterator();
        while ((p = it.fetch()) != null) {
            System.out.println(" person: " + p);
        }
    }
}
