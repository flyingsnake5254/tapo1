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
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSetNameViewModel;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2NameBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6915c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final DrawableEditText f6916d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f6917f;
    @Bindable
    protected CameraOnBoardingViewModel p0;
    @Bindable
    protected g p1;
    @NonNull
    public final Toolbar q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected CameraSetNameViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2NameBinding(Object obj, View view, int i, Button button, DrawableEditText drawableEditText, RelativeLayout relativeLayout, Toolbar toolbar, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6915c = button;
        this.f6916d = drawableEditText;
        this.f6917f = relativeLayout;
        this.q = toolbar;
        this.x = textView;
        this.y = textView2;
    }
}
