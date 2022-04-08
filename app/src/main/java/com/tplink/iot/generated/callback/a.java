package com.tplink.iot.generated.callback;

import android.view.View;

/* compiled from: OnClickListener.java */
/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    final AbstractC0211a f7962c;

    /* renamed from: d  reason: collision with root package name */
    final int f7963d;

    /* compiled from: OnClickListener.java */
    /* renamed from: com.tplink.iot.generated.callback.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0211a {
        void d(int i, View view);
    }

    public a(AbstractC0211a aVar, int i) {
        this.f7962c = aVar;
        this.f7963d = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7962c.d(this.f7963d, view);
    }
}
