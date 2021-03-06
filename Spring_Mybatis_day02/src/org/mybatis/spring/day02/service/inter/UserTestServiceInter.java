package org.mybatis.spring.day02.service.inter;

import org.mybatis.spring.day02.bean.UserTestBean;

import java.util.List;

public interface UserTestServiceInter {
    List<UserTestBean> getAllUserTest();
    List<UserTestBean> getUserTestByName(String name);
    void insertUserBeans(List<UserTestBean> userTestBeans);
    void insertUserBean(UserTestBean userTestBean);
    void  deleteUserBeanById(int id);
    void  updateUserBeanById(UserTestBean userTestBean);
    void  updateUserBeansById(List<UserTestBean> userTestBeans);
}
