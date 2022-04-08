package com.tplink.iot.dailysummary.network.bean.common;

/* loaded from: classes2.dex */
public class SummaryVideo {
    private long duration;
    private String m3u8;
    private String resolution;
    private String uri;
    private long uriExpiresAt;

    public long getDuration() {
        return this.duration;
    }

    public String getM3u8() {
        return this.m3u8;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getUri() {
        return this.uri;
    }

    public long getUriExpiresAt() {
        return this.uriExpiresAt;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setM3u8(String str) {
        this.m3u8 = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setUriExpiresAt(long j) {
        this.uriExpiresAt = j;
    }

    public String toString() {
        return "Video{uri='" + this.uri + "', m3u8='" + this.m3u8 + "', duration=" + this.duration + ", resolution='" + this.resolution + "', uriExpiresAt=" + this.uriExpiresAt + '}';
    }
}
