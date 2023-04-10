package fit.johann.model.pianolayout;

public class PianoLayout {


    // Piano key layout
    private final PianoKey[] pianoKeys;

    /**
     * Generates the normal KeyLayout (no highlighted Keys)
     */
    public PianoLayout (){
        pianoKeys = new PianoKey[88];
        generateLayout();
        System.out.println("Layout instantiated");
    }

    /**
     *
     * @return piano key layout
     */
    public PianoKey[] getKeys() {
        return pianoKeys;
    }

    /**
     * Helper method to generate the Keys
     */
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

    /**
     * helper method to generate on chuck of the key layout
     * @param counter keyPostion
     * @return counter
     */
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

    /**
     * Chnages the color of a key
     * @param key index of key in Array
     * @param wasPressed key pressed condition
     */
    public void keyInput(int key, boolean wasPressed) {
        int index = key - 21;
        if (index < pianoKeys.length && index >= 0) {
            if (wasPressed) {
                pianoKeys[index].wasPressed();
            } else pianoKeys[index].wasReleased();
        }
    }

}
