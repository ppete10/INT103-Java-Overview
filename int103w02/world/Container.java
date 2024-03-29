package world;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

public class Container<T> { // generic
    private T[] arr;
    private int count;

    public Container(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Containner's Size must be a positive");
        arr = (T[]) new Object[n];
    }

    public void sort(){
        Arrays.sort(arr,0,count);
    }
    public void sort(Comparator<T> c){
        Arrays.sort(arr,0,count,c);
    }
    public int getCount() {
        return count;
    }
    private boolean isValid(int i) {
        return i < count && i >= 0;
    }

    public T get(int i) {
        return isValid(i) ? arr[i] : null;
    }

    public void set(int i, T o) {
        if (isValid(i) && o != null) arr[i] = o;
    }

    public boolean add(T o) {
        if (o == null) return false;
        if (count == arr.length)
            arr = Arrays.copyOf(arr, count << 1);
        arr[count++] = o;
        return true;
    }

    public T remove(T o) {
        if (o == null) return null;
        for (int i = 0; i < count; i++) {
            if (o.equals(arr[i])) {
                T x = arr[i];
                arr[i] = arr[--count];
                arr[count] = null;
                return x;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner j = new StringJoiner(", ", "Contain{","}");
        for (int i = 0; i < count; i++) {
            j.add(arr[i].toString());
        }
        return j.toString();
    }
}
