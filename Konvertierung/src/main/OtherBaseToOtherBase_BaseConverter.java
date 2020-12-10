package main;

public class OtherBaseToOtherBase_BaseConverter implements BaseConverter {
    private int originalBase;
    private int newBase;

    public OtherBaseToOtherBase_BaseConverter(int originalBase, int newBase) {
        this.originalBase = originalBase;
        this.newBase = newBase;
    }

    @Override
    public String convert(String input) {
        String inDecimal = new OtherBaseToDecimalConverter(originalBase).convert(input);
        return new DecimalToOtherBaseConverter(newBase).convert(inDecimal);
    }
}
