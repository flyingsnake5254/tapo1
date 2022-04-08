package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.devices.switches.viewmodel.SwitchDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;

/* loaded from: classes2.dex */
public class LayoutSwitchDetailBottomExtBindingImpl extends LayoutSwitchDetailBottomExtBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I3 = null;
    @Nullable
    private static final SparseIntArray J3;
    @NonNull
    private final LinearLayout K3;
    private long L3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J3 = sparseIntArray;
        sparseIntArray.put(R.id.ll_rules, 7);
        sparseIntArray.put(R.id.ll_rules2, 8);
        sparseIntArray.put(R.id.thing_next_event_view, 9);
        sparseIntArray.put(R.id.thing_usage_view, 10);
    }

    public LayoutSwitchDetailBottomExtBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, I3, J3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.L3;
            this.L3 = 0L;
        }
        View.OnClickListener onClickListener = this.p3;
        if ((j & 6) != 0) {
            this.f7295c.setOnClickListener(onClickListener);
            this.f7296d.setOnClickListener(onClickListener);
            this.f7297f.setOnClickListener(onClickListener);
            this.p0.setOnClickListener(onClickListener);
            this.p1.setOnClickListener(onClickListener);
            this.p2.setOnClickListener(onClickListener);
        }
    }

    public void h(@Nullable SwitchDetailViewModel switchDetailViewModel) {
        this.H3 = switchDetailViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L3 != 0;
        }
    }

    public void i(@Nullable View.OnClickListener onClickListener) {
        this.p3 = onClickListener;
        synchronized (this) {
            this.L3 |= 2;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L3 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (15 == i) {
            h((SwitchDetailViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            i((View.OnClickListener) obj);
        }
        return true;
    }

    private LayoutSwitchDetailBottomExtBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[3], (LinearLayout) objArr[7], (LinearLayout) objArr[8], (ThingNextEventView) objArr[9], (ThingUsageView) objArr[10], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[6]);
        this.L3 = -1L;
        this.f7295c.setTag(null);
        this.f7296d.setTag(null);
        this.f7297f.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.K3 = linearLayout;
        linearLayout.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
