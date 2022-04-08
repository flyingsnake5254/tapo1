package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoUploadParams;
import com.tplink.cloud.bean.webservice.params.AppServiceUrlParams;
import com.tplink.cloud.bean.webservice.params.DataCollectRequestParams;
import com.tplink.cloud.bean.webservice.params.ServiceStatusInfoParams;
import com.tplink.cloud.bean.webservice.params.WebServiceInfoParams;
import com.tplink.cloud.bean.webservice.result.AccountAvatarResult;
import com.tplink.cloud.bean.webservice.result.AppServiceUrlResult;
import com.tplink.cloud.bean.webservice.result.DeviceAvatarResult;
import com.tplink.cloud.bean.webservice.result.WebServiceInfoResult;
import io.reactivex.q;
import okhttp3.MultipartBody;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.x.a;
import retrofit2.x.i;
import retrofit2.x.k;
import retrofit2.x.l;
import retrofit2.x.o;
import retrofit2.x.s;
import retrofit2.x.t;
import retrofit2.x.y;

/* compiled from: WebServiceApi.java */
/* loaded from: classes2.dex */
public interface j {
    @o
    @l
    q<CloudResult<DeviceAvatarResult>> I1(@y String str, @t("deviceId") String str2, @retrofit2.x.q MultipartBody.Part part);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<WebServiceInfoResult>> S0(@a CloudParams<WebServiceInfoParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> X(@a CloudParams<ServiceStatusInfoParams> cloudParams);

    @o
    @l
    q<CloudResult<AccountAvatarResult>> Y(@y String str, @retrofit2.x.q MultipartBody.Part part);

    @k({"Content-Encoding:gzip"})
    @o("{url}/api/data/app/uploadBasicData")
    q<CloudResult> d1(@s(encoded = true, value = "url") String str, @i("X-Authorization") String str2, @a DataCollectRequestParams dataCollectRequestParams);

    @o
    q<CloudResult<Void>> i1(@y String str, @a DeviceConfigInfoUploadParams deviceConfigInfoUploadParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<AppServiceUrlResult>> l0(@a CloudParams<AppServiceUrlParams> cloudParams);
}
