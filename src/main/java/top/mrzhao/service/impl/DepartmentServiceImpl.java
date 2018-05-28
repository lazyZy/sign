package top.mrzhao.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mrzhao.dao.DepartmentMapper;
import top.mrzhao.entity.Department;
import top.mrzhao.entity.DepartmentExample;
import top.mrzhao.service.DepartmentService;
import top.mrzhao.util.BaseResult;

import java.util.List;

/**
 * Created by ZY on 2018/5/28.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    DepartmentExample departmentExample;

    @Override
    public Department SelectDepartmentById(Integer departmentId) {
        logger.info("通过ID查询部门。。。。。。");
        Department department = departmentMapper.selectByPrimaryKey(departmentId);
        if(null != department){
            logger.info("获取数据成功");
            return department;
        }
        return null;
    }

    @Override
    public boolean DeleteDepartmentById(Integer departmentId) {
        logger.info("通过ID删除部门。。。。。。");
        if(departmentMapper.deleteByPrimaryKey(departmentId) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean InsertDepartment(Department department) {
        logger.info("插入部门。。。。。。");
        if(departmentMapper.insertSelective(department) > 0){
            return true;
        }
        return false;
    }

    @Override
    public BaseResult SelectAllDepartment() {
        departmentExample.createCriteria().andDepartmentIdIsNotNull();
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        return BaseResult.create(200,departments,"获取数据成功");
    }
}
