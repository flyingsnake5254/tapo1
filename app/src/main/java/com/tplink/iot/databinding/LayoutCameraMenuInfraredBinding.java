package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class LayoutCameraMenuInfraredBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f7220c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7221d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7222f;
    @Bindable
    protected ObservableBoolean q;
    @Bindable
    protected ObservableBoolean x;
    @Bindable
    protected ObservableBoolean y;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutCameraMenuInfraredBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7220c = textView;
        this.f7221d = textView2;
        this.f7222f = textView3;
    }

    public abstract void h(@Nullable ObservableBoolean observableBoolean);

    public abstract void i(@Nullable ObservableBoolean observableBoolean);

    public abstract void l(@Nullable ObservableBoolean observableBoolean);
}
