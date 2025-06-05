import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class CookingScreen extends GameScreen {
	private Timer stopwatchTimer;
	private long elapsedMillis = 0;     // Tracks total elapsed time
	private long lastStartTime = 0;     // Time when the stopwatch last resumed
	private int seconds = 0;
	private JLabel timeLabel = new JLabel(); // Label reused across screen shows
	private customer cust = OrderScreen.getRandCust();
	
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
    	
    	// Setup and position label
        timeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        timeLabel.setForeground(Color.WHITE);
        add(timeLabel);

        // Start/resume stopwatch
        lastStartTime = System.currentTimeMillis();

        if (stopwatchTimer == null) {
            stopwatchTimer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    long totalTime = elapsedMillis + (System.currentTimeMillis() - lastStartTime);
                    seconds = (int) (totalTime / 1000) % 60;
                    timeLabel.setText(String.format("Time: %02d", seconds));
                }
            });
        }
        stopwatchTimer.start();

        repaint();
    	
    }
    public void onHide() {
        if (stopwatchTimer != null) {
            stopwatchTimer.stop();
            elapsedMillis += System.currentTimeMillis() - lastStartTime;
        }
    }
    
    public int getScore() {
    	return 100-5*(Math.abs(cust.getBakeTime()-seconds));
    }
}
