package util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Objects;

public class ArrayBox<T> extends AbstractBox<Object> {

    protected Object[] arr;
    private int modCount;

    public ArrayBox(int i) {
        arr = (T[]) new Object[i < 3 ? 3 : i];
    }

    @Override
    public boolean append(Object t) {
        Objects.requireNonNull(t);
        if (size == arr.length) arr = Arrays.copyOf(arr, size << 1);
        arr[size++] = t;
        ++modCount;
        return true;
    }

    @Override
    public Object getAt(int i) {
        return arr[validateRange(i)];
    }

    @Override
    public Object get(Condition<Object> condition) {
        for (int i = 0; i < size; i++) {
            if (condition.isTrue(arr[i])) return arr[i];
        }
        return null;
    }

    @Override
    public SimpleIterator<Object> simpleIterator() {
        return new SimpleIterator() {
            private int cursor;
            private final int modCount = ArrayBox.this.modCount;

            @Override
            public Object fetch() {
                if (modCount != ArrayBox.this.modCount)
                    throw new ConcurrentModificationException();
                return cursor < size ? arr[cursor++] : null;
            }
        };
    }

    @Override
    public void sort() {
        Arrays.sort(arr, 0, size);
    }

    @Override
    public void sort(Comparator<Object> c) {
        Arrays.sort(arr, 0, size, c);
    }
}
