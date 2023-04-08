package fit.johann.UI;

import fit.johann.controller.GUIController;
import javax.swing.*;


@SuppressWarnings("unused")
public class MainWindow {
    private JButton nextWindow;

    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JLabel title;

    public MainWindow (GUIController controller){

        nextWindow.addActionListener(e -> controller.deviceConnectionWindow());
    }

}
