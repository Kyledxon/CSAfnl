import javax.swing.ImageIcon;

public class Sprite {
	private int x;
	private int y;
	private ImageIcon image;
	
	public Sprite(int x, int y, ImageIcon image) {
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
	public ImageIcon getImage() {
		return image;
	}
}
