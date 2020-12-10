package main;

import flanagan.util.Strings;

public class StringUtils {
    public static class NoBinaryNumberException extends RuntimeException {
        @Override
        public String getMessage() {
            return "Input was no binary number";
        }
    }

    public static void checkOnlyContainsZerosAndOnes(String dual_str) {
        if (!containsOnlyZerosAndOnes(dual_str)) {
            throw new NoBinaryNumberException();
        }
    }

    public static boolean containsOnlyZerosAndOnes(String dual_str) {
        return dual_str.matches("^[01]+$");
    }

    public static boolean containsOnlyHexadecimalChars(String s) {
        return s.matches("^[0123456789ABCDEF]+$");
    }
}
