package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.view.iotplug.energymonitor.chart.PowerLineChart;

/* loaded from: classes2.dex */
public abstract class ActivityPlugPowerStatisticBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f6645c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final PowerLineChart f6646d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CardView f6647f;
    @NonNull
    public final TabLayout q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityPlugPowerStatisticBinding(Object obj, View view, int i, LinearLayout linearLayout, PowerLineChart powerLineChart, CardView cardView, TabLayout tabLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6645c = linearLayout;
        this.f6646d = powerLineChart;
        this.f6647f = cardView;
        this.q = tabLayout;
        this.x = textView;
        this.y = textView2;
    }
}
