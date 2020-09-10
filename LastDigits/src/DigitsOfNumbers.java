import java.util.ArrayList;

public class DigitsOfNumbers {

    private long number;

    private String numberStr;

    private ArrayList<Integer> digits;

    public DigitsOfNumbers(Long number) {
        this(number, number.toString().length());
    }

    public DigitsOfNumbers(Long number, int numDigits) {
        this.number = number;
        numberStr = String.valueOf(number);

        digits = new ArrayList<>();

        for (int place = numDigits; place > 0; place--) {
            int digitPlace = (int) Math.pow(10, (place - 1)); //power of 10
            this.digits.add(getNumPowerOfTens(digitPlace));
        }
    }

    private int getNumPowerOfTens(int powerOfTen) {
        int counter = 0;
        while (number >= powerOfTen) {
            counter++;
            number = number - powerOfTen;
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
                "Digits of " + numberStr + ": " + digits.get(0));
        for (int i = 1; i < digits.size(); i++) {
            result.append(", ").append(digits.get(i));
        }
        return result.toString();
    }

    public static int lastDigitOf(long number){
        return Math.floorMod(number, 10);
    }
}
