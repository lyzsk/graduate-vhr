package cn.sichu.vhr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sichu.vhr.model.Salary;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaries();
}