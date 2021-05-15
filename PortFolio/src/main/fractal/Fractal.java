package main.fractal;

import main.draw.Drawer;
import main.fractal.drache.DrachenKurve;
import main.fractal.pfeilspitze.Pfeilspitze;
import main.fractal.schneeflocke.Schneeflocke;
import main.math.graph.Point;
import main.schildkroete.Schildkroete;

public abstract class Fractal {
    public static final String PFEIL_SPITZE = "Pfeilspitze";
    public static final String DRACHEN_KURVE = "Drachenkurve";
    public static final String SCHNEE_FLOCKE = "Schneeflocke";

    public static final String[] NAMES = {SCHNEE_FLOCKE, DRACHEN_KURVE, PFEIL_SPITZE};

    public static Fractal getFractalFromName(String name) {
        return switch (name) {
            case SCHNEE_FLOCKE -> new Schneeflocke();
            case DRACHEN_KURVE -> new DrachenKurve();
            case PFEIL_SPITZE -> new Pfeilspitze();
            default -> throw new IllegalArgumentException("Fractal " + name + " was not valid!");
        };
    }

    private int moveCount = 0;

    protected final Schildkroete schildkroete = new Schildkroete(getStartingPoint());

    public int getMoveCount() {
        return moveCount;
    }

    protected void incrementMoveCount() {
        moveCount++;
    }

    public Schildkroete getSchildkroete() {
        return schildkroete;
    }

    public Drawer getDrawer() {
        return schildkroete.getDrawer();
    }

    protected abstract Point getStartingPoint();

    public abstract int getDefaultDepth();

    public PerformanceResult draw(int depth) {
        moveCount = 0;
        long timeStart = System.currentTimeMillis();
        drawAbstr(depth);
        long timeEnd = System.currentTimeMillis();
        long duration = timeEnd - timeStart;
        return new PerformanceResult(duration, moveCount);
    }

    protected abstract void drawAbstr(int depth);

    /**
     * @param filename the filename without the suffix (e.g. ".png")
     */
    public void savePng(String filename) {
        getDrawer().saveImage(filename + ".png");
    }

    public void clear() {
        getDrawer().clear();
        schildkroete.setDirection(0);
        schildkroete.setPosition(getStartingPoint());
    }


}
