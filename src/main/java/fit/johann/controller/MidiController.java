package fit.johann.controller;

import uk.co.xfactorylibrarians.coremidi4j.CoreMidiDeviceProvider;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiNotification;


import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;
import javax.swing.*;
import java.util.ArrayList;

public class MidiController {

    //List of available Devices
    private ArrayList<MidiDevice> availableDevices;

    //NotificationListener
    CoreMidiNotification listener = new CoreMidiNotification() {
        @Override
        public void midiSystemUpdated(){
            availableDevices = new ArrayList<>();
            System.out.println("Test");
            for (MidiDevice.Info i : CoreMidiDeviceProvider.getMidiDeviceInfo()){
                MidiDevice device;
                try {
                    device = MidiSystem.getMidiDevice(i);
                } catch (MidiUnavailableException e) {
                    throw new RuntimeException(e);
                }
                try(Transmitter ignored1 = device.getTransmitter()){
                    availableDevices.add(device);
                    System.out.println(device + " has transmitter");
                } catch (MidiUnavailableException ignored) {}
            }
        }
    };

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
    private void watchForMidiChanges() throws CoreMidiException {
        CoreMidiDeviceProvider.addNotificationListener(listener);
    }

    /**
     * This Method is used for the first scan of MidiDevices and updates deviceArray
     * @throws MidiUnavailableException Midi Connection Error
     */
    private void firstScan() throws MidiUnavailableException {
        availableDevices = new ArrayList<>();
        for (MidiDevice.Info info : CoreMidiDeviceProvider.getMidiDeviceInfo()){
            MidiDevice device = MidiSystem.getMidiDevice(info);
            try(Transmitter ignored1 = device.getTransmitter()){
                availableDevices.add(device);
                System.out.println(device + " has transmitter");
            } catch (MidiUnavailableException ignored) {}
        }
    }

    /**
     * Adds the names of all currently available Devices to a List, which ist used by JList
     * @return DefaultListModel with device names
     */
    public DefaultListModel<String> getDeviceNames() {
        DefaultListModel<String> deviceNames = new DefaultListModel<>();

        for (MidiDevice e : availableDevices){
            deviceNames.addElement(e.getDeviceInfo().getName());
        }
        return deviceNames;
    }

    /**
     * Constructor that scans and for available midi devices and updates an array containing those
     * @throws CoreMidiException Error when library not available
     * @throws MidiUnavailableException Midi Connection Error
     */
    public MidiController() throws CoreMidiException, MidiUnavailableException {
        if(!isCoreMidiLoaded()){
            throw new IllegalStateException("Library failed to load");
        }
        firstScan();
        watchForMidiChanges();
    }

    /**
     * Removes the listener, therefore no new scans possible
     * @throws CoreMidiException Library error
     */
    public void stopScanning() throws CoreMidiException {
        CoreMidiDeviceProvider.removeNotificationListener(listener);
    }

    /**
     * Returns the device at the specific Index of the Array of available devices
     * @param i index
     * @return device
     */
    public MidiDevice getSelectedDevice(int i){
        if(i == -1){
            return null;
        }else{
            return availableDevices.get(i);
        }
    }
}
