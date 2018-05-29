package top.mrzhao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mrzhao.dao.UserMapper;
import top.mrzhao.entity.User;
import top.mrzhao.entity.UserExample;
import top.mrzhao.service.UserService;
import top.mrzhao.util.BaseResult;

import java.util.List;

/**
 * Created by ZY on 2018/5/27.
 */
@Service
public class UserServiceImpl implements UserService {
    protected Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserExample userExample;
    @Autowired
    UserMapper userMapper;

    @Override
    public User UserLogin(String userName, String userPwd) {
        userExample.clear();
        logger.info("正在进行登录验证。。。。。。");
        userExample.createCriteria().andEmployeeNumberEqualTo(userName).andUserPwdEqualTo(userPwd).andUserStatusGreaterThanOrEqualTo(1);
        if(userMapper.selectByExample(userExample).size() > 0){
            logger.info("用户登陆成功!");
            return userMapper.selectByExample(userExample).get(0);
        }
        userExample.clear();
        userExample.createCriteria().andUserAccountEqualTo(userName).andUserPwdEqualTo(userPwd).andUserStatusGreaterThanOrEqualTo(1);
        if(userMapper.selectByExample(userExample).size() > 0){
            logger.info("用户登陆成功!");
            return userMapper.selectByExample(userExample).get(0);
        }
        userExample.clear();
        logger.info("用户登录失败！");
        return null;
    }

    @Override
    public BaseResult UserRegister(User user) {
        logger.info("进入用户注册。。。。。。");
        if(null != user.getUserId() && userMapper.updateByPrimaryKey(user) > 0){
            return BaseResult.createOk("个人信息修改成功");
        }
        String userAccount = user.getUserAccount();
        String employeeNumber = user.getEmployeeNumber();
        userExample.createCriteria().andUserAccountEqualTo(userAccount).andUserStatusNotEqualTo(-1);
        if(userMapper.selectByExample(userExample).size() > 0){
            userExample.clear();
            return BaseResult.createFail(400,"账户已存在");
        }
        userExample.createCriteria().andEmployeeNumberEqualTo(employeeNumber).andUserStatusNotEqualTo(-1);
        if(null != employeeNumber && userMapper.selectByExample(userExample).size() > 0){
            userExample.clear();
            return BaseResult.createFail(400,"工号已存在");
        }
        userExample.clear();
        if(userMapper.insertSelective(user) > 0){
            return BaseResult.createOk("个人信息添加成功");
        }
        return BaseResult.createBadRequest();
    }

    @Override
    public BaseResult UserPass(User user) {
        logger.info("进入用户过审。。。。。。");
        if(user.getUserId() > 0 && userMapper.updateByPrimaryKey(user) > 0){
            return BaseResult.createOk("已通过审核");
        }
        return BaseResult.createBadRequest();
    }

    @Override
    public boolean UserRefuse(Integer userId) {
        logger.info("进入用户拒审。。。。。。");
        User user = userMapper.selectByPrimaryKey(userId);
        if(null == user){
            return false;
        }
        user.setUserStatus(-1);
        return true;
    }


    @Override
    public BaseResult UserInfo() {
        logger.info("进入获取所有用户信息。。。。。。");
        userExample.createCriteria().andUserStatusNotEqualTo(-1);
        List<User> users = userMapper.selectByExample(userExample);
        userExample.clear();
        return BaseResult.create(200,users,"获取所有用户信息成功！");
    }

    @Override
    public BaseResult UserInfoById(Integer userId) {
        logger.info("进入获取用户信息，获取的用户id为：{}",userId);
        User user = userMapper.selectByPrimaryKey(userId);
        return BaseResult.create(200,user,"获取单个用户信息成功！");
    }

    @Override
    public List<User> SelectUserByDepartmentId(Integer departmentId) {
        if(departmentId == 0){
            return (List<User>)UserInfo().getData();
        }
        userExample.createCriteria().andUserDepartmentIdEqualTo(departmentId).andUserStatusGreaterThan(0);
        List<User> users = userMapper.selectByExample(userExample);
        userExample.clear();
        return users;
    }
}
