package cn.sichu.vhr.mapper;

import cn.sichu.vhr.model.EmpSalary;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface EmpSalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmpSalary record);

    int insertSelective(EmpSalary record);

    EmpSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpSalary record);

    int updateByPrimaryKey(EmpSalary record);
}