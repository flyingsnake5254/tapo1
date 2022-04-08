package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.libtpcontrols.TPRippleBackground;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2RescanWifiBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6927c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6928d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f6929f;
    @NonNull
    public final TPRippleBackground q;
    @NonNull
    public final TextView x;
    @Bindable
    protected g y;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2RescanWifiBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TPRippleBackground tPRippleBackground, TextView textView) {
        super(obj, view, i);
        this.f6927c = imageView;
        this.f6928d = imageView2;
        this.f6929f = imageView3;
        this.q = tPRippleBackground;
        this.x = textView;
    }
}
