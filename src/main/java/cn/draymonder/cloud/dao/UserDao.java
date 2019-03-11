package cn.draymonder.cloud.dao;

import cn.draymonder.cloud.entity.User;
import org.apache.ibatis.annotations.*;

import java.sql.Date;

/**
 * 用户增加和查询和修改
 * @auther draymonder
 */
@Mapper
public interface UserDao {

    @Select("select count(*) from user where username=#{username}")
    public int selectUserByUsername(@Param("username") String username);
    /**
     * 根据{username}和{password} 查询系统存在账户
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username=#{username} and password=#{password}")
    public User selectUserByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 新增账户 {username} {password} {createTime} {lastEditTime}
     * @param username
     * @param password
     * @param createTime
     * @param lastEditTime
     * @return
     */
    @Insert("insert into user(username, password, create_time, last_edit_time) values(#{username}, #{password}," +
            "#{createTime}, #{lastEditTime})")
    public int insertUser(@Param("username") String username, @Param("password")String password,
                          @Param("createTime")Date createTime, @Param("lastEditTime")Date lastEditTime);

    @Insert("insert into user(username, password, create_time, last_edit_time) values(#{username}, #{password}," +
            "#{createTime}, #{lastEditTime})")
    public int inserUser(User user);
    /**
     * 更新账户密码
     * @param username
     * @param oldpPassword
     * @param newpassword
     * @param lastEditTime
     * @return
     */
    @Update("update user \n" +
            "set `password` = #{newpassword} , `last_edit_time` = #{lastEditTime} \n" +
            "where `username` = #{username} and `password` = #{oldpassword};\n")
    public int updateUser(@Param("username") String username, @Param("oldpassword")String oldpPassword,
                          @Param("newpassword")String newpassword,@Param("lastEditTime")Date lastEditTime);
}
