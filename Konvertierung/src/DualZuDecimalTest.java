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
}