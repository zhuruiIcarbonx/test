package com.tanyun.commons.domain;

import java.util.Date;

public class Surveyquesmap {
    private Long surveyquesmapId;

    private Long surveyId;

    private Long questionId;

    private Integer position;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getSurveyquesmapId() {
        return surveyquesmapId;
    }

    public void setSurveyquesmapId(Long surveyquesmapId) {
        this.surveyquesmapId = surveyquesmapId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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