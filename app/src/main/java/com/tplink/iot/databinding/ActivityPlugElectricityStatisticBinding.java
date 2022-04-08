package com.tplink.iot.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.view.iotplug.energymonitor.chart.ElectricityBarChart;

/* loaded from: classes2.dex */
public abstract class ActivityPlugElectricityStatisticBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ElectricityBarChart f6642c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f6643d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CardView f6644f;
    @NonNull
    public final TabLayout q;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityPlugElectricityStatisticBinding(Object obj, View view, int i, ElectricityBarChart electricityBarChart, LinearLayout linearLayout, CardView cardView, TabLayout tabLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f6642c = electricityBarChart;
        this.f6643d = linearLayout;
        this.f6644f = cardView;
        this.q = tabLayout;
        this.x = textView;
        this.y = textView2;
    }
}
