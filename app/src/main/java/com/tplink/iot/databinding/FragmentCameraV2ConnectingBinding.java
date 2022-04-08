package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.libtpcontrols.TPHookView;
import com.tplink.libtpcontrols.TPRippleBackground;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2ConnectingBinding extends ViewDataBinding {
    @NonNull
    public final ImageView H3;
    @NonNull
    public final ImageView I3;
    @NonNull
    public final TextView J3;
    @NonNull
    public final RelativeLayout K3;
    @Bindable
    protected g L3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6873c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TPHookView f6874d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TPHookView f6875f;
    @NonNull
    public final ImageView p0;
    @NonNull
    public final TPRippleBackground p1;
    @NonNull
    public final TPRippleBackground p2;
    @NonNull
    public final ImageView p3;
    @NonNull
    public final ImageView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final ImageView y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2ConnectingBinding(Object obj, View view, int i, ImageView imageView, TPHookView tPHookView, TPHookView tPHookView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TPRippleBackground tPRippleBackground, TPRippleBackground tPRippleBackground2, ImageView imageView7, ImageView imageView8, ImageView imageView9, TextView textView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f6873c = imageView;
        this.f6874d = tPHookView;
        this.f6875f = tPHookView2;
        this.q = imageView2;
        this.x = imageView3;
        this.y = imageView4;
        this.z = imageView5;
        this.p0 = imageView6;
        this.p1 = tPRippleBackground;
        this.p2 = tPRippleBackground2;
        this.p3 = imageView7;
        this.H3 = imageView8;
        this.I3 = imageView9;
        this.J3 = textView;
        this.K3 = relativeLayout;
    }
}
