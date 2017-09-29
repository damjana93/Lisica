package lisica;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Sheep {
    private final int sheepHeight = 20;
    private final int sheepWidth = 20;
    private int sheepX;
    private int sheepY;
    private static BufferedImage sheepImage = null;

    public int getSheepHeight() {
        return sheepHeight;
    }

    public int getSheepWidth() {
        return sheepWidth;
    }

    public int getSheepX() {
        return sheepX;
    }

    public int getSheepY() {
        return sheepY;
    }
    
    public static BufferedImage getSheepImage() {
        return sheepImage;
    }

    public Sheep() {
        this.sheepX = new Random().nextInt(MainPanel.getPanelWidth() - sheepWidth - 40) + 20;
        this.sheepY = new Random().nextInt(MainPanel.getPanelHeight() - sheepHeight- 130) + 60;
    }

    public static boolean loadImage()
    {
        try
        {
            sheepImage = ImageIO.read(new File("src/img/sheep.png"));
            return true;
        }
        catch(IOException e)
        {
            return false;
        }
    }
    
    public Rectangle sheepRect()
    {
        return new Rectangle(sheepX, sheepY, sheepWidth, sheepHeight);
    }
}
