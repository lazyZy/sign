package top.mrzhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mrzhao.entity.User;
import top.mrzhao.pojo.LoginPojo;
import top.mrzhao.service.DepartmentService;
import top.mrzhao.service.TokenService;
import top.mrzhao.service.UserService;
import top.mrzhao.util.BaseResult;

/**
 * Created by ZY on 2018/5/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/login")
    @ResponseBody
    public BaseResult toLogin(@RequestBody LoginPojo loginPojo) {
        User user = userService.UserLogin(loginPojo.getUserName(),loginPojo.getPwd());
        if(null != user){
            String token = tokenService.SetUserLoginInfo(user);
            return BaseResult.create(200,token,"登陆成功");
        }
        return BaseResult.createFail(400, "登录失败");
    }

    @RequestMapping("/register")
    @ResponseBody
    public BaseResult toRegister(@RequestBody User user) {
        return userService.UserRegister(user);
    }

    @RequestMapping("/getInfoByToken")
    @ResponseBody
    public BaseResult getInfoByToken(@RequestParam String token) {
        return tokenService.GetUserLoginInfo(token);
    }

    @RequestMapping("/getDepartmentInfoById")
    @ResponseBody
    public BaseResult getDepartmentInfoById(@RequestParam Integer departmentId) {
        return BaseResult.create(200,departmentService.SelectDepartmentById(departmentId),"ok");
    }
}
