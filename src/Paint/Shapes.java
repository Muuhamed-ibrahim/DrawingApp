package Paint;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Mohamed Ibrahim && Mina Nagy
 */
abstract class Shapes extends JPanel {

    protected int xStart, yStart, xEnd, yEnd;
    private Color color;
    private boolean dashed;

    public Shapes() {
        xStart = 0;
        yStart = 0;
        xEnd = 0;
        yEnd = 0;
        color = Color.BLACK;
        dashed = false;
    }

    public Shapes(int xStart, int yStart, int xEnd, int yEnd, Color color, boolean dashed) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.color = color;
        this.dashed = dashed;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public int getxEnd() {
        return xEnd;
    }

    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getDashed() {
        return dashed;
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
    }

    abstract public void draw(Graphics g);

}
