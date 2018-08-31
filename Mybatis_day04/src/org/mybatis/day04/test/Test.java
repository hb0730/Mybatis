package org.mybatis.day04.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.day04.bean.HobbyBean;
import org.mybatis.day04.bean.UserBean;
import org.mybatis.day04.dao.UserDaoInter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @className Test
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/2914:44
 * @Version: 1.0
 *
 */
public class Test {
    @org.junit.Test
    public void getUserBean() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        SqlSession sqlSession1 = build.openSession();
        try{
            /*UserDaoImpl userDao = new UserDaoImpl(build);
            List<UserBean> userBean = userDao.getUserBean(1);
            for (UserBean bean : userBean) {
                System.out.println(bean.getAccountId().getNumber());
            }*/
            UserDaoInter mapper = sqlSession.getMapper(UserDaoInter.class);
            List<UserBean> userBeans = mapper.getUserBean(1);
            for (UserBean bean : userBeans) {
                System.out.println(bean.getSex());
                System.out.println(bean.getAccountId().getNumber());
            }
            UserDaoInter mapper1 = sqlSession1.getMapper(UserDaoInter.class);
            List<UserBean> userBean = mapper1.getUserBean(1);
            for (UserBean bean : userBean) {
                System.out.println(bean.getSex());
                System.out.println(bean.getAccountId().getNumber());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            sqlSession.rollback();
        }finally {
            sqlSession.close();
            sqlSession1.close();
        }
    }
}
