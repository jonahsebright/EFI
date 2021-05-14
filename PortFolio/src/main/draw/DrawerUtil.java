package main.draw;

import main.math.graph.Point;
import main.schildkroete.Schildkroete;

public class DrawerUtil {
    public static void drawPolygon(int numCorners, double radiusToCorners, Point center) {
        System.out.println("StdDrawSchildkroete.drawPolygon");
        center.translate(0, radiusToCorners);
        Schildkroete schildkroete = new Schildkroete(center);
        schildkroete.direction(90);
        double exteriorAngle = 360d / numCorners;
        System.out.println("exteriorAngle = " + exteriorAngle);
        double sideLength = getSideLengthOfPolygon(radiusToCorners, numCorners);
        System.out.println("sideLength = " + sideLength);
        schildkroete.direction(90 - (exteriorAngle / 2));

        for (int i = 0; i < numCorners; i++) {
            schildkroete.direction(exteriorAngle);
            schildkroete.move(sideLength);
        }
    }

    public static double getSideLengthOfPolygon(double radiusToCorners, int numCorners) {
        return 2 * radiusToCorners * Math.sin(Math.PI / numCorners);
    }
}
