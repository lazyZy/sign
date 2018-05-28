package top.mrzhao.service;

import top.mrzhao.entity.Department;
import top.mrzhao.util.BaseResult;

/**
 * Created by ZY on 2018/5/27.
 */
public interface DepartmentService {
    Department SelectDepartmentById(Integer departmentId);
    boolean DeleteDepartmentById(Integer departmentId);
    boolean InsertDepartment(Department department);
    BaseResult SelectAllDepartment();
}
