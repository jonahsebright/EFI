import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecimalToOtherBaseFloatingPointConverterTest {

    @Test
    void convert() {
    }

    @Test
    void calculateOtherBaseNegativeMagnitude() {
        assertEquals(0, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(0, 2));
        assertEquals(-0, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(1, 2));
        assertEquals(-1, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(2, 2));
        assertEquals(-2, DecimalToOtherBaseFloatingPointConverter
                .calculateOtherBaseNegativeMagnitude(75, 2));
    }
}