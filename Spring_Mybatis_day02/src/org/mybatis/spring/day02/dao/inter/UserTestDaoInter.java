package org.mybatis.spring.day02.dao.inter;

import org.mybatis.spring.day02.bean.UserTestBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userTestDaoInter")
public interface UserTestDaoInter {
    List<UserTestBean> getAllUserTest();
    List<UserTestBean> getUserTestByName(String name);
    void insertUserBeans(List<UserTestBean> userTestBeans);
    void insertUserBean(UserTestBean userTestBean);
    void  deleteUserBeanById(int id);
    void  updateUserBeanById(UserTestBean userTestBean);
    void  updateUserBeansById(List<UserTestBean> userTestBeans);
}
