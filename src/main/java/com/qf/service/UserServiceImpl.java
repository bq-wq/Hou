package com.qf.service;

import com.qf.dao.UserDAO;
import com.qf.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2019/10/2911:27
 * <p>
 * 未知的事情 永远充满变数
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;
    @Override
    public User queryUsername(String username) {
        return userDAO.queryUsername(username);
    }

    @Override
    public List<String> queryByUsername(String username) {
        return userDAO.queryByUsername(username);
    }
}
