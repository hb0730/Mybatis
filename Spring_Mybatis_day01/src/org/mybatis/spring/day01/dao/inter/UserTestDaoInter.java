package org.mybatis.spring.day01.dao.inter;

import org.mybatis.spring.day01.bean.UserTestBean;

import java.util.List;

public interface UserTestDaoInter {
    List<UserTestBean> getAllUserTest();
    List<UserTestBean> getUserTestByName(String name);
    void insertUserBeans(List<UserTestBean> userTestBeans);
    void insertUserBean(UserTestBean userTestBean);
    void  deleteUserBeanById(int id);
    void  updateUserBeanById(UserTestBean userTestBean);
    void  updateUserBeansById(List<UserTestBean> userTestBeans);
}
