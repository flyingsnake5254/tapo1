package com.tplink.iot.cloud.bean.smart.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;
import com.tplink.iot.cloud.bean.thing.params.ThingEventParams;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartThingTrigger {
    private String avatarUrl;
    private String category;
    private ThingEventParams event;
    private boolean isSubThing;
    @b(Base64TypeAdapter.class)
    private String nickname;
    private SmartThingStateReported stateReported;
    private String thingName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartThingTrigger smartThingTrigger = (SmartThingTrigger) obj;
        return this.isSubThing == smartThingTrigger.isSubThing && Objects.equals(this.thingName, smartThingTrigger.thingName) && Objects.equals(this.nickname, smartThingTrigger.nickname) && Objects.equals(this.avatarUrl, smartThingTrigger.avatarUrl) && Objects.equals(this.stateReported, smartThingTrigger.stateReported) && Objects.equals(this.event, smartThingTrigger.event);
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getCategory() {
        return this.category;
    }

    public ThingEventParams getEvent() {
        return this.event;
    }

    public String getNickname() {
        return this.nickname;
    }

    public SmartThingStateReported getStateReported() {
        return this.stateReported;
    }

    public String getThingName() {
        return this.thingName;
    }

    public int hashCode() {
        return Objects.hash(this.thingName, this.nickname, this.avatarUrl, Boolean.valueOf(this.isSubThing), this.stateReported, this.event, this.category);
    }

    public boolean isSubThing() {
        return this.isSubThing;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setEvent(ThingEventParams thingEventParams) {
        this.event = thingEventParams;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setStateReported(SmartThingStateReported smartThingStateReported) {
        this.stateReported = smartThingStateReported;
    }

    public void setSubThing(boolean z) {
        this.isSubThing = z;
    }

    public void setThingName(String str) {
        this.thingName = str;
    }
}
