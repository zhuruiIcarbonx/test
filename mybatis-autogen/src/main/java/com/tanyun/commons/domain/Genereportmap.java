package com.tanyun.commons.domain;

import java.util.Date;

public class Genereportmap {
    private Long genereportmapId;

    private Long genedecunitId;

    private Long repdataunitId;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getGenereportmapId() {
        return genereportmapId;
    }

    public void setGenereportmapId(Long genereportmapId) {
        this.genereportmapId = genereportmapId;
    }

    public Long getGenedecunitId() {
        return genedecunitId;
    }

    public void setGenedecunitId(Long genedecunitId) {
        this.genedecunitId = genedecunitId;
    }

    public Long getRepdataunitId() {
        return repdataunitId;
    }

    public void setRepdataunitId(Long repdataunitId) {
        this.repdataunitId = repdataunitId;
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