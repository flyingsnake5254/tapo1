package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;

/* loaded from: classes2.dex */
public abstract class FragmentSubGSaveSettingBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7075c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7076d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7077f;
    @NonNull
    public final TPRippleBackground q;
    @NonNull
    public final TextView x;
    @Bindable
    protected SubGViewModel y;
    @Bindable
    protected g z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubGSaveSettingBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TPRippleBackground tPRippleBackground, TextView textView) {
        super(obj, view, i);
        this.f7075c = imageView;
        this.f7076d = imageView2;
        this.f7077f = imageView3;
        this.q = tPRippleBackground;
        this.x = textView;
    }
}
