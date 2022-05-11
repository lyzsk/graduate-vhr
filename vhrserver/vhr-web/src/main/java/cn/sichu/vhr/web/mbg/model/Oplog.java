package cn.sichu.vhr.web.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class Oplog implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oplog.id
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oplog.addDate
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    private Date adddate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oplog.operate
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    private String operate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oplog.hrid
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    private Integer hrid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table oplog
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oplog.id
     *
     * @return the value of oplog.id
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oplog.id
     *
     * @param id the value for oplog.id
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oplog.addDate
     *
     * @return the value of oplog.addDate
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public Date getAdddate() {
        return adddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oplog.addDate
     *
     * @param adddate the value for oplog.addDate
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oplog.operate
     *
     * @return the value of oplog.operate
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public String getOperate() {
        return operate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oplog.operate
     *
     * @param operate the value for oplog.operate
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public void setOperate(String operate) {
        this.operate = operate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oplog.hrid
     *
     * @return the value of oplog.hrid
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public Integer getHrid() {
        return hrid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oplog.hrid
     *
     * @param hrid the value for oplog.hrid
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oplog
     *
     * @mbg.generated Wed May 11 10:46:51 BST 2022
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adddate=").append(adddate);
        sb.append(", operate=").append(operate);
        sb.append(", hrid=").append(hrid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}