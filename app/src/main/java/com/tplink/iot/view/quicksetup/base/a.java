package com.tplink.iot.view.quicksetup.base;

import android.view.View;

/* compiled from: OnMultiClickListener.java */
/* loaded from: classes2.dex */
public abstract class a implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private long f9511c;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f9511c >= 200) {
            this.f9511c = currentTimeMillis;
            a(view);
        }
    }
}
