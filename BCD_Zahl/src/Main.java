import flanagan.io.Db;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        String decimal = Db.readLine("Welche Dezimalzahl möchten Sie in eine BCD-Zahl umgewandeln?",
                "013579086420");
        String[] digits = decimal.split("");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            String digit = digits[i];
            result.append(asNibble(digit));
            if(i < digits.length -1) result.append(" ");
        }
        Db.show("Die Dezimalzahl "+ decimal + " in BCD-Darstellung lautet: "+ result.toString());
        System.exit(0);
    }

    private static String asNibble(String digit) {
        switch (digit){
            case "-": return "-";
            case "0": return "0000";
            case "1": return "0001";
            case "2": return "0010";
            case "3": return "0011";
            case "4": return "0100";
            case "5": return "0101";
            case "6": return "0110";
            case "7": return "0111";
            case "8": return "1000";
            case "9": return "1001";
            default:
                Db.show("Sie haben keine Dezimalzahl angegeben");
                main(null);
        }
        return null;
    }
}
