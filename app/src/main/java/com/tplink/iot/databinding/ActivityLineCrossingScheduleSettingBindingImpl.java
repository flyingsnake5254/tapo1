package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingScheduleViewModel;

/* loaded from: classes2.dex */
public class ActivityLineCrossingScheduleSettingBindingImpl extends ActivityLineCrossingScheduleSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts M3 = null;
    @Nullable
    private static final SparseIntArray N3;
    @NonNull
    private final ConstraintLayout O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar_layout, 8);
        sparseIntArray.put(R.id.toolbar, 9);
        sparseIntArray.put(R.id.record_plan_custom_setting_view, 10);
        sparseIntArray.put(R.id.record_plan_custom_type_layout, 11);
        sparseIntArray.put(R.id.record_custom_type_timing_tv, 12);
        sparseIntArray.put(R.id.record_custom_type_none_tv, 13);
    }

    public ActivityLineCrossingScheduleSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, M3, N3));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 1;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityLineCrossingScheduleSettingBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityLineCrossingScheduleSettingBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.K3 = onClickListener;
        synchronized (this) {
            this.P3 |= 8;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityLineCrossingScheduleSettingBinding
    public void i(@Nullable LineCrossingScheduleViewModel lineCrossingScheduleViewModel) {
        this.J3 = lineCrossingScheduleViewModel;
        synchronized (this) {
            this.P3 |= 16;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 32L;
        }
        requestRebind();
    }

    public void n(@Nullable RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.L3 = onCheckedChangeListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (7 == i) {
            n((RadioGroup.OnCheckedChangeListener) obj);
        } else if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((LineCrossingScheduleViewModel) obj);
        }
        return true;
    }

    private ActivityLineCrossingScheduleSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[2], (CameraLoadingView) objArr[7], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[13], (TextView) objArr[12], (RecordCustomSettingView) objArr[10], (LinearLayout) objArr[3], (LinearLayout) objArr[4], (LinearLayout) objArr[11], (AppCompatImageView) objArr[1], (Toolbar) objArr[9], (AppBarLayout) objArr[8]);
        this.P3 = -1L;
        this.f6612c.setTag(null);
        this.f6613d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.O3 = constraintLayout;
        constraintLayout.setTag(null);
        this.f6614f.setTag(null);
        this.q.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
