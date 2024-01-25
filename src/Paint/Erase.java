package Paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mohamed Ibrahim && Mina Nagy
 */
public class Erase extends FillShapes {

    public Erase() {
    }

    public Erase(boolean fill, int xStart, int yStart, int xEnd, int yEnd, Color color, boolean dashed) {
        super(fill, xStart, yStart, xEnd, yEnd, color, dashed);
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(getUpperX(), getUpperY(), getWidth(), getHeight());

    }

}
