import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        sprites.clear();
        ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
    	Image pizzaImage = pizza.getImage();
    	sprites.add(new Sprite(0, 0, pizzaImage, .5));
    	//hi
    	
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
