package main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class DecimalToOtherBaseFloatingPointConverter extends DecimalToOtherBaseConverter {
    public DecimalToOtherBaseFloatingPointConverter(int otherBase) {
        super(otherBase);
    }

    @Override
    public String convert(String inDecimal) {
        String[] beforeAndAfterPoint = inDecimal.split(".");
        String result = super.convert(beforeAndAfterPoint[0]);
        result += ".";

        BigInteger remainder = new BigInteger(beforeAndAfterPoint[1]);
        int maxOtherBaseMagnitude = calculateOtherBaseNegativeMagnitude(new BigDecimal(remainder), otherBase);
        for (int magnitude = maxOtherBaseMagnitude; magnitude > 0; magnitude--) {
            BigInteger magVal = BigInteger.valueOf((long) Math.pow(otherBase, magnitude));
            BigInteger numberTimesFitsIn = remainder.divide(magVal);
            result = addValueToResult(result, numberTimesFitsIn);
            remainder = remainder.subtract(magVal.multiply(numberTimesFitsIn));
        }
        result = addValueToResult(result, remainder);
        return result;
    }

    public static int calculateOtherBaseNegativeMagnitude(int decimal, int otherBase) {
        return calculateOtherBaseNegativeMagnitude(BigDecimal.valueOf(decimal), otherBase);
    }

    public static int calculateOtherBaseNegativeMagnitude(BigDecimal decimal, int otherBase) {
        int posMag = calculateHigherBaseMagnitude(decimal.intValue() + 1, otherBase);
        //return -posMag;
        //int posMag = calculateHigherBaseMagnitude(decimal.intValue(), otherBase);
        int mag = 0;
        while (decimal.compareTo(getHigherBaseToPowerMag(otherBase, mag)) <= 0) {
            mag--;
        }
        return mag;


    }

    private static BigDecimal getHigherBaseToPowerMag(int higherBase, int mag) {
        if (mag < 0) {
            return BigDecimal.ONE.divide(getHigherBaseToPowerMag(higherBase, -mag), MathContext.DECIMAL128);
        }
        return BigDecimal.valueOf(higherBase).pow(mag);
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
