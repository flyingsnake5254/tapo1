package com.tplink.iot.dailysummary.network.bean.common;

/* loaded from: classes2.dex */
public class SummaryClipVideo {
    private Long duration;
    private String m3u8;
    private Long startTimestamp;
    private String uri;
    private Long uriExpiresAt;

    public Long getDuration() {
        return this.duration;
    }

    public String getM3u8() {
        return this.m3u8;
    }

    public Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public String getUri() {
        return this.uri;
    }

    public Long getUriExpiresAt() {
        return this.uriExpiresAt;
    }

    public void setDuration(Long l) {
        this.duration = l;
    }

    public void setM3u8(String str) {
        this.m3u8 = str;
    }

    public void setStartTimestamp(Long l) {
        this.startTimestamp = l;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setUriExpiresAt(Long l) {
        this.uriExpiresAt = l;
    }

    public String toString() {
        return "SummaryClipVideo{uri='" + this.uri + "', duration=" + this.duration + ", m3u8='" + this.m3u8 + "', startTimestamp=" + this.startTimestamp + ", uriExpiresAt=" + this.uriExpiresAt + '}';
    }
}
