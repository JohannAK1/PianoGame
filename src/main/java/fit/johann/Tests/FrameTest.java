package fit.johann.Tests;

import fit.johann.UI.shipPlacement.ShipSelectPanel;


import javax.swing.*;

public class FrameTest {
    public static void main(String[] args) {
        ShipSelectPanel panel = new ShipSelectPanel(800);
        JFrame f = new JFrame();
        f.setSize(800,800);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setContentPane(panel);
        f.validate();
        f.setVisible(true);
        panel.repaint();
    }

}
