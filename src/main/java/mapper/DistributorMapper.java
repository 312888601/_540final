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

    //place order
    void placeOrder(int distributor_ID, int publication_ID, int number_of_copies);

    //get all orders belongs to me
    List<Order> getOrderList(int ID);

    //pay an order
    void payOrder(int orderID);
}
