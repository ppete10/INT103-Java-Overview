package world;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        //if (name == null) throw new IllegalArgumentException("name cannot");
        this.firstName = Objects.requireNonNull(firstName, "name can not be null");
        this.lastName = Objects.requireNonNull(lastName,"Cant null");
    }

    public String getName() {
        return firstName +" "+ lastName;
    }

    public void setName(String firstName) {
        if (firstName != null)
            this.firstName = firstName;
        //this.name = Objects.requireNonNullElse(name,this.name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + getContent() + ")";
    }

    protected  String getContent(){
        return firstName +" "+ lastName;
    }


    @Override public boolean equals(Object o) {
        return this == o || (o != null && getClass() == o.getClass() && contentEquals(o));
    }

    protected boolean contentEquals(Object o) {
        return Objects.equals(this.firstName,((Person)o).firstName)
                && Objects.equals(this.lastName,((Person)o).lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName);
    }

    @Override
    public int compareTo(Person o) {
        return firstName.compareTo(o.firstName) + lastName.compareTo(o.lastName);
    }
}
