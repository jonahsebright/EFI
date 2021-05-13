package main;

import main.draw.Drawer;

public abstract class Fractal {
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
