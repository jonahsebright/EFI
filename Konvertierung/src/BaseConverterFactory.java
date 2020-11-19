public class BaseConverterFactory {
    public static BaseConverter create(int basisOriginal, int basisNeu) {
        if (basisNeu == basisOriginal) return new SameBase_BaseConverter();
        if (basisOriginal == 10) return new DecimalToOtherBaseConverter(basisNeu);
        else if (basisNeu == 10) return new OtherBaseToDecimalConverter(basisOriginal);
        // none of the bases are decimal
        return new OtherBaseToOtherBase_BaseConverter(basisOriginal, basisNeu);
    }
}
