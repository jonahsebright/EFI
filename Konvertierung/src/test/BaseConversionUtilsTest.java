package test;

import main.BaseConversionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseConversionUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateDigitVal() {
        Assertions.assertEquals("0", BaseConversionUtils.calculateDigitVal("0", 0, 2).toString());
        Assertions.assertEquals("0", BaseConversionUtils.calculateDigitVal("0", 1303003, 5).toString());
        Assertions.assertEquals("1", BaseConversionUtils.calculateDigitVal("1", 0, 2).toString());
        Assertions.assertEquals("81", BaseConversionUtils.calculateDigitVal("1", 4, 3).toString());
        Assertions.assertEquals("108", BaseConversionUtils.calculateDigitVal("4", 3, 3).toString());
    }
}