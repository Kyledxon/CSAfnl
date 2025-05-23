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

    // Collision check
    public boolean contains(int px, int py) {
        return px >= x && px <= x + getWidth() &&
               py >= y && py <= y + getHeight();
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
    public void draw(Graphics2D g2d) {
        if (!visible) return;

        AffineTransform tx = new AffineTransform();
        tx.translate(x, y);
        tx.scale(scaleWidth, scaleHeight);
        g2d.drawImage(image, tx, null);
    }
}