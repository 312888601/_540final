package mapper;

import entity.Distributor;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtils;

import java.util.List;

public class DistributorMapperTest {
    public static void main(String[] args) {
        //get Sqlsession object
        SqlSession sqlSession= MybatisUtils.getSqlsession();

        //execute sql
        DistributorMapper distributorMapper=sqlSession.getMapper(DistributorMapper.class);
        List<Distributor> distributorList=distributorMapper.getDistributorList();

        for (Distributor distributor : distributorList) {
            System.out.println(distributor);
        }

        sqlSession.close();
    }
}
