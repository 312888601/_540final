package UI;

import entity.Distributor;
import entity.Order;
import entity.Publication;
import mapper.AdminMapper;
import mapper.DistributorMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Distributormenu {
    public static void print(){
        System.out.println(" -------------------------- ");
        System.out.println("1. Check my information");
        System.out.println("2. Check all publication IDs");
        System.out.println("4. Get orders belong to me");


        System.out.println("5001. Place an order");
        System.out.println("5003. Check order information");
        System.out.println("5005. Calculate the total price of an order");
        System.out.println("5006. Pay an order");
        System.out.println("5010. Calculate the balance");
        System.out.println("5011. Get all order information from me");
        System.out.println("6. return");

        Scanner scanner= new Scanner(System.in);
        String input=scanner.nextLine();

        switch (input){
            case "1":{
                System.out.println("Please enter your ID:");
                String ID=scanner.nextLine();

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                DistributorMapper distributorMapper=sqlSession.getMapper(DistributorMapper.class);
                Distributor distributor=distributorMapper.getDistributor(Integer.parseInt(ID));

                System.out.println("distributorID:"+distributor.getDistributorID());
                System.out.println("name:"+distributor.getName());
                System.out.println("type:"+distributor.getType());
                System.out.println("street address:"+distributor.getStreetAddress());
                System.out.println("city:"+distributor.getCity());
                System.out.println("phone number:"+distributor.getPhoneNumber());
                System.out.println("contact person:"+distributor.getContactPerson());
                System.out.println("balance:"+distributor.getBalance());
                Distributormenu.print();
            }
            case "2":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                DistributorMapper distributorMapper=sqlSession.getMapper(DistributorMapper.class);
                List<Integer> IDList=distributorMapper.getPublicationList();
                for (Integer integer : IDList) {
                    System.out.println("ID: "+integer.toString());
                }
                Distributormenu.print();
            }

            //create order
            case "5001":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                System.out.println("Please enter  distributor ID:");
                String distributorID=scanner.nextLine();
                System.out.println("Please enter publication ID:");
                String publicationID=scanner.nextLine();
                System.out.println("Please enter number of copies:");
                String numberOfCopies=scanner.nextLine();
                System.out.println("Please enter current date(YYYY-MM-DD):");
                String orderDate=scanner.nextLine();
                adminMapper.placeOrder(Integer.parseInt(distributorID),Integer.parseInt(publicationID),Integer.parseInt(numberOfCopies), Date.valueOf(orderDate));
                sqlSession.commit();
                sqlSession.close();
                Distributormenu.print();
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
                Distributormenu.print();
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
                Distributormenu.print();
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
                    sqlSession.rollback();
                }
                sqlSession.close();
                Distributormenu.print();
            }

            //calculate balence
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
                sqlSession.commit();
                sqlSession.close();
                Distributormenu.print();
            }
            //Get all order information me
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
                Distributormenu.print();
            }

            case "6":{
                Mainmenu.print();
            }
        }


    }
}
