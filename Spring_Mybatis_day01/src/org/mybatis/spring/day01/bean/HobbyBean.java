package org.mybatis.spring.day01.bean;

import java.io.Serializable;

/**
 * @className HobbyBean
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/3014:58
 * @Version: 1.0
 *
 */
public class HobbyBean implements Serializable {
    private  int id;
    private  String name;
    private  String disc;
    private  int userId;

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

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
