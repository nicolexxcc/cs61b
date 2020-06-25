public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private float usage;

    /** Create an empty Array Deque. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        usage = size / items.length;
    }

    private void resize(int capacity) {
        T[] i = (T[]) new Object[capacity];
        System.arraycopy(items, 0, i, 0, nextLast);
        System.arraycopy(items, nextLast, i, nextLast + capacity / 2, items.length - nextLast);
        items = i;
        nextFirst = nextFirst + capacity / 2;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        size += 1;
        items[nextFirst] = item;
        nextFirst = firstPointer(nextFirst);
    }

    private int firstPointer(int i) {
        if (i != 0) {
            i -= 1;
        } else {
            i = items.length - 1;
        }
        return i;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        size += 1;
        items[nextLast] = item;
        nextLast = lastPointer(nextLast);
    }

    private int lastPointer(int i) {
        if (i != items.length - 1) {
            i += 1;
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    /** problem!!!!!!!!!!  */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(nextFirst + 1 + i) % items.length] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        int firstIndex = lastPointer(nextFirst);
        T firstItem = items[firstIndex];
        size -= 1;
        nextFirst = firstIndex;
        return firstItem;
    }

    public T removeLast() {
        int lastIndex = firstPointer(nextLast);
        T lastItem = items[lastIndex];
        size -= 1;
        nextLast = lastIndex;
        return lastItem;
    }

    public T get(int index) {
        return items[(nextFirst + 1 + index) % items.length];
    }

}
