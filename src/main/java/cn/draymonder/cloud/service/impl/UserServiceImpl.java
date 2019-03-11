package cn.draymonder.cloud.service.impl;

import cn.draymonder.cloud.dao.UserDao;
import cn.draymonder.cloud.entity.User;
import cn.draymonder.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @auther draymonder
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String username, String password) {
        return userDao.selectUserByUsernameAndPwd(username, password);
    }

    @Override
    public boolean createUser(String username, String password) {
        long times = System.currentTimeMillis();
        if(userDao.selectUserByUsername(username) >= 1)
            return false;
        if (userDao.insertUser(username, password, new Date(times), new Date(times)) >= 1)
            return true;
        return false;
    }

    @Override
    public boolean modifyUserPwd(String username, String oldPassword, String Password) {
        long times = System.currentTimeMillis();
        if (userDao.updateUser(username, oldPassword, Password, new Date(times)) >= 1)
            return true;
        return false;
    }
}
