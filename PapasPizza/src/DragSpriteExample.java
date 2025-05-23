import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class DragSpriteExample extends JPanel implements MouseListener, MouseMotionListener {

    class Sprite {
        BufferedImage originalImage;
        Image scaledImage;
        int x, y; // Center position
        int width, height;
        boolean placed = false;
        boolean placed1 = true;

        public Sprite(String imagePath, int x, int y, int scaleWidth, int scaleHeight) {
            try {
                originalImage = ImageIO.read(new File(imagePath));
                scaledImage = originalImage.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);
                this.width = scaleWidth;
                this.height = scaleHeight;
                this.x = x;
                this.y = y;
            } catch (IOException e) {
                System.err.println("Could not load image: " + imagePath);
            }
        }
    }

    private final ArrayList<Sprite> sprites = new ArrayList<>();
    private Sprite draggingSprite = null;
    private int dragX, dragY;
    private final int pickupRadius = 80; // Increased pickup size

    public DragSpriteExample() {
    	sprites.add(new Sprite("images/mushroom.png", 100, 100, 80, 80));
        sprites.add(new Sprite("images/pepper.png", 250, 150, 80, 80));
        sprites.add(new Sprite("images/bacon.png", 400, 200, 80, 80));

        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw pickup targets
        g.setColor(Color.RED);
        for (Sprite s : sprites) {
        	if(s.placed1 && s != draggingSprite && s.scaledImage != null) {
        		g.fillOval(s.x - pickupRadius / 2, s.y - pickupRadius / 2, pickupRadius, pickupRadius);
        	}
            
        }

        // Draw placed sprites (skip the one currently being dragged)
        for (Sprite s : sprites) {
            if (s.placed && s != draggingSprite && s.scaledImage != null) {
                g.drawImage(s.scaledImage, s.x - s.width / 2, s.y - s.height / 2, null);
            }
        }

        // Draw dragged sprite under the mouse
        if (draggingSprite != null && draggingSprite.scaledImage != null) {
            g.drawImage(draggingSprite.scaledImage, dragX - draggingSprite.width / 2, dragY - draggingSprite.height / 2, null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Sprite s : sprites) {
            int dx = e.getX() - s.x;
            int dy = e.getY() - s.y;
            if (Math.sqrt(dx * dx + dy * dy) <= pickupRadius / 2.0) {
                draggingSprite = s;
                dragX = e.getX();
                dragY = e.getY();
                repaint();
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggingSprite != null) {
            draggingSprite.x = e.getX();
            draggingSprite.y = e.getY();
            draggingSprite.placed = true;
            draggingSprite.placed1 = false;
            draggingSprite = null;
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (draggingSprite != null) {
            dragX = e.getX();
            dragY = e.getY();
            repaint();
        }
    }

    // Unused events
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e ){}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("DragSpriteExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DragSpriteExample());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}