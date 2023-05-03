package fit.johann.UI.shipPlacement;

import fit.johann.logic.Painter;
import fit.johann.model.battleship.GameBoard;
import fit.johann.model.battleship.SectorType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class PlacementPanel extends JPanel {

    private SectorType selectedShip = SectorType.CRUISER;
    private int shipRotation = 0;
    private Point shipPostion = new Point(0,0);
    private final int boardSize;

    private final GameBoard gameBoard;


    public PlacementPanel(GameBoard board, int boardSize){
        this.gameBoard = board;
        this.boardSize = boardSize;

        listenerSetup();

        this.setSize(boardSize*100,boardSize*100);
        this.repaint();

    }


    private void listenerSetup(){
        MouseWheelListener wheelListener = new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                shipRotation += 1;
                shipRotation = shipRotation % 2;
                System.out.println(shipRotation);
                repaint();
            }
        };

        MouseListener mouseListener = new MouseAdapter() {


            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                gameBoard.setShip(selectedShip,shipRotation,e.getX() / (getWidth() / boardSize), e.getY() / (getHeight() / boardSize));
                repaint();
            }
        };

        MouseMotionListener motionListener = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                shipPostion = new Point(e.getX() / (getWidth() / boardSize), e.getY() / (getHeight() / boardSize));
                repaint();
            }
        };

        this.addMouseListener(mouseListener);
        this.addMouseWheelListener(wheelListener);
        this.addMouseMotionListener(motionListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        int sectorWidth = this.getWidth()/boardSize;
        int sectorHeight = this.getHeight()/boardSize;
        //super.paint(g);
        try {
            Painter.paintBoard(g,gameBoard,sectorWidth,sectorHeight);
            Painter.paintShip(g,selectedShip,(int) shipPostion.getX(),(int) shipPostion.getY(),shipRotation,sectorWidth,sectorHeight);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setSelectedShip(SectorType shipType) {
        this.selectedShip = shipType;
    }
}
