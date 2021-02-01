package main;

import flanagan.io.Db;
import main.BaseConverter;

public class ProgramInput {
    public static void main(String[] args) {
        readNumberInput();
    }

    private static void readNumberInput() {
        String inBase15 = Db.readLine("Geben sie eine Zahl in Basis 15 ein", "111111111111111");
        if (StringUtils.containsOnlyCharsOfBase(inBase15, 15, false)) {
            calculateAndDisplayResult(inBase15);
        } else invalidNumber(inBase15);
    }

    private static void calculateAndDisplayResult(String inBase15) {
        boolean negative = false;
        if (inBase15.split("")[0].equals("-")) {
            inBase15 = inBase15.substring(1);
            negative = true;
        }
        BaseConverter baseConverter = new OtherBaseToOtherBase_BaseConverter(15, 9);
        String converted = baseConverter.convert(inBase15);
        if (negative) converted = "-" + converted;

        Db.show("Die Zahl in Basis 15 wurde erfolgreich in Basis 9 umgewandelt:\n",
                inBase15 + "_15" +
                        " = " + converted + "_9");
    }

    private static void invalidNumber(String inOriginalBase) {
        Db.show("Die eingebene Zahl (" + inOriginalBase + ") ist keine Zahl der Basis 15!");
        readNumberInput();
    }


}
