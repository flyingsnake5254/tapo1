package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;

/* loaded from: classes2.dex */
public abstract class ItemModeAddCameraBinding extends ViewDataBinding {
    @Bindable
    protected Integer H3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f7181c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f7182d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f7183f;
    @Bindable
    protected String p0;
    @Bindable
    protected Integer p1;
    @Bindable
    protected d p2;
    @Bindable
    protected Boolean p3;
    @NonNull
    public final ImageView q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @Bindable
    protected CameraPreviewInfo z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemModeAddCameraBinding(Object obj, View view, int i, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f7181c = view2;
        this.f7182d = imageView;
        this.f7183f = imageView2;
        this.q = imageView3;
        this.x = textView;
        this.y = textView2;
    }
}
