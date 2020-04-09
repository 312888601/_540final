package mapper;

import entity.Distributor;
import entity.Staff;

import java.util.List;

public interface AdminMapper {
    //get all staff list
    List<Staff> getStaffList();

    //check all distributor information
    List<Distributor> getDistributorList();
    //create new distributor account
    void createNewDistributor(int distributorID, String name, double balance, String city, String streetAddress, String type, String contactPerson, String phoneNumber);
    //update a distributor
    void updateDistributor(int distributorID, String name, double balance, String city, String streetAddress, String type, String contactPerson, String phoneNumber);
    //delete a distributor account
    void deleteDistributor(int distributorID);
}
