package org.mybatis.spring.day02.service.impl;

import org.mybatis.spring.day02.bean.UserTestBean;
import org.mybatis.spring.day02.dao.inter.UserTestDaoInter;
import org.mybatis.spring.day02.service.inter.UserTestServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @className UserTestServiceImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/3015:07
 * @Version: 1.0
 *
 */
@Service("userTestServiceImpl")
public class UserTestServiceImpl implements UserTestServiceInter {
    @Autowired
    @Qualifier("userTestDaoInter")
    private UserTestDaoInter userTestDaoInter;

    public void setUserTestDaoInter(UserTestDaoInter userTestDaoInter) {
        this.userTestDaoInter = userTestDaoInter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserTestBean> getAllUserTest() {
        return userTestDaoInter.getAllUserTest();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserTestBean> getUserTestByName(String name) {
        return userTestDaoInter.getUserTestByName(name);
    }
    @Transactional(readOnly =false,propagation = Propagation.REQUIRED)
    @Override
    public void insertUserBeans(List<UserTestBean> userTestBeans) {
        userTestDaoInter.insertUserBeans(userTestBeans);
    }
    @Transactional(readOnly =false,propagation = Propagation.REQUIRED)
    @Override
    public void insertUserBean(UserTestBean userTestBean) {
        userTestDaoInter.insertUserBean(userTestBean);
    }
    @Transactional(readOnly =false,propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserBeanById(int id) {
        userTestDaoInter.deleteUserBeanById(id);
    }
    @Transactional(readOnly =false,propagation = Propagation.REQUIRED)
    @Override
    public void updateUserBeanById(UserTestBean userTestBean) {
        userTestDaoInter.updateUserBeanById(userTestBean);
    }
    @Transactional(readOnly =false,propagation = Propagation.REQUIRED)
    @Override
    public void updateUserBeansById(List<UserTestBean> userTestBeans) {
        userTestDaoInter.updateUserBeansById(userTestBeans);
    }
}
