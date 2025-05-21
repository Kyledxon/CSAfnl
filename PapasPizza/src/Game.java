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

        // Add the screens to the container with names
        cards.add(orderScreen, "Order Screen");
        cards.add(toppingsScreen, "Toppings Screen");

        // Setup the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.add(cards);

        // Add a button to switch screens
        JPanel buttonPanel = new JPanel();
        JButton switchButton = new JButton("Switch Screen");
        buttonPanel.add(switchButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listener to switch screens when button is pressed
        switchButton.addActionListener(new ActionListener() {
            private boolean isScreen1 = true; // Track which screen we're on

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isScreen1) {
                    cardLayout.show(cards, "Toppings Screen"); // Switch to Screen 2
                } else {
                    cardLayout.show(cards, "Order Screen"); // Switch to Screen 1
                }
                isScreen1 = !isScreen1; // Toggle the screen tracker
            }
        });

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