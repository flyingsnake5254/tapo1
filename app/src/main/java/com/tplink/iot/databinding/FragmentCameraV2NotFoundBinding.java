package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2NotFoundBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6918c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f6919d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f6920f;
    @Bindable
    protected CameraOnBoardingViewModel p0;
    @Bindable
    protected g p1;
    @Bindable
    protected View p2;
    @NonNull
    public final ImageView q;
    @NonNull
    public final LinearLayout x;
    @NonNull
    public final Toolbar y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2NotFoundBinding(Object obj, View view, int i, Button button, View view2, View view3, ImageView imageView, LinearLayout linearLayout, Toolbar toolbar, TextView textView) {
        super(obj, view, i);
        this.f6918c = button;
        this.f6919d = view2;
        this.f6920f = view3;
        this.q = imageView;
        this.x = linearLayout;
        this.y = toolbar;
        this.z = textView;
    }
}
