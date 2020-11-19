import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OtherBaseToDecimalTest {

    private OtherBaseToDecimalConverter converter;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void dualToDecimal() {
        converter = new OtherBaseToDecimalConverter(2);
        assertEquals("1", converter.convert("1"));
        assertEquals("2", converter.convert("10"));
        assertEquals("3", converter.convert("11"));
        assertEquals("4", converter.convert("100"));
        assertEquals("1485553", converter.convert("101101010101011110001"));
        assertEquals("17570460958271", converter.convert("11111111101011110001000101010111111000111111"));
    }

    @Test
    void otherToDecimal(){
        converter = new OtherBaseToDecimalConverter(3);
        assertEquals("1", converter.convert("1"));
        assertEquals("23", converter.convert("212"));
        converter = new OtherBaseToDecimalConverter(9);
        assertEquals("118", converter.convert("141"));
        converter = new OtherBaseToDecimalConverter(10);
        assertEquals("12345678", converter.convert("12345678"));
    }

    @Test
    void hexadecimalToDecimal() {
        converter = new OtherBaseToDecimalConverter(16);
        assertEquals("1", converter.convert("1"));
        assertEquals("15", converter.convert("F"));
    }
}