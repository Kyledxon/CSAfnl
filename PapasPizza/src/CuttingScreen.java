import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class CuttingScreen extends GameScreen implements MouseListener, MouseMotionListener{
	
	private CardLayout cardLayout;
	private JPanel cards;
	private GameScreen orderScreen;
   public CuttingScreen() {
  
   }
   public CuttingScreen(CardLayout cardLayout, JPanel cards, GameScreen orderScreen) {
       this.cardLayout = cardLayout;
       this.cards = cards;
       this.orderScreen = orderScreen;
   }
	 	int numCutsNeeded;
	    int deltaX;
	    int deltaY;
	    int startX;
	    int endX;
	    int startY;
	    int endY;
	    int cutsDone;
	    
	    private boolean isDragging = false;
	    private int dragEndX;
	    private int dragEndY;

	   
	    private ArrayList<Line2D> cutLines = new ArrayList<>();
	    private JButton doneButton;
	   
	   
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
   	
   	
   	addMouseListener(this);
   	if (doneButton == null) {
   		doneButton = new JButton("Done Cutting");
   		doneButton.setBounds(800, 30, 150, 40); // Position as needed
   		doneButton.addActionListener(e -> {
   			orderScreen.onShow();
   			cardLayout.show(cards, "Order Screen");
   		});
   	}
   	add(doneButton);
   	addMouseMotionListener(this);
   	
   }
	    

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
       int y = e.getY();
       System.out.println("Mouse pressed at: (" + x + ", " + y + ")");
       startX = x;
       startY = y;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
       int y = e.getY();
       System.out.println("Mouse pressed at: (" + x + ", " + y + ")");
       startX = x;
       startY = y;
	}
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x = e.getX();
       int y = e.getY();
       System.out.println("Mouse released at: (" + x + ", " + y + ")");
       endX = x;
       endY = y;
       cutsDone++;
       deltaX = endX - startX;
       deltaY = endY - startY;
      
       cutLines.add(new Line2D.Float(startX, startY, endX, endY));
      
       if(deltaY <= 20 && deltaX >= 100) {
       	//horizontal cut
       	System.out.println("Good Cut!");
       } else if(deltaY >= 100 && deltaX <= 20) {
       	//vertical cut
       	System.out.println("Good Cut!");
       }else {
       	//bad cut smh
       	System.out.println("Bad Cut :(");
       }
      
       isDragging = false;
      
       repaint();
      
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(new Color(196, 194, 196)); // so same color as cutting board Add commentMore actions
	    g2d.setStroke(new BasicStroke(10)); // Thicker lines
	    for (Line2D line : cutLines) {
	        g2d.draw(line);
	    }
	    
	    if(isDragging) {
	        g2d.setColor(Color.RED); // Or any contrasting color
	        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10}, 0)); // Dashed line
	        g2d.drawLine(startX, startY, dragEndX, dragEndY);
	    }
	}
	@Override
	public void onHide() {
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		isDragging = true;
		dragEndX = e.getX();
		dragEndY = e.getY();
		repaint();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
