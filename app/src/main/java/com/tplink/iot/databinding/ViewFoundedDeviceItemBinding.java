package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class ViewFoundedDeviceItemBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CheckBox f7350c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7351d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7352f;
    @NonNull
    public final TextView q;
    @Bindable
    protected View.OnClickListener x;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewFoundedDeviceItemBinding(Object obj, View view, int i, CheckBox checkBox, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7350c = checkBox;
        this.f7351d = imageView;
        this.f7352f = textView;
        this.q = textView2;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);
}
