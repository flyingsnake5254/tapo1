package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionViewModel;

/* loaded from: classes2.dex */
public class ActivityAreaIntrusionRegionSettingBindingLandImpl extends ActivityAreaIntrusionRegionSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts T3 = null;
    @Nullable
    private static final SparseIntArray U3;
    private long V3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        U3 = sparseIntArray;
        sparseIntArray.put(R.id.setting_area_container, 8);
        sparseIntArray.put(R.id.setting_cover_iv, 9);
        sparseIntArray.put(R.id.action_region, 10);
        sparseIntArray.put(R.id.delete_region_lan_layout, 11);
    }

    public ActivityAreaIntrusionRegionSettingBindingLandImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, T3, U3));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 2;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.V3 |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.V3     // Catch: all -> 0x00a6
            r4 = 0
            r1.V3 = r4     // Catch: all -> 0x00a6
            monitor-exit(r18)     // Catch: all -> 0x00a6
            android.view.View$OnClickListener r0 = r1.S3
            com.tplink.iot.viewmodel.ipcamera.setting.AreaIntrusionViewModel r6 = r1.R3
            r7 = 27
            long r7 = r7 & r2
            r9 = 26
            r11 = 25
            r13 = 0
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x006a
            long r7 = r2 & r11
            r14 = 8
            r15 = 0
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0044
            if (r6 == 0) goto L_0x0028
            androidx.databinding.ObservableBoolean r7 = r6.j
            goto L_0x0029
        L_0x0028:
            r7 = r15
        L_0x0029:
            r1.updateRegistration(r13, r7)
            if (r7 == 0) goto L_0x0033
            boolean r7 = r7.get()
            goto L_0x0034
        L_0x0033:
            r7 = 0
        L_0x0034:
            if (r16 == 0) goto L_0x003f
            if (r7 == 0) goto L_0x003b
            r16 = 256(0x100, double:1.265E-321)
            goto L_0x003d
        L_0x003b:
            r16 = 128(0x80, double:6.32E-322)
        L_0x003d:
            long r2 = r2 | r16
        L_0x003f:
            if (r7 == 0) goto L_0x0044
            r7 = 8
            goto L_0x0045
        L_0x0044:
            r7 = 0
        L_0x0045:
            long r16 = r2 & r9
            int r8 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x006b
            if (r6 == 0) goto L_0x004f
            androidx.databinding.ObservableBoolean r15 = r6.i
        L_0x004f:
            r6 = 1
            r1.updateRegistration(r6, r15)
            if (r15 == 0) goto L_0x005a
            boolean r6 = r15.get()
            goto L_0x005b
        L_0x005a:
            r6 = 0
        L_0x005b:
            if (r8 == 0) goto L_0x0065
            if (r6 == 0) goto L_0x0062
            r15 = 64
            goto L_0x0064
        L_0x0062:
            r15 = 32
        L_0x0064:
            long r2 = r2 | r15
        L_0x0065:
            if (r6 == 0) goto L_0x006b
            r13 = 8
            goto L_0x006b
        L_0x006a:
            r7 = 0
        L_0x006b:
            r14 = 20
            long r14 = r14 & r2
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0090
            android.view.View r6 = r1.f6496f
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.x
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.z
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.p2
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.H3
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.J3
            r6.setOnClickListener(r0)
        L_0x0090:
            long r8 = r2 & r9
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x009b
            android.view.View r0 = r1.f6496f
            r0.setVisibility(r13)
        L_0x009b:
            long r2 = r2 & r11
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a5
            android.view.View r0 = r1.p1
            r0.setVisibility(r7)
        L_0x00a5:
            return
        L_0x00a6:
            r0 = move-exception
            monitor-exit(r18)     // Catch: all -> 0x00a6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityAreaIntrusionRegionSettingBindingLandImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityAreaIntrusionRegionSettingBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.S3 = onClickListener;
        synchronized (this) {
            this.V3 |= 4;
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

    @Override // com.tplink.iot.databinding.ActivityAreaIntrusionRegionSettingBinding
    public void i(@Nullable AreaIntrusionViewModel areaIntrusionViewModel) {
        this.R3 = areaIntrusionViewModel;
        synchronized (this) {
            this.V3 |= 8;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.V3 = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((ObservableBoolean) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((AreaIntrusionViewModel) obj);
        }
        return true;
    }

    private ActivityAreaIntrusionRegionSettingBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[10], null, (View) objArr[5], null, (ImageView) objArr[4], null, (ImageView) objArr[3], null, (View) objArr[2], (ImageView) objArr[6], null, (ImageView) objArr[1], (RelativeLayout) objArr[11], (ImageView) objArr[7], null, (View) objArr[0], (FrameLayout) objArr[8], (ImageView) objArr[9], null, null, null);
        this.V3 = -1L;
        this.f6496f.setTag(null);
        this.x.setTag(null);
        this.z.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.H3.setTag(null);
        this.J3.setTag(null);
        this.L3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
