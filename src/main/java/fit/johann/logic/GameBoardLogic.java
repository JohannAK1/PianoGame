package fit.johann.logic;

import fit.johann.model.battleship.GameBoard;
import fit.johann.model.battleship.SectorType;

public class GameBoardLogic {

    private final GameBoard gameBoard;
    public GameBoardLogic(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }



    public boolean hit(int location){
        if(location < (gameBoard.getBoard().length)){
            gameBoard.hit(location);
            return true;
        }
        return false;
    }

    public boolean setMine(int location){
        if(location < (gameBoard.getBoard().length) && gameBoard.getTypeAtLocation(location).equals(SectorType.WATER)){
            gameBoard.setNew(location, SectorType.MINE);
            return true;
        }
        return false;
    }






}
