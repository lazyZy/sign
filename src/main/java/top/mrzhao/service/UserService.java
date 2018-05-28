package top.mrzhao.service;

import top.mrzhao.entity.User;
import top.mrzhao.util.BaseResult;

import java.util.List;

/**
 * Created by ZY on 2018/5/27.
 */
public interface UserService {
    //登录验证
    User UserLogin(String userName, String userPwd);
    //注册用户
    BaseResult UserRegister(User user);
    //管理员审核通过用户&&修改个人信息
    BaseResult UserPass(User user);
    //管理员不通过用户
    boolean UserRefuse(Integer userId);
    //查看所有用户信息
    BaseResult UserInfo();
    //查看某位用户信息
    BaseResult UserInfoById(Integer userId);

    List<User> SelectUserByDepartmentId(Integer departmentId);
}
