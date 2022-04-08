package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.R;
import com.tplink.iot.devices.trv.view.chart.TemperatureRecordChart;

/* loaded from: classes2.dex */
public class ActivityTrvTemperatureRecordBindingImpl extends ActivityTrvTemperatureRecordBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    @NonNull
    private final LinearLayout p2;
    private long p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.temp_tab_layout, 1);
        sparseIntArray.put(R.id.chart_container, 2);
        sparseIntArray.put(R.id.marker_view, 3);
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.tv_temperature, 5);
        sparseIntArray.put(R.id.tv_time, 6);
        sparseIntArray.put(R.id.temp_line_chart, 7);
    }

    public ActivityTrvTemperatureRecordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p0, p1));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p3 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    private ActivityTrvTemperatureRecordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (CardView) objArr[3], (TemperatureRecordChart) objArr[7], (TabLayout) objArr[1], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[4]);
        this.p3 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p2 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
