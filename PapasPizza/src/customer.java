import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class customer {
	public static List<String> selectedToppings;
	public static ArrayList<Integer> randTopAmt;
    private List<orders> orders;
    private String name;
    private int xPos;
    private int yPos;
    private ImageIcon image;
    private String[] peps = {"people/fring.png", "people/jesse.png","people/mike.png",
    		"people/random1.png","people/salamanca twins.png","people/saul.png","people/tio.png",
    		"people/tortuga.png","people/tuco.png","people/tucos henchmen.png","people/walt.png"};
    private int bakeTime;
    private int numCuts;
    
    public customer(int posX, int posY, String nm, ImageIcon im) {
        this.orders = new ArrayList<>();
        this.xPos = posX;
        this.yPos = posY;
        this.name = nm;
        this.image = im;
    }
    
    public customer() {
    	int randLoc = (int) (Math.random()*peps.length);
        this.orders = new ArrayList<>();
        this.image = new ImageIcon(peps[randLoc]);
        String name = peps[randLoc];
        this.name = name.substring(name.lastIndexOf("/")+1,name.lastIndexOf("."));
        this.xPos = 0;
        this.yPos = 0;
    }
    
    public static ArrayList<Integer> generateRan(){
    	randTopAmt = new ArrayList<>();
    	for(int i =0; i < 6; i ++) {
    		randTopAmt.add((int) (Math.random()*4)+1);
    	}
    	return randTopAmt;
    }

    public String placeOrder() {
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
        return newOrder.toString();
        //System.out.println(name + " placed an order: " + newOrder);
    }

    private orders generateRandomOrder() {
    	randTopAmt = generateRan();
        List<String> possibleToppings = Arrays.asList(
        		randTopAmt.get(0)+" Pepperonis", 
        		randTopAmt.get(1)+" Mushrooms",
        		randTopAmt.get(2)+" Onions",
        		randTopAmt.get(3)+" Peppers",
        		randTopAmt.get(4)+" Bacons",
        		randTopAmt.get(5)+" Olives");
        Random rand = new Random();

        // Pick 2–4 random toppings
        int toppingCount = 2 + rand.nextInt(3); // 2 to 4 toppings
        selectedToppings = new ArrayList<>();
        while (selectedToppings.size() < toppingCount) {
            String topping = possibleToppings.get(rand.nextInt(possibleToppings.size()));
            if (!selectedToppings.contains(topping)) {
                selectedToppings.add(topping);
            }
        }

        bakeTime = 10 + rand.nextInt(11); // 10 to 20 seconds
        numCuts = (rand.nextInt(2) + 1) * 2; // 2 or 4 slices 

        return new orders(selectedToppings, bakeTime, numCuts);
    }
    
    public String[] printableString() {
    	String theString = this.placeOrder();
    	String[] lines = theString.split("\n");
    		
    	return lines;
    }
   
    public int getBakeTime() {
		return bakeTime;
	}

	public int getNumCuts() {
		return numCuts;
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
    
    public ImageIcon getImageString() {
    	return image;
    }
    
    public static void main(String[] args) {
		customer newCust = new customer();
		System.out.println(newCust.placeOrder());
		for(String it: newCust.printableString()) {
			System.out.println(it);
		}
		System.out.println(newCust.printableString());
	}
}
