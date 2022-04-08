package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraManualInputPwdViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2ManualInputPwdBinding extends ViewDataBinding {
    @Bindable
    protected g H3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6912c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DrawableEditText f6913d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final DrawableEditText f6914f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @Bindable
    protected CameraManualInputPwdViewModel p2;
    @Bindable
    protected CameraOnBoardingViewModel p3;
    @NonNull
    public final RelativeLayout q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2ManualInputPwdBinding(Object obj, View view, int i, Button button, DrawableEditText drawableEditText, DrawableEditText drawableEditText2, RelativeLayout relativeLayout, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f6912c = button;
        this.f6913d = drawableEditText;
        this.f6914f = drawableEditText2;
        this.q = relativeLayout;
        this.x = toolbar;
        this.y = textView;
        this.z = textView2;
        this.p0 = textView3;
        this.p1 = textView4;
    }
}
