package main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class OtherBaseToDecimalFloatingPointConverter implements BaseConverter {
    private int otherBase;
    private int scale;

    public OtherBaseToDecimalFloatingPointConverter(int otherBase, int scale) {
        this.otherBase = otherBase;
        this.scale = scale;
    }

    @Override
    public String convert(String inOtherBase) {
        FloatingPointStringDigitsOfNumbers floatingPointDigitsOfNumbers = new FloatingPointStringDigitsOfNumbers(inOtherBase);
        List<String> digitsBeforePoint = floatingPointDigitsOfNumbers.getDigitsBeforePoint();
        List<String> digitsAfterPoint = floatingPointDigitsOfNumbers.getDigitsAfterPoint();
        return calculateDecimal(otherBase, digitsBeforePoint, digitsAfterPoint)
                .stripTrailingZeros().toString();
    }

    private BigDecimal calculateDecimal(int otherBase, List<String> digitsBeforePoint, List<String> digitsAfterPoint) {
        int numAfterPoint = digitsAfterPoint.size();
        BigDecimal decimalSum = new BigDecimal(calculateDecimal(otherBase, digitsBeforePoint));
        for (int i = 0; i < digitsAfterPoint.size(); i++) {
            String digit = digitsAfterPoint.get(i);
            int magnitude = -(i + 1);
            decimalSum = decimalSum.add(
                    BaseConversionUtils.calculateDigitBehindPointVal(digit, magnitude, otherBase, scale));
        }
        return decimalSum;
    }

    private BigInteger calculateDecimal(int otherBase, List<String> digits) {
        int numDigits = digits.size();
        BigInteger decimalSum = BigInteger.ZERO;
        for (int i = 0; i < digits.size(); i++) {
            String digit = digits.get(i);
            int magnitude = numDigits - i - 1;
            decimalSum = decimalSum.add(
                    BaseConversionUtils.calculateDigitVal(digit, magnitude, otherBase));
        }
        return decimalSum;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
