package main;

import flanagan.io.Db;

public class ProgramInput {
    public static void main(String[] args) {
        readDualInput();
    }

    private static void readDualInput() {
        String inOriginalBase = Db.readLine("Geben sie eine Zahl in irgendeiner Basis ein", "110010101001");
        int basisOriginal = Db.readInt("In welcher Basis ist diese Zahl?");
        int basisNeu = Db.readInt("Zu welcher Basis möchten Sie die Zahl konvertieren?");

        BaseConverter baseConverter = BaseConverterFactory.create(basisOriginal, basisNeu);
        String converted = baseConverter.convert(inOriginalBase);

        Db.show("Die originale Zahl wurde erfolgreich in eine neue Basis umgewandelt:\n",
                inOriginalBase + "_" + basisOriginal +
                        " = " + converted + "_" + basisNeu);
        /*
        try {
            main.StringUtils.checkOnlyContainsZerosAndOnes(dual_str);
            String decimal = new main.OtherBaseToDecimalConverter().convert(dual_str, 2);
            Db.show("Die binäre Zahl wurde erfolgreich in eine Decimalzahl umgewandelt:\n",
                    dual_str + "_2 = " + decimal + "_10");
        } catch (NumberFormatException e) {
            Db.show("Die eingebene Zahl (" + dual_str + ") wahr keine Zahl!");
            readDualInput();
        } catch (main.StringUtils.NoBinaryNumberException noBinaryNumberException) {
            Db.show("Die eingebene Zahl (" + dual_str + ") wahr keine Binärzahl!");
        }

         */
    }
}
