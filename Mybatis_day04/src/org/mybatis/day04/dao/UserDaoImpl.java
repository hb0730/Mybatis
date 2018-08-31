package org.mybatis.day04.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.day04.bean.UserBean;

import java.util.List;

/**
 * @className UserDaoImpl
 * @Description: (这里用一句话描述这个类的作用)
 * @author: bing_huang
 * @Date: 2018/8/308:30
 * @Version: 1.0
 *
 */
public class UserDaoImpl implements UserDaoInter {
    private SqlSessionFactory sqlSessionFactory;
    public  UserDaoImpl(SqlSessionFactory sqlSessionFactory ){
        super();
        this.sqlSessionFactory=sqlSessionFactory;
    }
    @Override
    public List<UserBean> getUserBean(int i) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDaoInter mapper = sqlSession.getMapper(UserDaoInter.class);
        return mapper.getUserBean(i);
    }
}
