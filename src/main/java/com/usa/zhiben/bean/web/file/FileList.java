package com.usa.zhiben.bean.web.file;

import java.io.Serializable;
import java.util.Date;

public class FileList implements Serializable {

    private Long id;

    private String fileNo;

    private String officer;

    private String badge;

    private String caseId;

    private Integer retentionDay;

    private Date recordedTime;

    private Integer recordedLegth;

    private String eventType;

    private String fileType;

    private Double fileSize;

    private Integer fileTag;

    private Integer attachment;

    private Boolean fileLock;

    private Boolean fileProtect;

    private String licensePlate;

    private String offender;

    private String preview;

    private String fileName;

    private String filePath;

    private String storageServerNo;

    private String deviceId;

    private String root;

    private int isUpload;

    private String memo;

    private String serverIp;//文件所属服务器的IP

    private String resolution;//清晰度

    private String eventTypeSecond;//次要事件类型

    private static final long serialVersionUID = 1L;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getEventTypeSecond() {
        return eventTypeSecond;
    }

    public void setEventTypeSecond(String eventTypeSecond) {
        this.eventTypeSecond = eventTypeSecond;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public int getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(int isUpload) {
        this.isUpload = isUpload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo == null ? null : fileNo.trim();
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer == null ? null : officer.trim();
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge == null ? null : badge.trim();
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public Integer getRetentionDay() {
        return retentionDay;
    }

    public void setRetentionDay(Integer retentionDay) {
        this.retentionDay = retentionDay;
    }

    public Date getRecordedTime() {
        return recordedTime;
    }

    public void setRecordedTime(Date recordedTime) {
        this.recordedTime = recordedTime;
    }

    public Integer getRecordedLegth() {
        return recordedLegth;
    }

    public void setRecordedLegth(Integer recordedLegth) {
        this.recordedLegth = recordedLegth;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getFileTag() {
        return fileTag;
    }

    public void setFileTag(Integer fileTag) {
        this.fileTag = fileTag;
    }

    public Integer getAttachment() {
        return attachment;
    }

    public void setAttachment(Integer attachment) {
        this.attachment = attachment;
    }

    public Boolean getFileLock() {
        return fileLock;
    }

    public void setFileLock(Boolean fileLock) {
        this.fileLock = fileLock;
    }

    public Boolean getFileProtect() {
        return fileProtect;
    }

    public void setFileProtect(Boolean fileProtect) {
        this.fileProtect = fileProtect;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate == null ? null : licensePlate.trim();
    }

    public String getOffender() {
        return offender;
    }

    public void setOffender(String offender) {
        this.offender = offender == null ? null : offender.trim();
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview == null ? null : preview.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getStorageServerNo() {
        return storageServerNo;
    }

    public void setStorageServerNo(String storageServerNo) {
        this.storageServerNo = storageServerNo == null ? null : storageServerNo.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fileNo=").append(fileNo);
        sb.append(", officer=").append(officer);
        sb.append(", badge=").append(badge);
        sb.append(", caseId=").append(caseId);
        sb.append(", retentionDay=").append(retentionDay);
        sb.append(", recordedTime=").append(recordedTime);
        sb.append(", recordedLegth=").append(recordedLegth);
        sb.append(", eventType=").append(eventType);
        sb.append(", fileType=").append(fileType);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", fileTag=").append(fileTag);
        sb.append(", attachment=").append(attachment);
        sb.append(", fileLock=").append(fileLock);
        sb.append(", fileProtect=").append(fileProtect);
        sb.append(", licensePlate=").append(licensePlate);
        sb.append(", offender=").append(offender);
        sb.append(", preview=").append(preview);
        sb.append(", fileName=").append(fileName);
        sb.append(", filePath=").append(filePath);
        sb.append(", storageServerNo=").append(storageServerNo);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", memo=").append(memo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}