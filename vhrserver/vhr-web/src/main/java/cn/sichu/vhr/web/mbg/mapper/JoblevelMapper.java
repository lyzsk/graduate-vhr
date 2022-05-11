package cn.sichu.vhr.web.mbg.mapper;

import cn.sichu.vhr.web.mbg.model.Joblevel;
import cn.sichu.vhr.web.mbg.model.JoblevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JoblevelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    long countByExample(JoblevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int deleteByExample(JoblevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int insert(Joblevel row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int insertSelective(Joblevel row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    List<Joblevel> selectByExample(JoblevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    Joblevel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByExampleSelective(@Param("row") Joblevel row, @Param("example") JoblevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByExample(@Param("row") Joblevel row, @Param("example") JoblevelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByPrimaryKeySelective(Joblevel row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table joblevel
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    int updateByPrimaryKey(Joblevel row);
}