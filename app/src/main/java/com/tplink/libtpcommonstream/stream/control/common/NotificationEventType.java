package com.tplink.libtpcommonstream.stream.control.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface NotificationEventType {
    public static final String EVENT_TYPE_CHANNEL_LENS_MASK = "channel_lens_mask_info";
    public static final String EVENT_TYPE_CHANNEL_PASSENGER = "channel_passenger_flow_info";
    public static final String EVENT_TYPE_CHANNEL_PREVIEW = "channel_preview_params";
    public static final String EVENT_TYPE_CHANNEL_SMART_CODEC = "channel_smart_codec_info";
    public static final String EVENT_TYPE_CHANNEL_STATUS = "channel_stream_status";
    public static final String EVENT_TYPE_DEVICE_LOCKED = "device_locked";
    public static final String EVENT_TYPE_INTERNAL_ERROR = "internal_error";
    public static final String EVENT_TYPE_MOTOR_STATUS = "channel_motor_status";
    public static final String EVENT_TYPE_STREAM_FINISH = "stream_finish";
    public static final String EVENT_TYPE_STREAM_SEQ = "stream_sequence";
    public static final String EVENT_TYPE_STREAM_STATUS = "stream_status";
    public static final String EVENT_TYPE_UNSUPPORT_AUDIO = "unsupport_audio";
}
