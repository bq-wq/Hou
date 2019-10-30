package com.qf.service;

import com.qf.pojo.Menu;
import com.qf.pojo.User;

import java.util.List;

/**
 * 2019/10/2911:26
 * <p>
 * 未知的事情 永远充满变数
 */
public interface UserService {
    User queryUsername(String username);

    List<String> queryByUsername(String username);

    List<Menu> queryAllPermissionByUsername(String username);

    List<Menu> queryMenuOneChild(Integer menu_id, String username);
}
