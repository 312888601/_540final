package entity;
import java.sql.Date;

public class Article {
    private String title;
    private String text;
    private String topic;
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Article(String title, String text, String topic, Date date) {
        this.title = title;
        this.text = text;
        this.topic = topic;
        this.date = date;
    }
}
