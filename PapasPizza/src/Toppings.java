import java.util.HashMap;

public abstract class Toppings {
	
	private HashMap<String, Integer> toppingsList = new HashMap<>();
	
	public Toppings() {
		toppingsList.put("pepperoni", 0);
		toppingsList.put("sausage", 0);
		toppingsList.put("mushroom", 0);
		toppingsList.put("pepper", 0);
		toppingsList.put("bacon", 0);
		toppingsList.put("olive", 0);
	}
	
	public HashMap<String, Integer> getList(){
		return toppingsList;
	}
	public void incList(String topping){
		toppingsList.put(topping, toppingsList.get(topping)+1);
	}
	public void resetList() {
		toppingsList.put("pepperoni", 0);
		toppingsList.put("sausage", 0);
		toppingsList.put("mushroom", 0);
		toppingsList.put("pepper", 0);
		toppingsList.put("bacon", 0);
		toppingsList.put("olive", 0);
	}
	public void printList() {
		toppingsList.forEach((key, value) -> System.out.println(key + " -> " + value));
	}
}
