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

    public int getBakeTime() {
        return bakeTime;
    }

    public int getCuts() {
        return numCuts;
    }

    @Override
    public String toString() {
    	return "I would like a pizza with "+toppings+" baked for "+bakeTime + "s"+ ", and with "+numCuts+" cuts please!";
    	/*
        return "Toppings: " + toppings +
               ", Bake Time: " + bakeTime + "s" +
               ", Cuts: " + numCuts;
               */
    }
} //hey
