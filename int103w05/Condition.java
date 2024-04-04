package util;

@FunctionalInterface
public interface Condition<T> {
    boolean isTrue(T t);
    default boolean isFlalse(T t) {
        return !isTrue(t);
    }

}
