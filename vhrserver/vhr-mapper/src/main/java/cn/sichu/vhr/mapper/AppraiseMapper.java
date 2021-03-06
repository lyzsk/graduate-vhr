package cn.sichu.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.sichu.vhr.model.Appraise;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface AppraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}