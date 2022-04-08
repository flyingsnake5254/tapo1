package com.tplink.libtpappcommonmedia.bean.stream;

/* loaded from: classes3.dex */
public enum MediaDataFormat {
    AUDIO_WAV("audio/x-wav"),
    VIDEO_H264("video/x-h264"),
    VIDEO_MP2T("video/mp2t"),
    AUDIO_MP2T("audio/mp2t"),
    VOD_STREAM_FINISH("vodStreamFinish");
    
    private String value;

    MediaDataFormat(String str) {
        this.value = str;
    }

    public static MediaDataFormat fromValue(String str) {
        MediaDataFormat[] values;
        for (MediaDataFormat mediaDataFormat : values()) {
            if (mediaDataFormat.value.equalsIgnoreCase(str)) {
                return mediaDataFormat;
            }
        }
        return null;
    }

    public String value() {
        return this.value;
    }
}
