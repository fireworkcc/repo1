package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession对象创建Dao接口的代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        //5.使用代理对象调用方法
        List<Account> list = mapper.findAll();
        for(Account account : list ){
            System.out.println(account);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }


    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("喜羊羊");
        account.setMoney(500d);

        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession对象创建Dao接口的代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        //5.使用代理对象调用方法
        mapper.saveAccount(account);

        //提交事务
        sqlSession.commit();

        //6.释放资源
        sqlSession.close();
        in.close();
    }

}
