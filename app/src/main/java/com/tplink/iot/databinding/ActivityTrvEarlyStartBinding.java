package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public abstract class ActivityTrvEarlyStartBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6729c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TPSwitchCompat f6730d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6731f;
    @NonNull
    public final TextView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTrvEarlyStartBinding(Object obj, View view, int i, ImageView imageView, TPSwitchCompat tPSwitchCompat, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6729c = imageView;
        this.f6730d = tPSwitchCompat;
        this.f6731f = textView;
        this.q = textView2;
    }
}
