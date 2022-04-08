package com.tplink.iot.cloud.bean.thing.common;

import java.util.List;

/* loaded from: classes2.dex */
public class ThingMsgPushSettings {
    private List<MsgPushSetting> msgPushSettings;

    public ThingMsgPushSettings() {
    }

    public List<MsgPushSetting> getMsgPushSettings() {
        return this.msgPushSettings;
    }

    public void setMsgPushSettings(List<MsgPushSetting> list) {
        this.msgPushSettings = list;
    }

    public ThingMsgPushSettings(List<MsgPushSetting> list) {
        this.msgPushSettings = list;
    }
}
