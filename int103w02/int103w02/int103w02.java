package test;

import company.Employee;
import company.Staff;
import world.Container;
import world.Person;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Int103w02 {
    public static void main(String[] args){
        testPerson();
        testEmployee();
        testStaff();
        testCollection();
    }

    private static void testCollection() {
        System.out.println("\n----- Test Collection -----");

        Container<Person> c = new Container<>(3);
        c.add(new Person("Pete","Peerapan"));
        System.out.println("1.Container : " + c);
        c.add(new Employee(102, "Tenz","Kaydae",500.0));
        System.out.println("2.Container : " + c);

        for (int i = 0; i < c.getCount(); i++) {
            System.out.println("c:" + (c.get(i).getName()));
        }

        Employee E1 = new Employee(01,"CCC","AAA",500.0);
        Employee E2 = new Employee(02,"BBB","CCC", 20.0);
        Employee E3 = new Employee(03,"CCC","CCC", 405.0);
        var a = new Container<Employee>(3);
        a.add(E1);
        a.add(E2);
        a.add(E3);
        System.out.println("\nShow Container a \n" + a);
        a.remove(E2);
        System.out.println(a);

        a.add(E2);
        System.out.println(a);

        //a.sort((p,q) -> p.getId() - q.getId());
        a.sort(Employee.ComparedById);
        System.out.println("After sort\n" + a);
    }

    private static void testStaff() {
        System.out.println("\n-----TEST EMPLOYEE------");
        Staff S1 = new Staff(119, "Pete" , "Sa" , 500,30);
        Staff S2 = new Staff(006,"Get", "Sri", 500,25);
        System.out.println(S1);
        S2.setDays(0);
        S1.setDays(0);
        S1.setId(120);
        S2.setName("Pete");
        System.out.println("S1 = " + S1);
        System.out.println("S2 = " + S2);
        System.out.println("S1 hashcode = " + S1.hashCode());
        System.out.println("S2 hashcode = " + S2.hashCode());
        System.out.println("S1 equal S2 = " + S1.equals(S2));
        S1.setId(119);
        System.out.println(S1);
        System.out.println("S1 hashcode = " + S1.hashCode());
        System.out.println("S1 equal S2 = " + S1.equals(S2));

    }

    private static void testEmployee() {
        System.out.println("\n-----TEST EMPLOYEE------\n");
        Person P1 = new Employee(1,"Pete","Peerpan",500);
        System.out.println(P1);
        Employee E1 = new Employee(119, "PETE","PETE",500);
        Employee E2 = new Employee(005, "GET","Pete",500);
        System.out.println(E1);
        System.out.println(E2);
        System.out.println(E1.getName());
        System.out.println(E1.equals(E2));
        System.out.println(E1.hashCode());
    }

    private static void testPerson() {
        System.out.println("\n-----TEST Person------\n");

        Person p;
        try {
            p = new Person(null,null);
            System.out.println("P : " + p);
        } catch (Exception e) {
            System.out.println("Person's name can not null : " + e.getMessage());
        }
        Person P1 = new Person("Pete","Perapan");
        Person P2 = new Person("Get","Kanyapak");
        System.out.println("Name of P1 = " + P1);
        System.out.println("Name of P2 = " + P2);
        P1.setName("PEPE");
        System.out.println("After set Name of P1 = " + P1);
        P2.setName("PEPE");
        System.out.println(P1.equals(P2));
        System.out.println(P2.hashCode());
        System.out.println(P1.hashCode());
        P2.setName(null);
        System.out.println(P2);
        Person T1 = new Person("ABC","ABC");
        Person T2 = new Person("ABC", "ABC");
        System.out.println(T1.equals(T2));
        System.out.println(T1.compareTo(T2));

        Person PerEmp = new Person("pete","ja");
        PerEmp = new Employee(10,"game","sate",500); // subtitutability
        PerEmp.getName();
        // downcalss
        ((Employee) PerEmp).getId();

    }


}
