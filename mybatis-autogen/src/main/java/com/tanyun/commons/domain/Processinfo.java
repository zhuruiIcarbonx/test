package com.tanyun.commons.domain;

import java.util.Date;

public class Processinfo {
    private Long processinfoId;

    private String processinfoNumber;

    private String processinfoName;

    private String processinfoDesc;

    private String sampleCollectorType;

    private String sampleLogisticType;

    private String sampleExtractionType;

    private String samplesequencetype;

    private Date addedTime;

    private Date lastmodifiedTime;

    public Long getProcessinfoId() {
        return processinfoId;
    }

    public void setProcessinfoId(Long processinfoId) {
        this.processinfoId = processinfoId;
    }

    public String getProcessinfoNumber() {
        return processinfoNumber;
    }

    public void setProcessinfoNumber(String processinfoNumber) {
        this.processinfoNumber = processinfoNumber == null ? null : processinfoNumber.trim();
    }

    public String getProcessinfoName() {
        return processinfoName;
    }

    public void setProcessinfoName(String processinfoName) {
        this.processinfoName = processinfoName == null ? null : processinfoName.trim();
    }

    public String getProcessinfoDesc() {
        return processinfoDesc;
    }

    public void setProcessinfoDesc(String processinfoDesc) {
        this.processinfoDesc = processinfoDesc == null ? null : processinfoDesc.trim();
    }

    public String getSampleCollectorType() {
        return sampleCollectorType;
    }

    public void setSampleCollectorType(String sampleCollectorType) {
        this.sampleCollectorType = sampleCollectorType == null ? null : sampleCollectorType.trim();
    }

    public String getSampleLogisticType() {
        return sampleLogisticType;
    }

    public void setSampleLogisticType(String sampleLogisticType) {
        this.sampleLogisticType = sampleLogisticType == null ? null : sampleLogisticType.trim();
    }

    public String getSampleExtractionType() {
        return sampleExtractionType;
    }

    public void setSampleExtractionType(String sampleExtractionType) {
        this.sampleExtractionType = sampleExtractionType == null ? null : sampleExtractionType.trim();
    }

    public String getSamplesequencetype() {
        return samplesequencetype;
    }

    public void setSamplesequencetype(String samplesequencetype) {
        this.samplesequencetype = samplesequencetype == null ? null : samplesequencetype.trim();
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public Date getLastmodifiedTime() {
        return lastmodifiedTime;
    }

    public void setLastmodifiedTime(Date lastmodifiedTime) {
        this.lastmodifiedTime = lastmodifiedTime;
    }
}