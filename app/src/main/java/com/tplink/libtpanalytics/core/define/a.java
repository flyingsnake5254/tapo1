package com.tplink.libtpanalytics.core.define;

import android.os.HandlerThread;

/* compiled from: EventsConsumeThread.java */
/* loaded from: classes3.dex */
public class a extends HandlerThread {

    /* renamed from: c  reason: collision with root package name */
    public static final a f11947c = new a("EventsConsumer");

    private a(String str) {
        super(str);
        start();
    }
}
