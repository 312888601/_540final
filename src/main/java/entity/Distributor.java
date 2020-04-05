package entity;

public class Distributor {
    private int distributorID;
    private String name;
    private double balance;
    private String city;
    private String street_address;
    private String type;
    private String contact_person;
    private String phone_number;

    public Distributor() {
    }

    public Distributor(int distributorID, String name, double balance, String city, String street_address, String type, String contact_person, String phone_number) {
        this.distributorID = distributorID;
        this.name = name;
        this.balance = balance;
        this.city = city;
        this.street_address = street_address;
        this.type = type;
        this.contact_person = contact_person;
        this.phone_number = phone_number;
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

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
