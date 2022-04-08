package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ActivityTapoDebugBindingImpl extends ActivityTapoDebugBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts Q3 = null;
    @Nullable
    private static final SparseIntArray R3;
    @NonNull
    private final LinearLayout S3;
    private long T3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        R3 = sparseIntArray;
        sparseIntArray.put(R.id.tv_header_switch_cloud_env, 7);
        sparseIntArray.put(R.id.ll_tp_cloud_env, 8);
        sparseIntArray.put(R.id.tv_tp_cloud_env, 9);
        sparseIntArray.put(R.id.ll_iot_cloud_env, 10);
        sparseIntArray.put(R.id.tv_iot_cloud_env, 11);
        sparseIntArray.put(R.id.ll_tapo_care_env, 12);
        sparseIntArray.put(R.id.tv_tapo_care_env, 13);
        sparseIntArray.put(R.id.tv_header_save_log, 14);
        sparseIntArray.put(R.id.ll_log_path, 15);
        sparseIntArray.put(R.id.tv_log_path, 16);
        sparseIntArray.put(R.id.group_navigation, 17);
        sparseIntArray.put(R.id.tv_header_navigation, 18);
    }

    public ActivityTapoDebugBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, Q3, R3));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.T3;
            this.T3 = 0L;
        }
        View.OnLongClickListener onLongClickListener = this.P3;
        View.OnClickListener onClickListener = this.O3;
        int i = ((5 & j) > 0L ? 1 : ((5 & j) == 0L ? 0 : -1));
        if ((j & 6) != 0) {
            this.f6720c.setOnClickListener(onClickListener);
            this.f6721d.setOnClickListener(onClickListener);
            this.f6722f.setOnClickListener(onClickListener);
            this.x.setOnClickListener(onClickListener);
            this.y.setOnClickListener(onClickListener);
        }
        if (i != 0) {
            this.q.setOnLongClickListener(onLongClickListener);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityTapoDebugBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.O3 = onClickListener;
        synchronized (this) {
            this.T3 |= 2;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.T3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityTapoDebugBinding
    public void i(@Nullable View.OnLongClickListener onLongClickListener) {
        this.P3 = onLongClickListener;
        synchronized (this) {
            this.T3 |= 1;
        }
        notifyPropertyChanged(71);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.T3 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (71 == i) {
            i((View.OnLongClickListener) obj);
        } else if (69 != i) {
            return false;
        } else {
            h((View.OnClickListener) obj);
        }
        return true;
    }

    private ActivityTapoDebugBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[4], (Button) objArr[5], (Button) objArr[6], (Button) objArr[3], (Button) objArr[1], (Button) objArr[2], (Group) objArr[17], (LinearLayout) objArr[10], (LinearLayout) objArr[15], (LinearLayout) objArr[12], (LinearLayout) objArr[8], (TextView) objArr[18], (TextView) objArr[14], (TextView) objArr[7], (TextView) objArr[11], (TextView) objArr[16], (TextView) objArr[13], (TextView) objArr[9]);
        this.T3 = -1L;
        this.f6720c.setTag(null);
        this.f6721d.setTag(null);
        this.f6722f.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.S3 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
