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
public abstract class ItemCameraSelectDeviceBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7153c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7154d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7155f;
    @NonNull
    public final TextView q;
    @Bindable
    protected SelectDeviceViewModel.a x;
    @Bindable
    protected d y;
    @Bindable
    protected Integer z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCameraSelectDeviceBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.f7153c = imageView;
        this.f7154d = textView;
        this.f7155f = imageView2;
        this.q = textView2;
    }
}
