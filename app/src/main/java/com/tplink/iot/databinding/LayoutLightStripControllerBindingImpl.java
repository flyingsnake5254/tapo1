package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.devices.lightstrip.widget.LightStripBrightnessController;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

/* loaded from: classes2.dex */
public class LayoutLightStripControllerBindingImpl extends LayoutLightStripControllerBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    private long p0;
    @NonNull
    private final LinearLayout z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.brightness_switcher, 1);
        sparseIntArray.put(R.id.tv_color_temp_value, 2);
        sparseIntArray.put(R.id.ls_brightness_controller, 3);
        sparseIntArray.put(R.id.light_strip_switch, 4);
    }

    public LayoutLightStripControllerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, x, y));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p0 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p0 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p0 = 1L;
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

    private LayoutLightStripControllerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SimpleTextSwitcher) objArr[1], (TPCheckboxCompat) objArr[4], (LightStripBrightnessController) objArr[3], (TextView) objArr[2]);
        this.p0 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.z = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
