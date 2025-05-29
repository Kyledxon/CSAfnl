import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CookingScreen extends GameScreen {

    public CookingScreen() {
    	
    }

    @Override
    public void onShow() {
    	ArrayList<Sprite2> placedToppings = Game.toppingsScreen.getPlacedToppings();
    	
    	sprites.clear();
        ImageIcon bg = new ImageIcon("images/newbg.png");
    	Image bgImage = bg.getImage();
    	sprites.add(new Sprite(0,0,bgImage, 1.0));
        ImageIcon table = new ImageIcon("images/baking.png");
    	Image tableImage = table.getImage();
    	sprites.add(new Sprite(20, 60, tableImage, .65));
    	ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
        Image pizzaImage = pizza.getImage();
        sprites.add(new Sprite(85, 160, pizzaImage, .55));
    	
    	for(Sprite2 topping : placedToppings) {
    		sprites.add(new Sprite(topping.getX()-115, topping.getY()+60, topping.getImage(), topping.getScale()-.05));
    	}
    	
    }
}
