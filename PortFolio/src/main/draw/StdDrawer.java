package main.draw;

import main.math.graph.Point;

public class StdDrawer implements Drawer {
    @Override
    public void drawLine(Point from, Point to){
        StdDrawAdapter.line(from.getX(), from.getY(), to.getX(), to.getY());
    }
}
