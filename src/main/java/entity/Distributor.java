package entity;

public class Distributor {
    private int distributorID;
    private String name;
    private double balance;
    private String city;
    private String streetAddress;
    private String type;
    private String contactPerson;
    private String phoneNumber;

    public Distributor() {
    }

    public Distributor(int distributorID, String name, double balance, String city, String streetAddress, String type, String contactPerson, String phoneNumber) {
        this.distributorID = distributorID;
        this.name = name;
        this.balance = balance;
        this.city = city;
        this.streetAddress = streetAddress;
        this.type = type;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
    }

    public int getDistributorID() {
        return distributorID;
    }

    public void setDistributorID(int distributorID) {
        this.distributorID = distributorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
