package fit.johann.UI;

import fit.johann.model.PianoKey;
import fit.johann.model.PianoLayout;

import javax.swing.*;
import java.awt.*;


public class KeyBoardPanel extends JPanel {

    private int keyHeight;
    private int keyWidth;
    private PianoLayout layout;
    public KeyBoardPanel(int width, int height, PianoLayout layout){
        this.setSize(width,height);
        keyWidth = (width / 52)-2;
        keyHeight = keyWidth * 4;
        System.out.println("Panel instantiated");
        this.layout = layout;
    }
    @Override
    public void paintComponent(Graphics g){
        //super.paint(g);
        paintKeys(g);
    }

    private void paintKeys(Graphics g){
        PianoKey[] keys = layout.getKeys();
        int pos = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].getNormalColor().equals(Color.white)) {
                g.setColor(keys[i].getColor());
                g.fillRect(pos, 200, keyWidth, keyHeight);
                pos += keyWidth + 2;
            } else {
                int tempPos = pos;
                g.setColor(keys[i+1].getColor());
                g.fillRect(pos, 200, keyWidth, keyHeight);
                pos += keyWidth + 2;
                g.setColor(keys[i].getColor());
                g.fillRect(tempPos - (keyWidth / 2), 200, (int) (keyWidth * 0.8), (int) (keyHeight * 0.8));
                i +=1;
            }
        }

    }
}
