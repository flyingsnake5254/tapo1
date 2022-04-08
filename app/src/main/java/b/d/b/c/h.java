package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.protocol.params.HelloCloudParams;
import com.tplink.cloud.bean.protocol.result.HelloCloudResult;
import io.reactivex.q;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.x.a;
import retrofit2.x.k;
import retrofit2.x.o;

/* compiled from: ProtocolApi.java */
/* loaded from: classes2.dex */
public interface h {
    @k({"token-required:false"})
    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<HelloCloudResult>> v(@a CloudParams<HelloCloudParams> cloudParams);
}
