package lisica;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Fox {
    private final int foxHeight = 30;
    private final int foxWidth = 30;
    private int foxX;
    private int foxY;
    private final int foxSpeed = 10;
    private static BufferedImage foxImage = null;

    public int getFoxHeight() {
        return foxHeight;
    }

    public int getFoxWidth() {
        return foxWidth;
    }

    public int getFoxX() {
        return foxX;
    }

    public int getFoxY() {
        return foxY;
    }

    public static BufferedImage getFoxImage() {
        return foxImage;
    }
    
    public Fox(int x, int y) {
        foxX = x;
        foxY = y;
    }
    
    public static boolean loadImages() {
        try {
            foxImage = ImageIO.read(new File("src/img/fox.png"));
            System.out.println("lisica uspjela");
            return true;
        } catch (IOException e) {
            System.out.println("lisica neuspjela");
            return false;
        }
    }
    
    public void move(int LeftRight, int UpDown){
        foxX += LeftRight*foxSpeed;
        foxY += UpDown*foxSpeed;
        if(foxX < 20)
            foxX = 20;
        else if(foxX > MainPanel.getPanelWidth() - 20 - foxWidth)
            foxX = MainPanel.getPanelWidth() - 20 - foxWidth;
        if(foxY < 60)
            foxY = 60;
        else if(foxY > MainPanel.getPanelHeight() - 70 - foxHeight)
            foxY = MainPanel.getPanelHeight() - 70 - foxHeight;
        }
    
    public Rectangle foxRect()
    {
        return new Rectangle(foxX, foxY, foxWidth, foxHeight);
    }
}
