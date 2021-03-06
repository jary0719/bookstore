package edu.suse.bookstore.domain;

import java.io.Serializable;

public class Book extends BookExt implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.b_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer bId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.bt_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer btId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.bp_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer bpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.ba_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer baId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.price
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Float price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.stock
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer stock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.counter
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer counter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.content
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_book.status
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_book
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.b_id
     *
     * @return the value of bs_book.b_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getbId() {
        return bId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.b_id
     *
     * @param bId the value for bs_book.b_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setbId(Integer bId) {
        this.bId = bId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.bt_id
     *
     * @return the value of bs_book.bt_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getBtId() {
        return btId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.bt_id
     *
     * @param btId the value for bs_book.bt_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.bp_id
     *
     * @return the value of bs_book.bp_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getBpId() {
        return bpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.bp_id
     *
     * @param bpId the value for bs_book.bp_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setBpId(Integer bpId) {
        this.bpId = bpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.ba_id
     *
     * @return the value of bs_book.ba_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getBaId() {
        return baId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.ba_id
     *
     * @param baId the value for bs_book.ba_id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setBaId(Integer baId) {
        this.baId = baId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.name
     *
     * @return the value of bs_book.name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.name
     *
     * @param name the value for bs_book.name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.price
     *
     * @return the value of bs_book.price
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Float getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.price
     *
     * @param price the value for bs_book.price
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.stock
     *
     * @return the value of bs_book.stock
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.stock
     *
     * @param stock the value for bs_book.stock
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.counter
     *
     * @return the value of bs_book.counter
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getCounter() {
        return counter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.counter
     *
     * @param counter the value for bs_book.counter
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.content
     *
     * @return the value of bs_book.content
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.content
     *
     * @param content the value for bs_book.content
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_book.status
     *
     * @return the value of bs_book.status
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_book.status
     *
     * @param status the value for bs_book.status
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}