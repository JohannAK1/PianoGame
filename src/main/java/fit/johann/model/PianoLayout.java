package fit.johann.model;

public class PianoLayout {

    private final PianoKey[] pianoKeys;

    public PianoLayout (){
        pianoKeys = new PianoKey[88];
        generateLayout();
        System.out.println("Layout instantiated");
    }

    public PianoKey[] getKeys() {
        return pianoKeys;
    }

    private void generateLayout(){
        pianoKeys[0] = new PianoKey(true);
        pianoKeys[1] = new PianoKey(false);
        pianoKeys[2] = new PianoKey(true);

        int counter = 3;
        for(int i = 0; i < 7; i++){
            counter = onePack(counter);
        }
        pianoKeys[counter] = new PianoKey(true);

    }

    private int onePack(int counter){
        pianoKeys[counter] = new PianoKey(true);
        counter++;
        pianoKeys[counter] = new PianoKey(false);
        counter++;
        pianoKeys[counter] = new PianoKey(true);
        counter++;
        pianoKeys[counter] = new PianoKey(false);
        counter++;
        pianoKeys[counter] = new PianoKey(true);
        counter++;
        pianoKeys[counter] = new PianoKey(true);
        counter++;
        pianoKeys[counter] = new PianoKey(false);
        counter++;
        pianoKeys[counter] = new PianoKey(true);
        counter++;
        pianoKeys[counter] = new PianoKey(false);
        counter++;
        pianoKeys[counter] = new PianoKey(true);
        counter++;
        pianoKeys[counter] = new PianoKey(false);
        counter++;
        pianoKeys[counter] = new PianoKey(true);
        counter++;
        return counter;
    }

    public void keyInput(int key, boolean wasPressed) {
        int index = key - 21;
        if (index < pianoKeys.length && index >= 0) {
            if (wasPressed) {
                pianoKeys[index].wasPressed();
            } else pianoKeys[index].wasReleased();
        }
    }

}
