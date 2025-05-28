import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrderScreen extends GameScreen {
	
	
    public OrderScreen() {
    	
    }

    @Override
    public void onShow() {
        sprites.clear();
        // Add sprites for this screen
        ImageIcon pollos = new ImageIcon("images/8-bit pollos.png");
    	Image pollosImage = pollos.getImage();
        sprites.add(new Sprite(0, 0, pollosImage));
        // After changing sprites, repaint so paintComponent is called
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g; // Cast Graphics to Graphics2D
        for (Sprite sprite : sprites) {
            sprite.draw(g2d); // Call the draw method of the sprite which handles scaling
        }
    }
}
