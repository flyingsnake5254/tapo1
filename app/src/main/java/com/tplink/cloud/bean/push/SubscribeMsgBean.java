package com.tplink.cloud.bean.push;

import com.google.gson.q.b;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import java.util.List;

/* loaded from: classes2.dex */
public class SubscribeMsgBean {
    @b(SubscribeMessageAdapter.class)
    private List<SubscribeItemParams> subscribeMsgType;

    public SubscribeMsgBean() {
    }

    public List<SubscribeItemParams> getSubscribeMsgType() {
        return this.subscribeMsgType;
    }

    public void setSubscribeMsgType(List<SubscribeItemParams> list) {
        this.subscribeMsgType = list;
    }

    public SubscribeMsgBean(List<SubscribeItemParams> list) {
        this.subscribeMsgType = list;
    }
}
