public class Haus {
    public static void main(String[] args) {
        StdDrawUtil.setSketch();
        double centerX = 0.5;
        double centerY = 0.4;
        double halfLength = 0.2;
        StdDraw.square(centerX, centerY, halfLength);
        Point topLeft = new Point(centerX - halfLength, centerY + halfLength);
        Point topMiddle = new Point(centerX, topLeft.getY() + 0.15);
        Point topRight = new Point(centerX + halfLength, centerY + halfLength);
        StdDrawUtil.drawLine(topLeft, topMiddle);
        StdDrawUtil.drawLine(topMiddle, topRight);
        StdDraw.save();
    }
}
