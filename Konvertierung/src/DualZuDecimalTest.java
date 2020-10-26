import flanagan.util.Strings;
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
                ProgramInput.checkOnlyContainsZerosAndOnes("0101");
            }
        });

        assertThrows(ProgramInput.NoBinaryNumberException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ProgramInput.checkOnlyContainsZerosAndOnes("40101");
            }
        });
    }

    @Test
    void containsOnlyZerosAndOnes() {
        assertTrue(ProgramInput.containsOnlyZerosAndOnes("0"));
        assertTrue(ProgramInput.containsOnlyZerosAndOnes("1"));
        assertTrue(ProgramInput.containsOnlyZerosAndOnes("10101001010100101"));
        assertFalse(ProgramInput.containsOnlyZerosAndOnes("2"));
        assertFalse(ProgramInput.containsOnlyZerosAndOnes("a"));
        assertFalse(ProgramInput.containsOnlyZerosAndOnes("1010010110101022"));
    }

    @Test
    void s(){
        System.out.println(Strings.decimalToBinary("2"));
        System.out.println(Strings.decimalToBinary("9191"));
    }
}