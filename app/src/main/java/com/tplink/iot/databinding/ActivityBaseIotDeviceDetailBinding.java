package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

/* loaded from: classes2.dex */
public abstract class ActivityBaseIotDeviceDetailBinding extends ViewDataBinding {
    @NonNull
    public final ImageView H3;
    @NonNull
    public final ImageView I3;
    @NonNull
    public final LinearLayout J3;
    @NonNull
    public final ScrollLayout K3;
    @NonNull
    public final TextView L3;
    @NonNull
    public final TextView M3;
    @NonNull
    public final TextView N3;
    @Bindable
    protected IoTDetailBaseViewModel O3;
    @Bindable
    protected View.OnClickListener P3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardView f6500c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CardView f6501d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ScrollView f6502f;
    @NonNull
    public final FrameLayout p0;
    @NonNull
    public final ImageView p1;
    @NonNull
    public final ImageView p2;
    @NonNull
    public final ImageView p3;
    @NonNull
    public final ActivityBaseIotDeviceDetailBottomBinding q;
    @NonNull
    public final FrameLayout x;
    @NonNull
    public final FrameLayout y;
    @NonNull
    public final FrameLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityBaseIotDeviceDetailBinding(Object obj, View view, int i, CardView cardView, CardView cardView2, ScrollView scrollView, ActivityBaseIotDeviceDetailBottomBinding activityBaseIotDeviceDetailBottomBinding, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, ScrollLayout scrollLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6500c = cardView;
        this.f6501d = cardView2;
        this.f6502f = scrollView;
        this.q = activityBaseIotDeviceDetailBottomBinding;
        this.x = frameLayout;
        this.y = frameLayout2;
        this.z = frameLayout3;
        this.p0 = frameLayout4;
        this.p1 = imageView;
        this.p2 = imageView2;
        this.p3 = imageView3;
        this.H3 = imageView4;
        this.I3 = imageView5;
        this.J3 = linearLayout;
        this.K3 = scrollLayout;
        this.L3 = textView;
        this.M3 = textView2;
        this.N3 = textView3;
    }

    public abstract void h(@Nullable IoTDetailBaseViewModel ioTDetailBaseViewModel);

    public abstract void i(@Nullable View.OnClickListener onClickListener);
}
