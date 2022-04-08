package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityMemoriesVideoBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CameraLoadingView f6621c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f6622d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Toolbar f6623f;
    @NonNull
    public final DialogMemoryBottomOperationBinding p0;
    @Bindable
    protected g p1;
    @Bindable
    protected MemoriesViewModel p2;
    @NonNull
    public final AppBarLayout q;
    @NonNull
    public final TextView x;
    @NonNull
    public final FrameLayout y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMemoriesVideoBinding(Object obj, View view, int i, CameraLoadingView cameraLoadingView, RelativeLayout relativeLayout, Toolbar toolbar, AppBarLayout appBarLayout, TextView textView, FrameLayout frameLayout, TextView textView2, DialogMemoryBottomOperationBinding dialogMemoryBottomOperationBinding) {
        super(obj, view, i);
        this.f6621c = cameraLoadingView;
        this.f6622d = relativeLayout;
        this.f6623f = toolbar;
        this.q = appBarLayout;
        this.x = textView;
        this.y = frameLayout;
        this.z = textView2;
        this.p0 = dialogMemoryBottomOperationBinding;
    }
}
