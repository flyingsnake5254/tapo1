package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

/* loaded from: classes2.dex */
public abstract class ActivityCameraPreviewCloudVideoServerBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6518c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f6519d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6520f;
    @NonNull
    public final TextView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected MutableLiveData<Boolean> y;
    @Bindable
    protected MutableLiveData<Boolean> z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCameraPreviewCloudVideoServerBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6518c = imageView;
        this.f6519d = linearLayout;
        this.f6520f = textView;
        this.q = textView2;
        this.x = textView3;
    }

    public abstract void h(@Nullable MutableLiveData<Boolean> mutableLiveData);

    public abstract void i(@Nullable MutableLiveData<Boolean> mutableLiveData);
}
