package org.mybatis.day03.bean;

import java.util.List;

/**
 * @className UserBean
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/2914:44
 * @Version: 1.0
 *
 */
public class UserBean {
    private int id;
    private String name;
    private  String sex;
    private  AccountInfoBean accountId;
    private List<HobbyBean> hobbyBeans;

    public AccountInfoBean getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountInfoBean accountId) {
        this.accountId = accountId;
    }

    public List<HobbyBean> getHobbyBeans() {
        return hobbyBeans;
    }

    public void setHobbyBeans(List<HobbyBean> hobbyBeans) {
        this.hobbyBeans = hobbyBeans;
    }

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

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", accountId=" + accountId.getNumber() +
                ", hobbyBeansSize=" + hobbyBeans.size()+
                '}';
    }
}
