package fit.johann.UI;

import fit.johann.logic.GameBoardLogic;
import fit.johann.model.battleship.GameBoard;
import fit.johann.model.battleship.Sector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardPanel extends JPanel {

    private final GameBoard gameBoard;
    private final GameBoardLogic logic;
    private int sectorWidth;

    public boolean buttonPressed = false;

    public BoardPanel(GameBoard gameBoard, int widthHeight){
        this.gameBoard = gameBoard;
        this.logic = new GameBoardLogic(gameBoard);
        this.sectorWidth = widthHeight / gameBoard.getSize();
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(buttonPressed){
                    Point coordinate = new Point(e.getPoint().x / sectorWidth, e.getPoint().y / sectorWidth);
                    int location = coordinate.y * gameBoard.getSize() + coordinate.x;
                    System.out.println(location);
                    logic.hit(location);
                    super.mouseClicked(e);
                    repaint();
                }



            }
        };
        this.addMouseListener(mouseListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paint(g);
        paintBoard(g);
    }

    private void paintBoard (Graphics g){
        Sector[] board = gameBoard.getBoard();
        int boardWidth = gameBoard.getSize();
        int row = -1;
        for(int i = 0; i < board.length; i++){
            int indexInROW = i % boardWidth;
            if(indexInROW == 0) row++;
            switch(board[i].getSectorType()){
                case BATTLESHIP -> g.setColor(Color.darkGray);
                case WATER -> g.setColor(Color.BLUE);
                case MINE -> g.setColor(Color.PINK);
            }
            if(board[i].isWasHit()) g.setColor(Color.RED);
            g.fillRect(indexInROW*sectorWidth,row*sectorWidth,sectorWidth-2,sectorWidth-2);

        }
    }
    public void setButtonPressed(){
        buttonPressed = !buttonPressed;
    }
}
