package com.tplink.libtpmediaother.memory;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class MemoryBean implements Serializable {
    private String deviceAlias;
    private String deviceAvatarUrl;
    private long groupId;
    private long id;
    private boolean isMark;
    private String locationName;
    private String thumbnailPath;
    private long timestamp;
    private int videoLength;
    private String videoPath;

    public String getDeviceAlias() {
        return this.deviceAlias;
    }

    public String getDeviceAvatarUrl() {
        return this.deviceAvatarUrl;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getId() {
        return this.id;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getVideoLength() {
        return this.videoLength;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public boolean isMark() {
        return this.isMark;
    }

    public void setDeviceAlias(String str) {
        this.deviceAlias = str;
    }

    public void setDeviceAvatarUrl(String str) {
        this.deviceAvatarUrl = str;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setMark(boolean z) {
        this.isMark = z;
    }

    public void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setVideoLength(int i) {
        this.videoLength = i;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public MemoryBean clone() {
        MemoryBean memoryBean = new MemoryBean();
        memoryBean.setId(this.id);
        memoryBean.setGroupId(this.groupId);
        memoryBean.setDeviceAvatarUrl(this.deviceAvatarUrl);
        memoryBean.setDeviceAlias(this.deviceAlias);
        memoryBean.setMark(this.isMark);
        memoryBean.setTimestamp(this.timestamp);
        memoryBean.setVideoPath(this.videoPath);
        memoryBean.setThumbnailPath(this.thumbnailPath);
        memoryBean.setVideoLength(this.videoLength);
        memoryBean.setLocationName(this.locationName);
        return memoryBean;
    }
}
