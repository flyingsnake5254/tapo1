package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;

/* loaded from: classes2.dex */
public abstract class ActivityLightStripSoftApResetHintBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6599c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6600d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LottieAnimationView f6601f;
    @NonNull
    public final TextView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLightStripSoftApResetHintBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, TextView textView) {
        super(obj, view, i);
        this.f6599c = imageView;
        this.f6600d = imageView2;
        this.f6601f = lottieAnimationView;
        this.q = textView;
    }
}
