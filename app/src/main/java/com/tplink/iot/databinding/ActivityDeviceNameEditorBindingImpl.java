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
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceNameEditorViewModel;
import com.tplink.iot.widget.DrawableEditText;

/* loaded from: classes2.dex */
public class ActivityDeviceNameEditorBindingImpl extends ActivityDeviceNameEditorBinding {
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
        sparseIntArray.put(R.id.toolbar, 4);
        sparseIntArray.put(R.id.edit_title, 5);
        sparseIntArray.put(R.id.edit_tips, 6);
        sparseIntArray.put(R.id.editor_title, 7);
    }

    public ActivityDeviceNameEditorBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p2, p3));
    }

    private boolean l(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 1;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 2;
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
            long r2 = r1.I3     // Catch: all -> 0x0077
            r4 = 0
            r1.I3 = r4     // Catch: all -> 0x0077
            monitor-exit(r18)     // Catch: all -> 0x0077
            android.view.View$OnClickListener r0 = r1.p1
            com.tplink.iot.viewmodel.ipcamera.setting.DeviceNameEditorViewModel r6 = r1.p0
            r7 = 20
            long r7 = r7 & r2
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            r7 = 27
            long r7 = r7 & r2
            r10 = 25
            r12 = 26
            r14 = 0
            r15 = 0
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0056
            long r7 = r2 & r10
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0038
            if (r6 == 0) goto L_0x002b
            androidx.databinding.ObservableField<java.lang.String> r7 = r6.f10723b
            goto L_0x002c
        L_0x002b:
            r7 = r14
        L_0x002c:
            r1.updateRegistration(r15, r7)
            if (r7 == 0) goto L_0x0038
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0039
        L_0x0038:
            r7 = r14
        L_0x0039:
            long r16 = r2 & r12
            int r8 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0055
            if (r6 == 0) goto L_0x0043
            androidx.databinding.ObservableBoolean r14 = r6.a
        L_0x0043:
            r6 = 1
            r1.updateRegistration(r6, r14)
            if (r14 == 0) goto L_0x004d
            boolean r15 = r14.get()
        L_0x004d:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r15)
            boolean r15 = androidx.databinding.ViewDataBinding.safeUnbox(r6)
        L_0x0055:
            r14 = r7
        L_0x0056:
            long r6 = r2 & r12
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0065
            com.tplink.iot.view.ipcamera.widget.CameraLoadingView r6 = r1.q
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r15)
            com.tplink.iot.view.ipcamera.base.b.K(r6, r7)
        L_0x0065:
            long r2 = r2 & r10
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x006f
            com.tplink.iot.widget.DrawableEditText r2 = r1.x
            r2.setText(r14)
        L_0x006f:
            if (r9 == 0) goto L_0x0076
            android.widget.Button r2 = r1.y
            r2.setOnClickListener(r0)
        L_0x0076:
            return
        L_0x0077:
            r0 = move-exception
            monitor-exit(r18)     // Catch: all -> 0x0077
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityDeviceNameEditorBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityDeviceNameEditorBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.p1 = onClickListener;
        synchronized (this) {
            this.I3 |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityDeviceNameEditorBinding
    public void i(@Nullable DeviceNameEditorViewModel deviceNameEditorViewModel) {
        this.p0 = deviceNameEditorViewModel;
        synchronized (this) {
            this.I3 |= 8;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I3 = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((ObservableField) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            h((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((DeviceNameEditorViewModel) obj);
        }
        return true;
    }

    private ActivityDeviceNameEditorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[7], (CameraLoadingView) objArr[3], (DrawableEditText) objArr[1], (Button) objArr[2], (Toolbar) objArr[4]);
        this.I3 = -1L;
        this.q.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.H3 = relativeLayout;
        relativeLayout.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
