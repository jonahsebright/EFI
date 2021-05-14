package main.gui;

import flanagan.io.Db;

import javax.swing.*;

public class Input {
    public static int getFractalSelection(String[] fractals){
        int selection = Db.optionBox("Which Fractals would you like to see?", fractals, fractals, 1);
        if (selection == 0) {
            checkQuit();
            return getFractalSelection(fractals);
        }
        return selection;
    }

    public static int readDepth(String option, int defaultDepth) {
        int depth = Db.readInt("Bis zu welcher Stufe (natürliche Zahl) möchten Sie " + option + " zeichnen?",
                defaultDepth);
        System.out.println("depth = " + depth);
        if (depth < 0) {
            JOptionPane.showMessageDialog(null, "Die eingebene Stufe war negativ!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return readDepth(option, defaultDepth);
        }
        return depth;
    }

    private static void checkQuit() {
        if (quit()) System.exit(0);
    }

    private static boolean quit() {
        return Db.yesNo("Would you like to quit?");
    }

    public static boolean askSave() {
        return Db.yesNo("Would you like to save the image as a .png file?");
    }

    public static String readFilename(String fractalName, int depth) {
        String filename = Db.readLine("Filename", fractalName + "_depth_" + depth);
        filename = filename.trim();
        if (filename.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Filename cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return readFilename(fractalName, depth);
        } else return filename;
    }

    public static boolean _continue() {
        return Db.yesNo("Would you like to continue?");
    }
}
