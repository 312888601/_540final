package UI;

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
        System.out.println("8. return");

        Scanner scanner=new Scanner(System.in);
        String a =scanner.next();

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
                    System.out.println("job type: ");
                    System.out.println("Phone: "+staff.getPhone());
                    System.out.println("Email address: "+staff.getEmailAddress());
                    System.out.println("paycheck: ");
                    System.out.println("paycheck date: ");
                }


                Adminmenu.print();
            }

            case "2":

            case "3":

            case "4":

            case "5":

            case "6":

            case "7":

            case "8": Mainmenu.print();

        }
    }
}
