package main.schildkroete;

import main.draw.Drawer;
import main.draw.DrawerUtil;
import main.draw.StdDrawer;
import main.math.graph.Point;

public class Schildkroete {

    /**
     * current direction in degree, where to the right is 0
     */
    private double direction = 0;


    /**
     * instance of current pos of this {@link Schildkroete} instance
     */
    private final Point currentPos;

    private final Drawer drawer = new StdDrawer();

    private static final double DEFAULT_PEN_RADIUS = 0.005;

    public Schildkroete() {
        this(Point.ORIGIN());
    }

    public Schildkroete(double penRadius) {
        this(Point.ORIGIN(), penRadius);
    }

    public Schildkroete(Point startingPos) {
        this(startingPos, DEFAULT_PEN_RADIUS);
    }

    public Schildkroete(Point startingPos, double penRadius) {
        currentPos = startingPos;
        setPenRadius(penRadius);
    }

    public void setPenRadius(double penRadius) {
        drawer.setPenRadius(penRadius);
    }

    public static void main(String[] args) {
        DrawerUtil.drawPolygon(5, 0.2, new Point(0.5, 0.5));
    }

    public double getDirection() {
        return direction;
    }

    public Point getCurrentPos() {
        return currentPos;
    }

    public void move(double distance) {
        Point original = currentPos.getLocation();
        double dx = Math.sin(Math.toRadians(-direction + 90)) * distance;
        double dy = Math.cos(Math.toRadians(-direction + 90)) * distance;
        currentPos.translate(dx, dy);
        drawer.drawLine(original, currentPos);
    }

    /**
     * @param deg is the difference of degrees that should be turned,
     *            positive values mean a left turn, negative values a right turn
     */
    public void direction(double deg) {
        direction += deg;
    }

    public Drawer getDrawer() {
        return drawer;
    }
}
