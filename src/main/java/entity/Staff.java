package entity;

public class Staff {
    private int StaffID;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String emailAddress;
    private boolean isPublisher;
    private boolean isAdmin;
    private String address;

    //constructors
    public Staff() {
    }

    public Staff(int staffID, String name, int age, String gender, String phone, String emailAddress, boolean isPublisher, boolean isAdmin, String address) {
        StaffID = staffID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.emailAddress = emailAddress;
        this.isPublisher = isPublisher;
        this.isAdmin = isAdmin;
        this.address = address;
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int staffID) {
        StaffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isPublisher() {
        return isPublisher;
    }

    public void setPublisher(boolean publisher) {
        isPublisher = publisher;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
