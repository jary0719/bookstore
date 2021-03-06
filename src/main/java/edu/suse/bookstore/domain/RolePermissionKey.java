package edu.suse.bookstore.domain;

import java.io.Serializable;

public class RolePermissionKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fk_role_per.role_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fk_role_per.per_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private Integer perId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table fk_role_per
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fk_role_per.role_id
     *
     * @return the value of fk_role_per.role_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fk_role_per.role_id
     *
     * @param roleId the value for fk_role_per.role_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fk_role_per.per_id
     *
     * @return the value of fk_role_per.per_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public Integer getPerId() {
        return perId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fk_role_per.per_id
     *
     * @param perId the value for fk_role_per.per_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setPerId(Integer perId) {
        this.perId = perId;
    }
}