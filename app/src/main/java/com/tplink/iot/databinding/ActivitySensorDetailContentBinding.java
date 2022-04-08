package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

/* loaded from: classes2.dex */
public abstract class ActivitySensorDetailContentBinding extends ViewDataBinding {
    @NonNull
    public final RecyclerView H3;
    @NonNull
    public final TextView I3;
    @NonNull
    public final TextView J3;
    @NonNull
    public final TextView K3;
    @NonNull
    public final TextView L3;
    @Bindable
    protected View.OnClickListener M3;
    @Bindable
    protected SensorDetailViewModel N3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardView f6678c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CardView f6679d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f6680f;
    @NonNull
    public final ImageView p0;
    @NonNull
    public final LinearLayout p1;
    @NonNull
    public final LinearLayout p2;
    @NonNull
    public final TPSmartRefreshLayout p3;
    @NonNull
    public final FrameLayout q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final ImageView y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySensorDetailContentBinding(Object obj, View view, int i, CardView cardView, CardView cardView2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, TPSmartRefreshLayout tPSmartRefreshLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f6678c = cardView;
        this.f6679d = cardView2;
        this.f6680f = frameLayout;
        this.q = frameLayout2;
        this.x = imageView;
        this.y = imageView2;
        this.z = imageView3;
        this.p0 = imageView4;
        this.p1 = linearLayout;
        this.p2 = linearLayout2;
        this.p3 = tPSmartRefreshLayout;
        this.H3 = recyclerView;
        this.I3 = textView;
        this.J3 = textView2;
        this.K3 = textView3;
        this.L3 = textView4;
    }

    public abstract void h(@Nullable SensorDetailViewModel sensorDetailViewModel);

    public abstract void i(@Nullable View.OnClickListener onClickListener);
}
