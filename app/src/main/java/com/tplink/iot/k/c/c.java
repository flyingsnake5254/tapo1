package com.tplink.iot.k.c;

import android.view.View;

/* compiled from: OnLimitClickHelper.java */
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private long f8022c = 0;

    /* renamed from: d  reason: collision with root package name */
    private d f8023d;

    public c(d dVar) {
        this.f8023d = null;
        this.f8023d = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f8022c > 1000) {
            this.f8022c = currentTimeMillis;
            d dVar = this.f8023d;
            if (dVar != null) {
                dVar.onClick(view);
            }
        }
    }
}
