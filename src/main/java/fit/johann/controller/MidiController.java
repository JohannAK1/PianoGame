package fit.johann.controller;

import uk.co.xfactorylibrarians.coremidi4j.CoreMidiDestination;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiDeviceProvider;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiException;
import uk.co.xfactorylibrarians.coremidi4j.CoreMidiNotification;

import javax.management.Notification;
import javax.management.NotificationListener;
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
        public void midiSystemUpdated() throws CoreMidiException {
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

    public ArrayList<MidiDevice> getAvailableDevices() {
        return availableDevices;
    }

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
        CoreMidiDeviceProvider.addNotificationListener(listener);
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
                MidiDevice device = MidiSystem.getMidiDevice(info);
                try(Transmitter ignored1 = device.getTransmitter()){
                    availableDevices.add(device);
                    System.out.println(device + " has transmitter");
                } catch (MidiUnavailableException ignored) {}
        }
        if(!isCoreMidiLoaded()){
            throw new IllegalStateException("Library failed to load");
        }
    }


    public void stopScanning() throws CoreMidiException {
        CoreMidiDeviceProvider.removeNotificationListener(listener);
    }
    public MidiDevice getSelectedDevice(int i){
        if(i == -1){
            return null;
        }else{
            return availableDevices.get(i);
        }
    }
}
