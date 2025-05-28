import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class customer {

    private List<orders> orders;
    private String name;
    private int xPos;
    private int yPos;
    private ImageIcon image;

    public customer(int posX, int posY, String nm, ImageIcon im) {
        this.orders = new ArrayList<>();
        this.xPos = posX;
        this.yPos = posY;
        this.name = nm;
        this.image = im;
    }
// hey 
    public orders placeOrder() {
        // Simulate customer walking to counter
    	
        while (yPos < 600) {
            yPos++;
        }
        while (xPos > 800) {
            xPos--;
        }

        // Generate random order
        orders newOrder = generateRandomOrder();
        orders.add(newOrder);

        System.out.println(name + " placed an order: " + newOrder);
        return newOrder;
    }

    private orders generateRandomOrder() {
        List<String> possibleToppings = Arrays.asList("Pepperoni", "Mushrooms", "Onions", "Peppers", "Sausage", "Bacon", "Olives");
        Random rand = new Random();

        // Pick 2–4 random toppings
        int toppingCount = 2 + rand.nextInt(3); // 2 to 4 toppings
        List<String> selectedToppings = new ArrayList<>();
        while (selectedToppings.size() < toppingCount) {
            String topping = possibleToppings.get(rand.nextInt(possibleToppings.size()));
            if (!selectedToppings.contains(topping)) {
                selectedToppings.add(topping);
            }
        }

        int bakeTime = 10 + rand.nextInt(11); // 10 to 20 seconds
        int numCuts = (rand.nextInt(3) + 1) * 2; // 2, 4, or 6 cuts

        return new orders(selectedToppings, bakeTime, numCuts);
    }

    public String getName() {
        return name;
    }

    public List<orders> getOrders() {
        return orders;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setName(String name) {
        this.name = name;
    }
}
