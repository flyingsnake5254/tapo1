package com.tplink.libtpanalytics.core.define;

import androidx.annotation.NonNull;

/* compiled from: IntegerWrapper.java */
/* loaded from: classes3.dex */
public class b {
    private Integer a;

    public b(Integer num) {
        this.a = num;
    }

    public void a(int i) {
        this.a = Integer.valueOf(this.a.intValue() + i);
    }

    public Integer b() {
        return this.a;
    }

    public void c(Integer num) {
        this.a = num;
    }

    @NonNull
    public String toString() {
        return this.a.toString();
    }
}
