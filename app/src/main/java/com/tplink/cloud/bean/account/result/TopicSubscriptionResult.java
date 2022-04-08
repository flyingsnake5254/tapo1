package com.tplink.cloud.bean.account.result;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TopicSubscriptionResult {
    private Map<String, Boolean> topicSubscription = new HashMap();

    public Map<String, Boolean> getTopicSubscription() {
        return this.topicSubscription;
    }

    public void setTopicSubscription(Map<String, Boolean> map) {
        this.topicSubscription = map;
    }
}
