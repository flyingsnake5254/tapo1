package b.d.b.c;

import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.device.params.DeviceAliasParams;
import com.tplink.cloud.bean.device.params.DeviceConfigInfoParams;
import com.tplink.cloud.bean.device.params.DeviceFeatureParams;
import com.tplink.cloud.bean.device.params.DeviceInfoParams;
import com.tplink.cloud.bean.device.params.DeviceListPageParams;
import com.tplink.cloud.bean.device.params.DeviceUnbindParams;
import com.tplink.cloud.bean.device.params.DeviceUserNumberLimitParams;
import com.tplink.cloud.bean.device.result.DeviceConfigInfoListResult;
import com.tplink.cloud.bean.device.result.DeviceInfoResult;
import com.tplink.cloud.bean.device.result.DeviceListPageResult;
import com.tplink.cloud.bean.device.result.DeviceUnbindFeatureResult;
import com.tplink.cloud.bean.device.result.DeviceUserNumberLimitListResult;
import io.reactivex.q;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.x.a;
import retrofit2.x.o;
import retrofit2.x.y;

/* compiled from: DeviceApi.java */
/* loaded from: classes2.dex */
public interface c {
    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<DeviceConfigInfoListResult>> M(@a CloudParams<DeviceConfigInfoParams> cloudParams);

    @o
    q<CloudResult<Void>> Y0(@y String str, @a CloudParams<DeviceUnbindParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<DeviceUnbindFeatureResult>> a0(@a CloudParams<DeviceFeatureParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<DeviceListPageResult>> b1(@a CloudParams<DeviceListPageParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<DeviceInfoResult>> j1(@a CloudParams<DeviceInfoParams> cloudParams);

    @o
    q<CloudResult<DeviceInfoResult>> p1(@y String str, @a CloudParams<DeviceInfoParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<DeviceUserNumberLimitListResult>> y(@a CloudParams<DeviceUserNumberLimitParams> cloudParams);

    @o
    q<CloudResult<Void>> z0(@y String str, @a CloudParams<DeviceAliasParams> cloudParams);
}
