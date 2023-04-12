package fit.johann.UI;

import fit.johann.model.battleship.GameBoard;
import fit.johann.model.battleship.Sector;

import javax.swing.*;
import java.awt.*;

public class BattleShipsPanel extends JPanel {

    private final GameBoard gameBoard;
    private final int widthHeight;
    public BattleShipsPanel(GameBoard gameBoard, int widthHeight){
        this.widthHeight = widthHeight;
        this.gameBoard = gameBoard;
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paint(g);
        paintBoard(g);
    }

    private void paintBoard (Graphics g){
        Sector[] board = gameBoard.getBoard();
        int boardWidth = gameBoard.getSize();
        int sectorWidth = widthHeight / boardWidth;
        int row = -1;
        for(int i = 0; i < board.length; i++){
            int indexInROW = i % boardWidth;
            if(indexInROW == 0) row++;
            switch(board[i].getSectorType()){
                case SHIP -> g.setColor(Color.darkGray);
                case WATER -> g.setColor(Color.BLUE);
                case MINE -> g.setColor(Color.PINK);
            }
            g.fillRect(indexInROW*sectorWidth,row*sectorWidth,sectorWidth-2,sectorWidth-2);

        }
    }
}
