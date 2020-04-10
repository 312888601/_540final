package entity;

public class Revenue {
    private int orderID;
    private int distributorID;
    private int totalPayment;
    private String city;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDistributorID() {
        return distributorID;
    }

    public void setDistributorID(int distributorID) {
        this.distributorID = distributorID;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //constructor

    public Revenue() {
    }
}
