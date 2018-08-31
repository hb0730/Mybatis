package org.mybatis.spring.day01.test;

import org.mybatis.spring.day01.bean.UserTestBean;
import org.mybatis.spring.day01.service.impl.UserTestServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @className Test
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/3016:37
 * @Version: 1.0
 *
 */
public class Test {
    @org.junit.Test
    public void getAllUserTestBean(){
        ApplicationContext pathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserTestServiceImpl serviceImpl = pathXmlApplicationContext.getBean("serviceImpl",UserTestServiceImpl.class);
        List<UserTestBean> allUserTest = serviceImpl.getAllUserTest();
        for (UserTestBean userTestBean : allUserTest) {
            System.out.println(userTestBean.getSex());
            System.out.println(userTestBean.getAccountInfoBean().getNumber());
            System.out.println(userTestBean.getHobbyBeans().get(0).getName());
        }
    }
    @org.junit.Test
    public void getAllUserTestBeanByName(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserTestServiceImpl serviceImpl =(UserTestServiceImpl) applicationContext.getBean("serviceImpl");
        List<UserTestBean> userTestByName = serviceImpl.getUserTestByName("%王%");
        for (UserTestBean userTestBean : userTestByName) {
            System.out.println(userTestBean.getName()+userTestBean.getAccountInfoBean().getNumber()+userTestBean.getHobbyBeans().get(0).getName());
        }
    }
    @org.junit.Test
    public void insertUserTestBeans(){
        ApplicationContext pathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserTestServiceImpl serviceImpl = pathXmlApplicationContext.getBean("serviceImpl",UserTestServiceImpl.class);
        List<UserTestBean> userTestBeans=new ArrayList();
        for (int i = 0; i < 5; i++) {
            UserTestBean userTestBean=new UserTestBean();
            userTestBean.setName("测试"+i);
            userTestBean.setSex("男");
            userTestBeans.add(userTestBean);
        }
        serviceImpl.insertUserBeans(userTestBeans);
    }
    @org.junit.Test
    public void insertUserTestBean(){
        ApplicationContext pathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserTestServiceImpl serviceImpl = pathXmlApplicationContext.getBean("serviceImpl",UserTestServiceImpl.class);
        UserTestBean userTestBean =new UserTestBean();
        userTestBean.setSex("男");
        userTestBean.setName("测试实现1");
        serviceImpl.insertUserBean(userTestBean);
    }


}
