package fit.johann;


import fit.johann.Persistence.GameobjectRepository;
import fit.johann.Persistence.PersistenceManager;
import fit.johann.controller.GUIController;
import fit.johann.model.battleship.Gameobject;
import fit.johann.model.battleship.SectorType;
import fit.johann.model.battleship.ShipDataPer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

/**
 *          SectorType b = SectorType.BATTLESHIP;
 *
 *         List<byte[]> bytes = new ArrayList<>();
 *
 *         BufferedImage[] images = b.getImages();
 *         for (int i = 0; i < b.length; i++){
 *             bytes.add(getImageBytes(images[i]));
 *         }
 *
 *         Gameobject k = new Gameobject("test",3,bytes);
 *         GameobjectRepository gameobjectRepository = new GameobjectRepository();
 *         gameobjectRepository.persistGameobject(k);
 *         //System.out.println(gameobjectRepository.getGameobject("test").getImageBytes().length);
 *
 *         JFrame f = new JFrame();
 *         ImageIcon sdhfb = new ImageIcon(gameobjectRepository.getGameobject("test").getImageBytes()[0]);
 *         JLabel l = new JLabel(sdhfb);
 *
 *         f.add(l);
 *         f.setVisible(true);
 *         f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 */

        ShipDataPer p = new ShipDataPer()
        GameobjectRepository gameobjectRepository = new GameobjectRepository();




    }

    public static byte[] getImageBytes (BufferedImage image) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG" /* for instance */, out);
        return out.toByteArray();
    }

}


