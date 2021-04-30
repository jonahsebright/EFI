package main.schneeflocke;

import flanagan.io.Db;
import main.math.graph.Point;
import main.schildkroete.Schildkroete;
import main.schildkroete.SchildkroeteImpl;

public class Schneeflocke {

    private final static int LENGTH_DIVIDER = 3;

    private int moveCount = 0;

    private final Schildkroete kroete = new SchildkroeteImpl(new Point(0.1, 0.2));

    public static void main(String[] args) {
        int level = 6;
        Schneeflocke schneeflocke = new Schneeflocke();
        long timeStart = System.currentTimeMillis();
        schneeflocke.schneeflocke(level, 0.8);

        long timeEnd = System.currentTimeMillis();
        long duration = timeEnd - timeStart;
        String formattedDuration = duration < 5000 ? duration + " ms" : duration / 1000 + " sec";
        System.out.println("Duration = " + formattedDuration);

        System.out.println("move count = " + schneeflocke.getMoveCount());

        Db.show("Finished drawing Scheeflocke with a level of " + level
                +"\nThe duration was " + formattedDuration
                + " and the move count is " + schneeflocke.moveCount);
        boolean save = Db.yesNo("Would you like to save the image as a png file?");
        if (save) schneeflocke.saveImage("schneeflocke_level_" + level + "_" + timeEnd + ".png");
    }

    public void saveImage(String filename) {
        kroete.saveImage(filename);
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void schneeflocke0(double sideLength) {
        kroete.move(sideLength);
        moveCount++;
    }

    private void schneeflocke1(double sideLength) {
        double dividedSideLength = sideLength / LENGTH_DIVIDER;
        schneeflocke0(dividedSideLength);
        kroete.direction(60);
        schneeflocke0(dividedSideLength);
        kroete.direction(-120);
        schneeflocke0(dividedSideLength);
        kroete.direction(60);
        schneeflocke0(dividedSideLength);
    }

    public void schneeflocke(int level, double sideLength) {
        moveCount = 0;
        System.out.println("Drawing schneeflocke...");
        if (level > 4) kroete.setPenRadius(0.001);
        if (level > 7) kroete.setPenRadius(0.0005);
        schneeflockeRecursive(level, sideLength);
        System.out.println("Finished drawing schneeflocke");
    }

    public void schneeflockeRecursive(int level, double sideLength) {

        if (level == 0) {
            schneeflocke0(sideLength);
            return;
        }

        level--;
        double dividedSideLength = sideLength / LENGTH_DIVIDER;
        schneeflockeRecursive(level, dividedSideLength);
        kroete.direction(60);
        schneeflockeRecursive(level, dividedSideLength);
        kroete.direction(-120);
        schneeflockeRecursive(level, dividedSideLength);
        kroete.direction(60);
        schneeflockeRecursive(level, dividedSideLength);
    }
}