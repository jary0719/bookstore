package edu.suse.bookstore.mapper;

import edu.suse.bookstore.domain.Permission;
import edu.suse.bookstore.domain.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper extends PermissionMapperExt {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    long countByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int deleteByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int deleteByPrimaryKey(Integer perId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int insert(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int insertSelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    Permission selectByPrimaryKey(Integer perId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    int updateByPrimaryKey(Permission record);
}