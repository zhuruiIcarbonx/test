package com.tanyun.commons.domain;

import java.util.Date;

public class Thirdsystem {
    private Long thId;

    private String name;

    private Date lastModify;

    public Long getThId() {
        return thId;
    }

    public void setThId(Long thId) {
        this.thId = thId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }
}