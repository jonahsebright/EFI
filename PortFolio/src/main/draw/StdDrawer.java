package main.draw;

import main.math.graph.Point;

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
    public void saveImage(String filename) {
        StdDrawAdapter.save(filename);
    }
}
