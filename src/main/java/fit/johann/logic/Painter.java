package fit.johann.logic;

import fit.johann.model.battleship.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Painter {


    private final int sectorWidth;
    private final int sectorHeight;

    public Painter(int sectorWidth, int sectorHeight){
        this.sectorWidth = sectorWidth;
        this.sectorHeight = sectorHeight;

    }

    /**
     * Paints a ship at a specific Location
     * @param g Graphics painter
     * @param type ship type
     * @param xCord x Coordinate of startpostion
     * @param yCord y Coordinate of startpostion
     * @param rotation rotation of ship
     * @throws IOException helperMethod loads Imagefiles that could produce exceptions
     */
    public void paintShip(Graphics g, SectorType type, int xCord, int yCord, int rotation) throws IOException {
        for (int i = 1; i <= type.length; i++){
            switch (rotation){
                case 0 -> paintShipPart(g,type,i,xCord,yCord+(i-1),rotation);
                case 1 -> paintShipPart(g,type,i,xCord-(i-1),yCord,rotation);
            }
        }

    }

    /**
     * paints a part of a ship at a specific location
     * @param g Graphics painter
     * @param part the part of the ship
     * @param type ship type
     * @param xCord x Coordinate of location
     * @param yCord y Coordinate of location
     * @param rotation rotation of shipPart
     * @throws IOException loads Imagefiles that could produce exceptions
     */
    private void paintShipPart(Graphics g, SectorType type, int part, int xCord, int yCord, int rotation) throws IOException {
        String filePath = "/Users/johannarfmann-knubel/Documents/JavaProjects/PianoGame/src/main/resources/boat_Img/";
        switch (type){
            case UBOAT -> filePath = filePath +"uboat" + part + ".png";
            case CARRIER -> filePath = filePath +"carrier" + part + ".png";
            case CRUISER -> filePath = filePath +"cruiser" + part + ".png";
            case BATTLESHIP -> filePath = filePath +"battleship" + part + ".png";
        }
        File f = new File(filePath);
        BufferedImage img = ImageIO.read(f);
        for(int i = 0; i < rotation; i++){
            img = rotateClockwise90(img);
        }
        int xPos = xCord * sectorWidth;
        int yPos = yCord * sectorHeight;
        g.drawImage(img,xPos,yPos,sectorWidth,sectorHeight,null);
    }

    /**
     * Paints the game board
     * @param g Graphics painter
     * @param gameBoard gameBoard object
     * @throws IOException helperMethod loads Imagefiles that could produce exceptions
     */
    public void paintBoard(Graphics g, GameBoard gameBoard) throws IOException {
        Sector[] board = gameBoard.getBoard();
        int boardWidth = gameBoard.getSize();
        int row = -1;
        g.setColor(Color.BLUE);
        for(int i = 0; i < board.length; i++){
            int indexInROW = i % boardWidth;
            if(indexInROW == 0) row++;
            g.fillRect(indexInROW*sectorWidth,row*sectorHeight,sectorWidth-2,sectorHeight-2);
        }
        paintShips(g,gameBoard);
    }

    /**
     * Helper Method for paintBoard, only paints the ships
     * @param g Graphics painter
     * @param board gameBoard object
     * @throws IOException helperMethod loads Imagefiles that could produce exceptions
     */
    private void paintShips(Graphics g, GameBoard board) throws IOException {
        for (ShipData data: board.getShipData()){
            paintShip(g,data.type(),data.xCord(),data.yCord(),data.rotation());
        }
    }


    /**
     * Rotates a buffered image clockwise by 90 degrees
     * @param src buffered image
     * @return rotated image
     */
    private static BufferedImage rotateClockwise90(BufferedImage src) {
        int newHeight = src.getWidth();
        int newWidth = src.getHeight();

        BufferedImage dest = new BufferedImage(newWidth, newHeight, src.getType());

        Graphics2D graphics2D = dest.createGraphics();
        graphics2D.translate((newWidth - newHeight) / 2, (newWidth - newHeight) / 2);
        graphics2D.rotate(Math.PI / 2, (double) newWidth / 2, (double) newHeight / 2);
        graphics2D.drawRenderedImage(src, null);

        return dest;
    }





}
