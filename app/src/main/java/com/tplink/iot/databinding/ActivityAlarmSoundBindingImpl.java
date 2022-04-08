package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSoundViewModel;

/* loaded from: classes2.dex */
public class ActivityAlarmSoundBindingImpl extends ActivityAlarmSoundBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final LinearLayout p0;
    private long p1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.radio_group, 2);
        sparseIntArray.put(R.id.alarm, 3);
        sparseIntArray.put(R.id.notice, 4);
    }

    public ActivityAlarmSoundBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, y, z));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.p1 = 0L;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityAlarmSoundBinding
    public void h(@Nullable AlarmSoundViewModel alarmSoundViewModel) {
        this.x = alarmSoundViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p1 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p1 = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((AlarmSoundViewModel) obj);
        return true;
    }

    private ActivityAlarmSoundBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RadioButton) objArr[3], (RadioButton) objArr[4], (RadioGroup) objArr[2], (Toolbar) objArr[1]);
        this.p1 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p0 = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
