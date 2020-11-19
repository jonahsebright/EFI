import flanagan.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void checkOnlyContainsZerosAndOnes() {
        assertDoesNotThrow(new Executable() {
            @Override
            public void execute() throws Throwable {
                StringUtils.checkOnlyContainsZerosAndOnes("0101");
            }
        });

        assertThrows(StringUtils.NoBinaryNumberException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                StringUtils.checkOnlyContainsZerosAndOnes("40101");
            }
        });
    }

    @Test
    void containsOnlyZerosAndOnes() {
        assertTrue(StringUtils.containsOnlyZerosAndOnes("0"));
        assertTrue(StringUtils.containsOnlyZerosAndOnes("1"));
        assertTrue(StringUtils.containsOnlyZerosAndOnes("10101001010100101"));
        assertFalse(StringUtils.containsOnlyZerosAndOnes("2"));
        assertFalse(StringUtils.containsOnlyZerosAndOnes("a"));
        assertFalse(StringUtils.containsOnlyZerosAndOnes("1010010110101022"));
    }

    @Test
    void containsOnlyHexacecimalChars(){
        assertTrue(StringUtils.containsOnlyHexadecimalChars("0"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("1"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("0123456789"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("A"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("F"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("123456789ABCDEF"));

        assertFalse(StringUtils.containsOnlyHexadecimalChars("a"));
        assertFalse(StringUtils.containsOnlyHexadecimalChars("0a"));
        assertFalse(StringUtils.containsOnlyHexadecimalChars("G"));
    }

    @Test
    void containsOnlyCharsOfBase(){
        assertTrue(StringUtils.containsOnlyHexadecimalChars("0"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("1"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("0123456789"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("A"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("F"));
        assertTrue(StringUtils.containsOnlyHexadecimalChars("123456789ABCDEF"));

        assertFalse(StringUtils.containsOnlyHexadecimalChars("a"));
        assertFalse(StringUtils.containsOnlyHexadecimalChars("0a"));
        assertFalse(StringUtils.containsOnlyHexadecimalChars("G"));
    }
}