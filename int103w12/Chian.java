package util;

public class Chain<T> {
    private T value;
    private Chain<T> next;

    public T getValue() {
        return value;
    }

    public Chain<T> getNext() {
        return next;
    }

    private Chain(T value, Chain<T> next){
        this.value = value;
        this.next = next;
    }

    public static <T> Chain<T> getInstance(T value, Chain<T> next) {
         if (value == null || next == null) return null;
         return new Chain<>(value, next);
    }
    public static <T> Chain<T> getInstance(T value) {
         if (value == null) return null;
         return new Chain<>(value, null);
    }
}
