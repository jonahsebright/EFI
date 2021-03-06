package schildkroete;


import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StdDrawSchildkroete implements Schildkroete {

    /**
     * current direction in degree
     */
    private double direction = 0;

    public static void main(String[] args) {
        StdDrawSchildkroete schildkroete = new StdDrawSchildkroete();
        schildkroete.direction(45);
        schildkroete.move(0.7);
        schildkroete.direction(270);
        schildkroete.move(0.2);
    }

    @Override
    public void move(double distance) {
        StdDrawAdapter.line(0.3, distance-0.1, distance, distance+0.2);
    }

    @Override
    public void direction(double deg) {
        direction = deg;
    }

    /**
     * creates a static instance of of the class "StdDraw" and provides basic methods to interact with it.
     * The reason is, that the Class "StdDraw" is in a default package and cannot imported to a named package
     * (the package of {@link StdDrawSchildkroete}.
     * <p>
     * The solution is to create an instance of this class by calling
     * <code>stdDraw = Class.forName("StdDraw");</code>
     */
    private static class StdDrawAdapter {
        private static Class<?> stdDraw;
        private static Method setPenColor;
        private static Method line;

        static {
            try {
                System.out.println("Before...");
                stdDraw = Class.forName("StdDraw");
                setPenColor = stdDraw.getMethod("setPenColor", Color.class);
                setPenColor(Color.BLACK);

                line = stdDraw.getMethod("line", double.class, double.class, double.class, double.class);
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }

        public static void setPenColor(Color color) {
            try {
                setPenColor.invoke(stdDraw, color);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        public static void line(double x0, double y0, double x1, double y1) {
            try {
                line.invoke(stdDraw, x0, y0, x1, y1);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
