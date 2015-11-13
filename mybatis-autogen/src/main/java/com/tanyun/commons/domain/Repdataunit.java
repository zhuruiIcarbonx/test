package com.tanyun.commons.domain;

import java.util.Date;

public class Repdataunit {
    private Long reportdataunitId;

    private String reportdataunitNumber;

    private String reportdataunitName;

    private String reportdataunitDesc;

    private String userKind;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getReportdataunitId() {
        return reportdataunitId;
    }

    public void setReportdataunitId(Long reportdataunitId) {
        this.reportdataunitId = reportdataunitId;
    }

    public String getReportdataunitNumber() {
        return reportdataunitNumber;
    }

    public void setReportdataunitNumber(String reportdataunitNumber) {
        this.reportdataunitNumber = reportdataunitNumber == null ? null : reportdataunitNumber.trim();
    }

    public String getReportdataunitName() {
        return reportdataunitName;
    }

    public void setReportdataunitName(String reportdataunitName) {
        this.reportdataunitName = reportdataunitName == null ? null : reportdataunitName.trim();
    }

    public String getReportdataunitDesc() {
        return reportdataunitDesc;
    }

    public void setReportdataunitDesc(String reportdataunitDesc) {
        this.reportdataunitDesc = reportdataunitDesc == null ? null : reportdataunitDesc.trim();
    }

    public String getUserKind() {
        return userKind;
    }

    public void setUserKind(String userKind) {
        this.userKind = userKind == null ? null : userKind.trim();
    }

    public Date getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Date addedTime) {
        this.addedTime = addedTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}