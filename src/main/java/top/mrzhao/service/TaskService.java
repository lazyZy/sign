package top.mrzhao.service;

import top.mrzhao.entity.Task;
import top.mrzhao.util.BaseResult;

/**
 * Created by ZY on 2018/5/27.
 */
public interface TaskService {
    boolean InsertTask(Task task);

    BaseResult SelectAllTaskByStatus(Integer taskStatus);

    BaseResult SelectTaskById(Integer taskId);

    boolean ChangeTaskStatus(Integer taskId,Integer taskStatus);

}
