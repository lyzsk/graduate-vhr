package cn.sichu.vhr.web.mbg.mapper;

import org.apache.ibatis.annotations.Param;

import cn.sichu.vhr.web.mbg.model.MenuRole;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    void deleteByRid(Integer rid);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}