package com.tplink.iot.cloud.bean.smart.common;

import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartReferAction {
    private int action;
    private String avatarUrl;
    private int delaySeconds;
    private String id;
    private String name;

    public SmartReferAction() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartReferAction smartReferAction = (SmartReferAction) obj;
        return this.action == smartReferAction.action && this.delaySeconds == smartReferAction.delaySeconds && Objects.equals(this.id, smartReferAction.id) && Objects.equals(this.name, smartReferAction.name) && Objects.equals(this.avatarUrl, smartReferAction.avatarUrl);
    }

    public int getAction() {
        return this.action;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getDelaySeconds() {
        return this.delaySeconds;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.name, this.avatarUrl, Integer.valueOf(this.action), Integer.valueOf(this.delaySeconds));
    }

    public void setAction(int i) {
        this.action = i;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setDelaySeconds(int i) {
        this.delaySeconds = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public SmartReferAction(String str, int i, int i2) {
        this.id = str;
        this.action = i;
        this.delaySeconds = i2;
    }
}
