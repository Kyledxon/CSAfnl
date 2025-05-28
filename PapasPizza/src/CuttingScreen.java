import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CuttingScreen extends GameScreen {

    public CuttingScreen() {
        
    }

    @Override
    public void onShow() {
        sprites.clear();
        ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
    	Image pizzaImage = pizza.getImage();
    	sprites.add(new Sprite(0, 0, pizzaImage, .5));
    	
    }
}
