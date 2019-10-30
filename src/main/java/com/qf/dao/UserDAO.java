package com.qf.dao;

import com.qf.pojo.Menu;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

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

    List<Menu> queryAllPermissionByUsername(String username);

    List<Menu> queryMenuOneChild(@Param("menu_id") Integer menu_id,@Param("username") String username);
}
