package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class FragmentAbstractFeaturedActionBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6819c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f6820d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6821f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentAbstractFeaturedActionBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f6819c = imageView;
        this.f6820d = recyclerView;
        this.f6821f = textView;
        this.q = textView2;
        this.x = textView3;
        this.y = textView4;
    }
}
