import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitsOfNumbersTest {

    private DigitsOfNumbers digitsOfNumbers;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void test() {
        digitsOfNumbers = new DigitsOfNumbers(3869, 4);
        assertEquals(4, digitsOfNumbers.getDigits().size());

        assertEquals(3, digitsOfNumbers.getDigits().get(0));
        assertEquals(8, digitsOfNumbers.getDigits().get(1));
        assertEquals(6, digitsOfNumbers.getDigits().get(2));
        assertEquals(9, digitsOfNumbers.getDigits().get(3));

    }

    @Test
    public void calcCrossSum() {
        digitsOfNumbers = new DigitsOfNumbers(39289, 5);
        assertEquals(3 + 9 + 2 + 8 + 9, digitsOfNumbers.getCrossSum());
    }

    @Test
    public void displayDigits() {
        digitsOfNumbers = new DigitsOfNumbers(39289,5);
        assertEquals("Digits of 39289: 3, 9, 2, 8, 9" , digitsOfNumbers.displayDigits());
    }
}