package fit.johann.logic;

import fit.johann.model.battleship.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static fit.johann.logic.OpenSimplex2S.noise2;

public class Painter {

    /**
     * Paints a ship at a specific Location
     * @param g Graphics painter
     * @param type ship type
     * @param xCord x Coordinate of startpostion
     * @param yCord y Coordinate of startpostion
     * @param rotation rotation of ship
     * @param sectorWidth width of sector (screen width / board size)
     * @param sectorHeight height of sector (screen height / board size)
     * @throws IOException helperMethod loads Imagefiles that could produce exceptions
     */
    public static void paintShip(Graphics g, SectorType type, int xCord, int yCord, int rotation, int sectorWidth, int sectorHeight) throws IOException {
        for (int i = 1; i <= type.length; i++){
            switch (rotation){
                case 0 -> paintShipPart(g,type,i,xCord,yCord+(i-1),rotation, sectorWidth, sectorHeight);
                case 1 -> paintShipPart(g,type,i,xCord-(i-1),yCord,rotation, sectorWidth, sectorHeight);
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
     * @param sectorWidth width of sector (screen width / board size)
     * @param sectorHeight height of sector (screen height / board size)
     * @throws IOException loads Imagefiles that could produce exceptions
     */
    private static void paintShipPart(Graphics g, SectorType type, int part, int xCord, int yCord, int rotation, int sectorWidth, int sectorHeight) throws IOException {
        File f = new File(type.pngFiles[part-1]);
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
     * @param sectorWidth width of sector (screen width / board size)
     * @param sectorHeight height of sector (screen height / board size)
     * @throws IOException helperMethod loads Imagefiles that could produce exceptions
     */
    public static void paintBoard(Graphics g, GameBoard gameBoard, int sectorWidth, int sectorHeight) throws IOException {
        Sector[] board = gameBoard.getBoard();
        int boardWidth = gameBoard.getSize();
        int row = -1;
        g.setColor(Color.BLUE);
        for(int i = 0; i < board.length; i++){
            int indexInROW = i % boardWidth;
            if(indexInROW == 0) row++;

            paintShipPart(g,SectorType.WATER,1,indexInROW,row,1,sectorWidth-2,sectorHeight-2);
            //g.fillRect(indexInROW*sectorWidth,row*sectorHeight,sectorWidth-2,sectorHeight-2);
        }
        paintShips(g,gameBoard,sectorWidth,sectorHeight);
        //paintNoise(g);
    }

    /**
     * Helper Method for paintBoard, only paints the ships
     * @param g Graphics painter
     * @param board gameBoard object
     * @param sectorWidth width of sector (screen width / board size)
     * @param sectorHeight height of sector (screen height / board size)
     * @throws IOException helperMethod loads Imagefiles that could produce exceptions
     */
    private static void paintShips(Graphics g, GameBoard board, int sectorWidth, int sectorHeight) throws IOException {
        for (ShipData data: board.getShipData()){
            paintShip(g,data.type(),data.xCord(),data.yCord(),data.rotation(),sectorWidth,sectorHeight);
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

    private static void paintNoise(Graphics g){
        long seed = 32962364;
        for(float i = 0; i < 15; i+=0.01){
            for(float x = 0; x < 15; x+=0.01){
                g.setColor(Color.blue);
                if(-0.2<noise2(seed,i,x) && 0.2>noise2(seed,i,x)){
                    g.setColor(Color.CYAN);
                }
                if((-0.3<noise2(seed,i,x) && -0.2>noise2(seed,i,x)) || (0.2<noise2(seed,i,x) && 0.3>noise2(seed,i,x))){
                    g.setColor(Color.WHITE);
                }
                int k = (int) (i * 100);
                int b = (int) (x * 100);
                g.fillRect(k,b,1,1);
            }
        }
    }




}
