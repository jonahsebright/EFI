package main.schildkroete;

import main.draw.Drawer;

public interface Schildkroete {

    void move(double distance);

    /**
     * @param deg is the difference of degrees that should be turned
     */
    void direction(double deg);

    void setPenRadius(double radius);

    Drawer getDrawer();
}
