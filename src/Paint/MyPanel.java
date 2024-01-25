package Paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mohamed Ibrahim && Mina Nagy
 */
public class MyPanel extends JPanel {

    private LinkedList<Shapes> myShapes;
    private LinkedList<Shapes> clearedShapes;

    private int ShapeType;
    private Shapes ShapeObject;
    private Color ShapeColor;
    private boolean ShapeFilled;
    private boolean ShapeDashed;

    JLabel statusLabel;

    public MyPanel(JLabel LabelStatus) {

        myShapes = new LinkedList<Shapes>();
        clearedShapes = new LinkedList<Shapes>();

        ShapeType = 0;
        ShapeObject = null;
        ShapeColor = Color.BLACK;
        ShapeFilled = false;
        ShapeDashed = false;
        this.statusLabel = LabelStatus;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(LabelStatus, BorderLayout.SOUTH);

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Shapes> shapeArray = myShapes.getArray();
        for (int counter = shapeArray.size() - 1; counter >= 0; counter--) {
            shapeArray.get(counter).draw(g);
        }

        if (ShapeObject != null) {
            ShapeObject.draw(g);
        }
    }

    public void setShapeType(int type) {
        ShapeType = type;
    }

    public void setShapeColor(Color color) {
        ShapeColor = color;
    }

    public void setShapeFilled(boolean filled) {
        ShapeFilled = filled;
    }

    public void setShapeDashed(boolean dashed) {
        ShapeDashed = dashed;
    }

    public void undoLastShape() {
        if (!myShapes.isEmpty()) {
            clearedShapes.addFront(myShapes.removeFront());
            repaint();
        }
    }

    public void clearAll() {
        myShapes.makeEmpty();
        clearedShapes.makeEmpty();
        repaint();
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent event) {
            switch (ShapeType) {
                case 0:
                    ShapeObject = new Line(event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor, ShapeDashed);
                    break;
                case 1:
                    ShapeObject = new Rect(ShapeFilled, event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor, ShapeDashed);
                    break;
                case 2:
                    ShapeObject = new Oval(ShapeFilled, event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor, ShapeDashed);
                    break;
                case 3:
                    ShapeObject = new Pen(event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor, ShapeDashed);
                    break;
                case 4:
                    ShapeObject = new Erase(false, event.getX(), event.getY(),
                            event.getX(), event.getY(), Color.WHITE, false);
                    break;

            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {

            ShapeObject.setxEnd(event.getX());
            ShapeObject.setyEnd(event.getY());

            myShapes.addFront(ShapeObject);

            ShapeObject = null;
            clearedShapes.makeEmpty();
            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent event) {

        }

        @Override
        public void mouseDragged(MouseEvent event) {

            ShapeObject.setxEnd(event.getX());
            ShapeObject.setyEnd(event.getY());

            repaint();

        }

    }

}
