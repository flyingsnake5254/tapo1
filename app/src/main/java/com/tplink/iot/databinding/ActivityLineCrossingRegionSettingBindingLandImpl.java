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
import com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel;

/* loaded from: classes2.dex */
public class ActivityLineCrossingRegionSettingBindingLandImpl extends ActivityLineCrossingRegionSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts Y3 = null;
    @Nullable
    private static final SparseIntArray Z3;
    private long a4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Z3 = sparseIntArray;
        sparseIntArray.put(R.id.setting_area_container, 10);
        sparseIntArray.put(R.id.setting_cover_iv, 11);
        sparseIntArray.put(R.id.action_region, 12);
        sparseIntArray.put(R.id.delete_region_lan_layout, 13);
    }

    public ActivityLineCrossingRegionSettingBindingLandImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, Y3, Z3));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.a4 |= 2;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.a4 |= 1;
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
            long r2 = r1.a4     // Catch: all -> 0x00b0
            r4 = 0
            r1.a4 = r4     // Catch: all -> 0x00b0
            monitor-exit(r18)     // Catch: all -> 0x00b0
            android.view.View$OnClickListener r0 = r1.X3
            com.tplink.iot.viewmodel.ipcamera.setting.LineCrossingViewModel r6 = r1.W3
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
            if (r6 == 0) goto L_0x009a
            android.view.View r6 = r1.f6611f
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.x
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.z
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.p2
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.I3
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.K3
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.N3
            r6.setOnClickListener(r0)
            android.widget.ImageView r6 = r1.P3
            r6.setOnClickListener(r0)
        L_0x009a:
            long r8 = r2 & r9
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a5
            android.view.View r0 = r1.f6611f
            r0.setVisibility(r13)
        L_0x00a5:
            long r2 = r2 & r11
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00af
            android.view.View r0 = r1.H3
            r0.setVisibility(r7)
        L_0x00af:
            return
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r18)     // Catch: all -> 0x00b0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityLineCrossingRegionSettingBindingLandImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityLineCrossingRegionSettingBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.X3 = onClickListener;
        synchronized (this) {
            this.a4 |= 4;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.a4 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityLineCrossingRegionSettingBinding
    public void i(@Nullable LineCrossingViewModel lineCrossingViewModel) {
        this.W3 = lineCrossingViewModel;
        synchronized (this) {
            this.a4 |= 8;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.a4 = 16L;
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
            i((LineCrossingViewModel) obj);
        }
        return true;
    }

    private ActivityLineCrossingRegionSettingBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (View) objArr[12], null, (View) objArr[7], null, (ImageView) objArr[6], null, (ImageView) objArr[4], null, null, (ImageView) objArr[5], null, (View) objArr[2], (ImageView) objArr[8], null, (ImageView) objArr[3], null, null, (ImageView) objArr[1], (RelativeLayout) objArr[13], (ImageView) objArr[9], null, (View) objArr[0], (FrameLayout) objArr[10], (ImageView) objArr[11], null, null);
        this.a4 = -1L;
        this.f6611f.setTag(null);
        this.x.setTag(null);
        this.z.setTag(null);
        this.p2.setTag(null);
        this.H3.setTag(null);
        this.I3.setTag(null);
        this.K3.setTag(null);
        this.N3.setTag(null);
        this.P3.setTag(null);
        this.R3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
