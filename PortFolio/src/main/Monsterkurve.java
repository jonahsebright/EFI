package main;

import flanagan.io.Db;
import main.drache.DrachenKurve;
import main.pfeilspitze.Pfeilspitze;
import main.schneeflocke.Schneeflocke;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Monsterkurve {

    public static final String SCHNEE_FLOCKE = "Schneeflocke";
    public static final String DRACHEN_KURVE = "Drachenkurve";
    public static final String PFEIL_SPITZE = "Pfeilspitze";

    public static final String ALL = "All";

    public static void main(String[] args) {
        String headerComment = "Which Fractals would you like to see?";
        String[] comments_and_boxTitles = {SCHNEE_FLOCKE, DRACHEN_KURVE, PFEIL_SPITZE/*, ALL*/};
        int defaultBox = 1;
        int opt = Db.optionBox(headerComment, comments_and_boxTitles, comments_and_boxTitles, defaultBox);
        if (opt == 0) {
            checkQuit();
            main(args);
        }
        String option = comments_and_boxTitles[opt - 1];
        System.out.println("option = " + option);
        Fractal fractal = getFractalFromOption(option);
        int depth = readDepth(option, fractal);
        fractal.draw(depth);
        askSave(fractal, option, depth);
        boolean _continue = Db.yesNo("Would you like to continue?");
        if (_continue) {
            clearDrawing(fractal);
            main(args);
        }
        System.exit(0);
    }

    private static void clearDrawing(Fractal fractal) {
        fractal.getDrawer().clear();
    }

    private static void askSave(Fractal fractal, String option, int depth) {
        boolean save = Db.yesNo("Would you like to save the image as a .png file?");
        if (!save) return;
        String filename = Db.readLine("Filename", option + "_depth_" + depth);
        fractal.savePng(filename);
        JOptionPane.showMessageDialog(null, "Saved the image!");
    }

    private static void checkQuit() {
        if (quit()) System.exit(0);
    }

    private static boolean quit() {
        return Db.yesNo("Would you like to quit?");
    }

    private static int readDepth(String option, Fractal fractal) {
        int depth = Db.readInt("Bis zu welcher Stufe (natürliche Zahl) möchten Sie " + option + " zeichnen?",
                fractal.getDefaultDepth());
        System.out.println("depth = " + depth);
        if (depth < 0) {
            JOptionPane.showMessageDialog(null, "Die eingebene Stufe war negativ!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return readDepth(option, fractal);
        }
        return depth;
    }

    private static Fractal getFractalFromOption(String option) {
        return switch (option) {
            case SCHNEE_FLOCKE -> new Schneeflocke();
            case DRACHEN_KURVE -> new DrachenKurve();
            case PFEIL_SPITZE -> new Pfeilspitze();
            default -> throw new IllegalArgumentException("Option " + option + " was not valid!");
        };
    }
}
