package com.tanyun.commons.domain;

import java.util.Date;

public class Collectioninfo {
    private Long collectioninfoId;

    private String collectioninfoNumber;

    private String collectioninfoName;

    private String collectioninfoDesc;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getCollectioninfoId() {
        return collectioninfoId;
    }

    public void setCollectioninfoId(Long collectioninfoId) {
        this.collectioninfoId = collectioninfoId;
    }

    public String getCollectioninfoNumber() {
        return collectioninfoNumber;
    }

    public void setCollectioninfoNumber(String collectioninfoNumber) {
        this.collectioninfoNumber = collectioninfoNumber == null ? null : collectioninfoNumber.trim();
    }

    public String getCollectioninfoName() {
        return collectioninfoName;
    }

    public void setCollectioninfoName(String collectioninfoName) {
        this.collectioninfoName = collectioninfoName == null ? null : collectioninfoName.trim();
    }

    public String getCollectioninfoDesc() {
        return collectioninfoDesc;
    }

    public void setCollectioninfoDesc(String collectioninfoDesc) {
        this.collectioninfoDesc = collectioninfoDesc == null ? null : collectioninfoDesc.trim();
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