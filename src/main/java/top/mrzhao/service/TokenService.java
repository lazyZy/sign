package top.mrzhao.service;

import top.mrzhao.entity.User;
import top.mrzhao.util.BaseResult;

/**
 * Created by ZY on 2018/5/27.
 */
public interface TokenService {
    String SetUserLoginInfo(User user);
    String SetUserLoginInfo(String token,User user);
    BaseResult GetUserLoginInfo(String token);
}
