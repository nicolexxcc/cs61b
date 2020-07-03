package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(arb.dequeue(), i);
        }
    }

    @Test
    public void testPeek() {
        BoundedQueue<Integer> arb = new ArrayRingBuffer<>(10);
        for (int i = 0; i < arb.capacity(); i += 1) {
            arb.enqueue(i);
        }

        for (int i = 0; i < 5; i += 1) {
            arb.dequeue();
        }

        assertEquals((int) arb.peek(), 5);
    }


} 
