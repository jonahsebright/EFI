package main;

import main.fractal.Fractal;
import main.gui.Input;

import javax.swing.*;

public class Monsterkurve {

    public static void main(String[] args) {
        int fractalSelection = Input.getFractalSelection(Fractal.NAMES);
        String fractalName = Fractal.NAMES[fractalSelection - 1];
        System.out.println("fractal = " + fractalName);

        Fractal fractal = Fractal.getFractalFromName(fractalName);

        int depth = Input.readDepth(fractalName, fractal.getDefaultDepth());
        fractal.draw(depth);

        boolean save = Input.askSave();
        if (save){
            attemptSaveImage(fractalName, fractal, depth);
        };

        if (Input._continue()) {
            clearDrawing(fractal);
            main(args);
        } else System.exit(0);
    }

    private static void attemptSaveImage(String fractalName, Fractal fractal, int depth) {
        String filename = Input.readFilename(fractalName, depth);
        fractal.savePng(filename);
        JOptionPane.showMessageDialog(null, "Saved the image!",
                filename, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void clearDrawing(Fractal fractal) {
        fractal.getDrawer().clear();
    }

}
