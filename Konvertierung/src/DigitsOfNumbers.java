import java.util.ArrayList;

public abstract class DigitsOfNumbers<T>{

    protected T number;

    protected ArrayList<T> digits;

    public DigitsOfNumbers(T number) {
        this(number, number.toString().length());
    }

    public DigitsOfNumbers(T number, int numDigits) {
        this.number = number;
        calculateDigits(number, numDigits);
        resetNumberToOriginal(number);
    }

    protected abstract void calculateDigits(T number, int numDigits);


    private void resetNumberToOriginal(T number) {
        this.number = number;
    }

    public abstract int getCrossSum();

    public ArrayList<T> getDigits() {
        return digits;
    }
    public T getLast() {
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

    public static int lastDigitOf(long number){
        return Math.floorMod(number, 10);
    }
}
