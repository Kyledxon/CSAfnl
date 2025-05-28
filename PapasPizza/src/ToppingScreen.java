import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ToppingScreen extends GameScreen {
	
	
	private ArrayList<Sprite2> staticSprites;   // for table, crust, etc.
	private ArrayList<Sprite2> draggableSprites; // only these can be moved
	
	private ArrayList<Sprite2> infiniteSources = new ArrayList<>(); //tester

	
	
    private ArrayList<Sprite2> sprites;
    private Sprite2 draggingSprite = null;
    private int dragOffsetX, dragOffsetY;
    private boolean isDraggableScreen = false;
    
    public ToppingScreen() {
        
    }

    @Override
    public void onShow() {
        isDraggableScreen = true;

        // Static table
        ImageIcon table = new ImageIcon("images/toppings table.png");
        Image tableImage = table.getImage();
        staticSprites.add(new Sprite2(-9, 40, tableImage));

        // Static pizza crust
        ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
        Image pizzaImage = pizza.getImage();
        staticSprites.add(new Sprite2(200, 100, pizzaImage, .75));

        // Draggable toppings
        Sprite2 bacon = new Sprite2(733, 726, new ImageIcon("images/bacon.png").getImage(), 0.25);
        Sprite2 mushroom = new Sprite2(134, 740, new ImageIcon("images/mushroom.png").getImage(), 0.25);
        Sprite2 olive = new Sprite2(833, 553, new ImageIcon("images/olive.png").getImage(), 0.25);
        Sprite2 onion = new Sprite2(318, 823, new ImageIcon("images/onion.png").getImage(), 0.25);
        Sprite2 pepper = new Sprite2(569, 818, new ImageIcon("images/pepper.png").getImage(), 0.25);
        Sprite2 pepperoni = new Sprite2(41, 593, new ImageIcon("images/peperoni.png").getImage(), 0.25);
       
        bacon.setVisible(false);
        mushroom.setVisible(false);
        olive.setVisible(false);
        onion.setVisible(false);
        pepper.setVisible(false);
        pepperoni.setVisible(false);
        
        infiniteSources.add(bacon);
        infiniteSources.add(mushroom);
        infiniteSources.add(olive);
        infiniteSources.add(onion);
        infiniteSources.add(pepper);
        infiniteSources.add(pepperoni);

        draggableSprites.addAll(infiniteSources);

        addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        	    for (int i = draggableSprites.size() - 1; i >= 0; i--) {
        	        Sprite2 s = draggableSprites.get(i);
        	        if (s.contains(e.getX(), e.getY())) {
        	            if (infiniteSources.contains(s)) {
        	                // Create a visible clone from the invisible source
        	                Sprite2 clone = new Sprite2(s.getX(), s.getY(), s.getImage(), s.getScale());
        	                clone.setVisible(true);
        	                draggableSprites.add(clone);
        	                draggingSprite = clone;
        	            } else {
        	                // Existing visible sprite
        	                draggingSprite = s;
        	            }
        	            dragOffsetX = e.getX() - s.getX();
        	            dragOffsetY = e.getY() - s.getY();
        	            break;
        	        }
        	    }
        	}

            @Override
            public void mouseReleased(MouseEvent e) {
                draggingSprite = null;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (draggingSprite != null) {
                    draggingSprite.setPosition(e.getX() - dragOffsetX, e.getY() - dragOffsetY);
                    repaint();
                }
            }
        });
     // To print mouse coordinates when the mouse moves (hovering/moving)
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //System.out.println("Mouse moved to: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                //System.out.println("Mouse dragged to: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        // To print mouse coordinates when the mouse is clicked or pressed
        addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        	    for (int i = draggableSprites.size() - 1; i >= 0; i--) {
        	        Sprite2 s = draggableSprites.get(i);
        	        if (s.contains(e.getX(), e.getY())) {
        	            // If it's one of the infinite source toppings
        	            if (infiniteSources.contains(s)) {
        	                // Clone it and add the clone to draggableSprites
        	                Sprite2 clone = new Sprite2(s.getX(), s.getY(), s.getImage(), s.getScale());
        	                draggableSprites.add(clone);
        	                draggingSprite = clone;
        	            } else {
        	                // It's a previously placed topping
        	                draggingSprite = s;
        	            }
        	            dragOffsetX = e.getX() - s.getX();
        	            dragOffsetY = e.getY() - s.getY();
        	            break;
        	        }
        	    }
        	}


            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }
        });
    }
}
