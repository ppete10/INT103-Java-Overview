package int103;

import company.Employee;
import util.Container;
import world.Person;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        testContainer();

    }


    private static void testContainer() {
        Container<Employee> c = new Container<>(10);
        c.add(new Employee(01,"Pete",300));
        c.add(new Employee(05,"KK",1000));
        c.add(new Employee(04,"OPOP",50));
        for (var e: c) {
            System.out.println(e);
        }
        c.sort();
        System.out.println("After sorting");
        for (int i = 0; i < c.getCount(); i++) {
            System.out.println(c.get(i));
        }

        c.sort(Employee.EMPLOYEE_COMPARATOR);
        System.out.println("After sorting as Employee");
        for (int i = 0; i < c.getCount(); i++) {
            System.out.println(c.get(i));
        }

        c.sort(Employee.SALARY_COMPARATOR);
        System.out.println("After sorting as Salary");
        for (int i = 0; i < c.getCount(); i++) {
            System.out.println(c.get(i));
        }
    }

}