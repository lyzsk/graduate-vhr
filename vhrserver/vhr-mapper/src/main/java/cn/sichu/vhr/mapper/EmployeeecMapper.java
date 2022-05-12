package cn.sichu.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.sichu.vhr.model.Employeeec;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);
}