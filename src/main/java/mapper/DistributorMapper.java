package mapper;

import entity.Distributor;
import entity.Order;
import entity.Publication;

import java.util.List;

public interface DistributorMapper {
    List<Distributor> getDistributorList();

    //get all information
    Distributor getDistributor(int ID);

    //check all publication
    List<Integer> getPublicationList();

}
