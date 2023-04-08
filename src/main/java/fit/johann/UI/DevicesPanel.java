package fit.johann.UI;

import fit.johann.controller.GUIController;
import fit.johann.controller.MidiController;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;

public class DevicesPanel {
    private JLabel title;
    private JList<String> deviceList;
    private JButton selectButton;
    private JButton refreshButton;

    public JPanel getDevicePanel() {
        return devicePanel;
    }

    JPanel devicePanel;
    MidiController midiController;

    /**
     * Constructor that creates a JPanel, in which a user can select a desired MIDI device
     * @throws CoreMidiException Library Error
     * @throws MidiUnavailableException MIDI connection Error
     */
    public DevicesPanel(GUIController controller) throws CoreMidiException, MidiUnavailableException {

        midiController = new MidiController();
        deviceList.setModel(midiController.getDeviceNames());

        // button to selecting the device
        selectButton.addActionListener(e -> {
            try {
                midiController.stopScanning();
            } catch (CoreMidiException ex) {
                throw new RuntimeException(ex);
            }
            try {
                controller.keyInputTest(midiController.getSelectedDevice(deviceList.getSelectedIndex()));
            } catch (MidiUnavailableException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println(midiController.getSelectedDevice(deviceList.getSelectedIndex()));
        });

        // Button to refresh the list of available devices
        refreshButton.addActionListener(e -> {
            System.out.println(midiController.getDeviceNames().size());
            deviceList.setModel(midiController.getDeviceNames());
            devicePanel.repaint();
            devicePanel.getParent().repaint();
        });
    }
}
