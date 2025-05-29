import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
        sprites.clear();
        ImageIcon bg = new ImageIcon("images/newbg.png");
    	Image bgImage = bg.getImage();
    	sprites.add(new Sprite(0,0,bgImage, 1.0));
        ImageIcon table = new ImageIcon("images/baking.png");
    	Image tableImage = table.getImage();
    	sprites.add(new Sprite(20, 60, tableImage, .65));
    	
    	
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
