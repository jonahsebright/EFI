package main;

import flanagan.io.Db;

public class ProgramInput {
    public static void main(String[] args) {
        readNumberInput();
    }

    private static void readNumberInput() {
        String inOriginalBase = Db.readLine("Geben sie eine Fliesskomma-Zahl in irgendeiner Basis ein", "110010101001.0000111");
        readBase(inOriginalBase);
    }

    private static void readBase(String inOriginalBase) {
        int basisOriginal = Db.readInt("In welcher Basis ist diese Zahl?");

        if (BaseConverter.isBaseInAcceptedRange(basisOriginal)) {
            if (StringUtils.containsOnlyCharsOfBase(inOriginalBase, basisOriginal, true)) {
                int scale = getInputScale();
                showUpcomingCalcDialog(inOriginalBase, basisOriginal);
                calculate(inOriginalBase, basisOriginal);
            } else invalidNumber(inOriginalBase, basisOriginal);
        } else {
            invalidBase();
        }
    }

    private static int getInputScale() {
        int scale = Db.readInt("Auf wie viele Nachkommastellen möchten Sie ihr Resultat angezeigt bekommen?", 50);
        if (scale < 0) {
            showErrorInvalidInput();
            getInputScale();
        }
        return scale;
    }

    private static void showErrorInvalidInput() {
        Db.show("The mininale Anzahl Nachkommastellen ist 0");
    }

    private static void showUpcomingCalcDialog(String inOriginalBase, int basisOriginal) {
        Db.show("Es wird die Zahl " + inOriginalBase + " in der Basis " + basisOriginal
                + " zu Basis 10 umgewandelt");
    }

    private static void invalidBase() {
        Db.show("Die Basis kann nur zwischen 2 und 16 liegen!");
        readNumberInput();
    }

    private static void invalidNumber(String inOriginalBase, int basisOriginal) {
        Db.show("Die eingebene Zahl (" + inOriginalBase + ") ist keine Zahl der Basis " +
                +basisOriginal + "!");
        readNumberInput();
    }

    private static void calculate(String inOriginalBase, int basisOriginal) {
        BaseConverter baseConverter = new OtherBaseToDecimalFloatingPointConverter(basisOriginal, 40);
        String converted = baseConverter.convert(inOriginalBase);

        Db.show("Die originale Zahl wurde erfolgreich in eine neue Basis umgewandelt:\n",
                inOriginalBase + "_" + basisOriginal +
                        " = " + converted + "_" + 10);
    }
}
