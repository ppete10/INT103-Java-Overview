package lab;

import business.Data;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Group<T> implements Iterable<T> {
    private List<T> list;

    public Group(LinkedList<Data> ll) {
        list = new LinkedList<>();
    }

    public Group(boolean useArray) {
        list = useArray ? new ArrayList<>() : new LinkedList<>();
    }

    public Group(List<T> list) {
        this.list = list;
    }

    public Group(Supplier<List<T>> listConstructor) {
        list = listConstructor.get(); // use Supplier -> methods is .get()
        // can change ArrayList or LinkedList
    }

    public Group(IntFunction<List<T>> listConstructorWhithInt, int capacity) {
        list = listConstructorWhithInt.apply(capacity); // Use Function -> methods is .apply()
        // call => new ArrayList<Data>(100) create Array size 100(parameter int capacity)
        // can only be used ArrayList
    }

    public Group(Function<Collection<T>, List<T>> listConstructor, Collection<T> coll) {
        list = listConstructor.apply(coll);
        // create Collection(type collection) now and add to list
        // create where parameter Collection<T> coll
    }

    public void add(T item) {
        list.add(item);
    }

    public T getItem(int index) {
        return list.get(index);
    }

    public boolean containsItem(T item) {
        return list.contains(item);
    }

    public int size() {
        return list.size();
    }

    public void sort(Comparator<T> comparator) {
        list.sort(comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void forEach(Consumer<? super T> action) {
        list.forEach(action);
    }

    public boolean removeIf(Predicate<T> filter) {
        return list.removeIf(filter);
    }

    public Stream<T> stream() {
        return list.stream();
    }

}
