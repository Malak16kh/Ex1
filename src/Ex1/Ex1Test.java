package Ex1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex1Test {

    @Test
    void computerNumberTest() {
        // Test conversion to decimal and back.

        // Test binary number (base 2)
        String s2 = "1011b2";  // Represents binary "1011"
        int v = Ex1.number2Int(s2);  // Convert to decimal (should be 11)
        assertEquals(11, v, "Conversion to decimal failed");

        // Test custom base conversion
        String s10 = "1011bA";  // Base-A (custom base defined in Ex1)
        v = Ex1.number2Int(s10);  // Convert to decimal
        String s2Converted = Ex1.int2Number(v, 2);  // Convert back to binary
        int v2 = Ex1.number2Int(s2Converted);  // Convert binary back to decimal

        // Validate conversions
        assertEquals(v, v2, "Conversion back to binary failed");
        assertTrue(Ex1.equals(s10, s2Converted), "Equality check failed");
    }



    @Test
    void isNumberTest() {
        // Test valid and invalid numbers.
        assertTrue(Ex1.isNumber("123bA"));
        assertFalse(Ex1.isNumber("invalid"));
    }

    @Test
    void int2NumberTest() {
        // Test conversion from decimal to base.
        assertEquals("1011", Ex1.int2Number(11, 2));
        assertEquals("F", Ex1.int2Number(15, 16));
    }

    @Test
    void equalsTest() {
        // Test equality of two numbers.
        assertTrue(Ex1.equals("1011b2", "11bA"));
        assertFalse(Ex1.equals("1011b2", "10bA"));
    }

    @Test
    void maxIndexTest() {
        // Test finding the index of the largest number.
        String[] arr = {"1011b2", "15bA", null, "invalid"};
        assertEquals(1, Ex1.maxIndex(arr));
    }
}
