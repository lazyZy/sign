package top.mrzhao.service;

import top.mrzhao.entity.Task;
import top.mrzhao.util.BaseResult;

import java.util.List;

/**
 * Created by ZY on 2018/5/27.
 */
public interface TaskService {
    boolean InsertTask(Task task);

    BaseResult SelectAllTaskByStatus(Integer taskStatus);

    BaseResult SelectTaskById(Integer taskId);

    List<Task> SelectTaskByDepartmentId(Integer departmentId);

    boolean ChangeTaskStatus(Integer taskId,Integer taskStatus);

}
