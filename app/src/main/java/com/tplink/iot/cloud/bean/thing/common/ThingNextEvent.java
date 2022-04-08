package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.q.b;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;

/* loaded from: classes2.dex */
public class ThingNextEvent {
    private String avatarUrl;
    private NextEvent nextEvent;
    @b(Base64TypeAdapter.class)
    private String nickname;
    private String roomId;
    private String roomName;
    private String thingName;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public NextEvent getNextEvent() {
        return this.nextEvent;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getThingName() {
        return this.thingName;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setNextEvent(NextEvent nextEvent) {
        this.nextEvent = nextEvent;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setThingName(String str) {
        this.thingName = str;
    }
}
