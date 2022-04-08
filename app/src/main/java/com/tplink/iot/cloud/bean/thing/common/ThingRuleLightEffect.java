package com.tplink.iot.cloud.bean.thing.common;

import com.google.gson.i;
import com.google.gson.q.b;
import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.common.Base64TypeAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class ThingRuleLightEffect {
    @c("change_mode")
    private String changeMode;
    @c("change_time")
    private long changeTime;
    @c("color_status_list")
    private i colorStatusList;
    private String id;
    @c("scene_name")
    @b(Base64TypeAdapter.class)
    private String sceneName;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ChangeMode {
        public static final String MODE_BLN = "bln";
        public static final String MODE_DIRECT = "direct";
    }

    public String getChangeMode() {
        return this.changeMode;
    }

    public long getChangeTime() {
        return this.changeTime;
    }

    public i getColorStatusList() {
        return this.colorStatusList;
    }

    public String getId() {
        return this.id;
    }

    public String getSceneName() {
        return this.sceneName;
    }

    public void setChangeMode(String str) {
        this.changeMode = str;
    }

    public void setChangeTime(long j) {
        this.changeTime = j;
    }

    public void setColorStatusList(i iVar) {
        this.colorStatusList = iVar;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setSceneName(String str) {
        this.sceneName = str;
    }
}
