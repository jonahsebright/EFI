package main;

import main.monsterkurve.Monsterkurve;
import main.gui.Input;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int fractalSelection = Input.getMonsterkurveSelection(Monsterkurve.NAMES);
        String fractalName = Monsterkurve.NAMES[fractalSelection - 1];
        System.out.println("fractal = " + fractalName);

        Monsterkurve monsterkurve = Monsterkurve.getFractalFromName(fractalName);

        int depth = Input.readDepth(fractalName, monsterkurve.getDefaultDepth());
        monsterkurve.draw(depth);

        boolean save = Input.askSave();
        if (save){
            attemptSaveImage(fractalName, monsterkurve, depth);
        };

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
