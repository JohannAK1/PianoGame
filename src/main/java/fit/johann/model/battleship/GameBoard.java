package fit.johann.model.battleship;

import java.util.ArrayList;

public class GameBoard {

    private final Sector[] board;

    private final ArrayList<ShipData> shipData = new ArrayList<>();

    private final int size;
    /**
     * Create a new GameBoard with a specific size
     * @param size board size
     */
    public GameBoard(int size) {
        this.size = size;
        // Board Size
        board = new Sector[size*size];
        createWater();
    }

    /**
     * Helper Method to instantiate Board with Water
     */
    private void createWater(){
        for (int i = 0; i < board.length; i++){
            board[i] = new Sector(SectorType.WATER);
        }
    }

    /**
     * Changes the SectorType of a specific index
     * @param location index
     * @param type new Type
     */
    public void setNew(int location, SectorType type){
        board[location] = new Sector(type);
    }

    /**
     * Changes the state of Type to Hit
     * @param location index in Array (board)
     */
    public void hit(int location){
        board[location].wasHit();
    }

    /**
     * @return the board
     */
    public Sector[] getBoard() {
        return board;
    }

    /**
     * @return Size of GameBoard
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds the Ship to the board (Sector []), if the position is valid
     * @param shipType The type of the new Ship
     * @param rotation the rotation of the ship
     * @param xCord x Coordinate of the ships location
     * @param yCord y Coordinate of the ships location
     */
    public void setShip(SectorType shipType, int rotation, int xCord, int yCord){
        int location = xCord+(yCord*size);

        if(rotation == 0 && (size-1 < yCord-1+shipType.length)) return;
        if(rotation == 1 && (0 > xCord+1-shipType.length)) return;
        if(hasShip(location,shipType,rotation)) return;


        for(int i = 0; i < shipType.length; i++){
            if(rotation == 0){
                setNew(location,shipType);
                location += size;
            }
            if(rotation == 1){
                setNew(location,shipType);
                location -= 1;
            }
        }
        shipData.add(new ShipData(shipType,xCord,yCord,rotation));
    }

    /**
     * Checks if the sectors that the new ship needs are not occupied by another ship
     * @param location location of frist sector
     * @param shipType type of the new Ship
     * @param rotation rotation of the new ship
     * @return true if the sectors are occupied
     */
    private boolean hasShip(int location, SectorType shipType, int rotation){
        int sectorLocation = location;
        for(int i = 0; i < shipType.length; i++){
            if(rotation == 0){
                if(!board[sectorLocation].getSectorType().equals(SectorType.WATER)){
                    System.out.println("cant place");
                    return true;
                }
                sectorLocation += size;
            }
            if(rotation == 1){
                if(!board[sectorLocation].getSectorType().equals(SectorType.WATER)){
                    System.out.println("cant place");
                    return true;
                }
                sectorLocation -= 1;
            }
        }
        return false;
    }

    /**
     * Returns all ship data
     * @return ship data : type, location, rotation
     */
    public ArrayList<ShipData> getShipData() {
        return shipData;
    }

    /**
     * Returns the Sector type at a given location
     * @param location location of sector
     * @return type that the Sector has
     */
    public SectorType getTypeAtLocation(int location) {
        return board[location].getSectorType();
    }
}
