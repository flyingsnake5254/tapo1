package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ActivityDiscoveryDevicePairingFailedBindingImpl extends ActivityDiscoveryDevicePairingFailedBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray x;
    @NonNull
    private final LinearLayout y;
    private long z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.img_close, 1);
        sparseIntArray.put(R.id.ll_content, 2);
        sparseIntArray.put(R.id.btn_bottom, 3);
    }

    public ActivityDiscoveryDevicePairingFailedBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, q, x));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.z = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 1L;
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

    private ActivityDiscoveryDevicePairingFailedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[3], (ImageView) objArr[1], (LinearLayout) objArr[2]);
        this.z = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.y = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}