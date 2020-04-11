package entity;

public class Written_by {
    private int StaffID;
    private String title;

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int staffID) {
        StaffID = staffID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Written_by(int staffID, String title) {
        StaffID = staffID;
        this.title = title;
    }
}
