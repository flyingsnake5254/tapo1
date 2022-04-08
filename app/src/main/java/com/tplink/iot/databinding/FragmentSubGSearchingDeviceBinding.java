package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;

/* loaded from: classes2.dex */
public abstract class FragmentSubGSearchingDeviceBinding extends ViewDataBinding {
    @NonNull
    public final TextView H3;
    @NonNull
    public final RelativeLayout I3;
    @Bindable
    protected SubGViewModel J3;
    @Bindable
    protected g K3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7078c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7079d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7080f;
    @NonNull
    public final TPRippleBackground p0;
    @NonNull
    public final TPRippleBackground p1;
    @NonNull
    public final ImageView p2;
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
    public FragmentSubGSearchingDeviceBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, TPRippleBackground tPRippleBackground, TPRippleBackground tPRippleBackground2, ImageView imageView8, ImageView imageView9, TextView textView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f7078c = imageView;
        this.f7079d = imageView2;
        this.f7080f = imageView3;
        this.q = imageView4;
        this.x = imageView5;
        this.y = imageView6;
        this.z = imageView7;
        this.p0 = tPRippleBackground;
        this.p1 = tPRippleBackground2;
        this.p2 = imageView8;
        this.p3 = imageView9;
        this.H3 = textView;
        this.I3 = relativeLayout;
    }
}
