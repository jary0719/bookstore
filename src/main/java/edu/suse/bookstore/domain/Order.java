package edu.suse.bookstore.domain;

import java.io.Serializable;
import java.util.Date;

public class Order extends OrderExt implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.order_number
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String orderNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.user_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.order_time
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Date orderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.status
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_order
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.order_number
     *
     * @return the value of bs_order.order_number
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.order_number
     *
     * @param orderNumber the value for bs_order.order_number
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.user_id
     *
     * @return the value of bs_order.user_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.user_id
     *
     * @param userId the value for bs_order.user_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.order_time
     *
     * @return the value of bs_order.order_time
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.order_time
     *
     * @param orderTime the value for bs_order.order_time
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.status
     *
     * @return the value of bs_order.status
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.status
     *
     * @param status the value for bs_order.status
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}