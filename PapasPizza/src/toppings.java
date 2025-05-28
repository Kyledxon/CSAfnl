import java.util.HashMap;

public abstract class toppings {
	private String name;
	private int num;
	private HashMap<String, String> images = new HashMap<>();
	{
	    images.put("pepperoni", "images/pepperoni.png");
	    images.put("sausage", "images/sausage.png");
	    images.put("mushroom", "images/mushroom.png");
	    images.put("pepper", "images/pepper.png");
	    images.put("bacon", "images/bacon.png");
	    images.put("olive", "images/olive.png");
	}
	public toppings(String nm, int n) {
		name = nm;
		num = n;
	}
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
	
}
