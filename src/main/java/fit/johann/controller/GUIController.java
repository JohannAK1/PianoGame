package fit.johann.controller;

import fit.johann.UI.DevicesPanel;
import fit.johann.UI.KeyBoardPanel;
import fit.johann.UI.MainWindow;
import fit.johann.logic.MyMidiInputReceiver;
import fit.johann.model.pianolayout.PianoLayout;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;
import javax.swing.*;

public class GUIController {
    private final JFrame k;

    /**
     * Creates a new JFrame and adds the MainWindow.
     */
    public GUIController(){
        k = new JFrame();
        k.setSize(1000,1000);
        MainWindow window = new MainWindow(this);
        k.setContentPane(window.getPanel1());
        k.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        k.setVisible(true);
    }

    /**
     * Switches the current panel with the devicePanel
     */
    public void deviceConnectionWindow(){
        DevicesPanel panel;
        try {
            panel = new DevicesPanel(this);
        } catch (CoreMidiException | MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
        k.setContentPane(panel.getDevicePanel());
        k.validate();
    }

    /**
     * Panel switch: current -> keyInputTest
     * @param device selected E-Piano / MidiDevice
     * @throws MidiUnavailableException Midi Connection Error
     */
    public void keyInputTest(MidiDevice device) throws MidiUnavailableException {
        PianoLayout layout = new PianoLayout();
        KeyBoardPanel keyBoardPanel = new KeyBoardPanel(k.getWidth(),k.getHeight(),layout);
        k.setContentPane(keyBoardPanel);
        k.validate();
        device.open();
        Transmitter transmitter = device.getTransmitter();
        transmitter.setReceiver(new MyMidiInputReceiver(layout,k));
    }
}
