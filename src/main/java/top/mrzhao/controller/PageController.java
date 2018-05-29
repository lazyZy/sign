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

    @RequestMapping("/info")
    public String toInfo() {
        return "info";
    }

    @RequestMapping("/task")
    public String toTask() {
        return "task";
    }

    @RequestMapping("/meeting")
    public String toMeeting() {
        return "meeting";
    }

    @RequestMapping("/checkMember")
    public String toCheckMember() {
        return "checkMember";
    }

    @RequestMapping("/adminRegister")
    public String toAdminRegister() {
        return "adminRegister";
    }

    @RequestMapping("/member")
    public String toMember() {
        return "member";
    }

}
