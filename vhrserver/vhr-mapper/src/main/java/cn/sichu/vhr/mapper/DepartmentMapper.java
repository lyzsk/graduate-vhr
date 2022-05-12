package cn.sichu.vhr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.sichu.vhr.model.Department;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
@Mapper
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}