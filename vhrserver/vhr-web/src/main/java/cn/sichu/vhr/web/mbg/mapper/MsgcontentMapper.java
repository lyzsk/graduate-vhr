package cn.sichu.vhr.web.mbg.mapper;

import cn.sichu.vhr.web.mbg.model.Msgcontent;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface MsgcontentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Msgcontent record);

    int insertSelective(Msgcontent record);

    Msgcontent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msgcontent record);

    int updateByPrimaryKey(Msgcontent record);
}