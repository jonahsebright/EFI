public class StdDrawUtil {
    public static void setSketch(){
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.GRAY);
    }

    public static void drawLine(Point from, Point to){
        StdDraw.line(from.getX(), from.getY(), to.getX(), to.getY());
    }
}
