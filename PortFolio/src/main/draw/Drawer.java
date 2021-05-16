package main.draw;

import main.math.graph.Point;

import java.awt.*;

public interface Drawer {
    void drawLine(Point from, Point to);

    void setPenRadius(double radius);

    void setPenColor(Color color);

    void clear();

    void saveImage(String filename);
}
