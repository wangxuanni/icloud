package cn.draymonder.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther draymonder
 */
@Controller
public class Auth {

    @RequestMapping("/auth")
    @ResponseBody
    public String auth() {
        return "Auth: draymonder<br> Email: 93958042@qq.com";

    }
}
