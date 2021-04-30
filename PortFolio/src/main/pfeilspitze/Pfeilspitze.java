package main.pfeilspitze;

import main.math.graph.Point;
import main.schildkroete.Schildkroete;
import main.schildkroete.SchildkroeteImpl;

public class Pfeilspitze {

    private final Schildkroete schildkroete = new SchildkroeteImpl(new Point(0.1, 0.2));

    public Schildkroete getSchildkroete() {
        return schildkroete;
    }

    public static void main(String[] args) {
        Pfeilspitze pfeilspitze = new Pfeilspitze();
        pfeilspitze.getSchildkroete().setPenRadius(0.0005);
        int level = 9;
        pfeilspitze.pfeilspitze(level, 0.8);
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
