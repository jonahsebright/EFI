package main;

public class StringUtils {
    public static String getRegexCharsOfBase(int base) {
        StringBuilder chars = new StringBuilder("01");
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 2; i < base; i++) {
            if (i < 10) {
                chars.append(i);
            } else {
                chars.append(alphabet[i - 10]);
            }
        }
        return "^[" + chars.toString() + "]+$";
    }

    public static String getRegexCharsOfBase(int base, boolean canBeFloatingPoint) {
        StringBuilder chars = new StringBuilder("-01");
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        for (int i = 2; i < base; i++) {
            if (i < 10) {
                chars.append(i);
            } else {
                chars.append(alphabet[i - 10]);
            }
        }
        if (canBeFloatingPoint) chars.append(".");
        return "^[" + chars.toString() + "]+$";
    }

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

    public static boolean containsOnlyCharsOfBase(String s, int base) {
        return containsOnlyCharsOfBase(s, base, false);
    }

    public static boolean containsOnlyCharsOfBase(String s, int base, boolean canBeFloatingPoint) {
        return s.matches(getRegexCharsOfBase(base, canBeFloatingPoint));
    }
}
