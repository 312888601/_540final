import UI.Mainmenu;
import entity.Distributor;
import mapper.DistributorMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        Mainmenu.print();
////        get Sqlsession object
//        SqlSession sqlSession= MybatisUtils.getSqlsession();
//
//        //execute sql
//        DistributorMapper distributorMapper=sqlSession.getMapper(DistributorMapper.class);
//        List<Distributor> distributorList=distributorMapper.getDistributorList();
//
//        for (Distributor distributor : distributorList) {
//            System.out.println(distributor.getName());
//        }

    }
}
