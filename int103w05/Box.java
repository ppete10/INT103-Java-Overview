package util;

import java.util.Comparator;

public interface Box<T> extends SimpleIterable<T> {
    boolean append(T t);
    int size();
    T getAt(int i);
    T replaceAt(int i, T t);
    T removeAt(int i);
    T get(Condition<T> condition);
    void sort();
    void sort(Comparator<T> comparator);
}
