package lisica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements KeyListener {
    private final static int panelWidth = MainFrame.getWIDTH();
    private final static int panelHeight = MainFrame.getHEIGHT();
    private BufferedImage backgroudImage = null;
    private boolean imagesLoaded = false;
    int points;
    private Fox fox;
    private Sheep sheep;
    
    public static int getPanelWidth() {
        return panelWidth;
    }

    public static int getPanelHeight() {
        return panelHeight;
    }
    
    public MainPanel() {
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setLayout(null);
        setBackground(Color.GREEN);
        setFocusable(true);
        setVisible(true);
        StartGame();
        imagesLoaded = loadImages();
        addKeyListener(this);
    }
    
    public void StartGame()
    {
        fox = new Fox(panelWidth/2, panelHeight/2);
        sheep = new Sheep();
        points = 0;
        repaint();
    }
    
    public boolean loadImages() {
        try {
            backgroudImage = ImageIO.read(new File("src/img/background.png"));
            System.out.println("pozadina uspjela");
            return Fox.loadImages() && Sheep.loadImage();
        } catch (IOException e) {
            System.out.println("pozadina \n" + e.getMessage() );
            return false;
        }
    }

    private void CheckCollision()
    {
        if(fox.foxRect().intersects(sheep.sheepRect()))
        {
            sheep = new Sheep();
            points++;
            System.out.println(points);
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
       if(imagesLoaded)
       {        g.drawImage(backgroudImage, 0, 0, panelWidth, panelHeight, this);
                g.drawImage(Fox.getFoxImage(), fox.getFoxX(), fox.getFoxY(), 
                        fox.getFoxWidth(), fox.getFoxHeight(), this);
                g.drawImage(Sheep.getSheepImage(), sheep.getSheepX(), sheep.getSheepY(), 
                        sheep.getSheepWidth(), sheep.getSheepHeight(), this);
        }
       Font mainFont = new Font("Arial", Font.BOLD, 20);
        g.setFont(mainFont);

        String message = "SCORE: " + points;

        FontMetrics fontMetrics = g.getFontMetrics(mainFont);
        int stringWidth = fontMetrics.stringWidth(message);
        g.setColor(Color.WHITE);
        g.drawString(message, 0, 20);
        g.setColor(Color.BLACK);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
            fox.move(0, -1);
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            fox.move(1, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            fox.move(0, 1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            fox.move(-1, 0);
        }
        else if(e.getKeyCode() == KeyEvent.VK_F2)
            StartGame();
        CheckCollision();
        
        repaint();
            
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
