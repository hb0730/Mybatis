package org.mybatis.day03.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.day03.bean.UserBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
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
        try{
            List<UserBean> userBeans = sqlSession.selectList("Bean.getUserBean",1);
            Iterator<UserBean> iterator = userBeans.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
}
