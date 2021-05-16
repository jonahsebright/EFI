package main.monsterkurve.schneeflocke;

import flanagan.io.Db;
import main.monsterkurve.Monsterkurve;
import main.math.graph.Point;

public class Schneeflocke extends Monsterkurve {

    private final static int LENGTH_DIVIDER = 3;

    @Override
    protected Point getStartingPoint() {
        return new Point(0.1, 0.27);
    }

    public static void main(String[] args) {
        int level = 7;
        Schneeflocke schneeflocke = new Schneeflocke();
        long timeStart = System.currentTimeMillis();
        schneeflocke.schneeflockeTriangle(level, 0.8);

        long timeEnd = System.currentTimeMillis();
        long duration = timeEnd - timeStart;
        String formattedDuration = duration < 5000 ? duration + " ms" : duration / 1000 + " sec";
        System.out.println("Duration = " + formattedDuration);

        System.out.println("move count = " + schneeflocke.getMoveCount());

        Db.show("Finished drawing Scheeflocke with a level of " + level
                + "\nThe duration was " + formattedDuration
                + " and the move count is " + schneeflocke.getMoveCount());
        boolean save = Db.yesNo("Would you like to save the image as a png file?");
        if (save) schneeflocke.savePng("schneeflocke_level_" + level + "_" + timeEnd);
    }

    @Override
    public int getDefaultDepth() {
        return 5;
    }

    @Override
    public void drawAbstr(int depth) {
        schneeflockeTriangle(depth, 0.8);
    }

    public void schneeflockeTriangle(int depth, double sideLength) {
        System.out.println("Drawing schneeflocke...");
        if (depth > 4) schildkroete.setPenRadius(0.001);
        if (depth > 7) schildkroete.setPenRadius(0.0005);
        schildkroete.direction(60);
        schneeflockeRecursive(depth, sideLength);
        schildkroete.direction(-120);
        schneeflockeRecursive(depth, sideLength);
        schildkroete.direction(-120);
        schneeflockeRecursive(depth, sideLength);
        System.out.println("Finished drawing schneeflocke");
    }

    public void schneeflockeRecursive(int depth, double sideLength) {
        if (depth == 0) {
            schildkroete.move(sideLength);
            incrementMoveCount();
        } else {
            depth--;
            double dividedSideLength = sideLength / LENGTH_DIVIDER;
            schneeflockeRecursive(depth, dividedSideLength);
            schildkroete.direction(60);
            schneeflockeRecursive(depth, dividedSideLength);
            schildkroete.direction(-120);
            schneeflockeRecursive(depth, dividedSideLength);
            schildkroete.direction(60);
            schneeflockeRecursive(depth, dividedSideLength);
        }
    }
}
