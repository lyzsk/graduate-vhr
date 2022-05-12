package cn.sichu.vhr.mapper;

import cn.sichu.vhr.model.Adjustsalary;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface AdjustsalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adjustsalary record);

    int insertSelective(Adjustsalary record);

    Adjustsalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Adjustsalary record);

    int updateByPrimaryKey(Adjustsalary record);
}