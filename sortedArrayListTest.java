import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class sortedArrayListTest {
    @Test
    public void testAdd() {
        SortedArrayList<String> a = new SortedArrayList<>();
        a.add("Bob");
        assertEquals("Bob", a.get(0));
        a.add("Charlie");
        assertEquals("Charlie", a.get(1));
        assertEquals(a.indexOf("Adam"), 0);
        assertEquals(a.indexOf("Tom"), Integer.MAX_VALUE);

    }  
}