package main.schildkroete;

import main.draw.Drawer;
import main.draw.StdDrawer;
import main.math.graph.Point;

public class SchildkroeteImpl implements Schildkroete {

    /**
     * current direction in degree, where to the right is 0
     */
    private double direction = 0;


    /**
     * instance of current pos of this {@link Schildkroete} instance
     */
    private final Point currentPos = Point.ORIGIN();

    private final Drawer drawer = new StdDrawer();

    public static void main(String[] args) {
        SchildkroeteImpl schildkroete = new SchildkroeteImpl();

        //get to center
        schildkroete.direction(45);
        schildkroete.move(Math.sqrt(2) / 2);

        schildkroete.direction(90);
        schildkroete.move(0.2);
        schildkroete.drawPolygon(6, 0.2);
    }

    public double getDirection() {
        return direction;
    }

    public Point getCurrentPos() {
        return currentPos;
    }

    private void drawPolygon(int numCorners, double radiusToCorners) {
        System.out.println("StdDrawSchildkroete.drawPolygon");
        double exteriorAngle = 360d / numCorners;
        System.out.println("exteriorAngle = " + exteriorAngle);
        double sideLength = getSideLengthOfPolygon(radiusToCorners, numCorners);
        System.out.println("sideLength = " + sideLength);
        double currentAngle = 180 + exteriorAngle / 2;

        for (int i = 0; i < numCorners; i++) {
            //double angle = 180 + 360 / 5d * i;
            direction(currentAngle);
            move(sideLength);
            currentAngle += exteriorAngle;
        }
    }

    private double getSideLengthOfPolygon(double radiusToCorners, int numCorners) {
        return 2 * radiusToCorners * Math.sin(Math.PI / numCorners);
    }

    @Override
    public void move(double distance) {
        Point original = currentPos.getLocation();
        double dx = Math.sin(Math.toRadians(-direction + 90)) * distance;
        double dy = Math.cos(Math.toRadians(-direction + 90)) * distance;
        currentPos.translate(dx, dy);
        drawer.drawLine(original, currentPos);
    }

    @Override
    public void direction(double deg) {
        direction = deg;
    }


}
