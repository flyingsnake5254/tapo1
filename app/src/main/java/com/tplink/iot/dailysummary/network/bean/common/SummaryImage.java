package com.tplink.iot.dailysummary.network.bean.common;

/* loaded from: classes2.dex */
public class SummaryImage {
    private long length;
    private long startOffset;
    private String uri;
    private long uriExpiresAt;

    public long getLength() {
        return this.length;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public String getUri() {
        return this.uri;
    }

    public long getUriExpiresAt() {
        return this.uriExpiresAt;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setStartOffset(long j) {
        this.startOffset = j;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setUriExpiresAt(long j) {
        this.uriExpiresAt = j;
    }

    public String toString() {
        return "Image{uri='" + this.uri + "', startOffset=" + this.startOffset + ", length=" + this.length + ", uriExpiresAt=" + this.uriExpiresAt + '}';
    }
}
