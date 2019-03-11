package cn.draymonder.cloud.controller;

import cn.draymonder.cloud.entity.User;
import cn.draymonder.cloud.service.UserService;
import cn.draymonder.cloud.utils.HttpServletRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther draymonder
 */
@RequestMapping("user")
@RestController
public class UserController {
    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public Map<String, Object> getUser(HttpServletRequest req) {
        Map<String, Object> map = new HashMap<>();
        String name = HttpServletRequestUtil.getString(req, "username");
        String pwd = HttpServletRequestUtil.getString(req, "password");
        logger.info("name : " + name + " pwd: " + pwd);
        User user = null;
        if ((user = userService.getUser(name, pwd)) != null) {
            map.put("success", true);
            map.put("user", user);
            req.getSession().setAttribute("user", user);
        } else {
            map.put("success", false);
        }
//        map.put("user",userService.getUser(name, pwd));
//        System.out.println(map);
        return map;
    }

    @RequestMapping("/update")
    public Map<String, Object> updateUser(HttpServletRequest req) {
        Map<String, Object> map = new HashMap<>();
        String name = HttpServletRequestUtil.getString(req, "username");
        String oldPwd = HttpServletRequestUtil.getString(req, "oldPassword");
        String newPwd = HttpServletRequestUtil.getString(req, "newPwd");
        if(userService.modifyUserPwd(name,oldPwd,newPwd) == true) {
            map.put("success", true);
        } else
            map.put("success", false);
        return map;
    }


    @RequestMapping("/register")
    public Map<String, Object> createUser(HttpServletRequest req) {
        Map<String, Object> map = new HashMap<>();
        String name = HttpServletRequestUtil.getString(req, "username");
        String pwd = HttpServletRequestUtil.getString(req, "password");
        if(userService.createUser(name, pwd) == true) {
            map.put("success", true);
        } else
            map.put("success", false);
        return map;
    }
}
