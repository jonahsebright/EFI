package main.fractal;

import main.draw.Drawer;
import main.fractal.drache.DrachenKurve;
import main.fractal.pfeilspitze.Pfeilspitze;
import main.schneeflocke.Schneeflocke;

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

    public abstract int getDefaultDepth();

    public abstract void draw(int depth);

    /**
     * @param filename the filename without the suffix (e.g. ".png")
     */
    public void savePng(String filename){
        getDrawer().saveImage(filename + ".png");
    }

    public abstract Drawer getDrawer();
}
