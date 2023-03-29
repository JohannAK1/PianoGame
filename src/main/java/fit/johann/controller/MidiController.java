package fit.johann.controller;

import uk.co.xfactorylibrarians.coremidi4j.CoreMidiDeviceProvider;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.util.ArrayList;

public class MidiController {

    public ArrayList<MidiDevice> getAvailableDevices() {
        return availableDevices;
    }

    //List of available Devices
    private ArrayList<MidiDevice> availableDevices;

    /**
     * Checks if the library was loaded
     * @return true when loaded
     * @throws CoreMidiException when not loaded
     */
    public static boolean isCoreMidiLoaded() throws CoreMidiException {
        return CoreMidiDeviceProvider.isLibraryLoaded();
    }

    /**
     * Checks for changes in the Number of connected Midi-Devices and updates the list of devices
     * when changes occurred.
     * @throws CoreMidiException Connection Errors
     */
    public void watchForMidiChanges() throws CoreMidiException {
        CoreMidiDeviceProvider.addNotificationListener(() -> {
            availableDevices = new ArrayList<>();
            System.out.println("Test");
            for (MidiDevice.Info i : CoreMidiDeviceProvider.getMidiDeviceInfo()){
                try {
                    availableDevices.add(MidiSystem.getMidiDevice(i));
                } catch (MidiUnavailableException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public DefaultListModel<String> getDeviceNames() {
        DefaultListModel<String> deviceNames = new DefaultListModel<>();
        for (MidiDevice e : availableDevices){
            deviceNames.addElement(e.getDeviceInfo().getName());
        }
        return deviceNames;
    }

    public MidiController() throws CoreMidiException, MidiUnavailableException {
        availableDevices = new ArrayList<>();
        for (MidiDevice.Info info : CoreMidiDeviceProvider.getMidiDeviceInfo()){
            availableDevices.add(MidiSystem.getMidiDevice(info));
        }
        if(!isCoreMidiLoaded()){
            throw new IllegalStateException("Library failed to load");
        }
    }

    public MidiDevice getSelectedDevice(int i){
        if(i == -1){
            return null;
        }else{
            return availableDevices.get(i);
        }
    }
}
