package mapper;
import entity.Revenue;
import entity.Staff;

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
    //get revenue per location
    List<Revenue> getRevenuePerLocation();
    //get total payment per job type
    List<Staff> getTotalPaymentPerJobType();
}
