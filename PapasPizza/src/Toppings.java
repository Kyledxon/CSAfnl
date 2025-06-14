import java.util.HashMap;
import java.util.List;

public class Toppings {
	private int correctUnits;
	private int penaltyUnits;
	private int totalRequiredUnits;
	private static int score;
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
		System.out.println(checkList());
	}
	public static int getTheScore() {
		return score;
	}
	//
	public int checkList() {
	    HashMap<String, Integer> requiredMap = new HashMap<>();
	    for (String name : theCust.selectedToppings) {
	        String[] parts = name.split(" ", 2);
	        int quantity = Integer.parseInt(parts[0]);
	        String topping = parts[1].toLowerCase();

	        if (topping.endsWith("s")) {
	            topping = topping.substring(0, topping.length() - 1);
	        }

	        requiredMap.put(topping, quantity);
	    }
//
	    correctUnits = 0;
	    penaltyUnits = 0;
	    totalRequiredUnits = 0;

	    // Count correct and penalty units
	    for (String topping : requiredMap.keySet()) {
	        int requiredQty = requiredMap.get(topping);
	        int placedQty = toppingsList.getOrDefault(topping, 0);

	        totalRequiredUnits += requiredQty;

	        if (placedQty <= requiredQty) {
	            correctUnits += placedQty;
	        } else {
	            correctUnits += requiredQty;
	            penaltyUnits += (placedQty - requiredQty); // Extra units
	        }
	    }

	    for (String placedTop : toppingsList.keySet()) {
	        if (!requiredMap.containsKey(placedTop)) {
	            penaltyUnits += toppingsList.get(placedTop); // All units are extra
	        }
	    }

	    if (totalRequiredUnits == 0) {
	    	return 0;
	    }
	    score = (int)(100.0 * correctUnits / totalRequiredUnits) - 10*penaltyUnits;
	    if (score < 0) {
	    	return 0;
	    }
	    if (score > 100) {
	    	return 100;
	    }
	    return score;
	}
}
