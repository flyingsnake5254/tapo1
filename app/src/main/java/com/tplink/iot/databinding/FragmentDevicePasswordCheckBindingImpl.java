package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

/* loaded from: classes2.dex */
public class FragmentDevicePasswordCheckBindingImpl extends FragmentDevicePasswordCheckBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p1 = null;
    @Nullable
    private static final SparseIntArray p2;
    private long H3;
    @NonNull
    private final FrameLayout p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p2 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 5);
        sparseIntArray.put(R.id.password, 6);
    }

    public FragmentDevicePasswordCheckBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, p1, p2));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 2;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.H3 |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
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
            long r2 = r1.H3     // Catch: all -> 0x007c
            r4 = 0
            r1.H3 = r4     // Catch: all -> 0x007c
            monitor-exit(r18)     // Catch: all -> 0x007c
            android.view.View$OnClickListener r0 = r1.p0
            com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel r6 = r1.z
            r7 = 20
            long r7 = r7 & r2
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            r7 = 27
            long r7 = r7 & r2
            r10 = 26
            r12 = 25
            r14 = 0
            r15 = 0
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0056
            long r7 = r2 & r12
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0038
            if (r6 == 0) goto L_0x002b
            androidx.databinding.ObservableField<java.lang.String> r7 = r6.f10814b
            goto L_0x002c
        L_0x002b:
            r7 = r15
        L_0x002c:
            r1.updateRegistration(r14, r7)
            if (r7 == 0) goto L_0x0038
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0039
        L_0x0038:
            r7 = r15
        L_0x0039:
            long r16 = r2 & r10
            int r8 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0055
            if (r6 == 0) goto L_0x0043
            androidx.databinding.ObservableBoolean r15 = r6.a
        L_0x0043:
            r6 = 1
            r1.updateRegistration(r6, r15)
            if (r15 == 0) goto L_0x004d
            boolean r14 = r15.get()
        L_0x004d:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r14)
            boolean r14 = androidx.databinding.ViewDataBinding.safeUnbox(r6)
        L_0x0055:
            r15 = r7
        L_0x0056:
            if (r9 == 0) goto L_0x0062
            android.widget.TextView r6 = r1.f6990c
            r6.setOnClickListener(r0)
            android.widget.Button r6 = r1.q
            r6.setOnClickListener(r0)
        L_0x0062:
            long r6 = r2 & r10
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0071
            com.tplink.iot.view.ipcamera.widget.CameraLoadingView r0 = r1.f6991d
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r14)
            com.tplink.iot.view.ipcamera.base.b.K(r0, r6)
        L_0x0071:
            long r2 = r2 & r12
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x007b
            android.widget.TextView r0 = r1.y
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r15)
        L_0x007b:
            return
        L_0x007c:
            r0 = move-exception
            monitor-exit(r18)     // Catch: all -> 0x007c
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentDevicePasswordCheckBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentDevicePasswordCheckBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p0 = onClickListener;
        synchronized (this) {
            this.H3 |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.H3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentDevicePasswordCheckBinding
    public void i(@Nullable PasswordSettingViewModel passwordSettingViewModel) {
        this.z = passwordSettingViewModel;
        synchronized (this) {
            this.H3 |= 8;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.H3 = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            h((View.OnClickListener) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((PasswordSettingViewModel) obj);
        }
        return true;
    }

    private FragmentDevicePasswordCheckBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[2], (CameraLoadingView) objArr[4], (MaterialEditText) objArr[6], (Button) objArr[3], (Toolbar) objArr[5], (TextView) objArr[1]);
        this.H3 = -1L;
        this.f6990c.setTag(null);
        this.f6991d.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.p3 = frameLayout;
        frameLayout.setTag(null);
        this.q.setTag(null);
        this.y.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
