import java.util.ArrayList;

public class customer {
    
    private ArrayList<String> ordered;
    private String order;
    private String name;
    private int xPos;
    private int yPos;
    
    public customer(int posX, int posY, String nm, String ord) {
        this.ordered = new ArrayList<>();
        this.xPos = posX;
        this.yPos = posY;
        this.name = nm;
        this.order = ord;
        addOrder();  // Add initial order to the list
    }
    
    public void ordering() {
        // Simulate customer walking to counter
        while (yPos < 600) {
            yPos++;
        }
        while (xPos > 800) {
            xPos--;
        }
        
        // At counter: maybe trigger order UI, or mark them ready to give an order
        System.out.println(name + " has placed an order: " + order);
    }
    
    private void addOrder() {
        ordered.add(order);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
        addOrder(); // update order list
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public ArrayList<String> getOrderedList() {
        return ordered;
    }
}
