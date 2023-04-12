package fit.johann.Tests;

import fit.johann.UI.BattleShipsPanel;
import fit.johann.model.battleship.GameBoard;
import fit.johann.model.battleship.SectorType;

import javax.swing.*;

public class FrameTest {
    public static void main(String[] args) {
        GameBoard k = new GameBoard(8);
        BattleShipsPanel panel = new BattleShipsPanel(k,800);
        JFrame f = new JFrame();
        f.setSize(800,800);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setContentPane(panel);
        f.validate();
        f.setVisible(true);
        k.setNew(5, SectorType.MINE);
        panel.repaint();
    }

}
