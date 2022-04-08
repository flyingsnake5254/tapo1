package com.tplink.iot.model.smart;

import androidx.annotation.Nullable;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;

/* compiled from: SmartActionTaskBean.java */
/* loaded from: classes2.dex */
public class e {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private SmartReferAction f8197b;

    /* renamed from: c  reason: collision with root package name */
    private SmartThingAction f8198c;

    public e(SmartReferAction smartReferAction, int i) {
        this.f8197b = smartReferAction;
        this.a = i;
    }

    public int a() {
        SmartReferAction smartReferAction = this.f8197b;
        if (smartReferAction != null) {
            return smartReferAction.getAction();
        }
        return -1;
    }

    public int b() {
        return this.a;
    }

    public String c() {
        SmartThingAction smartThingAction = this.f8198c;
        if (smartThingAction != null) {
            return smartThingAction.getCategory();
        }
        return null;
    }

    public String d() {
        SmartReferAction smartReferAction = this.f8197b;
        if (smartReferAction != null) {
            return smartReferAction.getId();
        }
        return null;
    }

    @Nullable
    public String e() {
        SmartThingAction smartThingAction = this.f8198c;
        if (smartThingAction != null) {
            return smartThingAction.getNickname();
        }
        return null;
    }

    public SmartReferAction f() {
        return this.f8197b;
    }

    public SmartThingAction g() {
        return this.f8198c;
    }

    public String h() {
        SmartThingAction smartThingAction = this.f8198c;
        if (smartThingAction != null) {
            return smartThingAction.getThingName();
        }
        return null;
    }

    public e(SmartThingAction smartThingAction, int i) {
        this.f8198c = smartThingAction;
        this.a = i;
    }
}
