package com.tanyun.commons.domain;

import java.util.Date;

public class Question {
    private Long questionId;

    private String questionName;

    private String questionDesc;

    private Long parentQuestionId;

    private Long activeQuesoptionId;

    private String questionType;

    private String quesoptionType;

    private String required;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName == null ? null : questionName.trim();
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc == null ? null : questionDesc.trim();
    }

    public Long getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(Long parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public Long getActiveQuesoptionId() {
        return activeQuesoptionId;
    }

    public void setActiveQuesoptionId(Long activeQuesoptionId) {
        this.activeQuesoptionId = activeQuesoptionId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public String getQuesoptionType() {
        return quesoptionType;
    }

    public void setQuesoptionType(String quesoptionType) {
        this.quesoptionType = quesoptionType == null ? null : quesoptionType.trim();
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required == null ? null : required.trim();
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