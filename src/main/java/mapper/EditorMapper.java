package mapper;
import entity.Article;
import entity.Staff;
import entity.Written_by;

import java.sql.Date;
import java.util.List;

public interface EditorMapper {
    Staff findEditorByID(int ID);
    Staff findAutByName(String name);
    void createArticle(String title, String text, String topic, Date date);
    void updateArticle(String title, String text, String topic, Date date);
    void deleteArticle(String title);
    void writeArticle(int ID,String title);
    void updateWrite(int ID,String title);
    void deleteWrite(int ID,String title);

    void publishArticle(int ID,String title);
    void unpublishArticle(int ID,String title);

    List<Written_by> findArtByID(int ID);
    Article findArtByTitle(String title);
    List<Article> findArtByTopic(String topic);
    List<Article> findArtByDate(Date startDate, Date endDate);
}
