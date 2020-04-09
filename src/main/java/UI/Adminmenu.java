package UI;

import entity.Distributor;
import entity.Staff;
import mapper.AdminMapper;
import mapper.DistributorMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.util.List;
import java.util.Scanner;

public class Adminmenu{
    public static void print(){
        System.out.println(" -------------------------- ");
        System.out.println("1. Get all staff information");
        System.out.println("2. Get all editor information");
        System.out.println("3. Get all publisher information");
        System.out.println("4. delete an Editor account");
        System.out.println("5. Create a Publisher account");
        System.out.println("6. Update a Publisher account");
        System.out.println("7. delete an Publisher account");

        System.out.println("3001. Check all distributor information");
        System.out.println("3002. Update a distributor account");
        System.out.println("3003. Create a distributor account");
        System.out.println("3004. Delete a distributor account");

        System.out.println("8. return");

        Scanner scanner=new Scanner(System.in);
        String a =scanner.nextLine();

        switch (a){
            case "1": {
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Staff> staffList=adminMapper.getStaffList();

                for (Staff staff : staffList) {
                    System.out.println("-----------------------");
                    System.out.println("personnelID: "+staff.getStaffID());
                    System.out.println("Name: "+staff.getName());
                    System.out.println("Age: "+staff.getAge());
                    System.out.println("Gender: "+staff.getGender());
                    System.out.println("job type: "+staff.getJobType());
                    System.out.println("Phone: "+staff.getPhone());
                    System.out.println("Email address: "+staff.getEmailAddress());
                    System.out.println("paycheck: "+staff.getPaycheck());
                    System.out.println("paycheck date: "+staff.getPaycheckDate());
                }


                Adminmenu.print();
            }

            case "2":

            case "3":

            case "4":

            case "5":

            case "6":

            case "7":

            case "3001": {
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                List<Distributor> distributorList=adminMapper.getDistributorList();

                for (Distributor distributor : distributorList) {
                    System.out.println("-----------------------");
                    System.out.println("distributorID: "+distributor.getDistributorID());
                    System.out.println("name: "+distributor.getName());
                    System.out.println("type: "+distributor.getType());
                    System.out.println("street address: "+distributor.getStreetAddress());
                    System.out.println("city: "+distributor.getCity());
                    System.out.println("phone number: "+distributor.getPhoneNumber());
                    System.out.println("contact person: "+distributor.getContactPerson());
                    System.out.println("balance: "+distributor.getBalance());
                }
                Adminmenu.print();
            }
            case "3002": {
                //get user inputs
                System.out.println("Please enter the distributor ID you want to update:");
                String distributorID=scanner.nextLine();
                System.out.println("Please enter new name:");
                String name=scanner.nextLine();
                System.out.println("Please enter new balance:");
                String balance=scanner.nextLine();
                System.out.println("Please enter new city:");
                String city =scanner.nextLine();
                System.out.println("Please enter new street address:");
                String streetAddress=scanner.nextLine();
                System.out.println("Please enter new type:");
                String type=scanner.nextLine();
                System.out.println("Please enter new contact person:");
                String contactPerson=scanner.nextLine();
                System.out.println("Please enter new phone number:");
                String phoneNumber=scanner.nextLine();

                SqlSession sqlSession=MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.updateDistributor(Integer.parseInt(distributorID), name, Double.parseDouble(balance), city, streetAddress, type, contactPerson, phoneNumber);
                sqlSession.commit();
                Adminmenu.print();
            }
            case "3003":{

                //get user inputs
                System.out.println("Please enter distributor ID:");
                String distributorID=scanner.nextLine();
                System.out.println("Please enter name:");
                String name=scanner.nextLine();
                System.out.println("Please enter balance:");
                String balance=scanner.nextLine();
                System.out.println("Please enter city:");
                String city =scanner.nextLine();
                System.out.println("Please enter street address:");
                String streetAddress=scanner.nextLine();
                System.out.println("Please enter type:");
                String type=scanner.nextLine();
                System.out.println("Please enter contact person:");
                String contactPerson=scanner.nextLine();
                System.out.println("Please enter phone number:");
                String phoneNumber=scanner.nextLine();

                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.createNewDistributor(Integer.parseInt(distributorID), name, Double.parseDouble(balance), city, streetAddress, type, contactPerson, phoneNumber);
                sqlSession.commit();
                Adminmenu.print();
            }
            case "3004":
                System.out.println("Please enter the distrbutor ID you want to delete:");
                String distributorID = scanner.nextLine();
                SqlSession sqlSession= MybatisUtils.getSqlsession();
                AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
                adminMapper.deleteDistributor(Integer.parseInt(distributorID));
                sqlSession.commit();
                Adminmenu.print();
            case "8": Mainmenu.print();

        }
    }
}
