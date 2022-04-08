package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class VideoQuality {
    private final String bitRate;
    @c("bitrate_type")
    private final String bitRateType;
    @c("frame_rate")
    private final String frameRate;
    private final String quality;
    private final String resolution;
    @c("stream_type")
    private final String streamType;

    public VideoQuality(String resolution, String bitRateType, String streamType, String quality, String bitRate, String frameRate) {
        j.e(resolution, "resolution");
        j.e(bitRateType, "bitRateType");
        j.e(streamType, "streamType");
        j.e(quality, "quality");
        j.e(bitRate, "bitRate");
        j.e(frameRate, "frameRate");
        this.resolution = resolution;
        this.bitRateType = bitRateType;
        this.streamType = streamType;
        this.quality = quality;
        this.bitRate = bitRate;
        this.frameRate = frameRate;
    }

    public static /* synthetic */ VideoQuality copy$default(VideoQuality videoQuality, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoQuality.resolution;
        }
        if ((i & 2) != 0) {
            str2 = videoQuality.bitRateType;
        }
        if ((i & 4) != 0) {
            str3 = videoQuality.streamType;
        }
        if ((i & 8) != 0) {
            str4 = videoQuality.quality;
        }
        if ((i & 16) != 0) {
            str5 = videoQuality.bitRate;
        }
        if ((i & 32) != 0) {
            str6 = videoQuality.frameRate;
        }
        return videoQuality.copy(str, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.resolution;
    }

    public final String component2() {
        return this.bitRateType;
    }

    public final String component3() {
        return this.streamType;
    }

    public final String component4() {
        return this.quality;
    }

    public final String component5() {
        return this.bitRate;
    }

    public final String component6() {
        return this.frameRate;
    }

    public final VideoQuality copy(String resolution, String bitRateType, String streamType, String quality, String bitRate, String frameRate) {
        j.e(resolution, "resolution");
        j.e(bitRateType, "bitRateType");
        j.e(streamType, "streamType");
        j.e(quality, "quality");
        j.e(bitRate, "bitRate");
        j.e(frameRate, "frameRate");
        return new VideoQuality(resolution, bitRateType, streamType, quality, bitRate, frameRate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoQuality)) {
            return false;
        }
        VideoQuality videoQuality = (VideoQuality) obj;
        return j.a(this.resolution, videoQuality.resolution) && j.a(this.bitRateType, videoQuality.bitRateType) && j.a(this.streamType, videoQuality.streamType) && j.a(this.quality, videoQuality.quality) && j.a(this.bitRate, videoQuality.bitRate) && j.a(this.frameRate, videoQuality.frameRate);
    }

    public final String getBitRate() {
        return this.bitRate;
    }

    public final String getBitRateType() {
        return this.bitRateType;
    }

    public final String getFrameRate() {
        return this.frameRate;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final ResolutionType getResolutionType() {
        return ResolutionType.Companion.fromString(this.resolution);
    }

    public final String getStreamType() {
        return this.streamType;
    }

    public int hashCode() {
        String str = this.resolution;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bitRateType;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.streamType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.quality;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bitRate;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.frameRate;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "VideoQuality(resolution=" + this.resolution + ", bitRateType=" + this.bitRateType + ", streamType=" + this.streamType + ", quality=" + this.quality + ", bitRate=" + this.bitRate + ", frameRate=" + this.frameRate + ")";
    }
}
