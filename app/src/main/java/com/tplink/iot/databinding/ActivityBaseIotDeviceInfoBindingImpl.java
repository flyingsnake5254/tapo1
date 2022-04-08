package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.widget.ItemSettingLayout;

/* loaded from: classes2.dex */
public class ActivityBaseIotDeviceInfoBindingImpl extends ActivityBaseIotDeviceInfoBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3;
    @NonNull
    private final LinearLayout H3;
    private long I3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p3 = sparseIntArray;
        sparseIntArray.put(R.id.item_switch_button, 1);
        sparseIntArray.put(R.id.item_timezone, 2);
        sparseIntArray.put(R.id.item_wifi_network, 3);
        sparseIntArray.put(R.id.item_model, 4);
        sparseIntArray.put(R.id.item_ip_address, 5);
        sparseIntArray.put(R.id.item_mac_address, 6);
        sparseIntArray.put(R.id.divide_line, 7);
        sparseIntArray.put(R.id.item_hardware, 8);
        sparseIntArray.put(R.id.item_fw_version, 9);
    }

    public ActivityBaseIotDeviceInfoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, p2, p3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.I3 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I3 = 1L;
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

    private ActivityBaseIotDeviceInfoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[7], (ItemSettingLayout) objArr[9], (ItemSettingLayout) objArr[8], (ItemSettingLayout) objArr[5], (ItemSettingLayout) objArr[6], (ItemSettingLayout) objArr[4], (ImageView) objArr[1], (ItemSettingLayout) objArr[2], (ItemSettingLayout) objArr[3]);
        this.I3 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.H3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
