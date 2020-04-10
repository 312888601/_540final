package mapper;


import entity.Publication;
import entity.Book;
import entity.PeriodPub;

import java.sql.Date;
import java.util.List;



public interface PublisherMapper {
    List<Publication> getPubList();
    void createPublication(int ID,String topic, String title, String editor, String type);
    void updatePublication(int ID,String topic, String title, String editor, String type);
    void deletePublication(int ID);
    Publication findPubByID(int ID);
    void createBook(int ID,int ISBN, String edition, Date pubDate);
    void deleteBook(int ID);
    void updateBook(int ID,int ISBN, String edition, Date pubDate);
    List<Book> findBookByDate(Date startDate, Date endDate);
    void createPeriodPub(int ID,Date date, String Periodicity, String textOfArticle);
    void updatePeriodPub(int ID,Date date, String Periodicity, String textOfArticle);
    void deletePeriodPub(int ID);
    List<Publication> findPubByTopic(String topic);
}