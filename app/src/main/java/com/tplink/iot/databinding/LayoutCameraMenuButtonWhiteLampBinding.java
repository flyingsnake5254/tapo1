package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes2.dex */
public abstract class LayoutCameraMenuButtonWhiteLampBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7214c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    protected MutableLiveData<Boolean> f7215d;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    protected ObservableBoolean f7216f;
    @Bindable
    protected ObservableBoolean q;
    @Bindable
    protected ObservableBoolean x;
    @Bindable
    protected ObservableBoolean y;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutCameraMenuButtonWhiteLampBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f7214c = imageView;
    }

    public abstract void h(@Nullable MutableLiveData<Boolean> mutableLiveData);

    public abstract void i(@Nullable ObservableBoolean observableBoolean);

    public abstract void l(@Nullable ObservableBoolean observableBoolean);

    public abstract void m(@Nullable ObservableBoolean observableBoolean);

    public abstract void n(@Nullable ObservableBoolean observableBoolean);
}
