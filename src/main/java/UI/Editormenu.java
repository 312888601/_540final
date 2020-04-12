package UI;

import entity.*;

import mapper.EditorMapper;
import mapper.PublisherMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Editormenu{
    public static void print(){
        System.out.println(" -------------------------- ");
        System.out.println("2001. Find the editing work assigned to me");
        System.out.println("2002. Check my payment");
        System.out.println("2003. Edit one of my work's text");
        System.out.println("2004. Create an article or a chapter");
        System.out.println("2005. Update an article or a chapter");
        System.out.println("2006. Delete an article or a chapter");
        System.out.println("2007. Publish an article or add a chapter");
        System.out.println("2008. Unpublish an article or delete a chapter");
        System.out.println("2009. Find articles by topic");
        System.out.println("2010. Find articles by author");
        System.out.println("2011. Find articles by date");
        System.out.println("2012. return");

        Scanner scanner=new Scanner(System.in);
        String a =scanner.nextLine();

        switch (a){
            case "2001":{
                System.out.println("Please enter your StaffID:");
                String ID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                Staff staff = editorMapper.findEditorByID(Integer.parseInt(ID));
                List<Publication> pubList=publisherMapper.findPubByEditor(staff.getName());

                for (Publication pub:pubList) {
                    System.out.println("-----------------------");
                    System.out.println("ID: "+pub.getID());
                    System.out.println("Title: "+pub.getTitle());
                    System.out.println("Topic: "+pub.getTopic());
                    System.out.println("Editor: "+pub.getEditor());
                    System.out.println("Type: "+pub.getType());
                }
                sqlSession.close();
                Editormenu.print();
            }


            case "2002":{
                System.out.println("Please enter your StaffID:");
                String ID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                Staff staff = editorMapper.findEditorByID(Integer.parseInt(ID));
                System.out.println("-----------------------");
                System.out.println("staffID: "+ staff.getStaffID());
                System.out.println("name: "+staff.getName());
                System.out.println("paycheck: "+staff.getPaycheck());
                System.out.println("paycheckDate: "+staff.getPaycheckDate());
                sqlSession.close();
                Editormenu.print();
            }


            case "2003":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter Publication ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter textOfArticle:");
                String textOfArticle=scanner.nextLine();
                publisherMapper.editTextOfPeriodPub(Integer.parseInt(ID),textOfArticle);
                sqlSession.commit();
                sqlSession.close();
                Editormenu.print();
            }

            case "2004":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                System.out.println("Please enter  text:");
                String text=scanner.nextLine();
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                System.out.println("Please enter author:");
                String author=scanner.nextLine();
                try {
                    editorMapper.createArticle(title, text, topic, Date.valueOf(date));
                    Staff aut = editorMapper.findAutByName(author);
                    editorMapper.writeArticle(aut.getStaffID(), title);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                    sqlSession.rollback();
                }
                sqlSession.close();
                Editormenu.print();
            }

            case "2005":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                System.out.println("Please enter  text:");
                String text=scanner.nextLine();
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                System.out.println("Please enter author:");
                String author=scanner.nextLine();
                try {
                    editorMapper.updateArticle(title, text, topic, Date.valueOf(date));
                    Staff aut = editorMapper.findAutByName(author);
                    editorMapper.updateWrite(aut.getStaffID(), title);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                    sqlSession.rollback();
                }
                sqlSession.close();
                Editormenu.print();
            }

            case "2006":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                System.out.println("Please enter author:");
                String author=scanner.nextLine();
                try {
                    Staff aut = editorMapper.findAutByName(author);
                    editorMapper.deleteWrite(aut.getStaffID(), title);
                    editorMapper.deleteArticle(title);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                    sqlSession.rollback();
                }
                sqlSession.close();
                Editormenu.print();
            }

            case "2007":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter Publication ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                editorMapper.publishArticle(Integer.parseInt(ID),title);
                sqlSession.commit();
                sqlSession.close();
                Editormenu.print();

            }

            case "2008":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter Publication ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                editorMapper.unpublishArticle(Integer.parseInt(ID),title);
                sqlSession.commit();
                sqlSession.close();
                Editormenu.print();
            }

            case "2009":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();
                List<Article> artList=editorMapper.findArtByTopic(topic);

                for (Article article:artList) {

                    System.out.println("-----------------------");
                    System.out.println("Title: "+article.getTitle());
                    System.out.println("Text: "+article.getText());
                    System.out.println("Topic: "+article.getTopic());
                    System.out.println("Date: "+article.getDate());
                }
                Editormenu.print();
            }

            case "2010":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter author:");
                String author=scanner.nextLine();
                Staff aut = editorMapper.findAutByName(author);
                List<Written_by> wrtList=editorMapper.findArtByID(aut.getStaffID());

                for (Written_by wrt:wrtList) {
                    Article article=editorMapper.findArtByTitle(wrt.getTitle());
                    System.out.println("-----------------------");
                    System.out.println("Title: "+article.getTitle());
                    System.out.println("Text: "+article.getText());
                    System.out.println("Topic: "+article.getTopic());
                    System.out.println("Date: "+article.getDate());
                }
                Editormenu.print();
            }
            case "2011":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                EditorMapper editorMapper=sqlSession.getMapper(EditorMapper.class);
                System.out.println("Please enter start date(YYYY-MM-DD):");
                String startdate=scanner.nextLine();
                System.out.println("Please enter end date(YYYY-MM-DD):");
                String enddate=scanner.nextLine();
                List<Article> artList=editorMapper.findArtByDate(Date.valueOf(startdate),Date.valueOf(enddate));

                for (Article article:artList) {

                    System.out.println("-----------------------");
                    System.out.println("Title: "+article.getTitle());
                    System.out.println("Text: "+article.getText());
                    System.out.println("Topic: "+article.getTopic());
                    System.out.println("Date: "+article.getDate());
                }
                Editormenu.print();
            }

            case "2012":{
                Mainmenu.print();
            }

        }
    }
}
