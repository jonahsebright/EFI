package test;

import main.DecimalToOtherBaseFloatingPointConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToOtherBaseFloatingPointConverterTest {

    @Test
    void convert() {
    }

    @Test
    void calculateOtherBaseNegativeMagnitude() {
        Assertions.assertEquals(0, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(0, 2));
        Assertions.assertEquals(-0, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(1, 2));
        Assertions.assertEquals(-1, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(2, 2));
        Assertions.assertEquals(-2, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(75, 2));
    }
}