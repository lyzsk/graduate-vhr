package cn.sichu.vhr.web.mbg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sichu.vhr.web.mbg.model.JobLevel;

/**
 * 
 * @author sichu
 * @date 2022/05/12
 */
public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevels();

    Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids);
}