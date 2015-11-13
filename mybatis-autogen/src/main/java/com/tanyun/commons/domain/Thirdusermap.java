package com.tanyun.commons.domain;

import java.util.Date;

public class Thirdusermap {
    private Long thirdusermapId;

    private Long userId;

    private Long thId;

    private String thUserId;

    private String clientIp;

    private String clientId;

    private String thName;

    private String thPhotoUrl;

    private Date addedTime;

    private Date lastModifiedTime;

    public Long getThirdusermapId() {
        return thirdusermapId;
    }

    public void setThirdusermapId(Long thirdusermapId) {
        this.thirdusermapId = thirdusermapId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getThId() {
        return thId;
    }

    public void setThId(Long thId) {
        this.thId = thId;
    }

    public String getThUserId() {
        return thUserId;
    }

    public void setThUserId(String thUserId) {
        this.thUserId = thUserId == null ? null : thUserId.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getThName() {
        return thName;
    }

    public void setThName(String thName) {
        this.thName = thName == null ? null : thName.trim();
    }

    public String getThPhotoUrl() {
        return thPhotoUrl;
    }

    public void setThPhotoUrl(String thPhotoUrl) {
        this.thPhotoUrl = thPhotoUrl == null ? null : thPhotoUrl.trim();
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