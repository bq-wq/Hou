package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

/**
 * 2019/10/2911:07
 * <p>
 * 未知的事情 永远充满变数
 */
public interface UserDAO {

       User queryUsername(String username);




       //查询所有权限
    List<String> queryByUsername(String username);
}
