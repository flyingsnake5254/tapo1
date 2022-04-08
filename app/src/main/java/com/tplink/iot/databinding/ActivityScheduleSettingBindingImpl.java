package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.setting.RecordCustomSettingView;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.RecordPlanViewModel;

/* loaded from: classes2.dex */
public class ActivityScheduleSettingBindingImpl extends ActivityScheduleSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts P3 = null;
    @Nullable
    private static final SparseIntArray Q3;
    @NonNull
    private final ConstraintLayout R3;
    @NonNull
    private final RadioGroup S3;
    private long T3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Q3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar_layout, 9);
        sparseIntArray.put(R.id.toolbar, 10);
        sparseIntArray.put(R.id.record_plan_custom_setting_view, 11);
        sparseIntArray.put(R.id.record_plan_custom_type_layout, 12);
        sparseIntArray.put(R.id.record_custom_type_timing_tv, 13);
        sparseIntArray.put(R.id.record_custom_type_move_tv, 14);
        sparseIntArray.put(R.id.record_custom_type_none_tv, 15);
        sparseIntArray.put(R.id.item_time, 16);
        sparseIntArray.put(R.id.item_motion, 17);
    }

    public ActivityScheduleSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, P3, Q3));
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 1;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityScheduleSettingBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityScheduleSettingBinding
    public void h(@Nullable RadioGroup.OnCheckedChangeListener onCheckedChangeListener) {
        this.O3 = onCheckedChangeListener;
        synchronized (this) {
            this.T3 |= 4;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.T3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityScheduleSettingBinding
    public void i(@Nullable View.OnClickListener onClickListener) {
        this.N3 = onClickListener;
        synchronized (this) {
            this.T3 |= 8;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.T3 = 32L;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.ActivityScheduleSettingBinding
    public void l(@Nullable RecordPlanViewModel recordPlanViewModel) {
        this.M3 = recordPlanViewModel;
        synchronized (this) {
            this.T3 |= 16;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (7 == i) {
            h((RadioGroup.OnCheckedChangeListener) obj);
        } else if (55 == i) {
            i((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            l((RecordPlanViewModel) obj);
        }
        return true;
    }

    private ActivityScheduleSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[2], (AppCompatRadioButton) objArr[17], (AppCompatRadioButton) objArr[16], (CameraLoadingView) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[14], (TextView) objArr[15], (TextView) objArr[13], (RecordCustomSettingView) objArr[11], (LinearLayout) objArr[3], (LinearLayout) objArr[4], (LinearLayout) objArr[12], (AppCompatImageView) objArr[1], (Toolbar) objArr[10], (AppBarLayout) objArr[9]);
        this.T3 = -1L;
        this.f6666c.setTag(null);
        this.q.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.R3 = constraintLayout;
        constraintLayout.setTag(null);
        RadioGroup radioGroup = (RadioGroup) objArr[5];
        this.S3 = radioGroup;
        radioGroup.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        this.J3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
