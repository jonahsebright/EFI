public class DecimalToOtherBaseConverter implements BaseConverter {
    public static String[] HEXADECIMAL_EXTRA_CHARS = {"A", "B", "C", "D", "E", "F"};
    private int otherBase;

    public DecimalToOtherBaseConverter(int otherBase) {
        this.otherBase = otherBase;
    }

    @Override
    public String convert(String inDecimal) {
        int remainder = Integer.parseInt(inDecimal);
        String result = "";
        int maxOtherBaseMagnitude = calculateHigherBaseMagnitude(remainder, otherBase);
        for (int magnitude = maxOtherBaseMagnitude; magnitude > 0; magnitude--) {
            int magVal = (int) Math.pow(otherBase, magnitude);
            int numberTimesFitsIn = remainder / magVal;
            result = addValueToResult(result, numberTimesFitsIn);
            remainder -= magVal * numberTimesFitsIn;
        }
        result = addValueToResult(result, remainder);
        return result;
    }

    public static int calculateHigherBaseMagnitude(int decimal, int higherBase) {
        int mag = 0;
        while (decimal >= Math.pow(higherBase, mag + 1)) {
            mag++;
        }
        return mag;
    }

    private String addValueToResult(String result, int valueDecimal) {
        int diff = valueDecimal - 9;
        if (diff <= 0)
            result += valueDecimal;
        else
            result += HEXADECIMAL_EXTRA_CHARS[diff - 1];
        return result;
    }
}
