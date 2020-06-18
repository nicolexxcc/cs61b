import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void testFlik() {
        int a = 1;
        int b = 5;
        int c = 5;

        boolean d = Flik.isSameNumber(a, b);
        boolean e = Flik.isSameNumber(b, c);

        assertTrue(e);
        assertFalse(d);
    }
}
