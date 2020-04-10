package mapper;


import entity.Publication;
import entity.Book;
import entity.PeriodPub;

import java.sql.Date;
import java.util.List;



public interface PublisherMapper {
    List<Publication> getPubList();
    void createBook(int ID,String topic, String title, String editor, String type,int ISBN, String edition, Date pubDate);
    void deleteBook(int ID);
    void updateBook(int ID,String topic, String title, String editor, String type,int ISBN, String edition, Date pubDate);
    Book findBookByDate(Date date);
    void createPeriodPub(int ID, String topic, String title, String editor, String type ,Date date, String periodicity, String textOfArticle);
    void updatePeriodPub(int ID, String topic, String title, String editor, String type ,Date date, String periodicity, String textOfArticle);
    void deletePeriodPub(int ID);
    Publication findPubByTopic(String topic);
}
