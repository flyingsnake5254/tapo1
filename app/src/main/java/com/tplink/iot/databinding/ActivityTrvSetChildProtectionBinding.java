package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public abstract class ActivityTrvSetChildProtectionBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f6732c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TPSwitchCompat f6733d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6734f;
    @NonNull
    public final TextView q;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTrvSetChildProtectionBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TPSwitchCompat tPSwitchCompat, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6732c = relativeLayout;
        this.f6733d = tPSwitchCompat;
        this.f6734f = textView;
        this.q = textView2;
    }
}
