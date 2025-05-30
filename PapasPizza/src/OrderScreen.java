import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrderScreen extends GameScreen {
	
	private customer randCust = new customer();
	String[] theOrder = randCust.printableString();
	private Image custImage = randCust.getImageString().getImage();
    public OrderScreen() {
    	
    }
    
//    public class CustomerLoader {
//
//        public static ArrayList<customer> loadCustomersFromFolder(String folderPath) {
//            ArrayList<customer> customers = new ArrayList<>();
//
//            File folder = new File(folderPath);
//            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png") || 
//                                                            name.toLowerCase().endsWith(".jpg") ||
//                                                            name.toLowerCase().endsWith(".jpeg"));
//
//            if (files != null) {
//                for (File file : files) {
//                    String fileName = file.getName();
//                    String name = fileName.substring(0, fileName.lastIndexOf(".")); // e.g., "tony.png" -> "tony"
//                    ImageIcon image = new ImageIcon(file.getPath());
//
//                    // Assign random position or use default ones
//                    int x = 900;
//                    int y = 500;
//
//                   // customer customer = new customer(name, x, y, image);
//                   //.add(customer);
//                }
//            }
//
//            return customers;
//        }

    @Override
    public void onShow() {
        sprites.clear();
        // Add sprites for this screen
        ImageIcon pollos = new ImageIcon("images/8-bit pollos.png");
    	Image pollosImage = pollos.getImage();
        sprites.add(new Sprite(0, 0, pollosImage));
        sprites.add(new Sprite(800,550,custImage));
        // After changing sprites, repaint so paintComponent is called
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g; // Cast Graphics to Graphics2D
        for (Sprite sprite : sprites) {
            sprite.draw(g2d); // Call the draw method of the sprite which handles scaling
        }
        g.setColor(Color.white);
        g.fillRect(620, 475, 380, 120);
        g.setColor(Color.black);
        Font theFont = new Font("Arial", Font.BOLD, 20);
        g.setFont(theFont);
        int width = 0;
        for(String it : theOrder) {
        	g.drawString(it, 630, 500+width);
        	width += 25;
        }
    }
}
