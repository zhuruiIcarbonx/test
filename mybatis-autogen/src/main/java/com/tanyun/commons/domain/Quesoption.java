package com.tanyun.commons.domain;

import java.util.Date;

public class Quesoption {
    private Long quesoptionId;

    private String quesoptionName;

    private String quesoptionDesc;

    private Long ownerQuestionId;

    private Integer position;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getQuesoptionId() {
        return quesoptionId;
    }

    public void setQuesoptionId(Long quesoptionId) {
        this.quesoptionId = quesoptionId;
    }

    public String getQuesoptionName() {
        return quesoptionName;
    }

    public void setQuesoptionName(String quesoptionName) {
        this.quesoptionName = quesoptionName == null ? null : quesoptionName.trim();
    }

    public String getQuesoptionDesc() {
        return quesoptionDesc;
    }

    public void setQuesoptionDesc(String quesoptionDesc) {
        this.quesoptionDesc = quesoptionDesc == null ? null : quesoptionDesc.trim();
    }

    public Long getOwnerQuestionId() {
        return ownerQuestionId;
    }

    public void setOwnerQuestionId(Long ownerQuestionId) {
        this.ownerQuestionId = ownerQuestionId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
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