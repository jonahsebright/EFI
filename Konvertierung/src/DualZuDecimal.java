import flanagan.io.Db;

import java.math.BigInteger;

public class DualZuDecimal {
    public static void main(String[] args) {
        readDualInput();
    }

    private static void readDualInput() {
        String dual_str = String.valueOf(Db.readLine("Geben sie eine Binärzahl ein", "110010101001"));
        try {
            checkOnlyContainsZerosAndOnes(dual_str);
            BigInteger decimal = convertToDecimal(dual_str);
            Db.show("Die binäre Zahl wurde erfolgreich in eine Decimalzahl umgewandelt:\n",
                    dual_str + "_2 = " + decimal + "_10");
        } catch (NumberFormatException e) {
            Db.show("Die eingebene Zahl (" + dual_str + ") wahr keine Zahl!");
            readDualInput();
        } catch (NoBinaryNumberException noBinaryNumberException) {
            Db.show("Die eingebene Zahl (" + dual_str + ") wahr keine Binärzahl!");

        }
    }

    public static BigInteger convertToDecimal(String dual_str) {
        String[] digits = dual_str.split("");
        int numDigits = digits.length;
        BigInteger decimalResult = BigInteger.ZERO;
        for (int i = digits.length - 1; i >= 0; i--) {
            String digit = digits[i];
            int digitVal = Integer.parseInt(digit);
            BigInteger digitBig = BigInteger.valueOf(digitVal);
            BigInteger pow_2 = BigInteger.valueOf(2).pow(numDigits - i - 1);
            decimalResult = decimalResult.add(pow_2.multiply(digitBig));
        }
        return decimalResult;
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
}
