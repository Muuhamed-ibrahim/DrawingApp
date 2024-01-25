package Paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mohamed Ibrahim && Mina Nagy
 */
abstract class FillShapes extends Shapes {

    private boolean fill;

    public FillShapes() {
        super();
        fill = false;

    }

    public FillShapes(boolean fill, int xStart, int yStart, int xEnd, int yEnd, Color color, boolean dashed) {
        super(xStart, yStart, xEnd, yEnd, color, dashed);
        this.fill = fill;
    }

    public FillShapes(boolean fill) {
        this.fill = fill;
    }

    public boolean getFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public int getUpperX() {
        return Math.min(getxStart(), getxEnd());
    }

    public int getUpperY() {
        return Math.min(getyStart(), getyEnd());
    }

    @Override
    public int getWidth() {
        return Math.abs(getxStart() - getxEnd());
    }

    @Override
    public int getHeight() {
        return Math.abs(getyStart() - getyEnd());
    }

    @Override
    abstract public void draw(Graphics g);
}
