package UI;

import entity.Distributor;
import entity.Order;
import entity.Publication;
import mapper.DistributorMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Distributormenu {
    public static void print(){
        System.out.println(" -------------------------- ");
        System.out.println("1. Check my information");
        System.out.println("2. Check all publication IDs");
        System.out.println("3. Place an order");
        System.out.println("4. Get orders belong to me");
        System.out.println("5. Pay an order");
        System.out.println("6. return");

        Scanner scanner= new Scanner(System.in);
        String input=scanner.next();

        switch (input){
            case "1":{
                System.out.println("Please enter your ID:");
                String ID=scanner.next();

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
            case "3":{

                System.out.println("Please enter your distributorID:");
                String distributorID=scanner.next();
                System.out.println("Please enter the publication ID:");
                String publicationID=scanner.next();
                System.out.println("Please enter the # of copies:");
                String numberOfCopies=scanner.next();

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                DistributorMapper distributorMapper=sqlSession.getMapper(DistributorMapper.class);
                distributorMapper.placeOrder(Integer.parseInt(distributorID),Integer.parseInt(publicationID), Integer.parseInt(numberOfCopies));
                sqlSession.commit();
                Distributormenu.print();
            }
            case "4":{
                System.out.println("Please enter your ID:");
                String ID=scanner.next();

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                DistributorMapper distributorMapper=sqlSession.getMapper(DistributorMapper.class);
                List<Order> orderList=distributorMapper.getOrderList(Integer.parseInt(ID));

                for (Order order : orderList) {
                    System.out.println("OrderID: "+order.getOrderID()+"\t"+"status: "+order.isStatus());
                }
                Distributormenu.print();
            }
            case "5":{
                System.out.println("Please enter the order ID you want to pay:");
                String orderID=scanner.next();

                SqlSession sqlSession=MybatisUtils.getSqlsession();
                DistributorMapper distributorMapper=sqlSession.getMapper(DistributorMapper.class);
                distributorMapper.payOrder(Integer.parseInt(orderID));
                sqlSession.commit();
                Distributormenu.print();
            }
        }


    }
}
