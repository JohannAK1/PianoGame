package fit.johann.logic;

import fit.johann.model.PianoLayout;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.swing.*;


public class MyMidiInputReceiver implements Receiver {
    private final PianoLayout layout;
    private final JFrame frame;
    public MyMidiInputReceiver(PianoLayout pianoLayout, JFrame frame){
        System.out.println("Receiver instantiated");
        this.frame = frame;
        this.layout = pianoLayout;
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        byte[] arr = message.getMessage();
        if (arr.length != 1 && arr[1] != 123){
            int key = arr[1];
            boolean pressed = !(arr[2] == 0);
            layout.keyInput(key,pressed);
            frame.repaint();
        }
    }

    @Override
    public void close() {

    }
}
