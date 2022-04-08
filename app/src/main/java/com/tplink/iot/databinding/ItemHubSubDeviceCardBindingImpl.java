package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.iot.widget.trv.MarqueeTextView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

/* loaded from: classes2.dex */
public class ItemHubSubDeviceCardBindingImpl extends ItemHubSubDeviceCardBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts L3 = null;
    @Nullable
    private static final SparseIntArray M3;
    private long N3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M3 = sparseIntArray;
        sparseIntArray.put(R.id.tv_device_name, 1);
        sparseIntArray.put(R.id.tv_device_location, 2);
        sparseIntArray.put(R.id.rl_device_state, 3);
        sparseIntArray.put(R.id.iv_device_icon, 4);
        sparseIntArray.put(R.id.iv_share_icon, 5);
        sparseIntArray.put(R.id.tv_offline, 6);
        sparseIntArray.put(R.id.rl_extra_info, 7);
        sparseIntArray.put(R.id.tv_trigger_log, 8);
        sparseIntArray.put(R.id.tv_low_battery, 9);
        sparseIntArray.put(R.id.tv_trv_temp, 10);
        sparseIntArray.put(R.id.tv_trv_state, 11);
        sparseIntArray.put(R.id.rl_operation, 12);
        sparseIntArray.put(R.id.cb_selected, 13);
        sparseIntArray.put(R.id.iv_device_switch, 14);
    }

    public ItemHubSubDeviceCardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, L3, M3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.N3 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.N3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.N3 = 1L;
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

    private ItemHubSubDeviceCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RippleCardView) objArr[0], (TPCheckboxCompat) objArr[13], (ImageView) objArr[4], (ImageView) objArr[14], (ImageView) objArr[5], (RelativeLayout) objArr[3], (RelativeLayout) objArr[7], (RelativeLayout) objArr[12], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[9], (TextView) objArr[6], (TextView) objArr[8], (MarqueeTextView) objArr[11], (MarqueeTextView) objArr[10]);
        this.N3 = -1L;
        this.f7178c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
