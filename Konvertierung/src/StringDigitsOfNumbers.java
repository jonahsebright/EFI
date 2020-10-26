import java.util.ArrayList;
import java.util.Arrays;

public class StringDigitsOfNumbers extends DigitsOfNumbers<String> {

    public StringDigitsOfNumbers(String number) {
        super(number);
    }

    public StringDigitsOfNumbers(String number, int numDigits) {
        super(number, numDigits);
    }

    @Override
    protected void calculateDigits(String number, int numDigits) {
        digits = new ArrayList<>(Arrays.asList(
                number.split("")
        ));
    }

    @Override
    public int getCrossSum() {
        return 0;//TODO: implement
    }
}
