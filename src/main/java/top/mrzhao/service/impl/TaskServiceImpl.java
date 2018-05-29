package top.mrzhao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mrzhao.dao.TaskMapper;
import top.mrzhao.entity.Task;
import top.mrzhao.entity.TaskExample;
import top.mrzhao.service.TaskService;
import top.mrzhao.util.BaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZY on 2018/5/28.
 */
@Service
public class TaskServiceImpl implements TaskService {
    Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TaskExample taskExample;

    @Override
    public boolean InsertTask(Task task) {
        logger.info("开始插入任务信息。。。。。。");
        logger.info("插入任务信息为：{}",task);
        if(taskMapper.insertSelective(task) > 0){
            return true;
        }
        return false;
    }

    @Override
    public BaseResult SelectAllTaskByStatus(Integer taskStatus) {
        logger.info("开始获取{}状态下所有任务。。。",taskStatus);
        taskExample.createCriteria().andTaskStatusEqualTo(taskStatus.byteValue());
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        taskExample.clear();
        return BaseResult.create(200,tasks,"获取数据成功");
    }

    @Override
    public BaseResult SelectTaskById(Integer taskId) {
        logger.info("开始获取ID为：{}的任务信息",taskId);
        Task task = taskMapper.selectByPrimaryKey(taskId);
        return BaseResult.create(200,task,"获取数据成功");
    }

    @Override
    public List<Task> SelectTaskByDepartmentId(Integer departmentId) {
        List<Integer> in = new ArrayList<>();
        in.add(0);
        in.add(departmentId);
        taskExample.createCriteria().andTaskStatusEqualTo((byte)1).andTaskDepartmentIdIn(in);
        List<Task> tasks = taskMapper.selectByExample(taskExample);
        return tasks;
    }

    @Override
    public boolean ChangeTaskStatus(Integer taskId, Integer taskStatus) {
        logger.info("开始更改ID为：{}的任务的状态，更改后的状态为：{}",taskId,taskStatus);
        Task task = taskMapper.selectByPrimaryKey(taskId);
        task.setTaskStatus(taskStatus.byteValue());
        if(taskMapper.updateByPrimaryKeySelective(task) > 0){
            return true;
        }
        return false;
    }
}
