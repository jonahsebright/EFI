package main.draw;

import main.math.graph.Point;

import java.awt.*;

public class StdDrawer implements Drawer {
    @Override
    public void drawLine(Point from, Point to){
        StdDrawAdapter.line(from.getX(), from.getY(), to.getX(), to.getY());
    }

    @Override
    public void setPenRadius(double radius) {
        StdDrawAdapter.setPenRadius(radius);
    }

    @Override
    public void setPenColor(Color color) {
        StdDrawAdapter.setPenColor(color);
    }

    @Override
    public void saveImage(String filename) {
        StdDrawAdapter.save(filename);
    }

    @Override
    public void clear() {
        StdDrawAdapter.clear();
    }
}
