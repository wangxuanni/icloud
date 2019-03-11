package cn.draymonder.cloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * 文件类 存放文件的具体信息
 * @auther draymonder
 */
public class Files {
    private int fileId;
    private int ownerId;
    private String fileName;
    private int fileSize;
    private int fileType;
    private String filePath;
    private String MD5;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastEditTime;
    public Files() { }

    public Files(int fileId, int ownerId, String fileName, int fileSize, int fileType, String filePath, String md5, @NotNull Date createTime, @NotNull Date lastEditTime) {
        this.fileId = fileId;
        this.ownerId = ownerId;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.filePath = filePath;
        this.MD5 = md5;
        this.createTime = createTime;
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "Files{" +
                "fileId=" + fileId +
                ", ownerId=" + ownerId +
                ", fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", fileType=" + fileType +
                ", filePath='" + filePath + '\'' +
                ", MD5='" + MD5 + '\'' +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMd5() {
        return MD5;
    }

    public void setMd5(String md5) {
        this.MD5 = md5;
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
