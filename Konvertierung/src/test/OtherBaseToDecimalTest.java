package test;

import main.OtherBaseToDecimalConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OtherBaseToDecimalTest {

    private OtherBaseToDecimalConverter converter;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void dualToDecimal() {
        converter = new OtherBaseToDecimalConverter(2);
        Assertions.assertEquals("1", converter.convert("1"));
        Assertions.assertEquals("2", converter.convert("10"));
        Assertions.assertEquals("3", converter.convert("11"));
        Assertions.assertEquals("4", converter.convert("100"));
        Assertions.assertEquals("1485553", converter.convert("101101010101011110001"));
        Assertions.assertEquals("17570460958271", converter.convert("11111111101011110001000101010111111000111111"));
    }

    @Test
    void otherToDecimal(){
        converter = new OtherBaseToDecimalConverter(3);
        Assertions.assertEquals("1", converter.convert("1"));
        Assertions.assertEquals("23", converter.convert("212"));
        converter = new OtherBaseToDecimalConverter(9);
        Assertions.assertEquals("118", converter.convert("141"));
        converter = new OtherBaseToDecimalConverter(10);
        Assertions.assertEquals("12345678", converter.convert("12345678"));
    }

    @Test
    void hexadecimalToDecimal() {
        converter = new OtherBaseToDecimalConverter(16);
        Assertions.assertEquals("1", converter.convert("1"));
        Assertions.assertEquals("15", converter.convert("F"));
    }
}