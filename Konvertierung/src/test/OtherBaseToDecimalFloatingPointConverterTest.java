package test;

import main.OtherBaseToDecimalFloatingPointConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OtherBaseToDecimalFloatingPointConverterTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void convertFloatingPoint() {
        OtherBaseToDecimalFloatingPointConverter converter = new OtherBaseToDecimalFloatingPointConverter(2);
        Assertions.assertEquals("1",converter.convert("1"));
        Assertions.assertEquals("3",converter.convert("11"));
        Assertions.assertEquals("1.5",converter.convert("1.1"));
        Assertions.assertEquals("1.75",converter.convert("1.11"));
        Assertions.assertEquals("10.625",converter.convert("1010.101"));
    }
}