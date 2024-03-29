package company;

import world.Person;

import java.util.Comparator;
import java.util.Objects;

public class Employee extends Person {

    public static Comparator<Employee> ComparedById = (p,q) -> p.id - q.id;
    private int id;
    private double salary;

    public Employee(int id, String firstName, String lastName, double salary) {
        super(firstName,lastName);
        if (id <= 0){
            throw new RuntimeException("ID must be positive");
        }
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0)
            this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0)
            this.salary = salary;
    }

    @Override protected String getContent() {
        return "id:" + id + "," + super.getContent();
    }

    @Override protected boolean contentEquals(Object o) {
        return super.contentEquals(o) && this.id == ((Employee)o).id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return super.equals(employee) && id == employee.id && salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id , salary);
    }
}
