import java.util.List;

public class OrderItem {
    private String itemType;
    private String size;
    private String crust;
    private List<String> toppings;
    private int quantity;

    // ✅ REQUIRED for Jackson
    public OrderItem() {}

    public OrderItem(String itemType, String size, String crust, List<String> toppings, int quantity) {
        this.itemType = itemType;
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
        this.quantity = quantity;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}