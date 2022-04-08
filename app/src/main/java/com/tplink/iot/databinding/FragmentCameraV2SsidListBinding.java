package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSSIDListViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentCameraV2SsidListBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6948c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f6949d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f6950f;
    @NonNull
    public final Toolbar q;
    @Bindable
    protected CameraSSIDListViewModel x;
    @Bindable
    protected CameraOnBoardingViewModel y;
    @Bindable
    protected g z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraV2SsidListBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, RecyclerView recyclerView, Toolbar toolbar) {
        super(obj, view, i);
        this.f6948c = textView;
        this.f6949d = linearLayout;
        this.f6950f = recyclerView;
        this.q = toolbar;
    }
}
