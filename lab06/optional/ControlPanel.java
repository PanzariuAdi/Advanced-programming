package lab06;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ControlPanel extends JPanel{
    final Mainframe frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JButton deleteBtn = new JButton("Delete");

    public ControlPanel(Mainframe frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        add(deleteBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        deleteBtn.addActionListener(this::delete);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("C:/Users/panza/Desktop/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:/Users/panza/Desktop/caine.jpeg"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        frame.canvas.graphics.drawImage(image, 0, 0, null);
        frame.canvas.repaint();
    }

    private void reset(ActionEvent e) {
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }

    private void delete(ActionEvent e) {
        int index = Integer.parseInt(JOptionPane.showInputDialog("Write the ID : "));
        frame.canvas.shapes.remove(index);
        frame.canvas.delete = true;
        frame.canvas.redraw();
    }
}
