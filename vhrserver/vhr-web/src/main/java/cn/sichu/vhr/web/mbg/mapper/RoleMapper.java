package cn.sichu.vhr.web.mbg.mapper;

import java.util.List;

import cn.sichu.vhr.web.mbg.model.Role;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles();
}