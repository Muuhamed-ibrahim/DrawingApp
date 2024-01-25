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
public class Line extends Shapes {

    public Line() {
        super();
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd, Color color, boolean dashed) {
        super(xStart, yStart, xEnd, yEnd, color, dashed);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getDashed()) {
            Graphics2D g2d = (Graphics2D) g.create();
            Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);

            g2d.drawLine(getxStart(), getyStart(), getxEnd(), getyEnd());
        } else {

            g.drawLine(getxStart(), getyStart(), getxEnd(), getyEnd());
        }

    }

}
