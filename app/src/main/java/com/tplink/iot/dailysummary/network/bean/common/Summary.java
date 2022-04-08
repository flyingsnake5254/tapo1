package com.tplink.iot.dailysummary.network.bean.common;

/* loaded from: classes2.dex */
public class Summary {
    private int clipSize;
    private String date;
    private long duration;
    private String eventId;
    private SummaryImage image;
    private int status;
    private String uuid;
    private SummaryVideo video;

    public int getClipSize() {
        return this.clipSize;
    }

    public String getDate() {
        return this.date;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getEventId() {
        return this.eventId;
    }

    public SummaryImage getImage() {
        return this.image;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUuid() {
        return this.uuid;
    }

    public SummaryVideo getVideo() {
        return this.video;
    }

    public void setClipSize(int i) {
        this.clipSize = i;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setImage(SummaryImage summaryImage) {
        this.image = summaryImage;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVideo(SummaryVideo summaryVideo) {
        this.video = summaryVideo;
    }

    public String toString() {
        return "Summary{uuid='" + this.uuid + "', date='" + this.date + "', video=" + this.video + ", image=" + this.image + ", status=" + this.status + ", eventId='" + this.eventId + "', clipSize=" + this.clipSize + ", duration=" + this.duration + '}';
    }
}
