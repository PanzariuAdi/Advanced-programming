package lab06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final Mainframe frame;
    final static int W = 1000, H = 800;
    BufferedImage image;
    Graphics2D graphics;
    ArrayList<Shape> shapes;
    int index;
    boolean delete;

    public DrawingPanel(Mainframe frame) {
        this.frame = frame;
        createOffscrenImage();
        init();
    }

    private void createOffscrenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        index = 0;
        delete = false;
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        shapes = new ArrayList<>();
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //TODO Foreach shape add its points and then add this shape to ArrayList from DrawingPanel.
                drawShape(e.getX(), e.getY(), index);
                repaint();
            }
        });
    }
    private void drawShape(int x, int y, int index) {
        Random rnd = new Random();
        int radius = (int) rnd.nextInt(100);
        int sides = (int) frame.configPanel.getSidesField().getValue();
        int r = rnd.nextInt(255);
        int g = rnd.nextInt(255);
        int b = rnd.nextInt(255);
        Color color = new Color(r, g, b);
        Shape shape = new Shape(this.index);

        if("Black".equals((String) frame.configPanel.colorCombo.getSelectedItem())) {
            graphics.setColor(Color.BLACK);
            shape.setColor(Color.BLACK);
        } else {
            shape.setColor(color);
            graphics.setColor(color);
        }

        shape.setX(x);
        shape.setY(y);
        if("Regular polygon".equals((String) frame.configPanel.shapeCombo.getSelectedItem())) {
            shape.setRadius(radius);
            shape.setSides((int)frame.configPanel.sidesField.getValue());
            shape.setForm("polygon");
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        } else if ("Rectangle".equals((String) frame.configPanel.shapeCombo.getSelectedItem())){
            int w, h;
            w = rnd.nextInt(100);
            h = rnd.nextInt(100);
            shape.setHeight(h);
            shape.setWidth(w);
            shape.setForm("rectangle");
            graphics.fill(new RegularRectangle(x, y, w, h));
        } else {
            shape.setRadius(radius);
            shape.setForm("node");
            graphics.fill(new NodeShape(x, y, radius));
        }
        shapes.add(shape);
        this.index++;
    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void addShape(Shape shape) { this.shapes.add(shape); }
    public int getIndex() { return index; }
    public void setIndex(int index) { this.index = index; }

    public void redraw() {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
        repaint();

        for (Shape sh: shapes) {
            graphics.setColor(sh.getColor());
            if (sh.getForm().equals("polygon"))
                graphics.fill(new RegularPolygon(sh.getX(), sh.getY(), sh.getRadius(), sh.getSides()));
            else if (sh.getForm().equals("rectangle"))
                graphics.fill(new RegularRectangle(sh.getX(), sh.getY(), sh.getWidth(), sh.getHeight()));
            else
                graphics.fill(new NodeShape(sh.getX(), sh.getY(), sh.getRadius()));
        }
    }
}
