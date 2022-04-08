package com.tplink.iot.model.smart;

import com.tplink.iot.cloud.bean.smart.common.SmartScheduleSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import kotlin.jvm.internal.f;

/* compiled from: SmartConditionTriggerBean.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private int f8200b;

    /* renamed from: c  reason: collision with root package name */
    private SmartScheduleSetting f8201c;

    /* renamed from: d  reason: collision with root package name */
    private SmartThingTrigger f8202d;

    /* compiled from: SmartConditionTriggerBean.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private g(int i, SmartScheduleSetting smartScheduleSetting, SmartThingTrigger smartThingTrigger) {
        this.f8200b = i;
        this.f8201c = smartScheduleSetting;
        this.f8202d = smartThingTrigger;
    }

    public final int a() {
        return this.f8200b;
    }

    public final SmartScheduleSetting b() {
        return this.f8201c;
    }

    public final String c() {
        SmartThingTrigger smartThingTrigger = this.f8202d;
        if (smartThingTrigger != null) {
            return smartThingTrigger.getThingName();
        }
        return null;
    }

    public final SmartThingTrigger d() {
        return this.f8202d;
    }

    public g() {
        this(0, null, null);
    }

    public g(int i, SmartScheduleSetting smartScheduleSetting) {
        this(i, smartScheduleSetting, null);
    }

    public g(int i, SmartThingTrigger smartThingTrigger) {
        this(i, null, smartThingTrigger);
    }
}
