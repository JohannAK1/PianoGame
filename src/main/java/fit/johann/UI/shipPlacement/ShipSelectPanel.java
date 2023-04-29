package fit.johann.UI.shipPlacement;

import fit.johann.model.battleship.GameBoard;
import fit.johann.model.battleship.SectorType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShipSelectPanel extends JPanel {

    private final PlacementPanel boardView;
    private final JButton[] shipButtons = {new JButton("Cruiser"), new JButton("Battleship"), new JButton("Carrier"), new JButton("UBoat")};
    private final Container shipContainer = new Container();


    private final ActionListener actionListener1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boardView.setSelectedShip(SectorType.CRUISER);
        }
    };
    private final ActionListener actionListener2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boardView.setSelectedShip(SectorType.BATTLESHIP);
        }
    };
    private final ActionListener actionListener3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boardView.setSelectedShip(SectorType.CARRIER);
        }
    };
    private final ActionListener actionListener4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boardView.setSelectedShip(SectorType.UBOAT);
        }
    };





    public ShipSelectPanel(int size) {
        GameBoard gameBoard = new GameBoard(size);
        this.boardView = new PlacementPanel(gameBoard,size);
        this.setLayout(new BorderLayout());

        buttonCreation();

        shipContainer.setLayout(new GridLayout(1,4));


        this.add(boardView, BorderLayout.CENTER);
        this.add(shipContainer, BorderLayout.PAGE_END);
    }



    private void buttonCreation(){
        for (int i = 0; i < shipButtons.length; i++) {
            if(i == 0){
                shipButtons[i].addActionListener(actionListener1);
            } else if (i == 1) {
                shipButtons[i].addActionListener(actionListener2);
            }
            else if (i == 2) {
                shipButtons[i].addActionListener(actionListener3);
            }
            else {
                shipButtons[i].addActionListener(actionListener4);
            }
            shipContainer.add(shipButtons[i]);
        }
    }






}
