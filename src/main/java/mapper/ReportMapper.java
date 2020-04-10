package mapper;
import entity.Revenue;
import java.util.List;

public interface ReportMapper {
    //get total revenue
    int getTotalRevenue();
    //get total expense (shipping cost+salaries)
    int getShippingCost();
    int getSalaries();
    //get total # of distributors
    int getTotalNumberOfDistributor();
    //get revenue per distributor
    List<Revenue> getRevenuePerDistributor();
    //get revenue per city
    List<Revenue> getRevenuePerCity();
}
