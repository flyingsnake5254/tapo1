package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.tppulltorefresh.TPCircleProgressBar;

/* loaded from: classes2.dex */
public class ActivityTrvSetRemoveScaleBindingImpl extends ActivityTrvSetRemoveScaleBinding {
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
        sparseIntArray.put(R.id.rl_switch, 1);
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.switch_button, 3);
        sparseIntArray.put(R.id.tv_tip, 4);
        sparseIntArray.put(R.id.ll_remove_scale, 5);
        sparseIntArray.put(R.id.divider_line, 6);
        sparseIntArray.put(R.id.ll_remove_scale_content, 7);
        sparseIntArray.put(R.id.circle_progress_bar, 8);
        sparseIntArray.put(R.id.tv_remove_scale, 9);
    }

    public ActivityTrvSetRemoveScaleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    private ActivityTrvSetRemoveScaleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TPCircleProgressBar) objArr[8], (View) objArr[6], (LinearLayout) objArr[5], (LinearLayout) objArr[7], (RelativeLayout) objArr[1], (TPSwitchCompat) objArr[3], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[2]);
        this.I3 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.H3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
