package com.tritonsfs.springboot.model;

import com.tritonsfs.cac.frame.core.annotation.PrimaryKey;

import java.util.Date;

public class MailSendAttach implements java.io.Serializable {
    /**
     * 主键
     */
    @PrimaryKey
    private String id;

    /**
     * 发送记录主键
     */
    private String sendRecordId;

    /**
     * 附件URL，PDF指向归档目录，图片指向和附件模板表保持一致
     */
    private String attachmentUrl;

    /**
     * 附件名称
     */
    private String attachName;

    /**
     * 附件类型{01：图片，02：PDF，03：文件流[word、excel]}
     */
    private String attachType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 发送记录主键
     */
    public String getSendRecordId() {
        return sendRecordId;
    }

    /**
     * 发送记录主键
     */
    public void setSendRecordId(String sendRecordId) {
        this.sendRecordId = sendRecordId == null ? null : sendRecordId.trim();
    }

    /**
     * 附件URL，PDF指向归档目录，图片指向和附件模板表保持一致
     */
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    /**
     * 附件URL，PDF指向归档目录，图片指向和附件模板表保持一致
     */
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl == null ? null : attachmentUrl.trim();
    }

    /**
     * 附件名称
     */
    public String getAttachName() {
        return attachName;
    }

    /**
     * 附件名称
     */
    public void setAttachName(String attachName) {
        this.attachName = attachName == null ? null : attachName.trim();
    }

    /**
     * 附件类型{01：图片，02：PDF，03：文件流[word、excel]}
     */
    public String getAttachType() {
        return attachType;
    }

    /**
     * 附件类型{01：图片，02：PDF，03：文件流[word、excel]}
     */
    public void setAttachType(String attachType) {
        this.attachType = attachType == null ? null : attachType.trim();
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}