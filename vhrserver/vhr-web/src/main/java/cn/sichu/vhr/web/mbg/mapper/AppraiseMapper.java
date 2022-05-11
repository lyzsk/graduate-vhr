package cn.sichu.vhr.web.mbg.mapper;

import cn.sichu.vhr.web.mbg.model.Appraise;
import cn.sichu.vhr.web.mbg.model.AppraiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppraiseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    long countByExample(AppraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int deleteByExample(AppraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int insert(Appraise row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int insertSelective(Appraise row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    List<Appraise> selectByExample(AppraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    Appraise selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByExampleSelective(@Param("row") Appraise row, @Param("example") AppraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByExample(@Param("row") Appraise row, @Param("example") AppraiseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByPrimaryKeySelective(Appraise row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table appraise
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByPrimaryKey(Appraise row);
}