package org.mybatis.day02.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.day02.bean.UserBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

/**
 * @className Test
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/298:29
 * @Version: 1.0
 *
 */
public class Test {
    /**
     * 得到userBean
     * @throws IOException
     */
    @org.junit.Test
    public void getUserBean() throws IOException {
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            List<UserBean> userList = sqlSession.selectList("Bean.findUserBeanAll");
            Iterator<UserBean> iterator = userList.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 根据ID获取userBean
     * @throws IOException
     */
    @org.junit.Test
    public  void getUserBeanById()throws IOException{
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            UserBean userBean = sqlSession.selectOne("Bean.findUserBeanById", 1);
            System.out.println(userBean);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 根据名称获取
     * @throws IOException
     */
    @org.junit.Test
    public  void  getUserBeanByName()throws IOException{
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            List<UserBean> userBean = sqlSession.selectList("Bean.findUserBeanByName", "%"+"小"+"%");
            Iterator<UserBean> iterator = userBean.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 插入userBean
     * @throws IOException
     */
    @org.junit.Test
    public  void insertUserBean()throws IOException{
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            UserBean userBean=new UserBean();
            userBean.setName("王五五");
            userBean.setSex("男");
            sqlSession.insert("Bean.insertUserBean",userBean);
            System.out.println("userBean的id"+userBean.getId());
            sqlSession.commit();
        }catch(Exception e){
            sqlSession.rollback();
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 批量插入UserBean
     * @throws IOException
     */
    @org.junit.Test
    public  void insertListUserBean() throws IOException{
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            List list = new ArrayList();
            for (int i = 0; i <5; i++) {
                UserBean userBean = new UserBean();
                userBean.setSex("男");
                userBean.setName("小小"+i+"号");
                list.add(userBean);
            }
            sqlSession.insert("Bean.insertListUserBean",list);
            Iterator<UserBean> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next().getId());
            }

        }catch(Exception e){
            sqlSession.rollback();
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 根据ID修改
     * @throws IOException
     */
    @org.junit.Test
    public  void updateUserBeanById() throws  IOException{
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            UserBean userBean = new UserBean();
            userBean.setId(1);
            userBean.setName("xiaoxiao");
            userBean.setSex("女");
            sqlSession.update("Bean.updateUserBeanById", userBean);

        }catch(Exception e){
            sqlSession.rollback();
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 根据Id批量修改
     * @throws IOException
     */
    @org.junit.Test
    public void  updateListUserBeanById()throws IOException{
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            List list=new ArrayList();
            for (int i = 1; i <=5 ; i++) {
                UserBean userBean=new UserBean();
                userBean.setId(i);
                userBean.setName("修改"+i);
                userBean.setSex("男");
                list.add(userBean);
            }
            sqlSession.update("Bean.updateListUserBeanById", list);

        }catch(Exception e){
            sqlSession.rollback();
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 根据id删除
     * @throws IOException
     */
    @org.junit.Test
    public void deleteUserBeanById() throws IOException {
        InputStream inputStream= getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession= build.openSession();
        try{
            sqlSession.delete("Bean.deleteUserBeanById", 10);

        }catch(Exception e){
            sqlSession.rollback();
            System.out.println(e.getMessage());
        }finally {
            sqlSession.close();
        }
    }
}
