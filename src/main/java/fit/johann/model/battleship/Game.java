package fit.johann.model.battleship;

public class Game {
    private final String gameName;
    private final GameBoard player1Board;
    private final GameBoard player2Board;
    private int turnNumber;
    private int playersTurn;

    public Game(String name, GameBoard player1Board, GameBoard player2Board) {
        this.gameName = name;
        this.player1Board = player1Board;
        this.player2Board = player2Board;
        this.turnNumber = 0;
        this.playersTurn = 0;
    }

    public void nextPlayerTurn(){
        if(playersTurn == 1){
            playersTurn = 0;
            turnNumber += 1;
        }else playersTurn = 1;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public int getPlayersTurn() {
        return playersTurn;
    }

    public String getGameName() {
        return gameName;
    }

    public GameBoard getPlayer1Board() {
        return player1Board;
    }

    public GameBoard getPlayer2Board() {
        return player2Board;
    }
}
