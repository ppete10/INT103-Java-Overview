package int103;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private List<Person> friends = new ArrayList<>();
    private transient int luckNumber;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addFriend(Person p) {
        friends.add(p);
    }
    public Iterator<Person> getFriends() {
        return friends.iterator();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public int getLuckNumber() {
        return luckNumber;
    }

    public void setLuckNumber(int luckNumber) {
        this.luckNumber = luckNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", friends=[");
        for (Person f: friends
             ) {
            sb.append(f.id);
            sb.append(' ');
        }
        sb.append("], luckNumber=").append(luckNumber);
        sb.append('}');
        return sb.toString();
    }
}
