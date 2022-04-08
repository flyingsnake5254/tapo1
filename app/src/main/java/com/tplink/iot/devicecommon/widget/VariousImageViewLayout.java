package com.tplink.iot.devicecommon.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.LayoutVariousImageViewBinding;
import com.tplink.iot.devicecommon.feature.AnimationDrawableImageViewFeature;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: VariousImageViewLayout.kt */
/* loaded from: classes2.dex */
public final class VariousImageViewLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private final LayoutVariousImageViewBinding f7430c;

    public VariousImageViewLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public VariousImageViewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ VariousImageViewLayout(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void c() {
        ImageView imageView = this.f7430c.f7319c;
        j.d(imageView, "mBinding.imageView");
        imageView.setVisibility(0);
        LottieAnimationView lottieAnimationView = this.f7430c.f7320d;
        j.d(lottieAnimationView, "mBinding.lottieAnimationView");
        lottieAnimationView.setVisibility(8);
    }

    private final void d() {
        ImageView imageView = this.f7430c.f7319c;
        j.d(imageView, "mBinding.imageView");
        imageView.setVisibility(8);
        LottieAnimationView lottieAnimationView = this.f7430c.f7320d;
        j.d(lottieAnimationView, "mBinding.lottieAnimationView");
        lottieAnimationView.setVisibility(0);
    }

    public final void a(LifecycleOwner lifecycleOwner, @DrawableRes int i) {
        j.e(lifecycleOwner, "lifecycleOwner");
        AnimationDrawableImageViewFeature.a aVar = AnimationDrawableImageViewFeature.f7377c;
        ImageView imageView = this.f7430c.f7319c;
        j.d(imageView, "mBinding.imageView");
        aVar.a(lifecycleOwner, imageView).b(i);
        c();
    }

    public final void b(LifecycleOwner lifecycleOwner, l<? super LottieAnimationView, p> setup) {
        j.e(lifecycleOwner, "lifecycleOwner");
        j.e(setup, "setup");
        LottieAnimationViewFeature.a aVar = LottieAnimationViewFeature.f7383c;
        LottieAnimationView lottieAnimationView = this.f7430c.f7320d;
        j.d(lottieAnimationView, "mBinding.lottieAnimationView");
        aVar.b(lifecycleOwner, lottieAnimationView, setup);
        d();
    }

    public final void setStaticImageDrawable(Drawable drawable) {
        this.f7430c.f7319c.setImageDrawable(drawable);
        c();
    }

    public final void setStaticImageResource(@DrawableRes int i) {
        this.f7430c.f7319c.setImageResource(i);
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VariousImageViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_various_image_view, this, true);
        j.d(inflate, "DataBindingUtil.inflate(…s_image_view, this, true)");
        this.f7430c = (LayoutVariousImageViewBinding) inflate;
    }
}
