package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;

/* loaded from: classes2.dex */
public abstract class ItemCameraSelectDeviceFullScreenBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f7156c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7157d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7158f;
    @Bindable
    protected Integer p0;
    @NonNull
    public final ImageView q;
    @NonNull
    public final TextView x;
    @Bindable
    protected SelectDeviceViewModel.a y;
    @Bindable
    protected d z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCameraSelectDeviceFullScreenBinding(Object obj, View view, int i, View view2, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.f7156c = view2;
        this.f7157d = imageView;
        this.f7158f = textView;
        this.q = imageView2;
        this.x = textView2;
    }
}
