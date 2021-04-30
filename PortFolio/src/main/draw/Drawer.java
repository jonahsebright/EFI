package main.draw;

import main.math.graph.Point;

public interface Drawer {
    void drawLine(Point from, Point to);

    void setPenRadius(double radius);

    void saveImage(String filename);
}
