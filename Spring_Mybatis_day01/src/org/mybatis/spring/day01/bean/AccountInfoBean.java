package org.mybatis.spring.day01.bean;

import java.io.Serializable;

/**
 * @className AccountInfoBean
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/3014:59
 * @Version: 1.0
 *
 */
public class AccountInfoBean implements Serializable {
    private  int id;
    private  String number;
    private  String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
