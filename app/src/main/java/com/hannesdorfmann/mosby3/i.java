package com.hannesdorfmann.mosby3;

import android.content.Context;
import android.os.Parcelable;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;

/* compiled from: ViewGroupMviDelegateCallback.java */
/* loaded from: classes2.dex */
public interface i<V extends b, P extends d<V, ?>> extends f<V, P> {
    Context getContext();

    void n0(Parcelable parcelable);

    Parcelable r();
}
