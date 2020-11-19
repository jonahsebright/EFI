import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToOtherBaseConverterTest {

    private DecimalToOtherBaseConverter converter = new DecimalToOtherBaseConverter();

    @Test
    void calculateMaxOtherBaseMagnitude() {
        assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(0, 16));
        assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(1, 16));
        assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(2, 16));
        assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(15, 16));
        assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(16, 16));
        assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(255, 16));
        assertEquals(2, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(256, 16));
        assertEquals(5, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(1048576, 16));

        assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(0, 2));
        assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(1, 2));
        assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(2, 2));
        assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(3, 2));
        assertEquals(2, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(4, 2));
        assertEquals(7, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(128, 2));
    }

    @Test
    void canConvertToBase16() {
        assertEquals("1", converter.convert("1", 16));
        assertEquals("2", converter.convert("2", 16));
        assertEquals("3", converter.convert("3", 16));
        assertEquals("9", converter.convert("9", 16));

        assertEquals("A", converter.convert("10", 16));
        assertEquals("B", converter.convert("11", 16));
        assertEquals("F", converter.convert("15", 16));

        assertEquals("10", converter.convert("16", 16));
        assertEquals("11", converter.convert("17", 16));
        assertEquals("1F", converter.convert("31", 16));

        assertEquals("20", converter.convert("32", 16));
        assertEquals("21", converter.convert("33", 16));
        assertEquals("2F", converter.convert("47", 16));
        assertEquals("FF", converter.convert("255", 16));

        assertEquals("111", converter.convert("273", 16)); //256+16+1
        assertEquals("FFE", converter.convert("4094", 16)); //16 power of 2 * 15+16*15+14
        assertEquals("75BCD15", converter.convert("123456789", 16)); //16 power of 2 * 15+16*15+14
    }

    @Test
    void canConvertToBase2() {
        assertEquals("1", converter.convert("1", 2));
        assertEquals("10", converter.convert("2", 2));
        assertEquals("11", converter.convert("3", 2));
        assertEquals("100", converter.convert("4", 2));
        assertEquals("1010", converter.convert("10", 2));
        assertEquals("111010110111100110100010101", converter.convert("123456789", 2));
    }
}