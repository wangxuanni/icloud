package cn.draymonder.cloud.service;

import cn.draymonder.cloud.entity.User;

/**
 * @auther draymonder
 */
public interface UserService {
    /**
     * 获取相应用户
     * @param username
     * @param password
     * @return
     */
    public User getUser(String username, String password);

    /**
     * 创建账户
     * @param username
     * @param password
     * @return
     */
    public boolean createUser(String username, String password);

    /**
     * 更改用户密码
     * @param username
     * @param oldPassword
     * @param Password
     * @return
     */
    public boolean modifyUserPwd(String username, String oldPassword, String Password);
}
