package main.fractal.pfeilspitze;

import main.draw.Drawer;
import main.fractal.Fractal;
import main.math.graph.Point;

public class Pfeilspitze extends Fractal {

    @Override
    protected Point getStartingPoint() {
        return new Point(0.1, 0.2);
    }

    public static void main(String[] args) {
        Pfeilspitze pfeilspitze = new Pfeilspitze();
        pfeilspitze.getSchildkroete().setPenRadius(0.0005);
        int level = pfeilspitze.getDefaultDepth();
        pfeilspitze.pfeilspitze(level, 0.8);
    }

    @Override
    public int getDefaultDepth() {
        return 6;
    }

    @Override
    public void drawAbstr(int depth) {
        pfeilspitze(depth, 0.8);
    }

    @Override
    public Drawer getDrawer() {
        return schildkroete.getDrawer();
    }

    public void pfeilspitze(int level, double length) {
        getDrawer().setPenRadius(0.002);
        pfeilspitze(level, length, true);
    }

    public void pfeilspitze(int level, double length, boolean direction) {
        if (level == 0) {
            schildkroete.move(length);
            incrementMoveCount();
        } else {
            length /= 2;
            level--;
            int degree = direction ? 60 : -60;
            schildkroete.direction(degree);
            pfeilspitze(level, length, !direction);
            schildkroete.direction(-degree);
            pfeilspitze(level, length, direction);
            schildkroete.direction(-degree);
            pfeilspitze(level, length, !direction);
            schildkroete.direction(degree);
        }
    }
}
