package fit.johann.model.battleship;

public class GameBoard {

    private final Sector[] board;

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
     * @return Size of Gameboard
     */
    public int getSize() {
        return size;
    }
}
