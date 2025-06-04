import java.util.HashMap;
import java.util.List;

public class Toppings {
	
	private HashMap<String, Integer> toppingsList = new HashMap<>();
	private HashMap<String, Integer> checkerList = new HashMap<>();
	private customer theCust = OrderScreen.getRandCust();
	public Toppings() {
		toppingsList.put("pepperoni", 0);
		toppingsList.put("mushroom", 0);
		toppingsList.put("onion", 0);
		toppingsList.put("pepper", 0);
		toppingsList.put("bacon", 0);
		toppingsList.put("olive", 0);
		
		
		checkerList.put("pepperoni", theCust.randTopAmt.get(0));
		checkerList.put("mushroom", theCust.randTopAmt.get(1));
		checkerList.put("onion", theCust.randTopAmt.get(2));
		checkerList.put("pepper", theCust.randTopAmt.get(3));
		checkerList.put("bacon", theCust.randTopAmt.get(4));
		checkerList.put("olive", theCust.randTopAmt.get(5));
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
		toppingsList.put("bacon", 0);
		toppingsList.put("olive", 0);
	}
	public void printList() {
		toppingsList.forEach((key, value) -> System.out.println(key + " -> " + value));
		System.out.println();
		checkerList.forEach((key, value) -> System.out.println(key + " -> " + value));
	}
	
}
