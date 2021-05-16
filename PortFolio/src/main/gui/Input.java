package main.gui;

import flanagan.io.Db;

import javax.swing.*;

public class Input {
    public static int getMonsterkurveSelection(String[] monsterkurvenNames) {
        int selection = Db.optionBox("Welche Monsterkurve möchten Sie sehen?", monsterkurvenNames, monsterkurvenNames, 1);
        if (selection == 0) {
            checkQuit();
            return getMonsterkurveSelection(monsterkurvenNames);
        }
        return selection;
    }

    public static int readDepth(String option, int defaultDepth) {
        int depth = Db.readInt("Bis zu welcher Stufe (natürliche Zahl) möchten Sie " + option + " zeichnen?",
                defaultDepth);
        System.out.println("depth = " + depth);
        if (depth < 0) {
            JOptionPane.showMessageDialog(null, "Die eingebene Stufe war negativ!",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            return readDepth(option, defaultDepth);
        } else if (depth > 100) {
            JOptionPane.showMessageDialog(null, "Die eingebene Stufe war zu gross! Das maximum ist 100",
                    "Fehler", JOptionPane.ERROR_MESSAGE);
            return readDepth(option, defaultDepth);
        }
        return depth;
    }

    private static void checkQuit() {
        if (quit()) System.exit(0);
    }

    private static boolean quit() {
        return Db.yesNo("Möchten Sie das Pogramm beenden?");
    }

    public static boolean askSave() {
        return Db.yesNo("Möchten Sie das Bild als ein PNG-Datei speichern?");
    }

    public static String readFilename(String kurvenName, int depth) {
        String filename = Db.readLine("Dateiname", kurvenName + "_Stufe_" + depth);
        filename = filename.trim();
        if (filename.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Dateiname darf nicht leer sein!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return readFilename(kurvenName, depth);
        } else return filename;
    }

    public static boolean _continue() {
        return Db.yesNo("Möchten Sie fortfahren?");
    }
}
