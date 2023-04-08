package fit.johann.model;

import java.awt.*;

public class PianoKey {
    private final Color normalColor;
    private final Color highlightedColor = Color.RED;
    private Color eventColor;

    /**
     * Constructor that creates a white or black key
     * @param isWhiteKey then white key
     */
    public PianoKey(boolean isWhiteKey){
        if(isWhiteKey) normalColor = Color.WHITE;
        else normalColor = Color.BLACK;
        eventColor = normalColor;
    }

    /**
     * Returns current key colour
     * @return current key colour
     */
    public Color getColor(){return eventColor;}

    /**
     * changes current key-color to red
     */
    public void wasPressed(){
        eventColor = highlightedColor;
    }

    /**
     * changes current key-color to normal color
     */
    public void wasReleased(){
        eventColor = normalColor;
    }

    /**
     * Returns normal key-colour
     * @return normal key-colour
     */
    public Color getNormalColor(){return normalColor;}
}
