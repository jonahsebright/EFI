package main.schneeflocke;

import flanagan.io.Db;
import main.fractal.Fractal;
import main.draw.Drawer;
import main.math.graph.Point;
import main.fractal.schildkroete.Schildkroete;
import main.fractal.schildkroete.SchildkroeteImpl;

public class Schneeflocke extends Fractal {

    private final static int LENGTH_DIVIDER = 3;

    private int moveCount = 0;

    private final Schildkroete schildkroete = new SchildkroeteImpl(new Point(0.1, 0.27));

    public static void main(String[] args) {
        int level = 7;
        Schneeflocke schneeflocke = new Schneeflocke();
        long timeStart = System.currentTimeMillis();
        schneeflocke.schneeflocke(level, 0.8);

        long timeEnd = System.currentTimeMillis();
        long duration = timeEnd - timeStart;
        String formattedDuration = duration < 5000 ? duration + " ms" : duration / 1000 + " sec";
        System.out.println("Duration = " + formattedDuration);

        System.out.println("move count = " + schneeflocke.getMoveCount());

        Db.show("Finished drawing Scheeflocke with a level of " + level
                + "\nThe duration was " + formattedDuration
                + " and the move count is " + schneeflocke.moveCount);
        boolean save = Db.yesNo("Would you like to save the image as a png file?");
        if (save) schneeflocke.savePng("schneeflocke_level_" + level + "_" + timeEnd);
    }

    @Override
    public int getDefaultDepth() {
        return 5;
    }

    @Override
    public void draw(int depth) {
        schneeflocke(depth, 0.8);
    }

    @Override
    public Drawer getDrawer() {
        return schildkroete.getDrawer();
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void schneeflocke(int level, double sideLength) {
        moveCount = 0;
        System.out.println("Drawing schneeflocke...");
        if (level > 4) schildkroete.setPenRadius(0.001);
        if (level > 7) schildkroete.setPenRadius(0.0005);
        schildkroete.direction(60);
        schneeflockeRecursive(level, sideLength);
        schildkroete.direction(-120);
        schneeflockeRecursive(level, sideLength);
        schildkroete.direction(-120);
        schneeflockeRecursive(level, sideLength);
        System.out.println("Finished drawing schneeflocke");
    }

    private void schneeflockeRecursive(int level, double sideLength) {
        if (level == 0) {
            schildkroete.move(sideLength);
            moveCount++;
            return;
        }
        level--;
        double dividedSideLength = sideLength / LENGTH_DIVIDER;
        schneeflockeRecursive(level, dividedSideLength);
        schildkroete.direction(60);
        schneeflockeRecursive(level, dividedSideLength);
        schildkroete.direction(-120);
        schneeflockeRecursive(level, dividedSideLength);
        schildkroete.direction(60);
        schneeflockeRecursive(level, dividedSideLength);
    }
}
