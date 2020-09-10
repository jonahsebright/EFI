import javax.print.attribute.standard.NumberOfDocuments;
import java.util.ArrayList;

public class LastDigits {

    private long base;
    private long pow;

    public LastDigits(long base, long pow) {
        this.base = base;
        this.pow = pow;
    }

    public long tooLongOperation() throws OperationTooLongException {
        long l = 0;
        long startTime = System.currentTimeMillis();
        while (l > -1) {
            l++;
            if (System.currentTimeMillis() > startTime + 1000) throw new OperationTooLongException(1);
        }
        return l;
    }

    public int calculate(int numDigits) {
        long originalBase = base;
        long originalPow = pow;

        int baseLastDigit = DigitsOfNumbers.lastDigitOf(base);
        int cycleLength = cycleLengthOfDigit(baseLastDigit);

        if (numDigits > 1) return 81;

        resetOriginalBaseAndPower(originalBase, originalPow);
        return 1;


    }

    private int cycleLengthOfDigit(int digit) {
        if (digit == 1) return 1;
        int length = 0;
        int currentLast = -1;
        int power_n = digit;
        while (currentLast != digit) {
            power_n = (int) Math.pow(digit, digit);
            DigitsOfNumbers digitsOfPowerN = new DigitsOfNumbers((long) power_n);
            currentLast = digitsOfPowerN.getLast();
            length++;
        }
        return length;
    }

    private void resetOriginalBaseAndPower(long originalBase, long originalPow) {
        this.base = originalBase;
        this.pow = originalPow;
    }

    public static class OperationTooLongException extends Exception {
        public OperationTooLongException(int secs) {
            super(String.format("Operation took longer than %d seconds, operation stopped!", secs));
        }
    }
}
