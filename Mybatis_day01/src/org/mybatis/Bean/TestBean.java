package org.mybatis.Bean;

/**
 * @className TestBean
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/288:55
 * @Version: 1.0
 *
 */
public class TestBean {
    private  String  id;
    private  String  name;

    public TestBean() {
    }

    public TestBean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
