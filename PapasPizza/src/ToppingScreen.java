import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ToppingScreen extends GameScreen {

    public ToppingScreen() {
        
    }

    @Override
    public void onShow() {
        sprites.clear();
        
        ImageIcon table = new ImageIcon("images/toppings table.png");
    	Image tableImage = table.getImage();
    	sprites.add(new Sprite(-9, 40, tableImage));
    	
    	ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
    	Image pizzaImage = pizza.getImage();
    	sprites.add(new Sprite(200, 100, pizzaImage, .75));
        // You can refresh data, reset state, etc.
    }
}
