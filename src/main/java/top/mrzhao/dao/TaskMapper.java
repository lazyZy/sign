package top.mrzhao.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.mrzhao.entity.Task;
import top.mrzhao.entity.TaskExample;

import java.util.List;
@Component
public interface TaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    long countByExample(TaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int deleteByExample(TaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int insert(Task record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int insertSelective(Task record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    List<Task> selectByExample(TaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    Task selectByPrimaryKey(Integer taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Task record);
}