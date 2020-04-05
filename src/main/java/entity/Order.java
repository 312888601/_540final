package entity;

import java.sql.Date;

public class Order {
    private int orderID;
    private int distributorID;
    private int publicationID;
    private int number_of_copies;
    private java.sql.Date delivery_date;
    private java.sql.Date order_date;
    private double shippingCost;
    private boolean status;

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

    public int getNumber_of_copies() {
        return number_of_copies;
    }

    public void setNumber_of_copies(int number_of_copies) {
        this.number_of_copies = number_of_copies;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Order() {
    }

    public Order(int orderID, int distributorID, int publicationID, int number_of_copies, java.sql.Date delivery_date, java.sql.Date order_date, double shippingCost, double price_per_copy, boolean status) {
        this.orderID = orderID;
        this.distributorID = distributorID;
        this.publicationID = publicationID;
        this.number_of_copies = number_of_copies;
        this.delivery_date = delivery_date;
        this.order_date = order_date;
        this.shippingCost = shippingCost;
        this.status = status;
    }
}
