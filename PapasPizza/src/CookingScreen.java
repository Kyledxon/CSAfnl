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
        sprites.add(new Sprite(140, 208, pizzaImage, .55));
    	
    	for(Sprite2 topping : placedToppings) {
    		sprites.add(new Sprite((int)(140 + (topping.getX() - 200)/1.37), (int)(208 + (topping.getY() - 100)/1.37), topping.getImage(), topping.getScale()/1.37));
    	}
    	
    }
}
