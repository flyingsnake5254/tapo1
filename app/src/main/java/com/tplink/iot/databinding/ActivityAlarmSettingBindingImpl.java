package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;

/* loaded from: classes2.dex */
public class ActivityAlarmSettingBindingImpl extends ActivityAlarmSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts Q3 = null;
    @Nullable
    private static final SparseIntArray R3;
    @NonNull
    private final LinearLayout S3;
    @NonNull
    private final LinearLayout T3;
    private InverseBindingListener U3;
    private long V3;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = ActivityAlarmSettingBindingImpl.this.f6485c.isChecked();
            AlarmSettingViewModel alarmSettingViewModel = ActivityAlarmSettingBindingImpl.this.P3;
            boolean z = true;
            if (alarmSettingViewModel != null) {
                ObservableBoolean observableBoolean = alarmSettingViewModel.f10683d;
                if (observableBoolean == null) {
                    z = false;
                }
                if (z) {
                    observableBoolean.set(isChecked);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        R3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar_divider, 14);
        sparseIntArray.put(R.id.type_title, 15);
        sparseIntArray.put(R.id.sound_title, 16);
        sparseIntArray.put(R.id.schedule_mode, 17);
        sparseIntArray.put(R.id.all_day_content, 18);
        sparseIntArray.put(R.id.time_text, 19);
    }

    public ActivityAlarmSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, Q3, R3));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 128;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 8;
        }
        return true;
    }

    private boolean n(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 32;
        }
        return true;
    }

    private boolean o(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 64;
        }
        return true;
    }

    private boolean p(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 16;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 2;
        }
        return true;
    }

    private boolean r(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 4;
        }
        return true;
    }

    private boolean s(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityAlarmSettingBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityAlarmSettingBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.O3 = onClickListener;
        synchronized (this) {
            this.V3 |= 256;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.V3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityAlarmSettingBinding
    public void i(@Nullable AlarmSettingViewModel alarmSettingViewModel) {
        this.P3 = alarmSettingViewModel;
        synchronized (this) {
            this.V3 |= 512;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.V3 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return s((ObservableField) obj, i2);
            case 1:
                return q((ObservableBoolean) obj, i2);
            case 2:
                return r((ObservableField) obj, i2);
            case 3:
                return m((ObservableBoolean) obj, i2);
            case 4:
                return p((ObservableField) obj, i2);
            case 5:
                return n((ObservableField) obj, i2);
            case 6:
                return o((ObservableInt) obj, i2);
            case 7:
                return l((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((AlarmSettingViewModel) obj);
        }
        return true;
    }

    private ActivityAlarmSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (CheckBox) objArr[1], (RelativeLayout) objArr[3], (TextView) objArr[18], (RadioButton) objArr[7], (RadioButton) objArr[8], (RelativeLayout) objArr[9], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[10], (RadioGroup) objArr[17], (TextView) objArr[6], (TextView) objArr[16], (RelativeLayout) objArr[5], (LinearLayout) objArr[19], (View) objArr[14], (TextView) objArr[4], (TextView) objArr[15], (ScheduleWeekdayTextView) objArr[13]);
        this.U3 = new a();
        this.V3 = -1L;
        this.f6485c.setTag(null);
        this.f6486d.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.S3 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.T3 = linearLayout2;
        linearLayout2.setTag(null);
        this.p3.setTag(null);
        this.I3.setTag(null);
        this.L3.setTag(null);
        this.N3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
