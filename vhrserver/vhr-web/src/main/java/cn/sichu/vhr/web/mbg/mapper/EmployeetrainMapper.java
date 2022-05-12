package cn.sichu.vhr.web.mbg.mapper;

import cn.sichu.vhr.web.mbg.model.Employeetrain;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface EmployeetrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);

    Employeetrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeetrain record);

    int updateByPrimaryKey(Employeetrain record);
}