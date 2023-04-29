package fit.johann.Tests;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ship {

    public String name;
    public int shipLength;
    public ArrayList<BufferedImage> images;

    public String getName() {
        return name;
    }

    public int getShipLength() {
        return shipLength;
    }

    public ArrayList<BufferedImage> getImages() {
        return images;
    }
}
