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
        assertEquals("1",converter.convert("1"));
        assertEquals("3",converter.convert("11"));
        assertEquals("1.5",converter.convert("1.1"));
        assertEquals("1.75",converter.convert("1.11"));
        assertEquals("10.625",converter.convert("1010.101"));
    }
}