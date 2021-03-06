package UI;

import entity.*;

import mapper.AdminMapper;
import mapper.DistributorMapper;
import mapper.EditorMapper;
import mapper.PublisherMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Adminmenu{
    public static void print(){
        System.out.println("1001. Check all staff information");
        System.out.println("1002. Update a staff account");
        System.out.println("1003. Create a staff account");
        System.out.println("1004. Delete a staff account");
        System.out.println("1005. Enter payment for editor or author");

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
        System.out.println("4010. Assign editor to a publication");
        System.out.println("4011. Find book by author");
        System.out.println("4012. Get all books");
        System.out.println("4013. Get all Period publications");

        System.out.println("5001. Place an order");
        System.out.println("5002. Update an order");
        System.out.println("5003. Check order information");
        System.out.println("5004. Delete an order");
        System.out.println("5005. Calculate the total price of an order");
        System.out.println("5006. Pay an order");
        System.out.println("5007. Check all payment");
        System.out.println("5008. Check the order payment information");
        System.out.println("5009. Delete a payment");
        System.out.println("5010. Calculate the balance");
        System.out.println("5011. Get all order information from one distributor");


        System.out.println("0. return");

        Scanner scanner=new Scanner(System.in);
        String a =scanner.nextLine();

        switch (a){
            case "1001":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Staff> staffList=adminMapper.getStaffList();

                for (Staff staff : staffList) {
                    System.out.println("-----------------------");
                    System.out.println("staffID: "+ staff.getStaffID());
                    System.out.println("name: "+staff.getName());
                    System.out.println("age: "+staff.getAge());
                    System.out.println("gender: "+staff.getGender());
                    System.out.println("phone: "+staff.getPhone());
                    System.out.println("email address: "+staff.getEmailAddress());
                    System.out.println("is Publisher: "+staff.isPublisher());
                    System.out.println("is Admin: "+staff.isAdmin());
                    System.out.println("address: "+staff.getAddress());
                    System.out.println("paycheck: "+staff.getPaycheck());
                    System.out.println("paycheckDate: "+staff.getPaycheckDate());
                    System.out.println("jobType: "+staff.getJobType());
                }
                sqlSession.close();
                Adminmenu.print();

            }
            case "1002":{
                //get user inputs
                System.out.println("Please enter the staff ID you want to update:");
                String StaffID=scanner.nextLine();
                System.out.println("Please enter new name:");
                String name=scanner.nextLine();
                System.out.println("Please enter new age:");
                String age=scanner.nextLine();
                System.out.println("Please enter new gender:");
                String gender=scanner.nextLine();
                System.out.println("Please enter new phone:");
                String phone=scanner.nextLine();
                System.out.println("Please enter new email Address:");
                String emailAddress=scanner.nextLine();
                System.out.println("Please confirm whether it is Publisher(use true or false):");
                String isPublisher =scanner.nextLine();
                System.out.println("Please confirm whether it is Admin(use true or false):");
                String isAdmin =scanner.nextLine();
                System.out.println("Please enter new address:");
                String address=scanner.nextLine();
                System.out.println("Please enter new paycheck:");
                String paycheck=scanner.nextLine();
                System.out.println("Please enter new paycheckDate:");
                String paycheckDate1=scanner.nextLine();
                System.out.println("Please enter new job type:");
                String jobType=scanner.nextLine();

                Date paycheckDate=java.sql.Date.valueOf(paycheckDate1);

                SqlSession sqlSession=MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.updateStaff(Integer.parseInt(StaffID), name, Integer.parseInt(age), gender, phone, emailAddress, Boolean.parseBoolean(isPublisher), Boolean.parseBoolean(isAdmin), address,Integer.parseInt(paycheck), paycheckDate, jobType);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();

            }
            case "1003":{
                //get user inputs
                System.out.println("Please enter staff ID:");
                String StaffID=scanner.nextLine();
                System.out.println("Please enter name:");
                String name=scanner.nextLine();
                System.out.println("Please enter age:");
                String age=scanner.nextLine();
                System.out.println("Please enter gender:");
                String gender=scanner.nextLine();
                System.out.println("Please enter phone:");
                String phone=scanner.nextLine();
                System.out.println("Please enter email Address:");
                String emailAddress=scanner.nextLine();
                System.out.println("Please confirm whether it is Publisher(use true or false):");
                String isPublisher =scanner.nextLine();
                System.out.println("Please confirm whether it is Admin(use true or false):");
                String isAdmin =scanner.nextLine();
                System.out.println("Please enter address:");
                String address=scanner.nextLine();
                System.out.println("Please enter paycheck:");
                String paycheck=scanner.nextLine();
                System.out.println("Please enter paycheckDate:");
                String paycheckDate1=scanner.nextLine();
                System.out.println("Please enter new job type:");
                String jobType=scanner.nextLine();

                Date paycheckDate=java.sql.Date.valueOf(paycheckDate1);

                SqlSession sqlSession=MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.createNewStaff(Integer.parseInt(StaffID), name, Integer.parseInt(age), gender, phone, emailAddress, Boolean.parseBoolean(isPublisher), Boolean.parseBoolean(isAdmin), address,Integer.parseInt(paycheck), paycheckDate, jobType);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            case "1004":{
                System.out.println("Please enter the Staff ID you want to delete:");
                String StaffID = scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.deleteStaff(Integer.parseInt(StaffID));
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }

            case "1005":{
                System.out.println("Please enter the staff ID:");
                String StaffID = scanner.nextLine();
                System.out.println("Please enter the payment:");
                String paycheck = scanner.nextLine();
                System.out.println("Please enter the paycheckDate:");
                String paycheckDate1=scanner.nextLine();
                Date paycheckDate=java.sql.Date.valueOf(paycheckDate1);

                SqlSession sqlSession=MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.updatePaycheck(Integer.parseInt(StaffID),Integer.parseInt(paycheck), paycheckDate);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }

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
                Adminmenu.print();
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
                Adminmenu.print();
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
                Adminmenu.print();
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
                Adminmenu.print();
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
                Adminmenu.print();
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
                Adminmenu.print();
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
                Adminmenu.print();

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
                Adminmenu.print();
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
                Adminmenu.print();
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
                Adminmenu.print();
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
                Adminmenu.print();
            }





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
                System.out.println("Please enter author:");
                String author=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                try {
                    publisherMapper.createPublication(Integer.parseInt(ID), topic, title, editor, type);
                    publisherMapper.createBook(Integer.parseInt(ID), Integer.parseInt(ISBN), edition, Date.valueOf(date),author);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
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
                    e.printStackTrace();
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
                System.out.println("Please enter author:");
                String author=scanner.nextLine();
                System.out.println("Please enter date(YYYY-MM-DD):");
                String date=scanner.nextLine();
                try {
                    publisherMapper.updatePublication(Integer.parseInt(ID), topic, title, editor, type);
                    publisherMapper.updateBook(Integer.parseInt(ID), Integer.parseInt(ISBN), edition, Date.valueOf(date),author);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
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
                    e.printStackTrace();
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
                    e.printStackTrace();
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
                    e.printStackTrace();
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
                    System.out.println("Author: "+book.getAuthor());
                }
                sqlSession.close();
                Adminmenu.print();
            }


            case "4010":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter  ID:");
                String ID=scanner.nextLine();
                System.out.println("Please enter editor:");
                String editor=scanner.nextLine();
                publisherMapper.updateEditor(Integer.parseInt(ID),editor);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }


            case  "4011":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);
                System.out.println("Please enter author:");
                String author=scanner.nextLine();

                List<Book> bookList=publisherMapper.findBookByAut(author);

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
                    System.out.println("Author: "+book.getAuthor());
                }
                sqlSession.close();
                Adminmenu.print();
            }

            case  "4012":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);


                List<Book> bookList=publisherMapper.getAllBook();

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
                    System.out.println("Author: "+book.getAuthor());
                }
                sqlSession.close();
                Adminmenu.print();
            }

            case  "4013":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                PublisherMapper publisherMapper=sqlSession.getMapper(PublisherMapper.class);

                List<PeriodPub> ppList = publisherMapper.getAllPeriod();

                for (PeriodPub pp:ppList) {
                    Publication pub = publisherMapper.findPubByID(pp.getID());
                    System.out.println("-----------------------");
                    System.out.println("ID: "+pub.getID());
                    System.out.println("Title: "+pub.getTitle());
                    System.out.println("Topic: "+pub.getTopic());
                    System.out.println("Editor: "+pub.getEditor());
                    System.out.println("Date: "+pp.getDate());
                    System.out.println("Periodicity: "+pp.getPeriodicity());
                    System.out.println("TextOfArticle: "+pp.getTextOfArticle());
                }
                sqlSession.close();
                Adminmenu.print();
            }


            //create order
            case "5001":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                System.out.println("Please enter  order ID:");
                String orderID=scanner.nextLine();
                System.out.println("Please enter  distributor ID:");
                String distributorID=scanner.nextLine();
                System.out.println("Please enter publication ID:");
                String publicationID=scanner.nextLine();
                System.out.println("Please enter number of copies:");
                String numberOfCopies=scanner.nextLine();
                System.out.println("Please enter current date(YYYY-MM-DD):");
                String orderDate=scanner.nextLine();
                adminMapper.placeOrder(Integer.parseInt(orderID),Integer.parseInt(distributorID),Integer.parseInt(publicationID),Integer.parseInt(numberOfCopies),Date.valueOf(orderDate));
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            //update order
            case "5002":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                System.out.println("Please enter orderID:");
                String orderID=scanner.nextLine();
                System.out.println("Please enter  distributor ID:");
                String distributorID=scanner.nextLine();
                System.out.println("Please enter publication ID:");
                String publicationID=scanner.nextLine();
                System.out.println("Please enter number of copies:");
                String numberOfCopies=scanner.nextLine();
                System.out.println("Please enter deliveryDate(YYYY-MM-DD):");
                String deliveryDate=scanner.nextLine();
                System.out.println("Please enter shippingCost");
                String shippingCost=scanner.nextLine();
                System.out.println("Please enter pricePerCopy:");
                String pricePerCopy=scanner.nextLine();
                try{
                    adminMapper.updateOrder(Integer.parseInt(orderID),Integer.parseInt(distributorID),Integer.parseInt(publicationID),Integer.parseInt(numberOfCopies), Date.valueOf(deliveryDate), Integer.parseInt(shippingCost), Integer.parseInt(pricePerCopy));
                    List<Order> unpaidOrder=adminMapper.findUnpaidOrder(Integer.parseInt(distributorID));
                    int balance=0;
                    for (Order order:unpaidOrder) {
                        int order_value=order.getPricePerCopy()*order.getNumberOfCopies()+order.getShippingCost();
                        balance+=order_value;
                    }
                    adminMapper.updateBalance(Integer.parseInt(distributorID), balance);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }
            //check order information
            case "5003": {
                System.out.println("Please enter orderID:");
                String orderID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                Order order=adminMapper.checkOrder(Integer.parseInt(orderID));
                String title=adminMapper.getPubTitle(order.getPublicationID());
                System.out.println("orderID:"+order.getOrderID());
                System.out.println("distributorID:"+order.getDistributorID());
                System.out.println("publicationID:"+order.getPublicationID());
                System.out.println("Title:"+title);
                System.out.println("numberOfCopies:"+order.getNumberOfCopies());
                System.out.println("deliveryDate:"+order.getDeliveryDate());
                System.out.println("orderDate:"+order.getOrderDate());
                System.out.println("shippingCost:"+ order.getShippingCost());
                System.out.println("price per copy:"+ order.getPricePerCopy());
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            //delete order
            case "5004": {
                System.out.println("Please enter orderID:");
                String orderID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                try{
                    Order targetorder=adminMapper.checkOrder(Integer.parseInt(orderID));
                    int distributorID=targetorder.getDistributorID();
                    adminMapper.deleteOrder(Integer.parseInt(orderID));
                    List<Order> unpaidOrder=adminMapper.findUnpaidOrder(distributorID);
                    int balance=0;
                    for (Order order:unpaidOrder) {
                        int order_value=order.getPricePerCopy()*order.getNumberOfCopies()+order.getShippingCost();
                        balance+=order_value;
                    }
                    adminMapper.updateBalance(distributorID, balance);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }
            //calculate order
            case "5005": {
                System.out.println("Please enter orderID:");
                String orderID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                Order order=adminMapper.checkOrder(Integer.parseInt(orderID));
                int bill=order.getPricePerCopy()*order.getNumberOfCopies()+order.getShippingCost();
                System.out.println("Order Bill:"+ bill);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            //pay order
            case "5006": {
                System.out.println("Please enter orderID:");
                String orderID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                try{
                    Order paidorder=adminMapper.checkOrder(Integer.parseInt(orderID));
                    int bill=paidorder.getPricePerCopy()*paidorder.getNumberOfCopies()+paidorder.getShippingCost();
                    adminMapper.payOrder(Integer.parseInt(orderID), bill);
                    Order targetorder=adminMapper.checkOrder(Integer.parseInt(orderID));
                    int distributorID=targetorder.getDistributorID();
                    List<Order> unpaidOrder=adminMapper.findUnpaidOrder(distributorID);
                    int balance=0;
                    for (Order order:unpaidOrder) {
                        int order_value=order.getPricePerCopy()*order.getNumberOfCopies()+order.getShippingCost();
                        balance+=order_value;
                    }
                    adminMapper.updateBalance(distributorID, balance);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }
            //check all payment
            case "5007" :{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Payment> paymentList=adminMapper.checkAllPayment();

                for (Payment payment:paymentList) {
                    System.out.println("-----------------------");
                    System.out.println("ID: "+payment.getOrderID());
                    System.out.println("Total Payment: "+payment.getTotalPayment());
                }
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            //check one payment information
            case "5008" :{
                System.out.println("Please enter orderID:");
                String orderID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                Payment payment=adminMapper.checkPayment(Integer.parseInt(orderID));
                System.out.println("-----------------------");
                System.out.println("ID: "+payment.getOrderID());
                System.out.println("Total Payment: "+payment.getTotalPayment());
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            //delete payment
            case "5009":{
                System.out.println("Please enter orderID:");
                String orderID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                try{
                    Order targetorder=adminMapper.checkOrder(Integer.parseInt(orderID));
                    adminMapper.deletePayment(Integer.parseInt(orderID));
                    int distributorID=targetorder.getDistributorID();
                    List<Order> unpaidOrder=adminMapper.findUnpaidOrder(distributorID);
                    int balance=0;
                    for (Order order:unpaidOrder) {
                        int order_value=order.getPricePerCopy()*order.getNumberOfCopies()+order.getShippingCost();
                        balance+=order_value;
                    }
                    adminMapper.updateBalance(distributorID, balance);
                    sqlSession.commit();
                }
                catch (Exception e){
                    e.printStackTrace();
                    sqlSession.rollback();
                }
                sqlSession.close();
                Adminmenu.print();
            }
            //calculate the balance according to current data
            case "5010":{
                System.out.println("Please enter distributorID:");
                String distributorID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Order> unpaidOrder=adminMapper.findUnpaidOrder(Integer.parseInt(distributorID));
                int balance=0;
                for (Order order:unpaidOrder) {
                    int order_value=order.getPricePerCopy()*order.getNumberOfCopies()+order.getShippingCost();
                    balance+=order_value;
                }
                adminMapper.updateBalance(Integer.parseInt(distributorID), balance);
                System.out.println("The balance of the distributor is updated to"+balance);
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }
            //Get all order information from one distributor
            case "5011":{
                System.out.println("Please enter distributorID:");
                String distributorID=scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Order> allorder=adminMapper.getOrderList(Integer.parseInt(distributorID));
                for (Order order:allorder) {
                    String title=adminMapper.getPubTitle(order.getPublicationID());
                    System.out.println("orderID:"+order.getOrderID());
                    System.out.println("distributorID:"+order.getDistributorID());
                    System.out.println("publicationID:"+order.getPublicationID());
                    System.out.println("Title:"+title);
                    System.out.println("numberOfCopies:"+order.getNumberOfCopies());
                    System.out.println("deliveryDate:"+order.getDeliveryDate());
                    System.out.println("orderDate:"+order.getOrderDate());
                    System.out.println("shippingCost:"+ order.getShippingCost());
                    System.out.println("price per copy:"+ order.getPricePerCopy());
                }
                sqlSession.commit();
                sqlSession.close();
                Adminmenu.print();
            }

            case "0": Mainmenu.print();

        }
    }
}
