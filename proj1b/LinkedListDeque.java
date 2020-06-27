import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> extends LinkedList<T> implements Deque<T> {
    @Override
    public void printDeque() {
        System.out.println("dummy");
    }

    public T getRecursive(int i) {
        return get(i);
    }

    @Override
    public T removeFirst() {
        try {
            return super.removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T removeLast() {
        try {
            return super.removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
