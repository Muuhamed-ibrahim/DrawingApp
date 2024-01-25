package Paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

/**
 *
 * @author Mohamed Ibrahim && Mina Nagy
 */
public class Pen extends Shapes {

    ArrayList<Integer> x = new ArrayList<Integer>();
    ArrayList<Integer> y = new ArrayList<Integer>();

    public Pen() {
        super();
    }

    public Pen(int xStart, int yStart, int xEnd, int yEnd, Color color, boolean dashed) {
        super(xStart, yStart, xEnd, yEnd, color, dashed);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        if (getDashed()) {
            Graphics2D g2d = (Graphics2D) g.create();
            Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);

            x.add(getxEnd());
            y.add(getyEnd());
            g2d.setColor(getColor());
            for (int i = 0; i < x.size() - 1; i++) {
                g2d.drawLine(x.get(i), y.get(i), x.get(i + 1), y.get(i + 1));
            }
        } else {
            x.add(getxEnd());
            y.add(getyEnd());

            for (int i = 0; i < x.size() - 1; i++) {
                g.drawLine(x.get(i), y.get(i), x.get(i + 1), y.get(i + 1));
            }

        }
    }

}
