
/** Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue.
 *  Double-ended queues are sequence containers with dynamic sizes that
 *  can be expanded or contracted on both ends (either its front or its back).
 */

 public class LinkedListDeque<T> {
     public class DequeNode {
        private T item;
        private DequeNode prev;
        private DequeNode next;
        public DequeNode(DequeNode m, T i, DequeNode n) {
            prev = m;
            item = i;
            next = n;
        }
    }

    private DequeNode sentinel;
    private int size;

    /** Creates an empty linked list deque. */

    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new DequeNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;     // why??
        size++;
    }

    public void addLast(T item) {
        sentinel.prev.next = new DequeNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size++;

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        DequeNode d = sentinel;
        while (d.next != sentinel) {
            d = d.next;
            System.out.print(d.item + " ");
        }
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T firstItem = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return firstItem;
    }

    /* Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T lastItem = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return lastItem;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
       If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        DequeNode d = sentinel;
        while (index >= 0) {
            d = d.next;
            index -= 1;
        }
        return d.item;
    }


    /* Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    public T getRecursiveHelper(DequeNode d, int i) {
        if (i == 0) {
            return null;
        }
        return getRecursiveHelper(d.next, i - 1);
    }
}
