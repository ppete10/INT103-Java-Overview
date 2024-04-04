package world;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private final int id;
    private final String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + '(' + getContent() + ')';
    }
    protected String getContent() {
        return "id:" + id + ",name:" + (name == null ? null : ("'" + name + "'")) ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var p = (Person) o;
        return id == p.id && Objects.equals(name, p.name);
    }
    @Override
    public int hashCode() { return Objects.hash(id,name); }
    @Override
    public int compareTo(Person p) {
        int i = id - p.id;
        if (i!=0) return i;
        if (name == p.name) return 0;
        if (name == null) return 1;
        if (p.name == null) return -1;
        return name.compareTo(p.name);
    }
}