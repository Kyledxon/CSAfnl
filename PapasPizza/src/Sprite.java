import java.awt.Image;

import javax.swing.ImageIcon;

public class Sprite {
	private int x;
	private int y;
	private Image image;
	
	public Sprite(int x, int y, Image image) {
		this.x = x;
		this.y = y;
		this.image = image;
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
}
