package main;

public interface BaseConverter {
    static boolean isBaseInAcceptedRange(int base) {
        return base >= 2 && base <= 16;
    }

    String convert(String input);
}
