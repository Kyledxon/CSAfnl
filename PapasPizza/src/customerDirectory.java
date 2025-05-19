import java.util.HashMap;
public class customerDirectory {
	HashMap <String,  customer> customerMap;
	
	public customerDirectory() {
		customerMap = new HashMap<>();
	}
	
	public void addCustomer(customer Customer) {
		customerMap.put(Customer.getName(), Customer);
	}
}
