package lab06;

import javax.swing.*;

import static java.awt.Color.*;

public class ConfigPanel extends JPanel {
    final Mainframe frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(Mainframe frame) {
        this.frame = frame;
        init();
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides : ");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        String[] colors = {"Random", "Black"};
        colorCombo = new JComboBox(colors);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}
