package com.tplink.iot.cloud.bean.push.params;

import com.google.gson.q.b;
import com.tplink.cloud.bean.push.SubscribeMessageAdapter;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class IoTSubscribeMsgParams {
    @b(SubscribeMessageAdapter.class)
    private List<SubscribeItemParams> subscribeMsgType = new ArrayList();
    @b(SubscribeMessageAdapter.class)
    private List<SubscribeItemParams> subscribeMsgTypeForSub = new ArrayList();

    public IoTSubscribeMsgParams() {
    }

    public List<SubscribeItemParams> getSubscribeMsgType() {
        return this.subscribeMsgType;
    }

    public List<SubscribeItemParams> getSubscribeMsgTypeForSub() {
        return this.subscribeMsgTypeForSub;
    }

    public void setSubscribeMsgType(List<SubscribeItemParams> list) {
        if (list != null) {
            this.subscribeMsgType = list;
        }
    }

    public void setSubscribeMsgTypeForSub(List<SubscribeItemParams> list) {
        if (list != null) {
            this.subscribeMsgTypeForSub = list;
        }
    }

    public IoTSubscribeMsgParams(List<SubscribeItemParams> list, List<SubscribeItemParams> list2) {
        setSubscribeMsgType(list);
        setSubscribeMsgTypeForSub(list2);
    }
}
