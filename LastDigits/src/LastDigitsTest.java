import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(1, lastDigits.calculate(1));
        assertEquals(81, lastDigits.calculate(2));

        lastDigits = new LastDigits(2, 1000);
        assertEquals(6, lastDigits.calculate(1));
    }

    @Test
    public void calculatesCorrectCycleLenght
}