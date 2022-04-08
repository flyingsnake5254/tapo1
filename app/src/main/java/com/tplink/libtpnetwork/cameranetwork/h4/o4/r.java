package com.tplink.libtpnetwork.cameranetwork.h4.o4;

import com.tplink.libtpnetwork.cameranetwork.model.LoginResult;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import io.reactivex.q;
import okhttp3.ResponseBody;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.x.a;
import retrofit2.x.o;
import retrofit2.x.s;

/* compiled from: LocalAccessApi.java */
/* loaded from: classes3.dex */
public interface r {
    @o("/stok={token}/ds")
    q<Response<MultipleResponse>> a(@s("token") String str, @a Request request);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<Response<LoginResult>> b(@a Request request);

    @o("/stok={token}/admin/system/diagnose_logs")
    q<ResponseBody> c(@s("token") String str);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<Response<Wrappers>> d(@a Request request);
}
