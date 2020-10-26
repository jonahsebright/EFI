import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class DualZuDecimalTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void checkOnlyContainsZerosAndOnes() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                DualZuDecimal.checkOnlyContainsZerosAndOnes("0101");
            }
        });

        assertThrows(DualZuDecimal.NoBinaryNumberException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                DualZuDecimal.checkOnlyContainsZerosAndOnes("40101");
            }
        });
    }

    @Test
    void containsOnlyZerosAndOnes() {
        assertTrue(DualZuDecimal.containsOnlyZerosAndOnes("0"));
        assertTrue(DualZuDecimal.containsOnlyZerosAndOnes("1"));
        assertTrue(DualZuDecimal.containsOnlyZerosAndOnes("10101001010100101"));
        assertFalse(DualZuDecimal.containsOnlyZerosAndOnes("2"));
        assertFalse(DualZuDecimal.containsOnlyZerosAndOnes("a"));
        assertFalse(DualZuDecimal.containsOnlyZerosAndOnes("1010010110101022"));
    }

    @Test
    void dualToDecimal(){
        assertEquals(0, DualZuDecimal.convertToDecimal("0").intValueExact());
        assertEquals(1, DualZuDecimal.convertToDecimal("1").intValueExact());
        assertEquals(2, DualZuDecimal.convertToDecimal("10").intValueExact());
        assertEquals(3, DualZuDecimal.convertToDecimal("11").intValueExact());
        assertEquals(4, DualZuDecimal.convertToDecimal("100").intValueExact());
        assertEquals(1485553, DualZuDecimal.convertToDecimal("101101010101011110001").intValueExact());
        assertEquals(17570460958271L, DualZuDecimal.convertToDecimal("11111111101011110001000101010111111000111111").longValue());

    }
}