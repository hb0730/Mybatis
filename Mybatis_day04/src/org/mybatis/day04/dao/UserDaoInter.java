package org.mybatis.day04.dao;

import org.mybatis.day04.bean.UserBean;

import java.util.List;

/**
 * The interface User dao inter.
 * @author bing_huang
 * @version 1.0.0
 */
public interface UserDaoInter {

    /**
     * Gets user bean.
     * @author bing_huang
     * @return the user bean
     */
    List<UserBean> getUserBean(int i);
}
