package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.yinglan.scrolllayout.content.ContentScrollView;

/* loaded from: classes2.dex */
public abstract class ActivityBaseIotDeviceDetailBottomBinding extends ViewDataBinding {
    @Bindable
    protected View.OnClickListener H3;
    @Bindable
    protected IoTDetailBaseViewModel I3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6503c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6504d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TPSwitchCompat f6505f;
    @NonNull
    public final RelativeLayout p0;
    @NonNull
    public final ContentScrollView p1;
    @NonNull
    public final TextView p2;
    @NonNull
    public final View p3;
    @NonNull
    public final FrameLayout q;
    @NonNull
    public final RelativeLayout x;
    @NonNull
    public final RelativeLayout y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityBaseIotDeviceDetailBottomBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TPSwitchCompat tPSwitchCompat, FrameLayout frameLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView3, RelativeLayout relativeLayout3, ContentScrollView contentScrollView, TextView textView, View view2) {
        super(obj, view, i);
        this.f6503c = imageView;
        this.f6504d = imageView2;
        this.f6505f = tPSwitchCompat;
        this.q = frameLayout;
        this.x = relativeLayout;
        this.y = relativeLayout2;
        this.z = imageView3;
        this.p0 = relativeLayout3;
        this.p1 = contentScrollView;
        this.p2 = textView;
        this.p3 = view2;
    }

    public abstract void h(@Nullable IoTDetailBaseViewModel ioTDetailBaseViewModel);

    public abstract void i(@Nullable View.OnClickListener onClickListener);
}
