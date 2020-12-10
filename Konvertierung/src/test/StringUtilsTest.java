package test;

import main.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        Assertions.assertTrue(StringUtils.containsOnlyZerosAndOnes("0"));
        Assertions.assertTrue(StringUtils.containsOnlyZerosAndOnes("1"));
        Assertions.assertTrue(StringUtils.containsOnlyZerosAndOnes("10101001010100101"));
        Assertions.assertFalse(StringUtils.containsOnlyZerosAndOnes("2"));
        Assertions.assertFalse(StringUtils.containsOnlyZerosAndOnes("a"));
        Assertions.assertFalse(StringUtils.containsOnlyZerosAndOnes("1010010110101022"));
    }

    @Test
    void containsOnlyHexacecimalChars(){
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("0"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("1"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("0123456789"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("A"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("F"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("123456789ABCDEF"));

        Assertions.assertFalse(StringUtils.containsOnlyHexadecimalChars("a"));
        Assertions.assertFalse(StringUtils.containsOnlyHexadecimalChars("0a"));
        Assertions.assertFalse(StringUtils.containsOnlyHexadecimalChars("G"));
    }

    @Test
    void containsOnlyCharsOfBase(){
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("0"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("1"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("0123456789"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("A"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("F"));
        Assertions.assertTrue(StringUtils.containsOnlyHexadecimalChars("123456789ABCDEF"));

        Assertions.assertFalse(StringUtils.containsOnlyHexadecimalChars("a"));
        Assertions.assertFalse(StringUtils.containsOnlyHexadecimalChars("0a"));
        Assertions.assertFalse(StringUtils.containsOnlyHexadecimalChars("G"));
    }
}