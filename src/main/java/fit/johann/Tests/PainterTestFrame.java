package fit.johann.Tests;
import fit.johann.UI.shipPlacement.ShipSelectPanel;


import javax.swing.*;

public class PainterTestFrame {

    public static void main(String[] args) {
        ShipSelectPanel panel = new ShipSelectPanel(10);
        JFrame f = new JFrame();
        f.setSize(800,900);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setContentPane(panel);
        f.validate();
        f.setVisible(true);
        panel.repaint();
    }



}
