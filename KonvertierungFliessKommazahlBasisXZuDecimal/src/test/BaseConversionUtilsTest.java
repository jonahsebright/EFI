package test;

import main.BaseConversionUtils;
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

    @Test
    public void calculateValAfterDecPoint() throws Exception {
        assertEquals("0", BaseConversionUtils.calculateDigitBehindPointVal("0", -1, 2, 50).stripTrailingZeros().toString());
        assertEquals("0", BaseConversionUtils.calculateDigitBehindPointVal("0", -12344, 8, 50).stripTrailingZeros().toString());
        assertEquals("0.5", BaseConversionUtils.calculateDigitBehindPointVal("1", -1, 2, 50).stripTrailingZeros().toString());
        assertEquals("0.33333333333333333333", BaseConversionUtils.calculateDigitBehindPointVal("1", -1, 3, 50).stripTrailingZeros().toString());
        assertEquals("0.25", BaseConversionUtils.calculateDigitBehindPointVal("1", -2, 2, 50).stripTrailingZeros().toString());
        assertEquals("0.125", BaseConversionUtils.calculateDigitBehindPointVal("1", -3, 2, 50).stripTrailingZeros().toString());
    }
}