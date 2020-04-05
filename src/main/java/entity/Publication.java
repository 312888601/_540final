package entity;

public class Publication {
    private int ID;
    private String topic;
    private String title;
    private int staffID;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public Publication(int ID, String topic, String title, int staffID, double price) {
        this.ID = ID;
        this.topic = topic;
        this.title = title;
        this.staffID = staffID;
        this.price = price;
    }
}
