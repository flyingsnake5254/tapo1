package com.tplink.iot.devicecommon.feature;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tplink.libtpnetwork.IoTNetwork.repository.IoTCommonFeatureRepository;
import kotlin.f;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.m;
import kotlin.reflect.j;
import kotlin.t.c;

/* compiled from: LedStatusFeature.kt */
/* loaded from: classes2.dex */
public final class LedStatusFeature implements LifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ j[] f7380c = {m.h(new PropertyReference1Impl(LedStatusFeature.class, "mFeatureRepository", "getMFeatureRepository()Lcom/tplink/libtpnetwork/IoTNetwork/repository/IoTCommonFeatureRepository;", 0))};

    /* renamed from: d  reason: collision with root package name */
    public static final a f7381d = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private final c f7382f;
    private final f q;

    /* compiled from: LedStatusFeature.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private final IoTCommonFeatureRepository a() {
        return (IoTCommonFeatureRepository) this.f7382f.b(this, f7380c[0]);
    }

    private final boolean b() {
        return ((Boolean) this.q.getValue()).booleanValue();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        b.d.w.c.a.n("LedStatusFeature", "onResume");
        if (b()) {
            a().a1().F0();
        }
    }
}
