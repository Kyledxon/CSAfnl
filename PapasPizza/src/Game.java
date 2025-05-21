import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

public class Game extends JFrame implements MouseListener, ActionListener{
	
	JFrame frame;
	private CardLayout cardLayout;
    private JPanel cards; // The container for the screens
	private int width 	= 1020;
	private int height 	= 1040;

	public static void main(String[] args) {
		// Create an instance of the board
		new Game();

	}

	public Game() {
		
		frame = new JFrame("Los Pollos Hermanos");
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Create the panels (screens) with different sprite sets
        DrawPane orderScreen = new DrawPane("Order Screen");
        DrawPane toppingsScreen = new DrawPane("Toppings Screen");
        DrawPane cookingScreen = new DrawPane("Cooking Screen");
        DrawPane cuttingScreen = new DrawPane("Cutting Screen");

        // Add the screens to the container with names
        cards.add(orderScreen, "Order Screen");
        cards.add(toppingsScreen, "Toppings Screen");
        cards.add(cookingScreen, "Cooking Screen");
        cards.add(cuttingScreen, "Cutting Screen");

        // Setup the JFrame
        frame.setUndecorated(true);
        frame.setSize(width, height);
        frame.add(cards);

        // Add buttons to switch screens
        JPanel buttonPanel = new JPanel();
        JButton button1 = new JButton("Order Screen");
        JButton button2 = new JButton("Toppings Screen");
        JButton button3 = new JButton("Cooking Screen");
        JButton button4 = new JButton("Cutting Screen");
        
        button1.addActionListener(e -> cardLayout.show(cards, "Order Screen"));
        button2.addActionListener(e -> cardLayout.show(cards, "Toppings Screen"));
        button3.addActionListener(e -> cardLayout.show(cards, "Cooking Screen"));
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
}