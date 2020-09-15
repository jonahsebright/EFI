import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LastDigitsTest {

    private LastDigits lastDigits;

    @BeforeEach
    void setUp() {
        lastDigits = new LastDigits(3, 4);
    }

    @Test
    public void throwsOperationTooLongExceptionIfTakesLongerThan5Secs() {

        Exception exception = assertThrows(
                LastDigits.OperationTooLongException.class, lastDigits::tooLongOperation);

        String expectedMessage = "Operation took longer than 1 seconds, operation stopped!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void calculate() {
        //assertEquals(1, lastDigits.calculate(1));
        assertEquals(new ArrayList<>(Arrays.asList(1, 8)), lastDigits.calculate(2));
        assertEquals(new ArrayList<>(Collections.singletonList(1)), lastDigits.calculate(1));

        lastDigits = new LastDigits(2, 1000);

        assertEquals(new ArrayList<>(Collections.singletonList(6)), lastDigits.calculate(1));

        ArrayList<Integer> sol = lastDigits.calculate(10);
        System.out.println(sol);
    }

    @Test
    public void calculatesCorrectCycleLength() {
        assertEquals(1, lastDigits.cycleLengthOfDigit(1));
        assertEquals(4, lastDigits.cycleLengthOfDigit(2)); //2,4,8,6
        assertEquals(4, lastDigits.cycleLengthOfDigit(3)); //3,9,7,1
        assertEquals(2, lastDigits.cycleLengthOfDigit(4)); //4,16
        assertEquals(1, lastDigits.cycleLengthOfDigit(5));
        assertEquals(1, lastDigits.cycleLengthOfDigit(6));
        assertEquals(4, lastDigits.cycleLengthOfDigit(7)); //7, 9, 3, 1
        assertEquals(4, lastDigits.cycleLengthOfDigit(8)); //8, 4, 2, 6
        assertEquals(2, lastDigits.cycleLengthOfDigit(9)); //9, 1
    }

    @Test
    public void isDivisibleBy() {
        assertTrue(LastDigits.isDivisibleBy(1, 1));
        assertTrue(LastDigits.isDivisibleBy(2, 2));
        assertTrue(LastDigits.isDivisibleBy(4, 2));
        assertFalse(LastDigits.isDivisibleBy(4, 3));
        assertTrue(LastDigits.isDivisibleBy(144, 12));
        assertFalse(LastDigits.isDivisibleBy(144, 11));

        assertFalse(LastDigits.isEven(23));
        assertTrue(LastDigits.isEven(24));
    }
}