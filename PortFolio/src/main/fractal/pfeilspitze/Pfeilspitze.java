package main.fractal.pfeilspitze;

import main.fractal.Fractal;
import main.draw.Drawer;
import main.math.graph.Point;
import main.fractal.schildkroete.Schildkroete;
import main.fractal.schildkroete.SchildkroeteImpl;

public class Pfeilspitze extends Fractal {

    private final Schildkroete schildkroete = new SchildkroeteImpl(new Point(0.1, 0.2));

    public Schildkroete getSchildkroete() {
        return schildkroete;
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
    public void draw(int depth) {
        pfeilspitze(depth, 0.8);
    }

    @Override
    public Drawer getDrawer() {
        return schildkroete.getDrawer();
    }

    public void pfeilspitze(int level, double length) {
        pfeilspitze(level, length, true);
    }

    public void pfeilspitze(int level, double length, boolean direction) {
        if (level == 0) {
            schildkroete.move(length);
            return;
        }
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
