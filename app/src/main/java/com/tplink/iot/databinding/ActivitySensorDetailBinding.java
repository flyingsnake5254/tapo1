package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.yinglan.scrolllayout.ScrollLayout;

/* loaded from: classes2.dex */
public abstract class ActivitySensorDetailBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6672c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ScrollLayout f6673d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ActivitySensorDetailBottomBinding f6674f;
    @NonNull
    public final ActivitySensorDetailContentBinding q;
    @Bindable
    protected View.OnClickListener x;
    @Bindable
    protected SensorDetailViewModel y;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySensorDetailBinding(Object obj, View view, int i, ImageView imageView, ScrollLayout scrollLayout, ActivitySensorDetailBottomBinding activitySensorDetailBottomBinding, ActivitySensorDetailContentBinding activitySensorDetailContentBinding) {
        super(obj, view, i);
        this.f6672c = imageView;
        this.f6673d = scrollLayout;
        this.f6674f = activitySensorDetailBottomBinding;
        this.q = activitySensorDetailContentBinding;
    }

    public abstract void h(@Nullable SensorDetailViewModel sensorDetailViewModel);

    public abstract void i(@Nullable View.OnClickListener onClickListener);
}
