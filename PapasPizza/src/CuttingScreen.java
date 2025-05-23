import java.awt.Color;
import javax.swing.JLabel;

public class CuttingScreen extends GameScreen {

    public CuttingScreen() {
        setBackground(Color.ORANGE);
        add(new JLabel("Order Screen - Put order UI here"));
        // Add your buttons, images, etc.
    }

    @Override
    public void onShow() {
        // This will be called every time the screen is shown
        System.out.println("OrderScreen is now visible");
        // You can refresh data, reset state, etc.
    }
}
