package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public abstract class FragmentCameraWiredSetWirelessFailedBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6966c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6967d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f6968f;
    @Bindable
    protected g p0;
    @NonNull
    public final PointTextView q;
    @NonNull
    public final PointTextView x;
    @NonNull
    public final Toolbar y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentCameraWiredSetWirelessFailedBinding(Object obj, View view, int i, Button button, ImageView imageView, LinearLayout linearLayout, PointTextView pointTextView, PointTextView pointTextView2, Toolbar toolbar, TextView textView) {
        super(obj, view, i);
        this.f6966c = button;
        this.f6967d = imageView;
        this.f6968f = linearLayout;
        this.q = pointTextView;
        this.x = pointTextView2;
        this.y = toolbar;
        this.z = textView;
    }
}
