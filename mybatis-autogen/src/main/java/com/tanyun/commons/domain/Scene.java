package com.tanyun.commons.domain;

import java.util.Date;

public class Scene {
    private Long sceneId;

    private String sceneNumber;

    private String sceneName;

    private String sceneDesc;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getSceneId() {
        return sceneId;
    }

    public void setSceneId(Long sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneNumber() {
        return sceneNumber;
    }

    public void setSceneNumber(String sceneNumber) {
        this.sceneNumber = sceneNumber == null ? null : sceneNumber.trim();
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName == null ? null : sceneName.trim();
    }

    public String getSceneDesc() {
        return sceneDesc;
    }

    public void setSceneDesc(String sceneDesc) {
        this.sceneDesc = sceneDesc == null ? null : sceneDesc.trim();
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