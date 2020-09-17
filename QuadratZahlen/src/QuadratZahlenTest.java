import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class QuadratZahlenTest {

    @Test
    void calculate() {
        assertRestIs_0_Or_1(1);
        assertRestIs_0_Or_1(5);
        assertRestIs_0_Or_1(1234);
        assertRestIs_0_Or_1(1235);
        assertRestIs_0_Or_1(123456789);


        assertIsNotSquareNumber(11);
        assertIsNotSquareNumber(111);
        assertIsNotSquareNumber(1111111111);
    }

    private void assertIsNotSquareNumber(int square) {
        BigInteger[] sol = QuadratZahlen.calculate(BigInteger.valueOf(square));
        int rest = sol[1].intValueExact();
        assertFalse(rest == 0 || rest == 1);
    }

    private void assertRestIs_0_Or_1(int a) {
        QuadratZahlen.setA(BigInteger.valueOf(a));
        BigInteger[] sol = QuadratZahlen.calculate();
        int rest = sol[1].intValueExact();
        assertTrue(rest == 0 || rest == 1);
    }

    @Test
    public void isEven() {
        assertTrue(isEven(8));
        assertFalse(isEven(9));
        assertTrue(isEven(10));
        assertFalse(isEven(11));

        assertTrue(isEven(2 * 35 * 6687 * 923));
        assertFalse(isEven(2 * 35 * 6687 * 923 + 1));

    }

    public boolean isEven(int i) {
        return i / 2 == (i + 1) / 2;
    }
}