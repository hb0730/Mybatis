package org.mybatis.spring.day02.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @className UserTestBean
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/3014:57
 * @Version: 1.0
 *
 */
public class UserTestBean implements Serializable {
    private int id;
    private  String name;
    private  String sex;
    private  AccountInfoBean accountInfoBean;
    private  List<HobbyBean> hobbyBeans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public AccountInfoBean getAccountInfoBean() {
        return accountInfoBean;
    }

    public void setAccountInfoBean(AccountInfoBean accountInfoBean) {
        this.accountInfoBean = accountInfoBean;
    }

    public List<HobbyBean> getHobbyBeans() {
        return hobbyBeans;
    }

    public void setHobbyBeans(List<HobbyBean> hobbyBeans) {
        this.hobbyBeans = hobbyBeans;
    }
}
