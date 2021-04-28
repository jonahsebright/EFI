import java.awt.*;

public class Drudenfuss {
    public static void main(String[] args) {
        StdDraw.setPenColor(Color.LIGHT_GRAY);
        Point center = Point.CENTER();
        StdDraw.filledSquare(center.getX(), center.getY(), 0.35);

        StdDraw.setPenColor(Color.GRAY);
        StdDraw.filledSquare(center.getX(), center.getY(), 0.3);

        StdDraw.setPenColor(Color.WHITE);
        double [] x = {0,1, 0,2, 0,3, 0,2};
        double [] y = {0,2, 0,3, 0,2, 0,1};
        StdDraw.polygon (x, y);
    }
}
