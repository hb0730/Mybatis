package org.mybatis.day05.dao;

import org.apache.ibatis.annotations.*;
import org.mybatis.day05.bean.AccountInfoBean;
import org.mybatis.day05.bean.HobbyBean;
import org.mybatis.day05.bean.UserBean;

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
    @Select(" SELECT *FROM userTest WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id",column = "id",id = true),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex",id = true),
            @Result(property = "accountId",column ="accountId",
                    one = @One(select = "org.mybatis.day05.dao.UserDaoInter.getAccountInfo")),
            @Result(property = "hobbyBeans",column = "id",
                    many = @Many(select = "org.mybatis.day05.dao.UserDaoInter.getHobbyBean")
            )
    })
    List<UserBean> getUserBean(@Param("id") int i);

    @Select("SELECT *FROM hobby WHERE userId=#{userId}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "disc",column = "disc"),
            @Result(property = "userId",column = "userId")
    })
    List<HobbyBean> getHobbyBean(@Param("userId") int userId);
    @Select("SELECT *FROM accountInfo WHERE id=#{id}")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "number",column = "number"),
            @Result(property = "password",column = "password")
    })
    AccountInfoBean getAccountInfo(@Param("id") int id);
}
