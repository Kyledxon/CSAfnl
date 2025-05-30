import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CuttingScreen extends GameScreen implements MouseListener{

    public CuttingScreen() {
    	 int numCuts; 
    	    int deltaX;
    	    int deltaY;
    	    int startX;
    	    int endX;
    	    int startY;
    	    int endY;
    }

   
    @Override
    public void onShow() {
    	ArrayList<Sprite2> placedToppings = Game.toppingsScreen.getPlacedToppings();
    	
    	sprites.clear();
    	ImageIcon bg = new ImageIcon("images/cutting-pixel.png");
    	Image bgImage = bg.getImage();
        ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
    	Image pizzaImage = pizza.getImage();

    	//hi
    	sprites.add(new Sprite(0, 0, bgImage, 1.0));

    	sprites.add(new Sprite(90, 130, pizzaImage, .6));
    	
    	for(Sprite2 topping : placedToppings) {
    		sprites.add(new Sprite((int)(90 + (topping.getX() - 200)/1.37), (int)(130 + (topping.getY() - 100)/1.37), topping.getImage(), topping.getScale()/1.37));
    	}
    	
    	
    	for(Sprite2 topping : placedToppings) {
    		sprites.add(new Sprite(topping.getX(), topping.getY(), topping.getImage(), topping.getScale()));
    	}
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
