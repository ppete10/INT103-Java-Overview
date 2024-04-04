package util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Container<T> implements Iterable<T>{
    private T[] arr;
    private int count;
    public Container(int n) {
        if (n<=0) throw new IllegalArgumentException("initial size must be positive.");
        arr = (T[]) new Object[n];
        count = 0;
    }
    private boolean isValidIndex(int i) { return i<count && i>=0; }
    public T get(int i) { return isValidIndex(i) ? arr[i] : null; }
    public void set(int i, T o) {
        if (isValidIndex(i) && o != null) { arr[i] = o; }
    }
    public int getCount() { return count; }
    public boolean add(T o) {
        if (o == null) return false;
        if (count == arr.length) arr = Arrays.copyOf(arr, count<<1);
        arr[count++] = o;
        return true;
    }
    public T remove(T o) {
        if (o == null) return null;
        T result;
        for (int i = 0; i < count; i++) {
            if (o.equals(arr[i])) {
                result = arr[i];
                arr[i] = arr[--count];
                arr[count] = null;
                return result;
            }
        }
        return null;
    }
    public void sort() { Arrays.sort(arr, 0, count); }
    public void sort(Comparator<T> c) { Arrays.sort(arr, 0, count, c); }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < count;
            }

            @Override
            public T next() {
                return arr[cursor++];
            }

        };
    }

}