package main.draw;

import main.fractal.schildkroete.SchildkroeteImpl;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * creates a static instance of of the class "StdDraw" and provides basic methods to interact with it.
 * The reason is, that the Class "StdDraw" is in a default package and cannot imported to a named package
 * (the package of {@link SchildkroeteImpl}.
 * <p>
 * The solution is to create an instance of this class by calling
 * <code>stdDraw = Class.forName("StdDraw");</code>
 */
class StdDrawAdapter {
    private static Class<?> stdDraw;
    private static Method setPenColor;
    private static Method line;
    private static Method setPenRadius;
    private static Method clear;
    private static Method save;

    static {
        try {
            stdDraw = Class.forName("StdDraw");
            setPenColor = stdDraw.getMethod("setPenColor", Color.class);
            setPenColor(Color.BLACK);
            line = stdDraw.getMethod("line", double.class, double.class, double.class, double.class);
            setPenRadius = stdDraw.getMethod("setPenRadius", double.class);
            clear = stdDraw.getMethod("clear");
            save = stdDraw.getMethod("save", String.class);
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

    public static void setPenRadius(double radius) {
        try {
            setPenRadius.invoke(stdDraw, radius);
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

    public static void save(String filename){
        try {
            save.invoke(stdDraw, filename);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        try {
            clear.invoke(stdDraw);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
