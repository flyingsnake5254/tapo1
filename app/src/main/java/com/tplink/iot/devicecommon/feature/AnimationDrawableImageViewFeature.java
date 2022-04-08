package com.tplink.iot.devicecommon.feature;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: AnimationDrawableImageViewFeature.kt */
/* loaded from: classes2.dex */
public final class AnimationDrawableImageViewFeature implements LifecycleObserver {

    /* renamed from: c  reason: collision with root package name */
    public static final a f7377c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private final LifecycleOwner f7378d;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f7379f;

    /* compiled from: AnimationDrawableImageViewFeature.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final AnimationDrawableImageViewFeature a(LifecycleOwner owner, ImageView imageView) {
            j.e(owner, "owner");
            j.e(imageView, "imageView");
            return new AnimationDrawableImageViewFeature(owner, imageView, null);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private AnimationDrawableImageViewFeature(LifecycleOwner lifecycleOwner, ImageView imageView) {
        this.f7378d = lifecycleOwner;
        this.f7379f = imageView;
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public static final AnimationDrawableImageViewFeature a(LifecycleOwner lifecycleOwner, ImageView imageView) {
        return f7377c.a(lifecycleOwner, imageView);
    }

    private final void c() {
        Drawable drawable = this.f7379f.getDrawable();
        if (drawable != null && (drawable instanceof AnimationDrawable)) {
            ((AnimationDrawable) drawable).start();
        }
    }

    private final void d() {
        Lifecycle lifecycle = this.f7378d.getLifecycle();
        j.d(lifecycle, "owner.lifecycle");
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            c();
        }
    }

    private final void e() {
        Drawable drawable = this.f7379f.getDrawable();
        if (drawable != null && (drawable instanceof AnimationDrawable)) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    public final void b(@DrawableRes int i) {
        this.f7379f.setImageResource(i);
        d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        e();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        c();
    }

    public /* synthetic */ AnimationDrawableImageViewFeature(LifecycleOwner lifecycleOwner, ImageView imageView, f fVar) {
        this(lifecycleOwner, imageView);
    }
}
