package com.tanyun.commons.domain;

import java.util.Date;

public class Template {
    private Long templateId;

    private String templateNumber;

    private Long repdataunitId;

    private Long repsceneId;

    private Date addedTime;

    private Date lastModifiedTime;

    private String templateContent;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateNumber() {
        return templateNumber;
    }

    public void setTemplateNumber(String templateNumber) {
        this.templateNumber = templateNumber == null ? null : templateNumber.trim();
    }

    public Long getRepdataunitId() {
        return repdataunitId;
    }

    public void setRepdataunitId(Long repdataunitId) {
        this.repdataunitId = repdataunitId;
    }

    public Long getRepsceneId() {
        return repsceneId;
    }

    public void setRepsceneId(Long repsceneId) {
        this.repsceneId = repsceneId;
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

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent == null ? null : templateContent.trim();
    }
}