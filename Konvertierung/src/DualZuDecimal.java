import flanagan.io.Db;

public class DualZuDecimal {
    public static void main(String[] args) {
        readDualInput();
    }

    private static void readDualInput() {
        String dual_str = String.valueOf(Db.readLine("Geben sie eine Binärzahl ein", "110010101001"));
        try {
            int dual = Integer.parseInt(dual_str);
            checkOnlyContainsZerosAndOnes(dual_str);
            convertToDecimal(dual_str);
        } catch (NumberFormatException e) {
            Db.show("Die eingebene Zahl (" + dual_str + ") wahr keine Zahl!");
            readDualInput();
        } catch (NoBinaryNumberException noBinaryNumberException) {
            Db.show("Die eingebene Zahl (" + dual_str + ") wahr keine Binärzahl!");

        }
    }

    private static void convertToDecimal(String dual_str) {
        //TODO: implement
    }

    public static class NoBinaryNumberException extends RuntimeException {
        @Override
        public String getMessage() {
            return "Input was no binary number";
        }
    }

    public static void checkOnlyContainsZerosAndOnes(String dual_str) {
        if (containsOnlyZerosAndOnes(dual_str)) {
            // contains only listed chars
        } else {
            // contains other chars
            throw new NoBinaryNumberException();
        }
    }

    public static boolean containsOnlyZerosAndOnes(String dual_str) {
        return dual_str.matches("^[01]+$");
    }
}
