package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.i;

/* loaded from: classes2.dex */
public class ThingRuleMusicRhythmMode {
    private i config;
    private String mode;

    public ThingRuleMusicRhythmMode() {
    }

    public i getConfig() {
        return this.config;
    }

    public String getMode() {
        return this.mode;
    }

    public void setConfig(i iVar) {
        this.config = iVar;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public ThingRuleMusicRhythmMode(String str, i iVar) {
        this.mode = str;
        this.config = iVar;
    }
}
