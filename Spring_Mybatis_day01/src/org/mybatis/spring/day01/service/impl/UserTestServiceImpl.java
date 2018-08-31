package org.mybatis.spring.day01.service.impl;

import org.mybatis.spring.day01.bean.UserTestBean;
import org.mybatis.spring.day01.dao.inter.UserTestDaoInter;
import org.mybatis.spring.day01.service.inter.UserTestServiceInter;

import java.util.List;

/**
 * @className UserTestServiceImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/3015:07
 * @Version: 1.0
 *
 */
public class UserTestServiceImpl implements UserTestServiceInter {
    private UserTestDaoInter userTestDaoInter;

    public void setUserTestDaoInter(UserTestDaoInter userTestDaoInter) {
        this.userTestDaoInter = userTestDaoInter;
    }

    @Override
    public List<UserTestBean> getAllUserTest() {
        return userTestDaoInter.getAllUserTest();
    }

    @Override
    public List<UserTestBean> getUserTestByName(String name) {
        return userTestDaoInter.getUserTestByName(name);
    }

    @Override
    public void insertUserBeans(List<UserTestBean> userTestBeans) {
        userTestDaoInter.insertUserBeans(userTestBeans);
    }

    @Override
    public void insertUserBean(UserTestBean userTestBean) {
        userTestDaoInter.insertUserBean(userTestBean);
    }

    @Override
    public void deleteUserBeanById(int id) {
        userTestDaoInter.deleteUserBeanById(id);
    }

    @Override
    public void updateUserBeanById(UserTestBean userTestBean) {
        userTestDaoInter.updateUserBeanById(userTestBean);
    }

    @Override
    public void updateUserBeansById(List<UserTestBean> userTestBeans) {
        userTestDaoInter.updateUserBeansById(userTestBeans);
    }
}
