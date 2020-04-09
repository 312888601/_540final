import entity.Distributor;
import entity.Order;
import mapper.DistributorMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String aa=scanner.nextLine();
        String bb=scanner.nextLine();
        System.out.println(aa);
        System.out.println(bb);
    }
}
