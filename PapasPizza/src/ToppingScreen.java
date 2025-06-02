import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ToppingScreen extends GameScreen {
	
	
	private ArrayList<Sprite2> draggableSprites = new ArrayList<>(); // only these can be moved
	private ArrayList<Sprite2> infiniteSources = new ArrayList<>(); //tester

	
    private Sprite2 draggingSprite = null;
    private int dragOffsetX, dragOffsetY;
    private boolean isDraggableScreen = false;
    
    public ToppingScreen() {
        
    }

    @Override
    public void onShow() {
        isDraggableScreen = true;
        Toppings toppings = new Toppings();

        // Static table
        ImageIcon table = new ImageIcon("images/toppings table.png");
        Image tableImage = table.getImage();
        sprites.add(new Sprite(-9, 40, tableImage));

        // Static pizza crust
        ImageIcon pizza = new ImageIcon("images/pizza crust1.png");
        Image pizzaImage = pizza.getImage();
        sprites.add(new Sprite(200, 100, pizzaImage, .75));

        // Draggable toppings
        Sprite2 bacon = new Sprite2(738, 731, new ImageIcon("images/bacon.png").getImage(), 0.25, "bacon");
        Sprite2 mushroom = new Sprite2(140, 743, new ImageIcon("images/mushroom.png").getImage(), 0.25, "mushroom");
        Sprite2 olive = new Sprite2(847, 558, new ImageIcon("images/olive.png").getImage(), 0.25, "olive");
        Sprite2 onion = new Sprite2(322, 827, new ImageIcon("images/onion.png").getImage(), 0.25, "onion");
        Sprite2 pepper = new Sprite2(575, 823, new ImageIcon("images/pepper.png").getImage(), 0.25, "pepper");
        Sprite2 pepperoni = new Sprite2(47, 593, new ImageIcon("images/peperoni.png").getImage(), 0.25, "pepperoni");
       
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
        	                Sprite2 clone = new Sprite2(s.getX(), s.getY(), s.getImage(), s.getScale(), s.getName());
        	                clone.setVisible(true);
        	                draggableSprites.add(clone);
        	                draggingSprite = clone;
        	                toppings.incList(clone.getName());
        	                toppings.printList();
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
        /*addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        	    for (int i = draggableSprites.size() - 1; i >= 0; i--) {
        	        Sprite2 s = draggableSprites.get(i);
        	        if (s.contains(e.getX(), e.getY())) {
        	            // If it's one of the infinite source toppings
        	            if (infiniteSources.contains(s)) {
        	                // Clone it and add the clone to draggableSprites
        	                Sprite2 clone = new Sprite2(s.getX(), s.getY(), s.getImage(), s.getScale(), s.getName());
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
        });*/
    }
    
    public ArrayList<Sprite2> getPlacedToppings() {
        ArrayList<Sprite2> placedToppings = new ArrayList<>();
        for (Sprite2 s : draggableSprites) {
            if (!infiniteSources.contains(s)) {
                placedToppings.add(new Sprite2(s.getX(), s.getY(), s.getImage(), s.getScale(), s.getName()));
            }
        }
        return placedToppings;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Sprite sprite : sprites) {
            sprite.draw(g2d); // unmovable background stuff
        }

        for (Sprite2 sprite : draggableSprites) {
            sprite.draw(g2d); // toppings that you can move
        }
    }
}
