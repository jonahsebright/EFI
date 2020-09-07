import java.util.ArrayList;

public class DigitsOfNumbers {

    private int number;

    private String numberStr;

    private ArrayList<Integer> digits;

    public DigitsOfNumbers(Integer number, int numDigits) {
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

    public String displayDigits() {
        StringBuilder result = new StringBuilder(
                "Digits of " + numberStr + ": " + digits.get(0));
        for (int i = 1; i < digits.size(); i++) {
            result.append(", ").append(digits.get(i));
        }
        return result.toString();
    }
}
