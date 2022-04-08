package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

/* loaded from: classes2.dex */
public abstract class FragmentPhotosBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f7041c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f7042d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CollapsingToolbarLayout f7043f;
    @Bindable
    protected g p0;
    @Bindable
    protected MemoriesViewModel p1;
    @NonNull
    public final RecyclerView q;
    @NonNull
    public final CameraLoadingView x;
    @NonNull
    public final ImageView y;
    @NonNull
    public final DialogMemoryBottomOperationBinding z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPhotosBinding(Object obj, View view, int i, View view2, RelativeLayout relativeLayout, CollapsingToolbarLayout collapsingToolbarLayout, RecyclerView recyclerView, CameraLoadingView cameraLoadingView, ImageView imageView, DialogMemoryBottomOperationBinding dialogMemoryBottomOperationBinding) {
        super(obj, view, i);
        this.f7041c = view2;
        this.f7042d = relativeLayout;
        this.f7043f = collapsingToolbarLayout;
        this.q = recyclerView;
        this.x = cameraLoadingView;
        this.y = imageView;
        this.z = dialogMemoryBottomOperationBinding;
    }

    public abstract void h(@Nullable MemoriesViewModel memoriesViewModel);

    public abstract void i(@Nullable g gVar);
}
