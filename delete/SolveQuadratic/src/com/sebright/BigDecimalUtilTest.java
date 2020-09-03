package com.sebright;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalUtilTest {

    @Test
    void isNegative() {
        BigDecimal bigDecimal = BigDecimal.valueOf(-14);
        assertTrue(BigDecimalUtil.isNegative(bigDecimal));
    }

    @Test
    void isZero() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        BigDecimal bigDecimal2 = BigDecimal.valueOf(0);

        assertTrue(BigDecimalUtil.isZero(bigDecimal));
        assertTrue(BigDecimalUtil.isZero(bigDecimal2));
    }

    @Test
    void isPositive() {
        BigDecimal bigDecimal = BigDecimal.valueOf(314);
        assertTrue(BigDecimalUtil.isPositive(bigDecimal));
    }
}