import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
public class Game extends JFrame implements MouseListener, ActionListener, KeyListener{
	
	public static int start = 0;
	
	
	JFrame frame;
	private CardLayout cardLayout;
	private JPanel cards; // The container for the screens
	private int width 	= 1020;
	private int height 	= 1120;
	private OrderScreen orderScreen = new OrderScreen();
	public static ToppingScreen toppingsScreen = new ToppingScreen();
	private CookingScreen cookingScreen;
	private CuttingScreen cuttingScreen;
	private GameScreen currentScreen;
	public static int money = 0;
	
	
	ArrayList<customer> Customers = new ArrayList<customer>();
	SimpleAudioPlayer backgroundMusic = new SimpleAudioPlayer("negroyazul.wav", true);
	
	
	
	
	public static void main(String[] args) {
		// Create an instance of the board
		new Game();
		//SwingUtilities.invokeLater(DraggableFrame::new);
	}
	public Game() {
	
		frame = new JFrame("Los Pollos Hermanos");
		cardLayout = new CardLayout();
		cards = new JPanel(cardLayout);
		
		
	  
		orderScreen = new OrderScreen();
	   toppingsScreen = new ToppingScreen();
	   cookingScreen = new CookingScreen();
	   cuttingScreen = new CuttingScreen(cardLayout, cards, orderScreen, this); // new
	   // Add the screens to the container with names
	   cards.add(orderScreen, "Order Screen");
	   cards.add(toppingsScreen, "Toppings Screen");
	   cards.add(cookingScreen, "Cooking Screen");
	   cards.add(cuttingScreen, "Cutting Screen");
	   // Setup the JFrame
	   frame.setUndecorated(false);
	   frame.setSize(width, height);
	   frame.add(cards);
	   // Add buttons to switch screens
	  
	   JPanel buttonPanel = new JPanel();
	   ImageIcon button1Icon = createCircularIcon("images/ordericon.png");
	   ImageIcon button2Icon = createCircularIcon("images/toppings icon.png");
	   ImageIcon button3Icon = createCircularIcon("images/cooking icon.png");
	   ImageIcon button4Icon = createCircularIcon("images/new cutter.png");
	  
	   JButton button1 = new JButton();
	   button1.addActionListener(e -> {
	   	if (currentScreen != null) currentScreen.onHide();
	   	cardLayout.show(cards, "Order Screen");
	       orderScreen.onShow();
	       currentScreen = orderScreen;
	   });
	   JButton button2 = new JButton();
	   button2.addActionListener(e -> {
	   	if (currentScreen != null) currentScreen.onHide();
	   	cardLayout.show(cards, "Toppings Screen");
	       toppingsScreen.onShow();
	       currentScreen = toppingsScreen;
	   });
	   JButton button3 = new JButton();
	   button3.addActionListener(e -> {
	   	if (currentScreen != null) currentScreen.onHide();
	   	cardLayout.show(cards, "Cooking Screen");
	       cookingScreen.onShow();
	       currentScreen = cookingScreen;
	   });
	   JButton button4 = new JButton();
	   button4.addActionListener(e -> {
	   	if (currentScreen != null) currentScreen.onHide();
	   	cardLayout.show(cards, "Cutting Screen");
	       cuttingScreen.onShow();
	       currentScreen = cuttingScreen;
	   });
	  
	   //Start on order screen
	   orderScreen.onShow();
	   buttonPanel.add(button1);
	   buttonPanel.add(button2);
	   buttonPanel.add(button3);
	   buttonPanel.add(button4);
	   add(buttonPanel, BorderLayout.SOUTH);
	   // Create the buttons and set the icons
	   button1.setIcon(button1Icon);
	   button1.setBorderPainted(false);
	   button1.setContentAreaFilled(false);
	   button1.setFocusPainted(false);
	   button1.addActionListener(e -> cardLayout.show(cards, "Order Screen"));
	  
	   button2.setIcon(button2Icon);
	   button2.setBorderPainted(false);
	   button2.setContentAreaFilled(false);
	   button2.setFocusPainted(false);
	   button2.addActionListener(e -> cardLayout.show(cards, "Toppings Screen"));
	  
	   button3.setIcon(button3Icon);
	   button3.setBorderPainted(false);
       button3.setContentAreaFilled(false);
       button3.setFocusPainted(false);
       button3.addActionListener(e -> cardLayout.show(cards, "Cooking Screen"));
      
       button4.setIcon(button4Icon);
       button4.setBorderPainted(false);
       button4.setContentAreaFilled(false);
       button4.setFocusPainted(false);
       button4.addActionListener(e -> cardLayout.show(cards, "Cutting Screen"));
       // Add buttons to the panel
       buttonPanel.add(button1);
       buttonPanel.add(button2);
       buttonPanel.add(button3);
       buttonPanel.add(button4);
      
       frame.add(buttonPanel, BorderLayout.SOUTH);
       addMenus();
       // Show the frame
       frame.setVisible(true);
      
	}
	
	public int getScore() {
		int score = (Toppings.getTheScore() + cookingScreen.getScore() + cuttingScreen.getScore()) / 3;
		System.out.println(Toppings.getTheScore());
		System.out.println(cookingScreen.getScore());
		System.out.println(cuttingScreen.getScore());
		money += score*10;
		return score;
	}
	
	private ImageIcon createCircularIcon(String imagePath) {
       ImageIcon icon = new ImageIcon(imagePath);
       Image image = icon.getImage(); // Get the image from the icon
       Image circularImage = createCircularImage(image);
       return new ImageIcon(circularImage); // Return a new circular ImageIcon
   }
	
	private Image createCircularImage(Image originalImage) {
       int width = originalImage.getWidth(null);
       int height = originalImage.getHeight(null);
       int diameter = Math.min(width, height);
       // Create a circular image
       Image circularImage = originalImage.getScaledInstance(diameter, diameter, Image.SCALE_SMOOTH);
       return circularImage;
   }
	
	
	public void addMenus() {
		//Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		
		//Create the menu bar.
		menuBar = new JMenuBar();
		//Build the first menu.
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);
		menuItem = new JMenuItem("Quit", new ImageIcon("images/middle.gif"));
		menuItem.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Define an array of custom options for the dialog
		        Object[] options = { "Yes", "Cancel" };
		        // Display an option dialog with custom options
		        // The user's choice is stored in the 'choice'
		        // variable
		        int choice = JOptionPane.showOptionDialog(
		            null, // Parent component (null means center on screen)
		            "Do you want to proceed?", // Message to display
		            "Quit the Game", // Dialog title
		            JOptionPane.YES_NO_CANCEL_OPTION, // Option type (Yes, No, Cancel)
		            JOptionPane.QUESTION_MESSAGE, // Message type (question icon)
		            null, // Custom icon (null means no custom icon)
		            options, // Custom options array
		            options[1] // Initial selection (default is "Cancel")
		        );
		        // Check the user's choice and display a
		        // corresponding message
		        if (choice == JOptionPane.YES_OPTION) {
		            // If the user chose 'Yes'
		            // show a message indicating that they are
		            // proceeding
		            System.exit(0);
		        }
		        else {
		            // If the user chose 'Cancel' or closed the
		            // dialog
		            // show a message indicating the operation is
		            // canceled
		            JOptionPane.showMessageDialog(null, "Operation canceled.");
		        }
			}	
		});
		menu.add(menuItem);
		frame.setJMenuBar(menuBar);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
