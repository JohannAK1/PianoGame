package fit.johann.model.battleship;

import jakarta.persistence.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Entity
public class Gameobject {
    @Id
    String name;
    @Column
    int length;
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(length=10000)
    List<byte[]> imageBytes;

    public Gameobject() {
    }

    public Gameobject(String name, int length, List<byte[]> images) {
        BufferedImage k = new BufferedImage(30,30,3);
        this.name = name;
        this.length = length;
        this.imageBytes = images;
    }

    public BufferedImage[] getImageBytes() throws IOException {
        BufferedImage[] images = new BufferedImage[length];
        for(int i = 0; i < length; i++){
            InputStream in = new ByteArrayInputStream(imageBytes.get(i));
            images[i] = ImageIO.read(in);
        }
        return images;
    }

}
