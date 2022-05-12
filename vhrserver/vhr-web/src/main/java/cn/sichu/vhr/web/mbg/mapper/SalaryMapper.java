package cn.sichu.vhr.web.mbg.mapper;

import java.util.List;

import cn.sichu.vhr.web.mbg.model.Salary;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaries();
}