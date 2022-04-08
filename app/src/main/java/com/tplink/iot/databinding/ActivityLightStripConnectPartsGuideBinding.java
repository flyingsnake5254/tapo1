package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class ActivityLightStripConnectPartsGuideBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6584c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6585d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6586f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected View.OnClickListener z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLightStripConnectPartsGuideBinding(Object obj, View view, int i, Button button, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6584c = button;
        this.f6585d = imageView;
        this.f6586f = imageView2;
        this.q = textView;
        this.x = textView2;
        this.y = textView3;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);
}
