import java.math.BigDecimal;
import java.math.BigInteger;
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

    public static boolean isEven(long num) {
        return isDivisibleBy(num, 2);
    }

    public static boolean isDivisibleBy(long num, int divisor) {
        return num % divisor == 0;
    }

    public ArrayList<Integer> calculate(int numDigits) {
        long originalBase = base;
        long originalPow = pow;

        int baseLastDigit = DigitsOfNumbers.lastDigitOf(base);
        int cycleLength = cycleLengthOfDigit(baseLastDigit);

        reducePowAsMuchAsPossible(originalBase, cycleLength);

        DigitsOfNumbers digitsOfNumbers = initNewDigitsOfNumbers();
        int numDigitsCalculated = digitsOfNumbers.getDigits().size();
        while (notEnoughDigitsCalculated(numDigitsCalculated, numDigits)) {
            multiplyPowByCycleLength(cycleLength);
            digitsOfNumbers = new DigitsOfNumbers((long) Math.pow(base, pow));
            numDigitsCalculated = digitsOfNumbers.getDigits().size();
        }

        resetOriginalBaseAndPower(originalBase, originalPow);
        return digitsOfNumbers.getLast(numDigits);
    }

    private DigitsOfNumbers initNewDigitsOfNumbers() {
        BigInteger baseBig = BigInteger.valueOf(base);
        return new DigitsOfNumbers(baseBig.pow((int) pow));
    }

    private void multiplyPowByCycleLength(int cycleLength) {
        pow *= cycleLength;
    }

    private boolean notEnoughDigitsCalculated(int numDigitsCalculated, int numDigitsToCalculate) {
        return numDigitsCalculated < numDigitsToCalculate;
    }

    public void reducePowAsMuchAsPossible(long originalBase, int cycleLength) {
        while (pow > cycleLength) {
            if (isDivisibleBy(pow, cycleLength)) {
                pow /= cycleLength;
            } else {
                base *= originalBase;
                pow--;
            }
        }
    }

    public int cycleLengthOfDigit(int digit) {
        if (digit == 1) return 1;
        int length = 0;
        int currentLast = -1;
        int multiplied = digit;
        while (currentLast != digit) {
            multiplied = multiplied * digit;
            currentLast = DigitsOfNumbers.lastDigitOf(multiplied);
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
