package assignments.ex1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {
    @Test
    void isNumberTest() {
        assertTrue(Ex1.isNumber("101b2"));
        assertTrue(Ex1.isNumber("ABb16"));
        assertFalse(Ex1.isNumber("12bG")); // Invalid base
        assertFalse(Ex1.isNumber(null));
    }

    @Test
    void number2IntTest() {
        assertEquals(11, Ex1.number2Int("1011b2"));
        assertEquals(255, Ex1.number2Int("FFb16"));
        assertEquals(-1, Ex1.number2Int("12bG")); // Invalid format
    }

    @Test
    void int2NumberTest() {
        assertEquals("101", Ex1.int2Number(5, 2));
        assertEquals("FF", Ex1.int2Number(255, 16));
        assertEquals("", Ex1.int2Number(-1, 10));
    }

    @Test
    void equalsTest() {
        assertTrue(Ex1.equals("1011b2", "11b10"));
        assertFalse(Ex1.equals("1011b2", "12b10"));
    }

    @Test
    void maxIndexTest() {
        String[] arr = {"10b10", "111b2", "A3b16", null, "50b10"};
        assertEquals(4, Ex1.maxIndex(arr));
    }
}
