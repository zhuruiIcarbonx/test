package com.tanyun.commons.domain;

import java.util.Date;

public class Productrepdatamap {
    private Long productrepdatamapId;

    private Long productId;

    private Long repdataunitId;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getProductrepdatamapId() {
        return productrepdatamapId;
    }

    public void setProductrepdatamapId(Long productrepdatamapId) {
        this.productrepdatamapId = productrepdatamapId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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