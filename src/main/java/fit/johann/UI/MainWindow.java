package fit.johann.UI;

import fit.johann.controller.GUIController;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JButton nextWindow;

    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JLabel title;

    public MainWindow (GUIController controller){
        nextWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deviceConnectionWindow();
            }
        });
    }

}
