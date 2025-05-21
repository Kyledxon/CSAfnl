import java.util.List;

public class orders {
    private List<String> toppings;
    private int bakeTime; // in seconds
    private int cuts;     // number of slices

    public orders(List<String> toppings, int bakeTime, int cuts) {
        this.toppings = toppings;
        this.bakeTime = bakeTime;
        this.cuts = cuts;
    }

    // Getters
    public List<String> getToppings() {
        return toppings;
    }

    public int getBakeTime() {
        return bakeTime;
    }

    public int getCuts() {
        return cuts;
    }

    @Override
    public String toString() {
        return "Toppings: " + toppings +
               ", Bake Time: " + bakeTime + "s" +
               ", Cuts: " + cuts;
    }
}
