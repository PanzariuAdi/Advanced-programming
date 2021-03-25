package lab06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final Mainframe frame;
    final static int W = 1000, H = 1000;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(Mainframe frame) {
        this.frame = frame;
        createOffScreenImage();
        init();
    }

    private void createOffScreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
            Random rnd = new Random();
            int radius = rnd.nextInt(100);
            int sides = (int) frame.configPanel.getSidesField().getValue();
            int r = rnd.nextInt(255);
            int g = rnd.nextInt(255);
            int b = rnd.nextInt(255);
            Color color = new Color(r, g, b);

            if ("Black".equals((String) frame.configPanel.getSidesField().getValue())) {
                graphics.setColor(Color.BLACK);
            } else {
                graphics.setColor(color);
            }
            graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

        @Override
        public void update (Graphics g) {
        }

        @Override
       protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, this);
       }
}
