package main;

import java.math.BigInteger;

public class DecimalToOtherBaseConverter implements BaseConverter {
    public static String[] HEXADECIMAL_EXTRA_CHARS = {"A", "B", "C", "D", "E", "F"};
    private int otherBase;

    public DecimalToOtherBaseConverter(int otherBase) {
        this.otherBase = otherBase;
    }

    @Override
    public String convert(String inDecimal) {
        BigInteger remainder = new BigInteger(inDecimal);
        String result = "";
        int maxOtherBaseMagnitude = calculateHigherBaseMagnitude(remainder, otherBase);
        for (int magnitude = maxOtherBaseMagnitude; magnitude > 0; magnitude--) {
            BigInteger magVal = BigInteger.valueOf((long) Math.pow(otherBase, magnitude));
            BigInteger numberTimesFitsIn = remainder.divide(magVal);
            result = addValueToResult(result, numberTimesFitsIn);
            remainder = remainder.subtract(magVal.multiply(numberTimesFitsIn));
        }
        result = addValueToResult(result, remainder);
        return result;
    }

    public static int calculateHigherBaseMagnitude(BigInteger decimal, int higherBase) {
        int mag = 0;
        while (decimal.compareTo(getHigherBaseToPowerMag(higherBase, mag)) >= 0) {
            mag++;
        }
        return mag;
    }

    private static BigInteger getHigherBaseToPowerMag(int higherBase, int mag) {
        return BigInteger.valueOf(higherBase).pow(mag + 1);
    }

    public static int calculateHigherBaseMagnitude(int decimal, int higherBase) {
        return calculateHigherBaseMagnitude(BigInteger.valueOf(decimal), higherBase);
    }

    private String addValueToResult(String result, BigInteger valueDecimal) {
        int diff = valueDecimal.intValue() - 9;
        if (diff <= 0)
            result += valueDecimal;
        else
            result += HEXADECIMAL_EXTRA_CHARS[diff - 1];
        return result;
    }
}
