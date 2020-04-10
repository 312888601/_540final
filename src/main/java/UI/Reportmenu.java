package UI;

import mapper.ReportMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.util.List;
import java.util.Scanner;
import entity.Revenue;

public class Reportmenu {
    public static void print(){
        System.out.println("-----------------------");
        System.out.println("1. Get total revenue");
        System.out.println("2. Get total expenses(shipping cost and salaries)");
        System.out.println("3. Get total number of distributor");
        System.out.println("4. Get total revenue per city");
        System.out.println("5. Get total revenue per distributor");
        System.out.println("6. Get total revenue per location");

        Scanner scanner=new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input){
            case "1":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                ReportMapper reportMapper=sqlSession.getMapper(ReportMapper.class);
                int revenue =reportMapper.getTotalRevenue();

                System.out.println("Total revenue: "+revenue);

                Reportmenu.print();
            }
            case "2":{
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                ReportMapper reportMapper=sqlSession.getMapper(ReportMapper.class);
                int salaries = reportMapper.getSalaries();
                int shippingCost = reportMapper .getShippingCost();

                System.out.println("Salaries: "+salaries);
                System.out.println("Shipping cost: "+shippingCost);
                System.out.println("Total expense: "+(salaries+shippingCost));

                Reportmenu.print();
            }
            case "3":{
                SqlSession sqlSession=MybatisUtils.getSqlsession();
                ReportMapper reportMapper=sqlSession.getMapper(ReportMapper.class);
                int totalNumber=reportMapper.getTotalNumberOfDistributor();

                System.out.println("Total number of Distributor: "+totalNumber);
                Reportmenu.print();
            }
            case "4":{
                SqlSession sqlSession=MybatisUtils.getSqlsession();
                ReportMapper reportMapper=sqlSession.getMapper(ReportMapper.class);
                List<Revenue> revenueList=reportMapper.getRevenuePerCity();

                for (Revenue revenue : revenueList) {
                    System.out.println("city: "+revenue.getCity()+"\t"+"Revenue: "+revenue.getTotalPayment());
                }
                Reportmenu.print();
            }
            case "5":{
                SqlSession sqlSession=MybatisUtils.getSqlsession();
                ReportMapper reportMapper=sqlSession.getMapper(ReportMapper.class);
                List<Revenue> revenueList=  reportMapper.getRevenuePerDistributor();

                for (Revenue revenue : revenueList) {
                    System.out.println("DistributorId: "+revenue.getDistributorID()+"\t"+"Revenue: "+revenue.getTotalPayment());
                }

                Reportmenu.print();
            }
            case "6":{}


    }





    }
}
