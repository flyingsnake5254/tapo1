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
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityLineCrossingRegionSettingBinding extends ViewDataBinding {
    @Nullable
    public final View H3;
    @Nullable
    public final ImageView I3;
    @Nullable
    public final FrameLayout J3;
    @Nullable
    public final ImageView K3;
    @Nullable
    public final View L3;
    @Nullable
    public final FrameLayout M3;
    @Nullable
    public final ImageView N3;
    @Nullable
    public final RelativeLayout O3;
    @Nullable
    public final ImageView P3;
    @Nullable
    public final ImageView Q3;
    @NonNull
    public final View R3;
    @NonNull
    public final FrameLayout S3;
    @NonNull
    public final ImageView T3;
    @Nullable
    public final TextView U3;
    @Nullable
    public final Toolbar V3;
    @Bindable
    protected LineCrossingViewModel W3;
    @Bindable
    protected View.OnClickListener X3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f6609c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final View f6610d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final View f6611f;
    @Nullable
    public final View p0;
    @Nullable
    public final FrameLayout p1;
    @Nullable
    public final ImageView p2;
    @Nullable
    public final View p3;
    @Nullable
    public final FrameLayout q;
    @Nullable
    public final ImageView x;
    @Nullable
    public final FrameLayout y;
    @Nullable
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLineCrossingRegionSettingBinding(Object obj, View view, int i, View view2, View view3, View view4, FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ImageView imageView2, View view5, FrameLayout frameLayout3, ImageView imageView3, View view6, View view7, ImageView imageView4, FrameLayout frameLayout4, ImageView imageView5, View view8, FrameLayout frameLayout5, ImageView imageView6, RelativeLayout relativeLayout, ImageView imageView7, ImageView imageView8, View view9, FrameLayout frameLayout6, ImageView imageView9, TextView textView, Toolbar toolbar) {
        super(obj, view, i);
        this.f6609c = view2;
        this.f6610d = view3;
        this.f6611f = view4;
        this.q = frameLayout;
        this.x = imageView;
        this.y = frameLayout2;
        this.z = imageView2;
        this.p0 = view5;
        this.p1 = frameLayout3;
        this.p2 = imageView3;
        this.p3 = view6;
        this.H3 = view7;
        this.I3 = imageView4;
        this.J3 = frameLayout4;
        this.K3 = imageView5;
        this.L3 = view8;
        this.M3 = frameLayout5;
        this.N3 = imageView6;
        this.O3 = relativeLayout;
        this.P3 = imageView7;
        this.Q3 = imageView8;
        this.R3 = view9;
        this.S3 = frameLayout6;
        this.T3 = imageView9;
        this.U3 = textView;
        this.V3 = toolbar;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable LineCrossingViewModel lineCrossingViewModel);
}
