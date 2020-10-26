import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseConversionUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateDigitVal() {
        assertEquals("0", BaseConversionUtils.calculateDigitVal("0", 0, 2).toString());
        assertEquals("0", BaseConversionUtils.calculateDigitVal("0", 1303003, 5).toString());
        assertEquals("1", BaseConversionUtils.calculateDigitVal("1", 0, 2).toString());
        assertEquals("81", BaseConversionUtils.calculateDigitVal("1", 4, 3).toString());
        assertEquals("108", BaseConversionUtils.calculateDigitVal("4", 3, 3).toString());
    }
}