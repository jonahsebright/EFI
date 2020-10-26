import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowerBaseToDecimalTest {

    private LowerBaseBaseToDecimal converter = new LowerBaseBaseToDecimal();

    @BeforeEach
    void setUp() {
    }

    @Test
    public void lowerToHigherBase() {

        assertEquals("1", converter.convert("1", 2));
        assertEquals("2", converter.convert("10", 2));
        assertEquals("3", converter.convert("11", 2));
        assertEquals("4", converter.convert("100", 2));
        assertEquals("1485553", converter.convert("101101010101011110001", 2));
        assertEquals("17570460958271", converter.convert("11111111101011110001000101010111111000111111", 2));

        assertEquals("1", converter.convert("1", 3));
        assertEquals("23", converter.convert("212", 3));
        assertEquals("118", converter.convert("141", 9));
        assertEquals("12345678", converter.convert("12345678", 10));

        //Strings.binaryToHexadecimal("01");
    }
}