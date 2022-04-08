package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;

/* loaded from: classes2.dex */
public abstract class ViewVideoSurfaceLayoutBinding extends ViewDataBinding {
    @NonNull
    public final TextView H3;
    @NonNull
    public final TextView I3;
    @NonNull
    public final View J3;
    @Bindable
    protected ObservableBoolean K3;
    @Bindable
    protected ObservableBoolean L3;
    @Bindable
    protected ObservableBoolean M3;
    @Bindable
    protected ObservableBoolean N3;
    @Bindable
    protected ObservableBoolean O3;
    @Bindable
    protected ObservableBoolean P3;
    @Bindable
    protected ObservableBoolean Q3;
    @Bindable
    protected ObservableField<String> R3;
    @Bindable
    protected ObservableBoolean S3;
    @Bindable
    protected ObservableBoolean T3;
    @Bindable
    protected Boolean U3;
    @Bindable
    protected ObservableBoolean V3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f7360c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7361d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f7362f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @NonNull
    public final ImageView p2;
    @NonNull
    public final ImageView p3;
    @NonNull
    public final FrameLayout q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final LottieAnimationView y;
    @NonNull
    public final View z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewVideoSurfaceLayoutBinding(Object obj, View view, int i, View view2, ImageView imageView, View view3, FrameLayout frameLayout, LinearLayout linearLayout, LottieAnimationView lottieAnimationView, View view4, TextView textView, TextView textView2, ImageView imageView2, ImageView imageView3, TextView textView3, TextView textView4, View view5) {
        super(obj, view, i);
        this.f7360c = view2;
        this.f7361d = imageView;
        this.f7362f = view3;
        this.q = frameLayout;
        this.x = linearLayout;
        this.y = lottieAnimationView;
        this.z = view4;
        this.p0 = textView;
        this.p1 = textView2;
        this.p2 = imageView2;
        this.p3 = imageView3;
        this.H3 = textView3;
        this.I3 = textView4;
        this.J3 = view5;
    }

    public abstract void h(@Nullable ObservableBoolean observableBoolean);

    public abstract void i(@Nullable ObservableBoolean observableBoolean);

    public abstract void l(@Nullable ObservableBoolean observableBoolean);

    public abstract void m(@Nullable ObservableBoolean observableBoolean);

    public abstract void n(@Nullable ObservableBoolean observableBoolean);

    public abstract void o(@Nullable ObservableBoolean observableBoolean);

    public abstract void p(@Nullable ObservableBoolean observableBoolean);

    public abstract void q(@Nullable ObservableBoolean observableBoolean);

    public abstract void r(@Nullable ObservableBoolean observableBoolean);

    public abstract void s(@Nullable ObservableBoolean observableBoolean);

    public abstract void t(@Nullable Boolean bool);

    public abstract void u(@Nullable ObservableField<String> observableField);
}
