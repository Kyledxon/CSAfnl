import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrderScreen extends GameScreen {
	private static customer randCust= new customer();
	String[] theOrder = randCust.printableString();
	private Image custImage = randCust.getImageString().getImage();
	private JLabel moneyText = new JLabel();
	
    public OrderScreen() {
    	
    }
    public static customer getRandCust() {
    	return randCust;
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
        if (Game.start == 1) {
            // When start changes to 1, reset customer and sprite
            randCust = new customer();
            custImage = randCust.getImageString().getImage();
            theOrder = randCust.printableString();
            Game.start = 0;  // Reset to 0 after updating
        }
        
        sprites.add(new Sprite(800, 550, custImage));
        // After changing sprites, repaint so paintComponent is called
        
        setLayout(null);
        moneyText.setFont(new Font("Arial", Font.BOLD, 100));
        moneyText.setForeground(Color.WHITE);
        moneyText.setBounds(50, 10, 500, 100);
        moneyText.setText(String.valueOf(Game.money));
        add(moneyText);
        
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        for (Sprite sprite : sprites) {
            sprite.draw(g2d);
        }

        g.setColor(Color.white);
        g.fillRect(620, 475, 380, 120); // box dimensions

        g.setColor(Color.black);
        Font theFont = new Font("Arial", Font.BOLD, 20);
        g.setFont(theFont);

        FontMetrics fm = g.getFontMetrics();
        int lineHeight = fm.getHeight();
        int maxWidth = 360; // Max width for text inside the box (380 - 20 padding)

        int x = 630;
        int y = 500;

        for (String line : theOrder) {
            String[] words = line.split(" ");
            StringBuilder currentLine = new StringBuilder();

            for (String word : words) {
                String testLine = currentLine + word + " ";
                int testWidth = fm.stringWidth(testLine);
                if (testWidth > maxWidth) {
                    g.drawString(currentLine.toString(), x, y);
                    y += lineHeight;
                    currentLine = new StringBuilder(word + " ");
                } else {
                    currentLine.append(word).append(" ");
                }
            }

            // Draw any remaining words in the line
            g.drawString(currentLine.toString(), x, y);
            y += lineHeight;
        }
    }
	@Override
	public void onHide() {
		// TODO Auto-generated method stub
		
	}  
}
