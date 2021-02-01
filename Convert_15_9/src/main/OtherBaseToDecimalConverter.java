package main;

import java.math.BigInteger;
import java.util.ArrayList;

public class OtherBaseToDecimalConverter implements BaseConverter {
    private final int otherBase;

    public OtherBaseToDecimalConverter(int otherBase) {
        this.otherBase = otherBase;
    }

    @Override
    public String convert(String inOtherBase) {
        DigitsOfNumbers<String> digitsOfNumbers = new StringDigitsOfNumbers(inOtherBase);
        ArrayList<String> digits = digitsOfNumbers.getDigits();
        return calculateDecimal(otherBase, digits).toString();
    }

    private BigInteger calculateDecimal(int lowerBase, ArrayList<String> digits) {
        int numDigits = digits.size();
        BigInteger decimalSum = BigInteger.ZERO;
        for (int i = 0; i < digits.size(); i++) {
            String digit = digits.get(i);
            int magnitude = numDigits - i - 1;
            decimalSum = decimalSum.add(
                    BaseConversionUtils.calculateDigitVal(digit, magnitude, lowerBase));
        }
        return decimalSum;
    }
}
