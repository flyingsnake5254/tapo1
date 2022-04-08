package com.tplink.cloud.bean.account.params;

import java.util.Map;

/* loaded from: classes2.dex */
public class UpdateTopicSubscriptionParams extends TopicSubscriptionParams {
    private Map<String, Boolean> topicSubscription;

    public UpdateTopicSubscriptionParams() {
    }

    public Map<String, Boolean> getTopicSubscription() {
        return this.topicSubscription;
    }

    public void setTopicSubscription(Map<String, Boolean> map) {
        this.topicSubscription = map;
    }

    public UpdateTopicSubscriptionParams(String str, String str2, Map<String, Boolean> map) {
        super(str, str2);
        this.topicSubscription = map;
    }
}
