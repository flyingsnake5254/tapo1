package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;

/* loaded from: classes2.dex */
public class ActivityWhiteLampConfigBindingImpl extends ActivityWhiteLampConfigBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3;
    @NonNull
    private final ConstraintLayout H3;
    private long I3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p3 = sparseIntArray;
        sparseIntArray.put(R.id.rl_seek_bar, 1);
        sparseIntArray.put(R.id.ll_level_text, 2);
        sparseIntArray.put(R.id.intensity_level_one_btn, 3);
        sparseIntArray.put(R.id.intensity_level_two_btn, 4);
        sparseIntArray.put(R.id.intensity_level_three_btn, 5);
        sparseIntArray.put(R.id.intensity_level_four_btn, 6);
        sparseIntArray.put(R.id.intensity_level_five_btn, 7);
        sparseIntArray.put(R.id.intensity_bar, 8);
        sparseIntArray.put(R.id.live_loading_view, 9);
    }

    public ActivityWhiteLampConfigBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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

    private ActivityWhiteLampConfigBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SeekBar) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[3], (TextView) objArr[5], (TextView) objArr[4], (CameraLoadingView) objArr[9], (LinearLayout) objArr[2], (RelativeLayout) objArr[1]);
        this.I3 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.H3 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
