package cn.sichu.vhr.web.mbg.mapper;

import cn.sichu.vhr.web.mbg.model.Employeeec;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}