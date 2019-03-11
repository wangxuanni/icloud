package cn.draymonder.cloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * 文件关系表 用来虚拟文件关系
 * @auther draymonder
 */
public class FileRelation {
    private int fileRelationId;
    private int userId;
    private int fileId;
    private String fileName;
    private int parentId;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastEditTime;

    public FileRelation() {}

    public FileRelation(int fileRelationId, int userId, int fileId, String fileName, int parentId, @NotNull Date createTime, @NotNull Date lastEditTime) {
        this.fileRelationId = fileRelationId;
        this.userId = userId;
        this.fileId = fileId;
        this.fileName = fileName;
        this.parentId = parentId;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "FileRelation{" +
                "fileRelationId=" + fileRelationId +
                ", userId=" + userId +
                ", fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", parentId=" + parentId +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }

    public int getFileRelationId() {
        return fileRelationId;
    }

    public void setFileRelationId(int fileRelationId) {
        this.fileRelationId = fileRelationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
