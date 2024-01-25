package Paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mohamed Ibrahim && Mina Nagy
 */
public class DrawFrame extends JFrame {

    private JLabel stausLabel;
    private MyPanel panel;
    private JButton undo;
    private JButton clear;
    private JButton rect;
    private JButton oval;
    private JButton line;
    private JButton pen;
    private JComboBox colors;
    private JButton erase;

    private String colorOptions[]
            = {"Black", "Blue", "Green", "Yellow", "Cyne", "Magenta", "Red", "Gray", "Oragen"};

    private Color colorArray[]
            = {Color.BLACK, Color.BLUE, Color.GREEN, Color.YELLOW, Color.cyan, Color.MAGENTA, Color.RED, Color.DARK_GRAY, Color.orange};

    private JComboBox shapes;

    private String shapeOptions[]
            = {"Line", "Rectangle", "Oval"};

    private JCheckBox filled, dashed;

    private JPanel widgetJPanel;
    private JPanel widgetPadder;

    public DrawFrame() {
        super(" Paint ");

        JLabel statusLabel = new JLabel("");

        panel = new MyPanel(statusLabel);

        rect   = new JButton("Rectangle");
        oval   = new JButton("Oval");
        line   = new JButton("Line");
        pen    = new JButton("Pen");
        erase  = new JButton("Erase");
        undo   = new JButton("Undo");
        clear  = new JButton("Clear");
        colors = new JComboBox(colorOptions);
        shapes = new JComboBox(shapeOptions);

        filled = new JCheckBox("Filled");
        dashed = new JCheckBox("Dashed");

        widgetJPanel = new JPanel();
        widgetJPanel.setLayout(new GridLayout(1, 0, 20, 70));

        widgetPadder = new JPanel();
        widgetPadder.setLayout(new FlowLayout(FlowLayout.LEADING, 150, 15));

        widgetJPanel.add(rect);
        widgetJPanel.add(oval);
        widgetJPanel.add(line);
        widgetJPanel.add(pen);
        widgetJPanel.add(erase);
        widgetJPanel.add(undo);

        widgetJPanel.add(clear);
        widgetJPanel.add(colors);

        widgetJPanel.add(filled);
        widgetJPanel.add(dashed);

        widgetPadder.add(widgetJPanel);

        add(widgetPadder, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener(buttonHandler);

        clear.addActionListener(buttonHandler);
        rect.addActionListener(buttonHandler);
        oval.addActionListener(buttonHandler);
        line.addActionListener(buttonHandler);
        pen.addActionListener(buttonHandler);
        erase.addActionListener(buttonHandler);

        ItemListenerHandler handler = new ItemListenerHandler();
        colors.addItemListener(handler);
        shapes.addItemListener(handler);
        filled.addItemListener(handler);
        dashed.addItemListener(handler);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 1000);
        setVisible(true);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("Undo")) {
                panel.undoLastShape();
            } else if (event.getActionCommand().equals("Clear")) {
                panel.clearAll();
            } else if (event.getActionCommand().equals("Rectangle")) {
                panel.setShapeType(1);

            } else if (event.getActionCommand().equals("Oval")) {
                panel.setShapeType(2);

            } else if (event.getActionCommand().equals("Line")) {
                panel.setShapeType(0);

            } else if (event.getActionCommand().equals("Pen")) {
                panel.setShapeType(3);

            } else if (event.getActionCommand().equals("Erase")) {
                panel.setShapeType(4);
            }

        }
    }

    private class ItemListenerHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {

            if (event.getSource() == filled) {
                boolean checkFill = filled.isSelected() ? true : false;
                panel.setShapeFilled(checkFill);
            }
            if (event.getSource() == dashed) {
                boolean checkDash = dashed.isSelected() ? true : false;
                panel.setShapeDashed(checkDash);
            }

            if (event.getStateChange() == ItemEvent.SELECTED) {

                if (event.getSource() == colors) {
                    panel.setShapeColor(colorArray[colors.getSelectedIndex()]);
                } else if (event.getSource() == shapes) {
                    panel.setShapeType(shapes.getSelectedIndex());
                }
            }

        }
    }

}
