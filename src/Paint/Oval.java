package Paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 *
 * @author Mohamed Ibrahim && Mina Nagy
 */
public class Oval extends FillShapes {

    public Oval() {
        super();
    }

    public Oval(boolean fill, int xStart, int yStart, int xEnd, int yEnd, Color color, boolean dashed) {
        super(fill, xStart, yStart, xEnd, yEnd, color, dashed);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getDashed()) {

            Graphics2D g2d = (Graphics2D) g.create();
            Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);

            if (getFill()) {
                g2d.fillOval(getUpperX(), getUpperY(), getWidth(), getHeight());
            } else {
                g2d.drawOval(getUpperX(), getUpperY(), getWidth(), getHeight());
            }
        } else {

            if (getFill()) {
                g.fillOval(getUpperX(), getUpperY(), getWidth(), getHeight());
            } else {
                g.drawOval(getUpperX(), getUpperY(), getWidth(), getHeight());
            }

        }
    }

}
