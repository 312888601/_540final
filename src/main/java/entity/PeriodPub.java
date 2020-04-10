package entity;
import java.sql.Date;

public class PeriodPub {
    private int ID;
    private Date date;
    private String Periodicity;
    private String textOfArticle;

    public PeriodPub(int ID, Date date, String Periodicity, String textOfArticle) {
        this.ID = ID;
        this.date = date;
        this.Periodicity = Periodicity;
        this.textOfArticle = textOfArticle;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPeriodicity() {
        return Periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.Periodicity = periodicity;
    }

    public String getTextOfArticle() {
        return textOfArticle;
    }

    public void setTextOfArticle(String textOfArticle) {
        this.textOfArticle = textOfArticle;
    }
}
