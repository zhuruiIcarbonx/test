package com.tanyun.commons.domain;

import java.util.Date;

public class Collectionseqinfo {
    private Long collectionseqinfoId;

    private String collectionseqinfoNumber;

    private String collectionseqinfoName;

    private String collectionseqinfoDesc;

    private Long seqscopeId;

    private Long collectioninfoId;

    private Integer isMedicaid;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getCollectionseqinfoId() {
        return collectionseqinfoId;
    }

    public void setCollectionseqinfoId(Long collectionseqinfoId) {
        this.collectionseqinfoId = collectionseqinfoId;
    }

    public String getCollectionseqinfoNumber() {
        return collectionseqinfoNumber;
    }

    public void setCollectionseqinfoNumber(String collectionseqinfoNumber) {
        this.collectionseqinfoNumber = collectionseqinfoNumber == null ? null : collectionseqinfoNumber.trim();
    }

    public String getCollectionseqinfoName() {
        return collectionseqinfoName;
    }

    public void setCollectionseqinfoName(String collectionseqinfoName) {
        this.collectionseqinfoName = collectionseqinfoName == null ? null : collectionseqinfoName.trim();
    }

    public String getCollectionseqinfoDesc() {
        return collectionseqinfoDesc;
    }

    public void setCollectionseqinfoDesc(String collectionseqinfoDesc) {
        this.collectionseqinfoDesc = collectionseqinfoDesc == null ? null : collectionseqinfoDesc.trim();
    }

    public Long getSeqscopeId() {
        return seqscopeId;
    }

    public void setSeqscopeId(Long seqscopeId) {
        this.seqscopeId = seqscopeId;
    }

    public Long getCollectioninfoId() {
        return collectioninfoId;
    }

    public void setCollectioninfoId(Long collectioninfoId) {
        this.collectioninfoId = collectioninfoId;
    }

    public Integer getIsMedicaid() {
        return isMedicaid;
    }

    public void setIsMedicaid(Integer isMedicaid) {
        this.isMedicaid = isMedicaid;
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