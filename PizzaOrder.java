/** Project: Lab 4 Pizza Order Web Services
 * Purpose Details: Main order object that holds all parts of a pizza order
 * Course: IST 242
 * Author: Kevin Agayby
 * Date Developed: 2025-06-12
 * Last Date Changed: 2025-06-16
 * Rev: 1
 */
import java.util.List;

public class PizzaOrder {
    private String orderId;
    private Customer customer;
    private List<OrderItem> orderItems;
    private Payment payment;
    private Delivery delivery;

    public PizzaOrder() {}

    public PizzaOrder(String orderId, Customer customer, List<OrderItem> orderItems, Payment payment, Delivery delivery) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderItems = orderItems;
        this.payment = payment;
        this.delivery = delivery;
    }

    // Getters and setters...

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public Delivery getDelivery() { return delivery; }
    public void setDelivery(Delivery delivery) { this.delivery = delivery; }
}
