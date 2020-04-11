package entity;

import java.sql.Date;

public class Order {
    private int orderID;
    private int distributorID;
    private int publicationID;
    private int numberOfCopies;
    private java.sql.Date deliveryDate;
    private java.sql.Date orderDate;
    private int shippingCost;
    private int pricePerCopy;
    private int total;

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

    public int getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    public int getPricePerCopy() {return pricePerCopy; }

    public void setPricePerCopy(int pricePerCopy) {this.pricePerCopy = pricePerCopy; }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Order() {
    }

    public Order(int orderID, int distributorID, int publicationID, int numberOfCopies, Date deliveryDate, Date orderDate, int shippingCost, int pricePerCopy, int total) {
        this.orderID = orderID;
        this.distributorID = distributorID;
        this.publicationID = publicationID;
        this.numberOfCopies = numberOfCopies;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.shippingCost = shippingCost;
        this.pricePerCopy = pricePerCopy;
        this.total = total;
    }
}
