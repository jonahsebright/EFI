import java.math.BigInteger;

public class BaseConversionUtils {
    static BigInteger calculateDigitVal(String digit, int magnitude, int base) {
        return new BigInteger(digit)
                .multiply(BigInteger.valueOf(base).pow(magnitude));
    }
}
