import java.util.ArrayList;

public class line {
	ArrayList<customer> theLine;
	
	
	public line() {
		theLine = new ArrayList<>();
	}
	
	public void addToLine(customer Customer) {
		theLine.add(Customer);
	}
	
	public ArrayList<customer> getTheLine() {
		return theLine;
	}
	
	public void initLinePos() {
		int x = 800;
		int y = 600;
		
		for(customer Customer : theLine) {
			Customer.setxPos(x);
			Customer.setxPos(y);
			
			x -= 200;
			y-= 100;
		}
	}
	
	//We need to implement this into the game class in order to allow the line to be created and 
	//to paint everything inside "theLine"
	
	//I think that the initLinePos() method works to push each customer behind the other but we
	//just need to paint each one now.
	
	
	
}
