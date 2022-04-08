package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

/* loaded from: classes2.dex */
public abstract class LayoutPlaybackToolbarBottomBinding extends ViewDataBinding {
    @Bindable
    protected g H3;
    @Bindable
    protected VodViewModel I3;
    @Bindable
    protected PlaybackMainViewModel J3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Guideline f7280c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Guideline f7281d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Guideline f7282f;
    @NonNull
    public final ImageView p0;
    @NonNull
    public final ImageView p1;
    @NonNull
    public final ImageView p2;
    @NonNull
    public final ImageView p3;
    @NonNull
    public final Guideline q;
    @NonNull
    public final Guideline x;
    @NonNull
    public final Guideline y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutPlaybackToolbarBottomBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.f7280c = guideline;
        this.f7281d = guideline2;
        this.f7282f = guideline3;
        this.q = guideline4;
        this.x = guideline5;
        this.y = guideline6;
        this.z = imageView;
        this.p0 = imageView2;
        this.p1 = imageView3;
        this.p2 = imageView4;
        this.p3 = imageView5;
    }

    public abstract void h(@Nullable g gVar);

    public abstract void i(@Nullable PlaybackMainViewModel playbackMainViewModel);

    public abstract void l(@Nullable VodViewModel vodViewModel);
}
