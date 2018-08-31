package org.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.Bean.TestBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @className Test
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/288:16
 * @Version: 1.0
 *
 */
public class Test {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession= sessionFactory.openSession();
                List<Integer> obj = sqlSession.selectList("org.mybatis.Bean.TestBean.getCount");
                System.out.println(obj.get(0));
                TestBean testBean=new TestBean();
                testBean.setId("1");
                List<TestBean> testBeans= sqlSession.selectList("org.mybatis.Bean.TestBean.getSelectForId", testBean);
                System.out.println(testBeans.get(0).getName());
                TestBean testBean1=new TestBean();
                testBean1.setId("2");
                testBean1.setName("李四");
                int i=   sqlSession.insert("org.mybatis.Bean.TestBean.insertBean", testBean1);
                System.out.println(i);
                int i1=sqlSession.update("org.mybatis.Bean.TestBean.updateForId",new TestBean("1", "王五") );
                System.out.println(i1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
