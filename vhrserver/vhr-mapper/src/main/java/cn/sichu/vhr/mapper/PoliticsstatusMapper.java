package cn.sichu.vhr.mapper;

import java.util.List;

import cn.sichu.vhr.model.Politicsstatus;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
// @Mapper
public interface PoliticsstatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);

    List<Politicsstatus> getAllPoliticsstatus();
}