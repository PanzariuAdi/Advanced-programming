package lab06;

import java.awt.*;

public class RegularRectangle extends Rectangle {
    public RegularRectangle(int x0, int y0, int width, int height) {
        this.add(x0, y0);
        this.add(x0,y0 + width);
        this.add(x0 + height, y0);
        this.add(x0 + height, y0 + width);
    }
}
