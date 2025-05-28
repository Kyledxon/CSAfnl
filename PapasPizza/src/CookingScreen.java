import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CookingScreen extends GameScreen {

    public CookingScreen() {
    	
    }

    @Override
    public void onShow() {
        sprites.clear();
        ImageIcon table = new ImageIcon("images/baking.png");
    	Image tableImage = table.getImage();
    	sprites.add(new Sprite(-9, 40, tableImage, .5));
    }
}
