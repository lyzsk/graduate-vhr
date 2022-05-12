package cn.sichu.vhr.mapper;

import cn.sichu.vhr.model.SysMsg;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface SysmsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMsg record);

    int insertSelective(SysMsg record);

    SysMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMsg record);

    int updateByPrimaryKey(SysMsg record);
}