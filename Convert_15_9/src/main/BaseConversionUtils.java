package main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class BaseConversionUtils {
    public static final String[] HEXADECIMAL_CHARS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

   public static BigInteger calculateDigitVal(String digit, int magnitude, int base) {
        int digitInt = Arrays.binarySearch(HEXADECIMAL_CHARS, digit);
        return BigInteger.valueOf(digitInt)
                .multiply(BigInteger.valueOf(base).pow(magnitude));
    }

}
