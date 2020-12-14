package test;

import flanagan.util.Strings;
import main.StringUtils;
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
    public void getRegexCharsOfBase() {
        assertEquals("^[01]+$", StringUtils.getRegexCharsOfBase(2));
        assertEquals("^[012]+$", StringUtils.getRegexCharsOfBase(3));
        assertEquals("^[012345678]+$", StringUtils.getRegexCharsOfBase(9));
        assertEquals("^[0123456789]+$", StringUtils.getRegexCharsOfBase(10));
        assertEquals("^[0123456789ABCDEF]+$", StringUtils.getRegexCharsOfBase(16));
        assertEquals("^[0123456789ABCDEFGHIJ]+$", StringUtils.getRegexCharsOfBase(20, false));

        assertEquals("^[01.]+$", StringUtils.getRegexCharsOfBase(2, true));
        assertEquals("^[0123456789ABCDEFGHIJ.]+$", StringUtils.getRegexCharsOfBase(20, true));
    }

    @Test
    void containsOnlyCharsOfBase() {
        assertTrue(StringUtils.containsOnlyCharsOfBase("0", 2));
        assertTrue(StringUtils.containsOnlyCharsOfBase("1", 2));
        assertTrue(StringUtils.containsOnlyCharsOfBase("0123456789", 10));
        assertTrue(StringUtils.containsOnlyCharsOfBase("A", 16));
        assertTrue(StringUtils.containsOnlyCharsOfBase("F", 16));
        assertTrue(StringUtils.containsOnlyCharsOfBase("123456789ABCDEF.9128374FBBB", 20, true));

        assertFalse(StringUtils.containsOnlyHexadecimalChars("a"));
        assertFalse(StringUtils.containsOnlyHexadecimalChars("0a"));
        assertFalse(StringUtils.containsOnlyHexadecimalChars("G"));
    }
}