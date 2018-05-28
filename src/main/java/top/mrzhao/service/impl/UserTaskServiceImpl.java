package top.mrzhao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mrzhao.dao.UserTaskMapper;
import top.mrzhao.entity.UserTask;
import top.mrzhao.entity.UserTaskExample;
import top.mrzhao.service.UserTaskService;

/**
 * Created by ZY on 2018/5/28.
 */
@Service
public class UserTaskServiceImpl implements UserTaskService {
    Logger logger = LoggerFactory.getLogger(UserTaskServiceImpl.class);

    @Autowired
    UserTaskExample userTaskExample;
    @Autowired
    UserTaskMapper userTaskMapper;

    @Override
    public boolean InsertUserTask(UserTask userTask) {
        if(userTaskMapper.insertSelective(userTask) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean UpdateUserTask(Integer userTaskId, Integer status) {
        UserTask userTask = userTaskMapper.selectByPrimaryKey(userTaskId);
        userTask.setStatus(status);
        if(userTaskMapper.updateByPrimaryKeySelective(userTask) > 0){
            return true;
        }
        return false;
    }
}
