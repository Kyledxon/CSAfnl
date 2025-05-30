import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

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
    	
    	
    	 JFrame frame = new JFrame("Digital Clock");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(300, 100);
         frame.setLayout(new FlowLayout());

         // Create a label to display time
         JLabel timeLabel = new JLabel();
         timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
         frame.add(timeLabel);

         // Format for time
         SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

         // Create a timer that updates the label every second
         Timer timer = new Timer(1000, new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 String currentTime = timeFormat.format(new Date());
                 timeLabel.setText(currentTime);
             }
         });
         timer.start();

         // Show the window
         frame.setVisible(true);
    	
    }
}
