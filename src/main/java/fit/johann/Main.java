package fit.johann;

import fit.johann.controller.MidiController;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

import javax.sound.midi.MidiUnavailableException;

public class Main {
    public static void main(String[] args) throws CoreMidiException, MidiUnavailableException {
        System.out.println("Hello world!");
        MidiController c = new MidiController();
    }
}