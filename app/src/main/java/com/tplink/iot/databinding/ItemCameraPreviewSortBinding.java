package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.databinding.f;

/* loaded from: classes2.dex */
public abstract class ItemCameraPreviewSortBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7150c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f7151d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f7152f;
    @Bindable
    protected String p0;
    @Bindable
    protected RecyclerView.ViewHolder p1;
    @Bindable
    protected f p2;
    @NonNull
    public final ImageView q;
    @Bindable
    protected Integer x;
    @Bindable
    protected String y;
    @Bindable
    protected String z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCameraPreviewSortBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2) {
        super(obj, view, i);
        this.f7150c = imageView;
        this.f7151d = textView;
        this.f7152f = textView2;
        this.q = imageView2;
    }
}
