package main;

import flanagan.io.Db;
import main.BaseConverter;

public class ProgramInput {
    public static void main(String[] args) {
        readNumberInput();
    }

    private static void readNumberInput() {
        String inOriginalBase = Db.readLine("Geben sie eine Zahl in irgendeiner Basis ein", "110010101001");
        readBase(inOriginalBase);
    }

    private static void readBase(String inOriginalBase) {
        int basisOriginal = Db.readInt("In welcher Basis ist diese Zahl?");

        if (BaseConverter.isBaseInAcceptedRange(basisOriginal)) {
            if (StringUtils.containsOnlyCharsOfBase(inOriginalBase, basisOriginal, false))
                readNewBase(inOriginalBase, basisOriginal);
            else invalidNumber(inOriginalBase, basisOriginal);
        } else {
            invalidBase();
        }
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

    private static void readNewBase(String inOriginalBase, int basisOriginal) {
        int basisNeu = Db.readInt("Zu welcher Basis möchten Sie die Zahl konvertieren?");
        if(BaseConverter.isBaseInAcceptedRange(basisNeu))
            validNewBase(inOriginalBase, basisOriginal, basisNeu);
        else invalidNewBase(inOriginalBase, basisOriginal);
    }

    private static void invalidNewBase(String inOriginalBase, int basisOriginal) {
        Db.show("Die Basis kann nur zwischen 2 und 16 liegen!");
        readNewBase(inOriginalBase, basisOriginal);
    }

    private static void validNewBase(String inOriginalBase, int basisOriginal, int basisNeu) {
        BaseConverter baseConverter = BaseConverterFactory.create(basisOriginal, basisNeu);
        String converted = baseConverter.convert(inOriginalBase);

        Db.show("Die originale Zahl wurde erfolgreich in eine neue Basis umgewandelt:\n",
                inOriginalBase + "_" + basisOriginal +
                        " = " + converted + "_" + basisNeu);
    }
}
