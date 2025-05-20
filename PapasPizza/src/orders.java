
public class orders {
	
	private String toppings = "";
	private int bakeTime;
	private int cut1; 
	private int cut2;
	
	public orders(String toppings, int bakeTime, int cut1, int cut2) {
		this.toppings = toppings;
		this.bakeTime = bakeTime;
		this.cut1 = cut1;
		this.cut2 = cut2;
		
	}

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	public int getBakeTime() {
		return bakeTime;
	}

	public void setBakeTime(int bakeTime) {
		this.bakeTime = bakeTime;
	}

	public int getCut1() {
		return cut1;
	}

	public void setCut1(int cut1) {
		this.cut1 = cut1;
	}

	public int getCut2() {
		return cut2;
	}

	public void setCut2(int cut2) {
		this.cut2 = cut2;
	}

	@Override
	public String toString() {
		return "orders [toppings=" + toppings + ", bakeTime=" + bakeTime + ", cut1=" + cut1 + ", cut2=" + cut2 + "]";
	}
	
	
	
	//to push 

}
