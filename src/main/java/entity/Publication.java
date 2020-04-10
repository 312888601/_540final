package entity;

public class Publication {
    private int ID;
    private String topic;
    private String title;
    private String editor;
    private String type;


    public String getEditor() {
        return editor;
    }

    public String getType() {
        return type;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setType(String type) {
        this.type = type;
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



    public Publication(int ID, String topic, String title, String editor, String type) {
        this.ID = ID;
        this.topic = topic;
        this.title = title;
        this.editor = editor;
        this.type = type;
    }
}
