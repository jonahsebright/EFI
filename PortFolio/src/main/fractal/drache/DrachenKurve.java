package main.fractal.drache;

import main.fractal.Fractal;
import main.math.graph.Point;

public class DrachenKurve extends Fractal {

    public static double SQRT_2 = Math.sqrt(2);

    public static void main(String[] args) {
        DrachenKurve drachenKurve = new DrachenKurve();
        drachenKurve.drache(15);
    }

    @Override
    protected Point getStartingPoint() {
        return new Point(0.25, 0.5);
    }

    @Override
    public int getDefaultDepth() {
        return 11;
    }

    @Override
    public void drawAbstr(int depth) {
        drache(depth);
    }

    public void drache(int depth) {
        getDrawer().setPenRadius(0.002);
        drache(depth, 0.4, true);
    }

    public void drache(int level, double length, boolean direction) {
        if (level == 0) {
            schildkroete.move(length);
            incrementMoveCount();
            return;
        }
        int degreeLeft = direction ? -45 : 45;
        int degreeRight = direction ? 90 : -90;
        length /= SQRT_2;
        level--;
        schildkroete.direction(degreeLeft);
        drache(level, length, false);
        schildkroete.direction(degreeRight);
        drache(level, length, true);
        schildkroete.direction(degreeLeft);
    }
}
