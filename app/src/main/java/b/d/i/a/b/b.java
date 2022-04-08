package b.d.i.a.b;

import com.google.gson.Gson;
import com.google.gson.d;
import com.google.gson.i;
import com.tplink.libtpcommonstream.stream.control.common.CommonPayload;
import com.tplink.libtpcommonstream.stream.control.common.NotificationEventType;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlNotification;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlRequest;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlType;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelLensMaskInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelMotorStatus;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelPassengerFlowInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelPreviewParams;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelSmartCodecInfo;
import com.tplink.libtpcommonstream.stream.control.notification.ChannelStreamStatus;
import com.tplink.libtpcommonstream.stream.control.notification.DeviceLockedInfo;
import com.tplink.libtpcommonstream.stream.control.notification.StreamFinish;
import com.tplink.libtpcommonstream.stream.control.notification.StreamStatus;
import com.tplink.libtpcommonstream.stream.control.notification.UnsupportAudio;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StreamPayloadUtils.java */
/* loaded from: classes3.dex */
public class b {
    private static Map<String, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(NotificationEventType.EVENT_TYPE_STREAM_STATUS, StreamStatus.class);
        a.put(NotificationEventType.EVENT_TYPE_STREAM_SEQ, String.class);
        a.put(NotificationEventType.EVENT_TYPE_STREAM_FINISH, StreamFinish.class);
        a.put("internal_error", InternalError.class);
        a.put(NotificationEventType.EVENT_TYPE_CHANNEL_PREVIEW, ChannelPreviewParams.class);
        a.put(NotificationEventType.EVENT_TYPE_CHANNEL_STATUS, ChannelStreamStatus.class);
        a.put(NotificationEventType.EVENT_TYPE_CHANNEL_LENS_MASK, ChannelLensMaskInfo.class);
        a.put(NotificationEventType.EVENT_TYPE_CHANNEL_SMART_CODEC, ChannelSmartCodecInfo.class);
        a.put(NotificationEventType.EVENT_TYPE_CHANNEL_PASSENGER, ChannelPassengerFlowInfo.class);
        a.put(NotificationEventType.EVENT_TYPE_MOTOR_STATUS, ChannelMotorStatus.class);
        a.put(NotificationEventType.EVENT_TYPE_UNSUPPORT_AUDIO, UnsupportAudio.class);
        a.put(NotificationEventType.EVENT_TYPE_DEVICE_LOCKED, DeviceLockedInfo.class);
    }

    public static <T> T a(i iVar, Class<T> cls) {
        return (T) f().g(iVar, cls);
    }

    public static <T> T b(String str, Class<T> cls) {
        return (T) f().l(str, cls);
    }

    public static StreamControlNotification<Object> c(CommonPayload commonPayload) {
        if (commonPayload == null || commonPayload.getParams() == null || !StreamControlType.NOTIFICATION.equals(commonPayload.getType())) {
            return null;
        }
        StreamControlNotification<Object> streamControlNotification = (StreamControlNotification) a(commonPayload.getParams(), StreamControlNotification.class);
        if (streamControlNotification.getEventType() == null || !a.containsKey(streamControlNotification.getEventType())) {
            return streamControlNotification;
        }
        return new StreamControlNotification<>(streamControlNotification.getEventType(), a(commonPayload.getParams(), a.get(streamControlNotification.getEventType())));
    }

    public static <T> String d(StreamControlRequest<T> streamControlRequest) {
        return f().v(streamControlRequest, StreamControlRequest.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> StreamControlResponse<T> e(CommonPayload commonPayload, Class<T> cls) {
        StreamControlResponse<T> streamControlResponse = (StreamControlResponse<T>) new StreamControlResponse();
        streamControlResponse.setSeq(commonPayload.getSeq());
        streamControlResponse.setType(commonPayload.getType());
        streamControlResponse.setResult(f().g(commonPayload.getParams(), cls));
        return streamControlResponse;
    }

    public static Gson f() {
        return new d().c().b();
    }
}
