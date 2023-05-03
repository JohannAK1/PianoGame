package fit.johann.UI.shipPlacement;

import fit.johann.model.battleship.GameBoard;
import fit.johann.model.battleship.SectorType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShipSelectPanel extends JPanel {

    private final PlacementPanel boardView;
    private final Container shipContainer = new Container();
    private final ArrayList<JButton> shipButtons = new ArrayList<>();

    /**
     * Iterates through all the SectorTypes, if a sector has the type ship, than a button will be created,
     * which also changes the current selected ship in class: boardView. And adds the newly created
     * button to shipContainer.
     */
    private void generateButtons(){
        for (SectorType type : SectorType.values()){
            if(type.isShip){
                JButton k = new JButton(type.name);
                k.addActionListener(e -> boardView.setSelectedShip(type));
                shipButtons.add(k);
                shipContainer.add(k);
            }

        }
    }

    /**
     * Creates a panel which is used to choose the locations of the ships by creating
     * a gameBoard which contains all the ship + board data and a BoardView JPanel which
     * is used to choose the location
     * @param size GameBoard size
     */
    public ShipSelectPanel(int size) {
        GameBoard gameBoard = new GameBoard(size);
        this.boardView = new PlacementPanel(gameBoard,size);
        this.setLayout(new BorderLayout());

        generateButtons();
        shipContainer.setLayout(new GridLayout(1, shipButtons.size()));


        this.add(boardView, BorderLayout.CENTER);
        this.add(shipContainer, BorderLayout.PAGE_END);
    }









}
