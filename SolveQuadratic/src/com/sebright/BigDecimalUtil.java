package com.sebright;

import java.math.BigDecimal;

public class BigDecimalUtil {

    public static boolean isEqualValue(BigDecimal compare, BigDecimal to){
        return compare.compareTo(to) == 0;
    }

    public static boolean isNegative(BigDecimal bigDecimal){
        return bigDecimal.signum() < 0;
    }

    public static boolean isZero(BigDecimal bigDecimal){
        return bigDecimal.signum() == 0;
    }

    public static boolean isPositive(BigDecimal bigDecimal){
        return bigDecimal.signum() > 0;
    }
}
