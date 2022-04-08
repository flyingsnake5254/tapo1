package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.widget.trv.TemperatureSlider;
import com.tplink.iot.widget.viewgroup.ToastTipBarView;

/* loaded from: classes2.dex */
public abstract class LayoutTrvDetailContentExtBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7310c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7311d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TemperatureSlider f7312f;
    @Bindable
    protected View.OnClickListener p0;
    @Bindable
    protected TRVDetailViewModel p1;
    @NonNull
    public final ToastTipBarView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutTrvDetailContentExtBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TemperatureSlider temperatureSlider, ToastTipBarView toastTipBarView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f7310c = imageView;
        this.f7311d = imageView2;
        this.f7312f = temperatureSlider;
        this.q = toastTipBarView;
        this.x = textView;
        this.y = textView2;
        this.z = textView3;
    }
}
