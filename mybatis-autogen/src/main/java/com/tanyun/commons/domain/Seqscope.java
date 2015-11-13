package com.tanyun.commons.domain;

import java.util.Date;

public class Seqscope {
    private Long seqscopeId;

    private String seqscopeNumber;

    private String seqscopeName;

    private Date addedTime;

    private Date lastModifiedTime;

    private String seqscopeDesc;

    public Long getSeqscopeId() {
        return seqscopeId;
    }

    public void setSeqscopeId(Long seqscopeId) {
        this.seqscopeId = seqscopeId;
    }

    public String getSeqscopeNumber() {
        return seqscopeNumber;
    }

    public void setSeqscopeNumber(String seqscopeNumber) {
        this.seqscopeNumber = seqscopeNumber == null ? null : seqscopeNumber.trim();
    }

    public String getSeqscopeName() {
        return seqscopeName;
    }

    public void setSeqscopeName(String seqscopeName) {
        this.seqscopeName = seqscopeName == null ? null : seqscopeName.trim();
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

    public String getSeqscopeDesc() {
        return seqscopeDesc;
    }

    public void setSeqscopeDesc(String seqscopeDesc) {
        this.seqscopeDesc = seqscopeDesc == null ? null : seqscopeDesc.trim();
    }
}