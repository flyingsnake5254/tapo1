package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;

/* loaded from: classes2.dex */
public abstract class ActivityTrvSetWindowOpenBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ItemSettingLayout f6753c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f6754d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f6755f;
    @NonNull
    public final TPSwitchCompat q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTrvSetWindowOpenBinding(Object obj, View view, int i, ItemSettingLayout itemSettingLayout, LinearLayout linearLayout, RelativeLayout relativeLayout, TPSwitchCompat tPSwitchCompat, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f6753c = itemSettingLayout;
        this.f6754d = linearLayout;
        this.f6755f = relativeLayout;
        this.q = tPSwitchCompat;
        this.x = textView;
        this.y = textView2;
        this.z = textView3;
    }
}
