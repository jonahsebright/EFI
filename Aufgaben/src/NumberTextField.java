import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.text.ParseException;

public class NumberTextField {

    public NumberTextField() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        NumberFormatter numberFormatter  = new NumberFormatter(numberFormat);
        JFormattedTextField textField = new JFormattedTextField(numberFormatter);
    }

}
