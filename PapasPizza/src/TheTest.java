import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TheTest extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;
    private JPanel buttonPanel;

    public TheTest() {
        setTitle("Transparency Test");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set the content pane to the background image panel
        setContentPane(new BackgroundPane());

        // Card layout panel, transparent to show background image
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        cards.setOpaque(false); // Transparent so background image shows

        // Create colored panels with semi-transparent backgrounds
        JPanel redPanel = new JPanel();
        redPanel.setOpaque(false);
        redPanel.setBackground(Color.red); // 50% transparent red

        JPanel greenPanel = new JPanel();
        greenPanel.setOpaque(false);
        greenPanel.setBackground(new Color(0, 255, 0, 128)); // 50% transparent green

        JPanel bluePanel = new JPanel();
        bluePanel.setOpaque(false);
        bluePanel.setBackground(new Color(0, 0, 255, 128)); // 50% transparent blue

        cards.add(redPanel, "Red");
        cards.add(greenPanel, "Green");
        cards.add(bluePanel, "Blue");

        // Transparent button panel (no background color)
        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));

        // Buttons to switch cards
        JButton redBtn = new JButton("Red");
        JButton greenBtn = new JButton("Green");
        JButton blueBtn = new JButton("Blue");

        redBtn.addActionListener((ActionEvent e) -> cardLayout.show(cards, "Red"));
        greenBtn.addActionListener((ActionEvent e) -> cardLayout.show(cards, "Green"));
        blueBtn.addActionListener((ActionEvent e) -> cardLayout.show(cards, "Blue"));

        buttonPanel.add(redBtn);
        buttonPanel.add(greenBtn);
        buttonPanel.add(blueBtn);

        // Layout setup on content pane (BackgroundPane)
        setLayout(new BorderLayout());
        add(cards, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Custom JPanel that paints a background image
    private static class BackgroundPane extends JPanel {
        private Image bg;

        public BackgroundPane() {
            try {
                bg = new ImageIcon("images/background.png").getImage(); // Make sure this path is correct!
            } catch (Exception e) {
                bg = null;
                System.err.println("Background image not found!");
            }
            setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TheTest::new);
    }
}
