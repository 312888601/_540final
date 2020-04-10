package UI;

import entity.Book;
import entity.Distributor;
import entity.Staff;
import entity.Publication;

import mapper.AdminMapper;
import mapper.DistributorMapper;
import mapper.PublisherMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Adminmenu{
    public static void print(){
        System.out.println(" -------------------------- ");
        System.out.println("1. Get all staff information");
        System.out.println("2. Get all editor information");
        System.out.println("3. Get all publisher information");
        System.out.println("4. delete an Editor account");
        System.out.println("5. Create a Publisher account");
        System.out.println("6. Update a Publisher account");
        System.out.println("7. delete an Publisher account");

        System.out.println("3001. Check all distributor information");
        System.out.println("3002. Update a distributor account");
        System.out.println("3003. Create a distributor account");
        System.out.println("3004. Delete a distributor account");


        System.out.println("4001. Get all Publication information");
        System.out.println("4002. Create new book");
        System.out.println("4003. Delete a book");
        System.out.println("4004. Update a book");
        System.out.println("4005. Create new PeriodPublication");
        System.out.println("4006. Delete a PeriodPublication");
        System.out.println("4007. Update a PeriodPublication");
        System.out.println("4008. Find publication by topic");
        System.out.println("4009. Find book by date");


        System.out.println("8. return");

        Scanner scanner=new Scanner(System.in);
        String a =scanner.nextLine();

        switch (a){
            case "1": {
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Staff> staffList=adminMapper.getStaffList();

                for (Staff staff : staffList) {
                    System.out.println("-----------------------");
                    System.out.println("personnelID: "+staff.getStaffID());
                    System.out.println("Name: "+staff.getName());
                    System.out.println("Age: "+staff.getAge());
                    System.out.println("Gender: "+staff.getGender());
                    System.out.println("job type: "+staff.getJobType());
                    System.out.println("Phone: "+staff.getPhone());
                    System.out.println("Email address: "+staff.getEmailAddress());
                    System.out.println("paycheck: "+staff.getPaycheck());
                    System.out.println("paycheck date: "+staff.getPaycheckDate());
                }

                sqlSession.close();
                Adminmenu.print();
            }

            case "2":

            case "3":

            case "4":

            case "5":

            case "6":

            case "7":

            case "3001": {
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Distributor> distributorList=adminMapper.getDistributorList();

                for (Distributor distributor : distributorList) {
                    System.out.println("-----------------------");
                    System.out.println("distributorID: "+distributor.getDistributorID());
                    System.out.println("name: "+distributor.getName());
                    System.out.println("type: "+distributor.getType());
                    System.out.println("street address: "+distributor.getStreetAddress());
                    System.out.println("city: "+distributor.getCity());
                    System.out.println("phone number: "+distributor.getPhoneNumber());
                    System.out.println("contact person: "+distributor.getContactPerson());
                    System.out.println("balance: "+distributor.getBalance());
                }
                sqlSession.close();
                Adminmenu.print();
            }
            case "3002": {
                //get user inputs
                System.out.println("Please enter the distributor ID you want to update:");
                String distributorID=scanner.nextLine();
                System.out.println("Please enter new name:");
                String name=scanner.nextLine();
                System.out.println("Please enter new balance:");
                String balance=scanner.nextLine();
                System.out.println("Please enter new city:");
                String city =scanner.nextLine();
                System.out.println("Please enter new street address:");
                String streetAddress=scanner.nextLine();
                System.out.println("Please enter new type:");
                String type=scanner.nextLine();
                System.out.println("Please enter new contact person:");
                String contactPerson=scanner.nextLine();
                System.out.println("Please enter new phone number:");
                String phoneNumber=scanner.nextLine();

                SqlSession sqlSession=MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.updateDistributor(Integer.parseInt(distributorID), name, Double.parseDouble(balance), city, streetAddress, type, contactPerson, phoneNumber);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            case "3003":{

                //get user inputs
                System.out.println("Please enter distributor ID:");
                String distributorID=scanner.nextLine();
                System.out.println("Please enter name:");
                String name=scanner.nextLine();
                System.out.println("Please enter balance:");
                String balance=scanner.nextLine();
                System.out.println("Please enter city:");
                String city =scanner.nextLine();
                System.out.println("Please enter street address:");
                String streetAddress=scanner.nextLine();
                System.out.println("Please enter type:");
                String type=scanner.nextLine();
                System.out.println("Please enter contact person:");
                String contactPerson=scanner.nextLine();
                System.out.println("Please enter phone number:");
                String phoneNumber=scanner.nextLine();

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.createNewDistributor(Integer.parseInt(distributorID), name, Double.parseDouble(balance), city, streetAddress, type, contactPerson, phoneNumber);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            case "3004": {
                System.out.println("Please enter the distrbutor ID you want to delete:");
                String distributorID = scanner.nextLine();
                SqlSession sqlSession = MybatisUtils.getSqlsession();
                AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
                adminMapper.deleteDistributor(Integer.parseInt(distributorID));
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();


            }

            case "4001":{

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                List<Publication> pubList=publisherMapper.getPubList();

                for (Publication pub:pubList) {
                    System.out.println("-----------------------");
                    System.out.println("ID: "+pub.getID());
                    System.out.println("Title: "+pub.getTitle());
                    System.out.println("Topic: "+pub.getTopic());
                    System.out.println("Editor: "+pub.getEditor());
                    System.out.println("Type: "+pub.getType());
                }
                sqlSession.close();
                Adminmenu.print();

            }

            case "4002":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter  ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();
                System.out.println("Please enter editor:");
                String editor=scanner.nextLine();
                System.out.println("Please enter type:");
                String type=scanner.nextLine();
                System.out.println("Please enter ISBN:");
                String ISBN=scanner.nextLine();
                System.out.println("Please enter edtion:");
                String edition=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                try {
                    publisherMapper.createPublication(Integer.parseInt(ID), topic, title, editor, type);
                    publisherMapper.createBook(Integer.parseInt(ID), Integer.parseInt(ISBN), edition, Date.valueOf(date));
                    sqlSession.commit();
                }
                catch (Exception e){
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();

            }

            case "4003":{
                SqlSession sqlSession = MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper = sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter  ID:");
                String ID = scanner.nextLine();
                try {
                    publisherMapper.deleteBook(Integer.parseInt(ID));
                    publisherMapper.deletePublication(Integer.parseInt(ID));
                    sqlSession.commit();
                }
                catch (Exception e){
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }

            case "4004":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter  ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();
                System.out.println("Please enter editor:");
                String editor=scanner.nextLine();
                System.out.println("Please enter type:");
                String type=scanner.nextLine();
                System.out.println("Please enter ISBN:");
                String ISBN=scanner.nextLine();
                System.out.println("Please enter edtion:");
                String edition=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                try {
                    publisherMapper.updatePublication(Integer.parseInt(ID), topic, title, editor, type);
                    publisherMapper.updateBook(Integer.parseInt(ID), Integer.parseInt(ISBN), edition, Date.valueOf(date));
                    sqlSession.commit();
                }
                catch (Exception e){
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }


            case "4005":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter  ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();
                System.out.println("Please enter editor:");
                String editor=scanner.nextLine();
                System.out.println("Please enter type:");
                String type=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                System.out.println("Please enter Periodicity(monthly/weekly/..):");
                String Periodicity=scanner.nextLine();
                System.out.println("Please enter textOfArticle:");
                String textOfArticle=scanner.nextLine();
                try {
                    publisherMapper.createPublication(Integer.parseInt(ID), topic, title, editor, type);
                    publisherMapper.createPeriodPub(Integer.parseInt(ID),Date.valueOf(date),Periodicity,textOfArticle);
                    sqlSession.commit();
                }
                catch (Exception e){
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();

            }

            case "4006":{
                SqlSession sqlSession = MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper = sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter  ID:");
                String ID = scanner.nextLine();
                try {
                    publisherMapper.deletePeriodPub(Integer.parseInt(ID));
                    publisherMapper.deletePublication(Integer.parseInt(ID));
                    sqlSession.commit();
                }
                catch (Exception e){
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }

            case "4007":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter  ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter title:");
                String title=scanner.nextLine();
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();
                System.out.println("Please enter editor:");
                String editor=scanner.nextLine();
                System.out.println("Please enter type:");
                String type=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                System.out.println("Please enter Periodicity(monthly/weekly/..):");
                String Periodicity=scanner.nextLine();
                System.out.println("Please enter textOfArticle:");
                String textOfArticle=scanner.nextLine();
                try {
                    publisherMapper.updatePublication(Integer.parseInt(ID), topic, title, editor, type);
                    publisherMapper.updatePeriodPub(Integer.parseInt(ID),Date.valueOf(date),Periodicity,textOfArticle);
                    sqlSession.commit();
                }
                catch (Exception e){
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }
            case "4008":{

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter topic:");
                String topic=scanner.nextLine();

                List<Publication> pubList=publisherMapper.findPubByTopic(topic);

                for (Publication pub:pubList) {
                    System.out.println("-----------------------");
                    System.out.println("ID: "+pub.getID());
                    System.out.println("Title: "+pub.getTitle());
                    System.out.println("Topic: "+pub.getTopic());
                    System.out.println("Editor: "+pub.getEditor());
                    System.out.println("Type: "+pub.getType());
                }
                sqlSession.close();
                Adminmenu.print();
            }

            case "4009":{

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter start date(YYYY-MM-DD):");
                String startdate=scanner.nextLine();
                System.out.println("Please enter end date(YYYY-MM-DD):");
                String enddate=scanner.nextLine();

                List<Book> bookList=publisherMapper.findBookByDate(Date.valueOf(startdate),Date.valueOf(enddate));

                for (Book book:bookList) {
                    Publication pub = publisherMapper.findPubByID(book.getID());
                    System.out.println("-----------------------");
                    System.out.println("ID: "+pub.getID());
                    System.out.println("Title: "+pub.getTitle());
                    System.out.println("Topic: "+pub.getTopic());
                    System.out.println("Editor: "+pub.getEditor());
                    System.out.println("ISBN: "+book.getISBN());
                    System.out.println("Edition: "+book.getEdition());
                    System.out.println("Pubdate: "+book.getPubDate());
                }
                sqlSession.close();
                Adminmenu.print();
            }

            case "8": Mainmenu.print();

        }
    }
}
