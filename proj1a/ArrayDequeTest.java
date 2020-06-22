import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testAddFirstLast() {
        System.out.println("Test addFirst & addLast");

        ArrayDeque<Integer> array = new ArrayDeque<>();

        array.addFirst(1);
        array.addFirst(2);
        array.addLast(4);
        array.addLast(3);

        array.addFirst(5);
        array.addFirst(6);
        array.addLast(7);
        array.addLast(8);

        array.addFirst(9);
        array.addFirst(10);
        array.addLast(11);
        array.addLast(12);

        array.removeLast();

        array.printDeque();

        int expected = 11;
        int actual = array.size();

        assertEquals(expected, actual);

    }
}
