package fit.johann.UI;

import fit.johann.logic.GameBoardLogic;
import fit.johann.model.battleship.Game;
import fit.johann.model.battleship.GameBoard;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    private Game game;
    private JLabel playerTurnLabel;
    public GamePanel(Game game){
        this.playerTurnLabel = new JLabel();
        playerTurnLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.game = game;
        this.setLayout(new BorderLayout());
        this.add(playerTurnLabel,BorderLayout.PAGE_START);
        nextPlayer();
        this.setVisible(true);
    }



    public void nextPlayer(){
        playerTurnLabel.setBackground(Color.BLUE);
        playerTurnLabel.setSize(1000,100);
        playerTurnLabel.setText("Player" + game.getPlayersTurn());
        repaint();
    }





}
