package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;

/* loaded from: classes2.dex */
public abstract class ExoPlaybackControlViewBinding extends ViewDataBinding {
    @Bindable
    protected g H3;
    @Bindable
    protected MemoriesViewModel I3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6816c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RelativeLayout f6817d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6818f;
    @NonNull
    public final DefaultTimeBar p0;
    @NonNull
    public final RelativeLayout p1;
    @NonNull
    public final RelativeLayout p2;
    @NonNull
    public final RelativeLayout p3;
    @NonNull
    public final TextView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final ImageView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ExoPlaybackControlViewBinding(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, LinearLayout linearLayout, TextView textView, ImageView imageView2, ImageView imageView3, TextView textView2, DefaultTimeBar defaultTimeBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4) {
        super(obj, view, i);
        this.f6816c = imageView;
        this.f6817d = relativeLayout;
        this.f6818f = linearLayout;
        this.q = textView;
        this.x = imageView2;
        this.y = imageView3;
        this.z = textView2;
        this.p0 = defaultTimeBar;
        this.p1 = relativeLayout2;
        this.p2 = relativeLayout3;
        this.p3 = relativeLayout4;
    }

    public abstract void h(@Nullable MemoriesViewModel memoriesViewModel);

    public abstract void i(@Nullable g gVar);
}
