package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class ItemCameraSsidLayoutBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7159c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7160d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7161f;
    @NonNull
    public final RelativeLayout q;
    @Bindable
    protected String x;
    @Bindable
    protected View.OnClickListener y;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCameraSsidLayoutBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f7159c = imageView;
        this.f7160d = imageView2;
        this.f7161f = textView;
        this.q = relativeLayout;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable String str);
}
