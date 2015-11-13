package com.tanyun.commons.domain;

import java.util.Date;

public class Genedecunit {
    private Long genedecunitId;

    private String genedecunitNumber;

    private String genedecunitName;

    private String genedecunitDesc;

    private String unitCode;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getGenedecunitId() {
        return genedecunitId;
    }

    public void setGenedecunitId(Long genedecunitId) {
        this.genedecunitId = genedecunitId;
    }

    public String getGenedecunitNumber() {
        return genedecunitNumber;
    }

    public void setGenedecunitNumber(String genedecunitNumber) {
        this.genedecunitNumber = genedecunitNumber == null ? null : genedecunitNumber.trim();
    }

    public String getGenedecunitName() {
        return genedecunitName;
    }

    public void setGenedecunitName(String genedecunitName) {
        this.genedecunitName = genedecunitName == null ? null : genedecunitName.trim();
    }

    public String getGenedecunitDesc() {
        return genedecunitDesc;
    }

    public void setGenedecunitDesc(String genedecunitDesc) {
        this.genedecunitDesc = genedecunitDesc == null ? null : genedecunitDesc.trim();
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
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