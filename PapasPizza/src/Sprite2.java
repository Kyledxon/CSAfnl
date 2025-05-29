import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

public class Sprite2 {
    private int x;
    private int y;
    private Image image;
    private double scaleWidth = 1.0;
    private double scaleHeight = 1.0;
    private boolean visible = true; // Optional: control visibility if needed

    public Sprite2(int x, int y, Image image) {
        this(x, y, image, 1.0);
    }

    public Sprite2(int x, int y, Image image, double scale) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.scaleWidth = scale;
        this.scaleHeight = scale;
    }
   

    public void draw(Graphics2D g2d) {
        if (!visible) return; // skip if not visible
        if (scaleWidth != 1.0) {
            g2d.drawImage(image, x, y, (int)(image.getWidth(null) * scaleWidth), (int)(image.getHeight(null) * scaleWidth), null);
        } else {
            g2d.drawImage(image, x, y, null);
        }
    }
    
    public void setScale(double newScale) {
        this.scaleWidth = newScale;
        this.scaleHeight = newScale;
    }
    
    public boolean contains(int mouseX, int mouseY) {
        int scaledWidth = (int)(image.getWidth(null) * 0.5);
        int scaledHeight = (int)(image.getHeight(null) * 0.5);
        return mouseX >= x && mouseX <= x + scaledWidth &&
               mouseY >= y && mouseY <= y + scaledHeight;
    }
    
    
    

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public Image getImage() { return image; }

    public int getWidth() {
        return (int) (image.getWidth(null) * scaleWidth);
    }

    public int getHeight() {
        return (int) (image.getHeight(null) * scaleHeight);
    }


    // Centered drag support
    public void setPositionFromCenter(int centerX, int centerY) {
        this.x = centerX - getWidth() / 2;
        this.y = centerY - getHeight() / 2;
    }

    public void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    // Visibility (optional)
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    // Drawing
    

	public double getScale() {
		// TODO Auto-generated method stub
		return scaleWidth;
	}
}
