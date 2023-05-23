package fit.johann.Tests;
import fit.johann.UI.GamePanel;
import fit.johann.UI.shipPlacement.ShipSelectPanel;
import fit.johann.model.battleship.Game;
import fit.johann.model.battleship.GameBoard;


import javax.swing.*;

public class PainterTestFrame {

    public static void main(String[] args) {
        //GamePanel panel  =new GamePanel(new Game("HElo",new GameBoard(8), new GameBoard(8)));
        ShipSelectPanel panel = new ShipSelectPanel(4);
        JFrame f = new JFrame();
        f.setSize(800,900);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setContentPane(panel);
        f.validate();
        f.setVisible(true);
        panel.repaint();
    }



}
