package main;

import java.util.ArrayList;

public class LongDigitsOfNumbers extends DigitsOfNumbers<Long> {

    public LongDigitsOfNumbers(Long number) {
        super(number);
    }

    public LongDigitsOfNumbers(Long number, int numDigits) {
        super(number, numDigits);
    }

    @Override
    protected void calculateDigits(Long number, int numDigits) {
        digits = new ArrayList<>();

        for (int place = numDigits; place > 0; place--) {
            int digitPlace = (int) Math.pow(10, (place - 1)); //power of 10
            this.digits.add(getNumPowerOfTens(digitPlace));
        }
    }

    @Override
    public int getCrossSum() {
        int sum = 0;
        for (Long digit : digits) {
            sum += digit;
        }
        return sum;
    }

    private long getNumPowerOfTens(int powerOfTen) {
        int counter = 0;
        while (number >= powerOfTen) {
            counter++;
            number = number - powerOfTen;
        }
        return counter;
    }
}
