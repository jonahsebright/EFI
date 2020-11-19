import java.math.BigInteger;
import java.util.ArrayList;

public class OtherBaseToDecimalConverter implements BaseConverter {
    @Override
    public String convert(String inLowerBase, int lowerBase) {
        DigitsOfNumbers<String> digitsOfNumbers = new StringDigitsOfNumbers(inLowerBase);
        ArrayList<String> digits = digitsOfNumbers.getDigits();
        return calculateDecimal(lowerBase, digits).toString();
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
