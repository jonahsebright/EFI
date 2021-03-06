import java.math.BigInteger;
import java.rmi.MarshalException;
import java.util.ArrayList;

public class DigitsOfNumbers {

    private BigInteger number;

    private ArrayList<Integer> digits;

    public DigitsOfNumbers(Long number) {
        this(BigInteger.valueOf(number));
    }

    public DigitsOfNumbers(BigInteger number) {
        this.number = number;

        digits = new ArrayList<>();

        int numDigits = calculateNumDigits(number);

        for (int place = numDigits; place > 0; place--) {
            int digitPlace = (int) Math.pow(10, (place - 1)); //power of 10
            this.digits.add(getNumPowerOfTens(digitPlace));
        }
    }

    private static int calculateNumDigits(BigInteger number) {
        //log function does not exist on BigInteger
        return number.toString().length();
    }

    private static int calculateNumDigits(int number) {
        return (int) (Math.log10(number) + 1);
    }

    private int getNumPowerOfTens(int powerOfTen) {
        int counter = 0;
        BigInteger powOfTenBig = BigInteger.valueOf(powerOfTen);
        while (number.compareTo(powOfTenBig) > 0) {
            counter++;
            number = number.subtract(powOfTenBig);
        }
        return counter;
    }

    public int getCrossSum() {
        int sum = 0;
        for (Integer digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public ArrayList<Integer> getDigits() {
        return digits;
    }

    public int getLast() {
        return digits.get(digits.size() - 1);
    }

    public String displayDigits() {
        StringBuilder result = new StringBuilder(
                "Digits of " + number + ": " + digits.get(0));
        for (int i = 1; i < digits.size(); i++) {
            result.append(", ").append(digits.get(i));
        }
        return result.toString();
    }

    public static int lastDigitOf(long number) {
        return Math.floorMod(number, 10);
    }

    public ArrayList<Integer> getLast(int numDigits) {
        ArrayList<Integer> lastDigits = new ArrayList<>();
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (lastDigits.size() == numDigits) break;
            lastDigits.add(digits.get(i));
        }
        return lastDigits;
    }
}
