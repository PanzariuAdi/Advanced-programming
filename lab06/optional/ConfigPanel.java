package lab06;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel{
    final Mainframe frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;
    JComboBox shapeCombo;
    JComboBox modeCombo;
    JLabel sidesLabel;
    public ConfigPanel(Mainframe frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides: ");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        String[] colors = {"Black", "Random"};
        String[] shapes = {"Regular polygon", "Rectangle", "Node Shape"};
        String[] modes = {"Retained", "Free"};
        colorCombo = new JComboBox(colors);
        shapeCombo = new JComboBox(shapes);
        modeCombo = new JComboBox(modes);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
        add(shapeCombo);
        add(modeCombo);
    }

    public JSpinner getSidesField() { return sidesField; }
    public JComboBox getColorCombo() { return colorCombo; }
    public JComboBox getShapeCombo() { return shapeCombo; }
    public JComboBox getModeCombo() { return modeCombo; }
}
