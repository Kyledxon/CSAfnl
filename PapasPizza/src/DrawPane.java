import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DrawPane extends JPanel {
    private ArrayList<Sprite> sprites;

    public DrawPane(String screenType) {
        // Set the sprites depending on the screen type
        sprites = new ArrayList<>();
        if ("Order Screen".equals(screenType)) {
        	ImageIcon pollos = new ImageIcon("images/8-bit pollos.png");
        	Image pollosImage = pollos.getImage();
        	sprites.add(new Sprite(0, 0, pollosImage));
        } else if ("screen2".equals(screenType)) {
            
        }
        // You can add more screens and sprites based on the screenType argument
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Sprite sprite : sprites) {
            g.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);
        }
    }
}