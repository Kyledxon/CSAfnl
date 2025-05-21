import java.awt.Graphics;
import java.awt.Graphics2D;
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
        } else if ("Toppings Screen".equals(screenType)) {
        	ImageIcon table = new ImageIcon("images/toppings table.png");
        	Image tableImage = table.getImage();
        	sprites.add(new Sprite(-9, 40, tableImage));
        	
        	ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
        	Image pizzaImage = pizza.getImage();
        	sprites.add(new Sprite(0, 0, pizzaImage, .5));
        }
        // You can add more screens and sprites based on the screenType argument
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