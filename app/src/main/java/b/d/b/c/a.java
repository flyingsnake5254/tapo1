package b.d.b.c;

import com.tplink.cloud.bean.account.params.CheckPasswordParams;
import com.tplink.cloud.bean.account.params.CloudUserEmailParams;
import com.tplink.cloud.bean.account.params.CloudUserParams;
import com.tplink.cloud.bean.account.params.LoginParams;
import com.tplink.cloud.bean.account.params.ModifyCloudPasswordParams;
import com.tplink.cloud.bean.account.params.RegisterParams;
import com.tplink.cloud.bean.account.params.TopicSubscriptionParams;
import com.tplink.cloud.bean.account.params.UpdateAccountInfoParams;
import com.tplink.cloud.bean.account.params.UpdateTopicSubscriptionParams;
import com.tplink.cloud.bean.account.result.AccountStatusResult;
import com.tplink.cloud.bean.account.result.CheckPasswordV1Result;
import com.tplink.cloud.bean.account.result.CloudUserResult;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.bean.account.result.TopicSubscriptionResult;
import com.tplink.cloud.bean.common.CloudParams;
import com.tplink.cloud.bean.common.CloudResult;
import io.reactivex.q;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit2.x.k;
import retrofit2.x.o;

/* compiled from: AccountApi.java */
/* loaded from: classes2.dex */
public interface a {
    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<TopicSubscriptionResult>> C1(@retrofit2.x.a CloudParams<TopicSubscriptionParams> cloudParams);

    @k({"token-required:false"})
    @o("/api/v1/account")
    q<CloudResult<CheckPasswordV1Result>> J1(@retrofit2.x.a CloudParams<CheckPasswordParams> cloudParams);

    @k({"token-required:false"})
    @o("/api/v1/account")
    q<CloudResult<LoginV1Result>> L1(@retrofit2.x.a CloudParams<LoginParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> N0(@retrofit2.x.a CloudParams<UpdateAccountInfoParams> cloudParams);

    @k({"token-required:false"})
    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> T(@retrofit2.x.a CloudParams<CloudUserEmailParams> cloudParams);

    @k({"token-required:false"})
    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> U0(@retrofit2.x.a CloudParams<CloudUserEmailParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> e1(@retrofit2.x.a CloudParams<CloudUserParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> f(@retrofit2.x.a CloudParams<CloudUserParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> f0(@retrofit2.x.a CloudParams<UpdateTopicSubscriptionParams> cloudParams);

    @k({"token-required:false"})
    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> o1(@retrofit2.x.a CloudParams<RegisterParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<CloudUserResult>> p(@retrofit2.x.a CloudParams<CloudUserParams> cloudParams);

    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<Void>> s1(@retrofit2.x.a CloudParams<ModifyCloudPasswordParams> cloudParams);

    @k({"token-required:false"})
    @o(MqttTopic.TOPIC_LEVEL_SEPARATOR)
    q<CloudResult<AccountStatusResult>> x1(@retrofit2.x.a CloudParams<CloudUserParams> cloudParams);
}
