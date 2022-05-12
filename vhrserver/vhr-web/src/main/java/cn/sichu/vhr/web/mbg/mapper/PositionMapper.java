package cn.sichu.vhr.web.mbg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sichu.vhr.web.mbg.model.Position;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface PositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPositions();

    Integer deletePositionsByIds(@Param("ids") Integer[] ids);
}