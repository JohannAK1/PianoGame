package fit.johann.UI;

import fit.johann.logic.GameBoardLogic;
import fit.johann.model.battleship.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private final BoardPanel boardPanel;
    private final GameBoardLogic logic1;
    private final GameBoard gameBoard1;
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");

    private Container container= new Container();


    public GamePanel(int size){
        this.setSize(size,size);
        this.gameBoard1 = new GameBoard(8);
        this.logic1 = new GameBoardLogic(gameBoard1);
        this.boardPanel = new BoardPanel(gameBoard1,size);
        this.setLayout(new BorderLayout());
        this.add(boardPanel,BorderLayout.CENTER);
        container.setLayout(new GridLayout(1,2));
        container.add(button1);
        container.add(button2);
        this.add(container,BorderLayout.PAGE_END);
        button1.addActionListener((ActionEvent e) -> {
            boardPanel.setButtonPressed();
            System.out.println("Test");
        });

    }





}
