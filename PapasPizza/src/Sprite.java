import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

public class Sprite {
	private int x;
	private int y;
	private Image image;
	private AffineTransform tx;
	double scaleWidth = 1.0;		//change to scale image
	double scaleHeight = 1.0; 
	
	public Sprite(int x, int y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}
	
	public Sprite(int x, int y, Image image, double scale) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Image getImage() {
		return image;
	}
	public void draw(Graphics2D g2d) {
        // Create an AffineTransform to scale the image
        AffineTransform tx = new AffineTransform();
        tx.translate(x, y); // Move the image to the position
        tx.scale(scaleWidth, scaleHeight); // Scale the image
        // Draw the image with the scaling transformation applied
        g2d.drawImage(image, tx, null);
    }
	
}
