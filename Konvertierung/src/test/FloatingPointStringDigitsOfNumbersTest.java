package test;

import main.FloatingPointStringDigitsOfNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class FloatingPointStringDigitsOfNumbersTest {

    @Test
    void getPosPoint() {
        FloatingPointStringDigitsOfNumbers digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("1");
        Assertions.assertEquals(-1, digitsOfNumbers.getPosPoint());
        digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("1.");
        Assertions.assertEquals(1, digitsOfNumbers.getPosPoint());
        digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("1999229.181992");
        Assertions.assertEquals(7, digitsOfNumbers.getPosPoint());
    }

    @Test
    void getDigitsBeforePoint() {
        FloatingPointStringDigitsOfNumbers digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("1");
        Assertions.assertEquals(Collections.singletonList("1"), digitsOfNumbers.getDigitsBeforePoint());
        digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("2.");
        Assertions.assertEquals(Collections.singletonList("2"), digitsOfNumbers.getDigitsBeforePoint());
        digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("1999229.181992");
        Assertions.assertEquals(Arrays.asList("1", "9", "9", "9", "2", "2", "9"), digitsOfNumbers.getDigitsBeforePoint());
    }

    @Test
    void getDigitsAfterPoint() {
        FloatingPointStringDigitsOfNumbers digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("1");
        Assertions.assertEquals(Collections.emptyList(), digitsOfNumbers.getDigitsAfterPoint());
        digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("2.4");
        Assertions.assertEquals(Collections.singletonList("4"), digitsOfNumbers.getDigitsAfterPoint());
        digitsOfNumbers = new FloatingPointStringDigitsOfNumbers("1999229.181992");
        Assertions.assertEquals(Arrays.asList("1", "8", "1", "9", "9", "2"), digitsOfNumbers.getDigitsAfterPoint());
    }

}