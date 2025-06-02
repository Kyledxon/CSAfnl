import java.util.List;

public class orders {
    private List<String> toppings;
    private int bakeTime; // in seconds
    private int numCuts;     // number of slices

    public orders(List<String> toppings, int bakeTime, int cuts) {
        this.toppings = toppings;
        this.bakeTime = bakeTime;
        this.numCuts = cuts;
    }

    // Getters
    public List<String> getToppings() {
        return toppings;
    }
    
    public String getStringToppings() {
    	String result = String.join(", ", toppings);
        return result;
    }

    public int getBakeTime() {
        return bakeTime;
    }

    public int getCuts() {
        return numCuts;
    }

    @Override
    public String toString() {
    	String line1 = "I would like a pizza with ";
    	String line2 = ""+this.getStringToppings();
    	String line3 = "baked for "+bakeTime + "s";
    	String line4 = "and with "+numCuts+" slices please!";
    	
    	return line1 +"\n"+ line2+"\n"+ line3+"\n"+line4;
    	
    	/*
        return "Toppings: " + toppings +
               ", Bake Time: " + bakeTime + "s" +
               ", Cuts: " + numCuts;
               */
    }
} //hey
