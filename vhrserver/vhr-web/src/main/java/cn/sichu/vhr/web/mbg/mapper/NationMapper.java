package cn.sichu.vhr.web.mbg.mapper;

import java.util.List;

import cn.sichu.vhr.web.mbg.model.Nation;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();
}