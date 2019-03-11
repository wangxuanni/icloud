package cn.draymonder.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther draymonder
 */
@Controller
public class FrontController {

    @RequestMapping("/signin")
    public String signIn() {
        return "signin.html";
    }

    @RequestMapping("/404")
    public String error() {
        return "404.html";
    }

    @RequestMapping("/upload")
    public String upload() {
        return "upload.html";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin.html";
    }

    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }
}
