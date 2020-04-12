package entity;
import java.sql.Date;

public class Book {
    private  int ID;
    private  int ISBN;
    private  String edition;
    private  Date pubDate;
    private  String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }


    public Book(int ID, int ISBN, String edition, Date pubDate, String author) {
        this.ID = ID;
        this.ISBN = ISBN;
        this.edition = edition;
        this.pubDate = pubDate;
        this.author = author;
    }
}
