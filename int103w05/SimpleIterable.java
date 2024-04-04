package util;

public interface SimpleIterable<T> {
    SimpleIterator<T> simpleIterator();
    default SimpleIterator<T> simpleIterator(Condition<T> c){

        throw new UnsupportedOperationException();
    }
}
