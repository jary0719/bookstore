package edu.suse.bookstore.domain;

import java.io.Serializable;

public class Permission extends PermissionExt implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_permission.per_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private Integer perId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_permission.pt_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private Integer ptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_permission.permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private String permission;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_permission.display_name
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private String displayName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_permission.url
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_permission.type_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private Integer typeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_permission.per_id
     *
     * @return the value of bs_permission.per_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public Integer getPerId() {
        return perId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_permission.per_id
     *
     * @param perId the value for bs_permission.per_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_permission.pt_id
     *
     * @return the value of bs_permission.pt_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public Integer getPtId() {
        return ptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_permission.pt_id
     *
     * @param ptId the value for bs_permission.pt_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setPtId(Integer ptId) {
        this.ptId = ptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_permission.permission
     *
     * @return the value of bs_permission.permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_permission.permission
     *
     * @param permission the value for bs_permission.permission
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_permission.display_name
     *
     * @return the value of bs_permission.display_name
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_permission.display_name
     *
     * @param displayName the value for bs_permission.display_name
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_permission.url
     *
     * @return the value of bs_permission.url
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_permission.url
     *
     * @param url the value for bs_permission.url
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_permission.type_id
     *
     * @return the value of bs_permission.type_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_permission.type_id
     *
     * @param typeId the value for bs_permission.type_id
     *
     * @mbg.generated Sun May 24 01:03:01 CST 2020
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}