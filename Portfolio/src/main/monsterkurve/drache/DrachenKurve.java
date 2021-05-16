package main.monsterkurve.drache;

import main.draw.DrawerUtil;
import main.math.graph.Point;
import main.monsterkurve.Monsterkurve;
import main.schildkroete.Schildkroete;

import java.awt.*;

public class DrachenKurve extends Monsterkurve {

    private double highestY = 0;
    private double lowestY = 1;
    private double highestX = 0;
    private double lowestX = 1;

    private double curveArea = 0;

    public static double SQRT_2 = Math.sqrt(2);
    private static final double PEN_RADIUS = 0.001;

    public static void main(String[] args) {
        DrachenKurve drachenKurve = new DrachenKurve();
        drachenKurve.drache(13);
        double areaRectangle = drachenKurve.getAreaRectangle();
        System.out.println("areaRectangle = " + areaRectangle);
        double areaCurve = drachenKurve.getCurveArea();
        System.out.println("areaCurve = " + areaCurve);
        double coverage = areaCurve / areaRectangle;
        System.out.println("coverage = " + coverage);

        Schildkroete schildkroete = drachenKurve.getSchildkroete();
        schildkroete.getDrawer().setPenColor(Color.RED);
        schildkroete.setPenRadius(0.002);
        schildkroete.setPosition(new Point(drachenKurve.lowestX, drachenKurve.lowestY));
        DrawerUtil.drawRectangleFromBottomLeft(schildkroete,
                drachenKurve.getHeight(), drachenKurve.getWidth());
        schildkroete.setPenRadius(PEN_RADIUS);
        schildkroete.getDrawer().setPenColor(Color.BLACK);
    }

    private double getHeight() {
        return highestY - lowestY;
    }

    private double getWidth() {
        return highestX - lowestX;
    }

    @Override
    protected Point getStartingPoint() {
        return new Point(0.25, 0.5);
    }

    @Override
    public int getDefaultDepth() {
        return 11;
    }

    @Override
    public void drawAbstr(int depth) {
        drache(depth);
    }

    public void drache(int depth) {
        getDrawer().setPenRadius(PEN_RADIUS);
        resetLowestAndHighestPoint();
        curveArea = 0;
        drache(depth, 0.4, true);
    }

    private void resetLowestAndHighestPoint() {
        highestY = 0;
        lowestY = 1;
        highestX = 0;
        lowestX = 1;
    }

    public double getAreaRectangle() {
        return getHeight() * getWidth();
    }

    public double getCurveArea() {
        return curveArea;
    }

    public void drache(int level, double length, boolean direction) {
        if (level == 0) {
            schildkroete.move(length);
            curveArea += length * PEN_RADIUS;
            checkReachedLowestOrHighestPoint();
            incrementMoveCount();
        } else {
            int degreeLeft = direction ? -45 : 45;
            int degreeRight = direction ? 90 : -90;
            length /= SQRT_2;
            level--;
            schildkroete.direction(degreeLeft);
            drache(level, length, false);
            schildkroete.direction(degreeRight);
            drache(level, length, true);
            schildkroete.direction(degreeLeft);
        }
    }

    private void checkReachedLowestOrHighestPoint() {
        Point currentPos = schildkroete.getCurrentPos();
        if (currentPos.getY() > highestY) highestY = currentPos.getY();
        if (currentPos.getY() < lowestY) lowestY = currentPos.getY();

        if (currentPos.getX() > highestX) highestX = currentPos.getX();
        if (currentPos.getX() < lowestX) lowestX = currentPos.getX();
    }
}
