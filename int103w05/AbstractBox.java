package util;

import java.util.Arrays;
import java.util.Comparator;

public abstract class AbstractBox<T> implements Box<T> {
    protected T[] arr;
    protected int size;

    @Override
    public int size() {
        return size;
    }

    protected int validateRange(int i) {
        if (i < 0 || i >= size)
            throw new InvalidRangeException();
        return i;
    }

    protected Object unsupported() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T removeAt(int i) {
        return (T) unsupported();
    }

    @Override
    public T replaceAt(int i, T t) {
        return (T) unsupported();
    }

    @Override
    public SimpleIterator<T> simpleIterator() {
        return (SimpleIterator<T>) unsupported();
    }

    @Override
    public void sort() {
        unsupported();
    }

    @Override
    public void sort(Comparator<T> comparator) {
        unsupported();
    }
}
