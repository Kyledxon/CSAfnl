import java.util.HashMap;

public class Toppings {
	
	private HashMap<String, Integer> toppingsList = new HashMap<>();
	private HashMap<String, Integer> checkerList = new HashMap<>();
	public Toppings() {
		toppingsList.put("pepperoni", 0);
		toppingsList.put("mushroom", 0);
		toppingsList.put("onion", 0);
		toppingsList.put("pepper", 0);
		toppingsList.put("sausage", 0);
		toppingsList.put("bacon", 0);
		toppingsList.put("olive", 0);
		
		
		checkerList.put("pepperoni", customer.randTopAmt.get(0));
		checkerList.put("mushroom", customer.randTopAmt.get(1));
		checkerList.put("onion", customer.randTopAmt.get(2));
		checkerList.put("pepper", customer.randTopAmt.get(3));
		checkerList.put("sausage", customer.randTopAmt.get(4));
		checkerList.put("bacon", customer.randTopAmt.get(5));
		checkerList.put("olive", customer.randTopAmt.get(6));
	}
	
	public HashMap<String, Integer> getList(){
		return toppingsList;
	}
	public void incList(String topping){
		toppingsList.put(topping, toppingsList.get(topping)+1);
	}
	public void resetList() {
		toppingsList.put("pepperoni", 0);
		toppingsList.put("mushroom", 0);
		toppingsList.put("onion", 0);
		toppingsList.put("pepper", 0);
		toppingsList.put("sausage", 0);
		toppingsList.put("bacon", 0);
		toppingsList.put("olive", 0);
	}
	public void printList() {
		toppingsList.forEach((key, value) -> System.out.println(key + " -> " + value));
		System.out.println();
		checkerList.forEach((key, value) -> System.out.println(key + " -> " + value));
	}
}
