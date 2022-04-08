package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.setting.ScheduleWeekView;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel;

/* loaded from: classes2.dex */
public class ActivityScheduleEditBindingImpl extends ActivityScheduleEditBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3;
    @NonNull
    private final RelativeLayout H3;
    private long I3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 3);
        sparseIntArray.put(R.id.save, 4);
        sparseIntArray.put(R.id.item_schedule_next_day_tv, 5);
        sparseIntArray.put(R.id.schedule_edit_weekday_view, 6);
        sparseIntArray.put(R.id.start, 7);
    }

    public ActivityScheduleEditBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p2, p3));
    }

    private boolean i(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 1;
        }
        return true;
    }

    private boolean l(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.I3     // Catch: all -> 0x0063
            r2 = 0
            r14.I3 = r2     // Catch: all -> 0x0063
            monitor-exit(r14)     // Catch: all -> 0x0063
            com.tplink.iot.viewmodel.ipcamera.setting.AlarmSettingViewModel r4 = r14.p0
            r5 = 27
            long r5 = r5 & r0
            r7 = 26
            r9 = 25
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x004c
            long r5 = r0 & r9
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x002f
            if (r4 == 0) goto L_0x0021
            androidx.databinding.ObservableField<java.lang.String> r5 = r4.i
            goto L_0x0022
        L_0x0021:
            r5 = r11
        L_0x0022:
            r6 = 0
            r14.updateRegistration(r6, r5)
            if (r5 == 0) goto L_0x002f
            java.lang.Object r5 = r5.get()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0030
        L_0x002f:
            r5 = r11
        L_0x0030:
            long r12 = r0 & r7
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0049
            if (r4 == 0) goto L_0x003b
            androidx.databinding.ObservableField<java.lang.String> r4 = r4.h
            goto L_0x003c
        L_0x003b:
            r4 = r11
        L_0x003c:
            r6 = 1
            r14.updateRegistration(r6, r4)
            if (r4 == 0) goto L_0x0049
            java.lang.Object r4 = r4.get()
            r11 = r4
            java.lang.String r11 = (java.lang.String) r11
        L_0x0049:
            r4 = r11
            r11 = r5
            goto L_0x004d
        L_0x004c:
            r4 = r11
        L_0x004d:
            long r5 = r0 & r9
            int r9 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x0058
            android.widget.TextView r5 = r14.f6663c
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r5, r11)
        L_0x0058:
            long r0 = r0 & r7
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0062
            android.widget.TextView r0 = r14.y
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r4)
        L_0x0062:
            return
        L_0x0063:
            r0 = move-exception
            monitor-exit(r14)     // Catch: all -> 0x0063
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityScheduleEditBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityScheduleEditBinding
    public void h(@Nullable AlarmSettingViewModel alarmSettingViewModel) {
        this.p0 = alarmSettingViewModel;
        synchronized (this) {
            this.I3 |= 8;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
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
            this.I3 = 16L;
        }
        requestRebind();
    }

    public void m(@Nullable View.OnClickListener onClickListener) {
        this.p1 = onClickListener;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return i((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            m((View.OnClickListener) obj);
        } else if (105 != i) {
            return false;
        } else {
            h((AlarmSettingViewModel) obj);
        }
        return true;
    }

    private ActivityScheduleEditBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[4], (ScheduleWeekView) objArr[6], (Button) objArr[7], (TextView) objArr[1], (Toolbar) objArr[3]);
        this.I3 = -1L;
        this.f6663c.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.H3 = relativeLayout;
        relativeLayout.setTag(null);
        this.y.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
