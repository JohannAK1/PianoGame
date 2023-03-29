package fit.johann.UI;

import fit.johann.controller.MidiController;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevicesPanel {
    private JTextField title;
    private JList<String> deviceList;
    private JButton selectButton;
    private JButton refreshButton;
    JPanel devicePanel;

    MidiController midiController;

    public DevicesPanel() throws CoreMidiException, MidiUnavailableException {

        midiController = new MidiController();
        midiController.watchForMidiChanges();
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
                deviceList.setModel(midiController.getDeviceNames());
                devicePanel.repaint();
                devicePanel.getParent().repaint();
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
