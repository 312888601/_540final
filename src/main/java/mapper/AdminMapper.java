package mapper;

import entity.*;

import java.util.Date;
import java.util.List;

public interface AdminMapper {
    //get all staff list
    List<Staff> getStaffList();
    //create new staff account
    void createNewStaff(int StaffID, String name, int age, String gender, String phone, String emailAddress, boolean isPublisher, boolean isAdmin, String address, int paycheck, Date paycheckDate, String jobType);
    //update a staff
    void updateStaff(int StaffID, String name, int age, String gender, String phone, String emailAddress, boolean isPublisher, boolean isAdmin, String address, int paycheck, Date paycheckDate, String jobType);
    //delete a staff account
    void deleteStaff(int StaffID);
//    //calculate total payments according to worktype
//    void calPayByWork(String jobType);
//    //calculate total payments according to month

    //check all distributor information
    List<Distributor> getDistributorList();
    //create new distributor account
    void createNewDistributor(int distributorID, String name, double balance, String city, String streetAddress, String type, String contactPerson, String phoneNumber);
    //update a distributor
    void updateDistributor(int distributorID, String name, double balance, String city, String streetAddress, String type, String contactPerson, String phoneNumber);
    //delete a distributor account
    void deleteDistributor(int distributorID);
    //place order
    void placeOrder(int distributorID, int publicationID, int numberOfCopies, Date orderDate);
    //check order information
    Order checkOrder(int orderID);
    //get publication title
    String getPubTitle(int publicationID);
    //delete order(then re-calculate balance)
    void deleteOrder(int orderID);
    //update order(then update balance)
    void updateOrder(int orderID, int distributorID, int publicationID, int numberOfCopies, Date deliveryDate, int shippingCost, int pricePerCopy);
    //calculate balance 1.find unpaid order
    List<Order> findUnpaidOrder(int distributorID);
    //calculate balance 2.update the balance
    void updateBalance(int distributorID, int balance);
    //get all orders belongs to one distributor
    List<Order> getOrderList(int ID);
    //pay an order (then calculate balance)
    void payOrder(int orderID, int totalPayment);
    //delete payment (then calculate balance)
    void deletePayment(int orderID);
    //check one payment
    Payment checkPayment(int orderID);
    //check all payment
    List<Payment> checkAllPayment();
}
