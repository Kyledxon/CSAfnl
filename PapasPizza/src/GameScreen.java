import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public abstract class GameScreen extends JPanel {
	
	
	protected List<Sprite> sprites = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        for (Sprite sprite : sprites) {
            sprite.draw(g2d);
        }
    }

    // Each subclass can add sprites to this list as needed
    public abstract void onShow();
    public abstract void onHide();
}
