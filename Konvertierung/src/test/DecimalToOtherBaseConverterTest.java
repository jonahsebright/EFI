package test;

import main.DecimalToOtherBaseConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecimalToOtherBaseConverterTest {

    private DecimalToOtherBaseConverter converter;

    @Test
    void calculateMaxOtherBaseMagnitude() {
        Assertions.assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(0, 16));
        Assertions.assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(1, 16));
        Assertions.assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(2, 16));
        Assertions.assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(15, 16));
        Assertions.assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(16, 16));
        Assertions.assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(255, 16));
        Assertions.assertEquals(2, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(256, 16));
        Assertions.assertEquals(5, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(1048576, 16));

        Assertions.assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(0, 2));
        Assertions.assertEquals(0, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(1, 2));
        Assertions.assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(2, 2));
        Assertions.assertEquals(1, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(3, 2));
        Assertions.assertEquals(2, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(4, 2));
        Assertions.assertEquals(7, DecimalToOtherBaseConverter.calculateHigherBaseMagnitude(128, 2));
    }

    @Test
    void canConvertToBase16() {
        converter = new DecimalToOtherBaseConverter(16);
        Assertions.assertEquals("1", converter.convert("1"));
        Assertions.assertEquals("2", converter.convert("2"));
        Assertions.assertEquals("3", converter.convert("3"));
        Assertions.assertEquals("9", converter.convert("9"));

        Assertions.assertEquals("A", converter.convert("10"));
        Assertions.assertEquals("B", converter.convert("11"));
        Assertions.assertEquals("F", converter.convert("15"));

        Assertions.assertEquals("10", converter.convert("16"));
        Assertions.assertEquals("11", converter.convert("17"));
        Assertions.assertEquals("1F", converter.convert("31"));

        Assertions.assertEquals("20", converter.convert("32"));
        Assertions.assertEquals("21", converter.convert("33"));
        Assertions.assertEquals("2F", converter.convert("47"));
        Assertions.assertEquals("FF", converter.convert("255"));

        Assertions.assertEquals("111", converter.convert("273")); //256+16+1
        Assertions.assertEquals("FFE", converter.convert("4094")); //16 power of 2 * 15+16*15+14
        Assertions.assertEquals("75BCD15", converter.convert("123456789")); //16 power of 2 * 15+16*15+14
    }

    @Test
    void canConvertToBase2() {
        converter = new DecimalToOtherBaseConverter(2);
        Assertions.assertEquals("1", converter.convert("1"));
        Assertions.assertEquals("10", converter.convert("2"));
        Assertions.assertEquals("11", converter.convert("3"));
        Assertions.assertEquals("100", converter.convert("4"));
        Assertions.assertEquals("1010", converter.convert("10"));
        Assertions.assertEquals("111010110111100110100010101", converter.convert("123456789"));
    }
}