package top.mrzhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.mrzhao.entity.User;
import top.mrzhao.pojo.LoginPojo;
import top.mrzhao.service.TaskService;
import top.mrzhao.util.BaseResult;

/**
 * Created by ZY on 2018/5/29.
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping("/login")
    @ResponseBody
    public BaseResult toLogin(@RequestBody LoginPojo loginPojo) {

        return BaseResult.createFail(400, "登录失败");
    }
}
