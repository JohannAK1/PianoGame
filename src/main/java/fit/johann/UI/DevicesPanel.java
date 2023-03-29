package fit.johann.UI;

import fit.johann.controller.MidiController;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevicesPanel {
    private JTextField title;
    private JList deviceList;
    private JButton selectButton;
    private JButton refreshButton;
    JPanel devicePanel;

    MidiController midiController;

    public DevicesPanel() throws MidiUnavailableException, CoreMidiException {

        midiController = new MidiController();

        deviceList.setModel(midiController.getDeviceNames());

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(midiController.getSelectedDevice(deviceList.getSelectedIndex()));
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(midiController.getDeviceNames().size());
                try {
                    midiController.watchForMidiChanges();
                } catch (CoreMidiException ex) {
                    throw new RuntimeException(ex);
                }
                deviceList.setModel(midiController.getDeviceNames());
                devicePanel.repaint();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public static void main(String[] args) throws MidiUnavailableException, CoreMidiException {
        JFrame fs = new JFrame();
        fs.setSize(400,400);
        fs.setContentPane(new DevicesPanel().devicePanel);
        fs.setVisible(true);
        fs.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
