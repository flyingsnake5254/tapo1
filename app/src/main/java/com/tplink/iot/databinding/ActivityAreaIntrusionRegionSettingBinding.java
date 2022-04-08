package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityAreaIntrusionRegionSettingBinding extends ViewDataBinding {
    @Nullable
    public final ImageView H3;
    @Nullable
    public final RelativeLayout I3;
    @Nullable
    public final ImageView J3;
    @Nullable
    public final ImageView K3;
    @NonNull
    public final View L3;
    @NonNull
    public final FrameLayout M3;
    @NonNull
    public final ImageView N3;
    @Nullable
    public final TextView O3;
    @Nullable
    public final TextView P3;
    @Nullable
    public final Toolbar Q3;
    @Bindable
    protected AreaIntrusionViewModel R3;
    @Bindable
    protected View.OnClickListener S3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f6494c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final View f6495d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final View f6496f;
    @Nullable
    public final View p0;
    @Nullable
    public final View p1;
    @Nullable
    public final ImageView p2;
    @Nullable
    public final FrameLayout p3;
    @Nullable
    public final FrameLayout q;
    @Nullable
    public final ImageView x;
    @Nullable
    public final FrameLayout y;
    @Nullable
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityAreaIntrusionRegionSettingBinding(Object obj, View view, int i, View view2, View view3, View view4, FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ImageView imageView2, View view5, View view6, ImageView imageView3, FrameLayout frameLayout3, ImageView imageView4, RelativeLayout relativeLayout, ImageView imageView5, ImageView imageView6, View view7, FrameLayout frameLayout4, ImageView imageView7, TextView textView, TextView textView2, Toolbar toolbar) {
        super(obj, view, i);
        this.f6494c = view2;
        this.f6495d = view3;
        this.f6496f = view4;
        this.q = frameLayout;
        this.x = imageView;
        this.y = frameLayout2;
        this.z = imageView2;
        this.p0 = view5;
        this.p1 = view6;
        this.p2 = imageView3;
        this.p3 = frameLayout3;
        this.H3 = imageView4;
        this.I3 = relativeLayout;
        this.J3 = imageView5;
        this.K3 = imageView6;
        this.L3 = view7;
        this.M3 = frameLayout4;
        this.N3 = imageView7;
        this.O3 = textView;
        this.P3 = textView2;
        this.Q3 = toolbar;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable AreaIntrusionViewModel areaIntrusionViewModel);
}
