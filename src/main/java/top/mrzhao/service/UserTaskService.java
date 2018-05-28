package top.mrzhao.service;

import top.mrzhao.entity.UserTask;

/**
 * Created by ZY on 2018/5/27.
 */
public interface UserTaskService {
    boolean InsertUserTask(UserTask userTask);

    boolean UpdateUserTask(Integer userTaskId,Integer status);
}
