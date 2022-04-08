package com.tplink.iot.generated.callback;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: OnTouchListener.java */
/* loaded from: classes2.dex */
public final class c implements View.OnTouchListener {

    /* renamed from: c  reason: collision with root package name */
    final a f7966c;

    /* renamed from: d  reason: collision with root package name */
    final int f7967d;

    /* compiled from: OnTouchListener.java */
    /* loaded from: classes2.dex */
    public interface a {
        boolean f(int i, View view, MotionEvent motionEvent);
    }

    public c(a aVar, int i) {
        this.f7966c = aVar;
        this.f7967d = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f7966c.f(this.f7967d, view, motionEvent);
    }
}
