package fit.johann.model;

import java.awt.*;

public class PianoKey {
    private final Color normalColor;
    private final Color highlightedColor = Color.RED;
    private Color eventColor;


    public PianoKey(boolean isWhiteKey){
        if(isWhiteKey) normalColor = Color.WHITE;
        else normalColor = Color.BLACK;
        eventColor = normalColor;
    }

    public Color getColor(){return eventColor;}

    public void wasPressed(){
        eventColor = highlightedColor;
    }

    public void wasReleased(){
        eventColor = normalColor;
    }
    public Color getNormalColor(){return normalColor;}
}
