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

        Integer[] depths = {0, 2, 4, 5, 6, 8, 10, 12, 14, 15};
        Double[] rectangles = new Double[depths.length];
        Double[] curveAreas = new Double[depths.length];
        Double[] curveCoverages = new Double[depths.length];

        for (int i = 0; i < depths.length; i++) {
            drachenKurve.drache(depths[i]);
            double areaRectangle = drachenKurve.getAreaRectangle();
            double areaCurve = drachenKurve.getCurveArea();
            double coverage = areaCurve / areaRectangle;
            rectangles[i] = areaRectangle;
            curveAreas[i] = areaCurve;
            curveCoverages[i] = coverage;

            Schildkroete schildkroete = drachenKurve.getSchildkroete();

            //draw rectangle
            schildkroete.getDrawer().setPenColor(Color.RED);
            schildkroete.setPenRadius(0.002);
            schildkroete.setPosition(new Point(drachenKurve.lowestX, drachenKurve.lowestY));
            DrawerUtil.drawRectangleFromBottomLeft(schildkroete,
                    drachenKurve.getHeight(), drachenKurve.getWidth());

            schildkroete.getDrawer().saveImage("Drachenkurve_Flächen_berechnung_" + depths[i] + ".png");

            //reset schildkroete after moving it around
            schildkroete.setPenRadius(PEN_RADIUS);
            schildkroete.getDrawer().setPenColor(Color.BLACK);
            drachenKurve.clear();
        }
        printTableView(new String[]{"Depth", "Rectangle area", "Curve area", "Converage"},
                new Object[][]{depths, rectangles, curveAreas, curveCoverages});
    }

    private static void printTableView(String[] headers, Object[][] items) {
        StringBuilder headerPrint = new StringBuilder(headers[0]);
        int numColoums = headers.length;
        for (int i = 1; i < numColoums; i++) {
            headerPrint.append("\t\t\t\t\t").append(headers[i]);
        }
        System.out.println(headerPrint);
        for (int i = 0; i < items[0].length; i++) {
            StringBuilder rowPrint = new StringBuilder(String.valueOf(items[0][i]));
            for (int j = 1; j < numColoums; j++) {
                rowPrint.append("\t\t\t").append(items[j][i]);
            }
            System.out.println(rowPrint);
        }
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
            curveArea += (length - PEN_RADIUS) * PEN_RADIUS;
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
