package com.tanyun.commons.domain;

import java.util.Date;

public class Colseqgenedecmap {
    private Long colseqgenedecmapId;

    private Long collectionseqinfoId;

    private Long genedecunitId;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getColseqgenedecmapId() {
        return colseqgenedecmapId;
    }

    public void setColseqgenedecmapId(Long colseqgenedecmapId) {
        this.colseqgenedecmapId = colseqgenedecmapId;
    }

    public Long getCollectionseqinfoId() {
        return collectionseqinfoId;
    }

    public void setCollectionseqinfoId(Long collectionseqinfoId) {
        this.collectionseqinfoId = collectionseqinfoId;
    }

    public Long getGenedecunitId() {
        return genedecunitId;
    }

    public void setGenedecunitId(Long genedecunitId) {
        this.genedecunitId = genedecunitId;
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