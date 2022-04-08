package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes2.dex */
public abstract class LayoutCameraMenuButtonDayNightModeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7211c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7212d;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    protected MutableLiveData<Boolean> f7213f;
    @Bindable
    protected ObservableBoolean q;
    @Bindable
    protected ObservableBoolean x;
    @Bindable
    protected ObservableBoolean y;
    @Bindable
    protected ObservableBoolean z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutCameraMenuButtonDayNightModeBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.f7211c = imageView;
        this.f7212d = textView;
    }

    public abstract void h(@Nullable MutableLiveData<Boolean> mutableLiveData);

    public abstract void i(@Nullable ObservableBoolean observableBoolean);

    public abstract void l(@Nullable ObservableBoolean observableBoolean);

    public abstract void m(@Nullable ObservableBoolean observableBoolean);

    public abstract void n(@Nullable ObservableBoolean observableBoolean);
}
