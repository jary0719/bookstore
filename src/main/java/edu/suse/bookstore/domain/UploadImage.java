package edu.suse.bookstore.domain;

import java.io.Serializable;
import java.util.Date;

public class UploadImage implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column upload_image.id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column upload_image.original_name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String originalName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column upload_image.save_name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String saveName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column upload_image.file_size
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Long fileSize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column upload_image.file_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String fileType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column upload_image.upload_time
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private Date uploadTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column upload_image.path
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private String path;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table upload_image
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column upload_image.id
     *
     * @return the value of upload_image.id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column upload_image.id
     *
     * @param id the value for upload_image.id
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column upload_image.original_name
     *
     * @return the value of upload_image.original_name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column upload_image.original_name
     *
     * @param originalName the value for upload_image.original_name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column upload_image.save_name
     *
     * @return the value of upload_image.save_name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getSaveName() {
        return saveName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column upload_image.save_name
     *
     * @param saveName the value for upload_image.save_name
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setSaveName(String saveName) {
        this.saveName = saveName == null ? null : saveName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column upload_image.file_size
     *
     * @return the value of upload_image.file_size
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Long getFileSize() {
        return fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column upload_image.file_size
     *
     * @param fileSize the value for upload_image.file_size
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column upload_image.file_type
     *
     * @return the value of upload_image.file_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column upload_image.file_type
     *
     * @param fileType the value for upload_image.file_type
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column upload_image.upload_time
     *
     * @return the value of upload_image.upload_time
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column upload_image.upload_time
     *
     * @param uploadTime the value for upload_image.upload_time
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column upload_image.path
     *
     * @return the value of upload_image.path
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column upload_image.path
     *
     * @param path the value for upload_image.path
     *
     * @mbg.generated Sat May 30 16:53:27 CST 2020
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}