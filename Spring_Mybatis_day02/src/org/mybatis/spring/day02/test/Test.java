package org.mybatis.spring.day02.test;

import org.mybatis.spring.day02.bean.UserTestBean;
import org.mybatis.spring.day02.service.impl.UserTestServiceImpl;
import org.mybatis.spring.day02.service.inter.UserTestServiceInter;
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
        UserTestServiceImpl serviceImpl = pathXmlApplicationContext.getBean("userTestServiceImpl",UserTestServiceImpl.class);
        List<UserTestBean> allUserTest = serviceImpl.getAllUserTest();
        for (UserTestBean userTestBean : allUserTest) {
            System.out.println(userTestBean.getSex());
            System.out.println(userTestBean.getAccountInfoBean().getNumber());
            System.out.println(userTestBean.getHobbyBeans().get(0).getName());
        }

    }
}
