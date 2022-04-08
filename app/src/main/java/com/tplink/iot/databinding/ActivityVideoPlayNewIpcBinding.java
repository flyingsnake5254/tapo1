package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityVideoPlayNewIpcBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout H3;
    @Bindable
    protected VideoPlayViewModel I3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f6762c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f6763d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f6764f;
    @NonNull
    public final TextView p0;
    @NonNull
    public final TextView p1;
    @NonNull
    public final Toolbar p2;
    @NonNull
    public final View p3;
    @NonNull
    public final TipsBar q;
    @NonNull
    public final RelativeLayout x;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityVideoPlayNewIpcBinding(Object obj, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, TipsBar tipsBar, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, Toolbar toolbar, View view2, FrameLayout frameLayout4) {
        super(obj, view, i);
        this.f6762c = frameLayout;
        this.f6763d = frameLayout2;
        this.f6764f = frameLayout3;
        this.q = tipsBar;
        this.x = relativeLayout;
        this.y = constraintLayout;
        this.z = imageView;
        this.p0 = textView;
        this.p1 = textView2;
        this.p2 = toolbar;
        this.p3 = view2;
        this.H3 = frameLayout4;
    }

    public abstract void h(@Nullable VideoPlayViewModel videoPlayViewModel);
}
