package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public abstract class ActivitySoftApCommonGuideBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TPRefreshableButton f6693c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f6694d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6695f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @Bindable
    protected View.OnClickListener p2;
    @NonNull
    public final ImageView q;
    @NonNull
    public final LottieAnimationView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySoftApCommonGuideBinding(Object obj, View view, int i, TPRefreshableButton tPRefreshableButton, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f6693c = tPRefreshableButton;
        this.f6694d = frameLayout;
        this.f6695f = imageView;
        this.q = imageView2;
        this.x = lottieAnimationView;
        this.y = textView;
        this.z = textView2;
        this.p0 = textView3;
        this.p1 = textView4;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);
}
