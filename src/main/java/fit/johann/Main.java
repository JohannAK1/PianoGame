package fit.johann;

import fit.johann.controller.MidiController;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

public class Main {
    public static void main(String[] args) throws CoreMidiException {
        System.out.println("Hello world!");
        MidiController c = new MidiController();
    }
}