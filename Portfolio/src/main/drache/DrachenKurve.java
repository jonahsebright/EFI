package main.drache;

import main.Fractal;
import main.draw.Drawer;
import main.math.graph.Point;
import main.schildkroete.Schildkroete;
import main.schildkroete.SchildkroeteImpl;

public class DrachenKurve extends Fractal {

    public static double SQRT_2 = Math.sqrt(2);

    private final Schildkroete schildkroete = new SchildkroeteImpl(new Point(0.25, 0.5));

    public static void main(String[] args) {
        DrachenKurve drachenKurve = new DrachenKurve();
        drachenKurve.drache(15);
    }

    @Override
    public int getDefaultDepth() {
        return 11;
    }

    @Override
    public void draw(int depth) {
        drache(depth);
    }

    @Override
    public Drawer getDrawer() {
        return schildkroete.getDrawer();
    }

    public void drache(int depth) {
       drache(depth, 0.4, true);
    }

    public void drache(int level, double length, boolean direction) {
        if (level == 0) {
            schildkroete.move(length);
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
