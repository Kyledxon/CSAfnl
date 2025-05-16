import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private BufferedImage image;
	
	public ImagePanel(String png) {
		try {
			image = ImageIO.read(new File(png));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	protected void paintImage(Graphics g) {
		super.paintComponent(g);
		if(image != null) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("sprite");
		ImagePanel panel = new ImagePanel("images/mike.png");
		frame.setContentPane(panel);
		
	}

}
