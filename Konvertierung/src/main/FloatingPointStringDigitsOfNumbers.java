package main;

import java.util.Collections;
import java.util.List;

public class FloatingPointStringDigitsOfNumbers extends StringDigitsOfNumbers {
    public FloatingPointStringDigitsOfNumbers(String number) {
        super(number);
    }

    public FloatingPointStringDigitsOfNumbers(String number, int numDigits) {
        super(number, numDigits);
    }

    public int getPosPoint() {
        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i).equals(".")) return i;
        }
        return -1;
    }

    public List<String> getDigitsBeforePoint() {
        if (getPosPoint() == -1) return digits;
        return digits.subList(0, getPosPoint());
    }

    public List<String> getDigitsAfterPoint() {
        if (getPosPoint() == -1) return Collections.emptyList();
        return digits.subList(getPosPoint() + 1, digits.size());
    }
}
