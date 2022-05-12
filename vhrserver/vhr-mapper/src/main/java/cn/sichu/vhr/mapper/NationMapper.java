package cn.sichu.vhr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sichu.vhr.model.Nation;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();
}