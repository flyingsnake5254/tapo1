package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class FragmentLightStripLightEffectsBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f7020c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f7021d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f7022f;
    @NonNull
    public final RecyclerView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentLightStripLightEffectsBinding(Object obj, View view, int i, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7020c = recyclerView;
        this.f7021d = recyclerView2;
        this.f7022f = recyclerView3;
        this.q = recyclerView4;
        this.x = textView;
        this.y = textView2;
    }
}
