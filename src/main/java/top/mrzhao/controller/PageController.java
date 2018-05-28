package top.mrzhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZY on 2018/5/26.
 */
@Controller
@RequestMapping("")
public class PageController {

    @RequestMapping("")
    public String defaultIndex() {
        return "login";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }
}
