package entity;

public class Payment {
    private int orderID;
    private int totalPayment;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Payment(int orderID, int totalPayment){
        this.orderID = orderID;
        this.totalPayment = totalPayment;
    }
}
