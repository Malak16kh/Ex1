package Ex1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {

    @Test
    void isNumberTest() {
        // Valid numbers
        assertTrue(Ex1.isNumber("1011b2"), "1011b2 should be a valid number");
        assertTrue(Ex1.isNumber("A1b16"), "A1b16 should be a valid number");

        // Invalid numbers
        assertFalse(Ex1.isNumber("1012b2"), "1012b2 should not be a valid number");
        assertFalse(Ex1.isNumber("G1b16"), "G1b16 should not be a valid number");
        assertFalse(Ex1.isNumber(""), "Empty string should not be a valid number");
        assertFalse(Ex1.isNumber("1011b"), "1011b should not be a valid number");
        assertFalse(Ex1.isNumber("b10"), "b10 should not be a valid number");
    }

    @Test
    void number2IntTest() {
        // Valid conversions
        assertEquals(11, Ex1.number2Int("1011b2"), "1011b2 should be 11 in decimal");
        assertEquals(1011, Ex1.number2Int("1011b10"), "1011b10 should be 1011 in decimal");

        // Invalid conversions
        assertEquals(-1, Ex1.number2Int("1012b2"), "1012b2 should be invalid and return -1");
        assertEquals(-1, Ex1.number2Int(""), "Empty string should return -1");
        assertEquals(-1, Ex1.number2Int("1011b"), "1011b should be invalid and return -1");
    }

    @Test
    void int2NumberTest() {
        // Valid conversions
        assertEquals("1011b2", Ex1.int2Number(11, 2), "11 in binary should be 1011b2");
        assertEquals("1011b10", Ex1.int2Number(1011, 10), "1011 in base 10 should be 1011b10");

        // Invalid base
        assertEquals("", Ex1.int2Number(11, 20), "Invalid base should return an empty string");
    }

    @Test
    void equalsTest() {
        // Equal numbers in different formats
        assertTrue(Ex1.equals("1011b2", "11b10"), "Expected numbers to be equal");
        assertFalse(Ex1.equals("1011b2", "12b10"), "Expected numbers to be unequal");
        assertFalse(Ex1.equals("invalid", "11b10"), "Invalid numbers should not be equal");
    }

    @Test
    void maxIndexTest() {
        // Valid array
        String[] arr = {"101b2", "A1b16", "15b10", "FFb16"};
        assertEquals(3, Ex1.maxIndex(arr), "FFb16 (255) is the largest number");

        // Array with invalid and null entries
        String[] invalidArr = {"invalid", null, "123b1"};
        assertEquals(-1, Ex1.maxIndex(invalidArr), "No valid numbers, so return -1");
    }
}





