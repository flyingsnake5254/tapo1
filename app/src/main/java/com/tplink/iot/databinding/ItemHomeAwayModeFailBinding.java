package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.preview.d;

/* loaded from: classes2.dex */
public abstract class ItemHomeAwayModeFailBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7175c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7176d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7177f;
    @Bindable
    protected d p0;
    @Bindable
    protected com.tplink.iot.adapter.databinding.d p1;
    @Bindable
    protected Integer p2;
    @NonNull
    public final ImageView q;
    @NonNull
    public final ImageView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemHomeAwayModeFailBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7175c = imageView;
        this.f7176d = imageView2;
        this.f7177f = imageView3;
        this.q = imageView4;
        this.x = imageView5;
        this.y = textView;
        this.z = textView2;
    }
}
