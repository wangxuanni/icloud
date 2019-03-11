package cn.draymonder.cloud.dao;

import cn.draymonder.cloud.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

/**
 * @auther draymonder
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Ignore
    public void testSelectUserByUsernameAndPwd() {
        User user = userDao.selectUserByUsernameAndPwd("root", "admin");
        System.out.println(user);
    }

    @Test
    @Ignore
    public void testInsertUser() {
        long times = System.currentTimeMillis();
        int effectedNum = userDao.insertUser("ixiaobing","ixiaobing",new Date(times), new Date(times));
        System.out.println(effectedNum);
    }

    @Test
    @Ignore
    public void testInsertUser1() {
        long times = System.currentTimeMillis();
        User user = new User(11, "ixiaobing1","ixiaobing1",new Date(times), new Date(times));
        System.out.println(userDao.inserUser(user));
    }

    @Test
    @Ignore
    public void testupdateUser() {
        long times = System.currentTimeMillis();
        User user = new User(11, "ixiaobing1","ixiaobing1",new Date(times), new Date(times));
        int effectedNum = userDao.updateUser(user.getusername(),user.getPassword(),"ixiaobing",user.getLastEditTime());
        System.out.println(effectedNum);
    }

    @Test
    @Ignore
    public void testSelectname() {
        int effectedNum = userDao.selectUserByUsername("root");
        System.out.println(effectedNum);
    }
}
