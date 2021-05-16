package main;

import main.monsterkurve.Monsterkurve;
import main.gui.Input;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int kurvenSelection = Input.getMonsterkurveSelection(Monsterkurve.NAMES);
        String kurveName = Monsterkurve.NAMES[kurvenSelection - 1];
        System.out.println("monsterkurve = " + kurveName);

        Monsterkurve monsterkurve = Monsterkurve.getFractalFromName(kurveName);

        int depth = Input.readDepth(kurveName, monsterkurve.getDefaultDepth());
        monsterkurve.draw(depth);

        boolean save = Input.askSave();

        if (save) attemptSaveImage(kurveName, monsterkurve, depth);

        if (Input._continue()) {
            monsterkurve.clear();
            main(args);
        } else System.exit(0);
    }

    private static void attemptSaveImage(String fractalName, Monsterkurve monsterkurve, int depth) {
        String filename = Input.readFilename(fractalName, depth);
        monsterkurve.savePng(filename);
        JOptionPane.showMessageDialog(null, "Saved the image!",
                filename, JOptionPane.INFORMATION_MESSAGE);
    }
}
