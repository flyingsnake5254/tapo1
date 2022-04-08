package com.tplink.iot.dailysummary.network.bean.common;

import java.util.List;

/* loaded from: classes2.dex */
public class SummaryClip {
    private Long createdTime;
    private String eventLocalTime;
    private List<SummaryImage> image;
    private Long splitPoint;
    private String uuid;
    private List<SummaryClipVideo> video;

    public Long getCreatedTime() {
        return this.createdTime;
    }

    public String getEventLocalTime() {
        return this.eventLocalTime;
    }

    public List<SummaryImage> getImage() {
        return this.image;
    }

    public Long getSplitPoint() {
        return this.splitPoint;
    }

    public String getUuid() {
        return this.uuid;
    }

    public List<SummaryClipVideo> getVideo() {
        return this.video;
    }

    public void setCreatedTime(Long l) {
        this.createdTime = l;
    }

    public void setEventLocalTime(String str) {
        this.eventLocalTime = str;
    }

    public void setImage(List<SummaryImage> list) {
        this.image = list;
    }

    public void setSplitPoint(Long l) {
        this.splitPoint = l;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVideo(List<SummaryClipVideo> list) {
        this.video = list;
    }

    public String toString() {
        return "SummaryClip{uuid='" + this.uuid + "', createdTime=" + this.createdTime + ", eventLocalTime='" + this.eventLocalTime + "', splitPoint=" + this.splitPoint + ", video=" + this.video + ", image=" + this.image + '}';
    }
}
