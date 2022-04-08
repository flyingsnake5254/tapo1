package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import uk.co.senab.photoview.PhotoView;

/* loaded from: classes2.dex */
public abstract class ActivityMemoriesImageBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6618c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CameraLoadingView f6619d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final PhotoView f6620f;
    @NonNull
    public final DialogMemoryBottomOperationBinding p0;
    @Bindable
    protected g p1;
    @Bindable
    protected MemoriesViewModel p2;
    @NonNull
    public final PhotoView q;
    @NonNull
    public final Toolbar x;
    @NonNull
    public final AppBarLayout y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMemoriesImageBinding(Object obj, View view, int i, ImageView imageView, CameraLoadingView cameraLoadingView, PhotoView photoView, PhotoView photoView2, Toolbar toolbar, AppBarLayout appBarLayout, TextView textView, DialogMemoryBottomOperationBinding dialogMemoryBottomOperationBinding) {
        super(obj, view, i);
        this.f6618c = imageView;
        this.f6619d = cameraLoadingView;
        this.f6620f = photoView;
        this.q = photoView2;
        this.x = toolbar;
        this.y = appBarLayout;
        this.z = textView;
        this.p0 = dialogMemoryBottomOperationBinding;
    }

    public abstract void h(@Nullable MemoriesViewModel memoriesViewModel);

    public abstract void i(@Nullable g gVar);
}
