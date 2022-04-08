package b.d.t.e;

import com.google.gson.k;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import io.netty.handler.codec.http.HttpHeaders;

/* compiled from: RemoteConnectionUtils.java */
/* loaded from: classes3.dex */
public class c {
    public static String a(String str, int i, int i2, int i3, long j, long j2, int i4, String str2, String str3, String str4, String str5, int i5) {
        k kVar = new k();
        kVar.m(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, str);
        kVar.l("p2p_type", Integer.valueOf(i));
        kVar.l("stream_type", Integer.valueOf(i2));
        kVar.l("resolution", Integer.valueOf(i3));
        kVar.l("start_time", Long.valueOf(j));
        kVar.l("end_time", Long.valueOf(j2));
        kVar.l("audio_mode", Integer.valueOf(i4));
        kVar.m("device_username", str2);
        kVar.m("device_password", str3);
        kVar.m("control_host", str4);
        kVar.m("control_host_p2p", str5);
        return kVar.toString();
    }

    public static String b(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, int i3, String str8, String str9, String str10, boolean z, String str11) {
        k kVar = new k();
        kVar.m("client_hwaddr", str);
        kVar.m("client_type", str2);
        kVar.m(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID, str3);
        kVar.m("tplink_id", str4);
        kVar.m("user_token", str5);
        kVar.m("client_uuid", str6);
        kVar.m("platform_model", str7);
        kVar.l("p2p_type", Integer.valueOf(i));
        kVar.l("stream_type", Integer.valueOf(i2));
        kVar.l("resolution", Integer.valueOf(i3));
        kVar.m("server_addr", str8);
        kVar.m("https_server_addr", str9);
        kVar.m(HttpHeaders.Values.BOUNDARY, str10);
        kVar.l("is_support_iot", Integer.valueOf(z ? 1 : 0));
        kVar.m("app_cid", str11);
        return kVar.toString();
    }
}
