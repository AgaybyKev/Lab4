public class Payment {
    private String method;
    private String cardLast4;
    private double totalAmount;
    public Payment() {}
    public Payment(String method, String cardLast4, double totalAmount) {
        this.method = method;
        this.cardLast4 = cardLast4;
        this.totalAmount = totalAmount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCardLast4() {
        return cardLast4;
    }

    public void setCardLast4(String cardLast4) {
        this.cardLast4 = cardLast4;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
