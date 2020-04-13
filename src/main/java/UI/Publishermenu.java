package UI;

import entity.Book;
import entity.Order;
import entity.Payment;
import entity.Publication;
import mapper.AdminMapper;
import mapper.PublisherMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Publishermenu{
    public static void print(){
        System.out.println(" -------------------------- ");
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
                adminMapper.placeOrder(Integer.parseInt(orderID),Integer.parseInt(distributorID),Integer.parseInt(publicationID),Integer.parseInt(numberOfCopies), Date.valueOf(orderDate));
                sqlSession.commit();
                sqlSession.close();
                Publishermenu.print();
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
                }
                sqlSession.close();
                Publishermenu.print();
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
                Publishermenu.print();
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
                    e.printStackTrace();sqlSession.rollback();
                }
                sqlSession.close();
                Publishermenu.print();
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
                Publishermenu.print();
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
                    e.printStackTrace();sqlSession.rollback();
                }
                sqlSession.close();
                Publishermenu.print();
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
                Publishermenu.print();
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
                Publishermenu.print();
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
                Publishermenu.print();
            }
            //calculate calculate the balance according to current data
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
                Publishermenu.print();
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
                Publishermenu.print();
            }

            case "0": Mainmenu.print();
        }
    }
}
