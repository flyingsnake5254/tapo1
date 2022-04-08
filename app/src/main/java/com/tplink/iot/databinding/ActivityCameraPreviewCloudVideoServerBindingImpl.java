package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ActivityCameraPreviewCloudVideoServerBindingImpl extends ActivityCameraPreviewCloudVideoServerBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1;
    private long p2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1 = sparseIntArray;
        sparseIntArray.put(R.id.tv_cloud_service_title, 1);
        sparseIntArray.put(R.id.tv_cloud_service_content, 2);
        sparseIntArray.put(R.id.tv_cloud_service_more, 3);
        sparseIntArray.put(R.id.iv_cloud_service_close, 4);
    }

    public ActivityCameraPreviewCloudVideoServerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, p0, p1));
    }

    private boolean l(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 1;
        }
        return true;
    }

    private boolean m(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 2;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        com.tplink.iot.view.ipcamera.base.b.Q(r15.f6519d, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        return;
     */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.p2     // Catch: all -> 0x0058
            r2 = 0
            r15.p2 = r2     // Catch: all -> 0x0058
            monitor-exit(r15)     // Catch: all -> 0x0058
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r4 = r15.y
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r5 = r15.z
            r6 = 7
            long r8 = r0 & r6
            r10 = 16
            r12 = 0
            r13 = 0
            int r14 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r14 == 0) goto L_0x0032
            if (r5 == 0) goto L_0x0021
            java.lang.Object r5 = r5.getValue()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            goto L_0x0022
        L_0x0021:
            r5 = r12
        L_0x0022:
            boolean r5 = androidx.databinding.ViewDataBinding.safeUnbox(r5)
            r5 = r5 ^ 1
            if (r14 == 0) goto L_0x0033
            if (r5 == 0) goto L_0x002e
            long r0 = r0 | r10
            goto L_0x0033
        L_0x002e:
            r8 = 8
            long r0 = r0 | r8
            goto L_0x0033
        L_0x0032:
            r5 = 0
        L_0x0033:
            long r8 = r0 & r10
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x0047
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r4.getValue()
            r12 = r4
            java.lang.Boolean r12 = (java.lang.Boolean) r12
        L_0x0042:
            boolean r4 = androidx.databinding.ViewDataBinding.safeUnbox(r12)
            goto L_0x0048
        L_0x0047:
            r4 = 0
        L_0x0048:
            long r0 = r0 & r6
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0050
            if (r5 == 0) goto L_0x0050
            r13 = r4
        L_0x0050:
            if (r6 == 0) goto L_0x0057
            android.widget.LinearLayout r0 = r15.f6519d
            com.tplink.iot.view.ipcamera.base.b.Q(r0, r13)
        L_0x0057:
            return
        L_0x0058:
            r0 = move-exception
            monitor-exit(r15)     // Catch: all -> 0x0058
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityCameraPreviewCloudVideoServerBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityCameraPreviewCloudVideoServerBinding
    public void h(@Nullable MutableLiveData<Boolean> mutableLiveData) {
        updateLiveDataRegistration(0, mutableLiveData);
        this.y = mutableLiveData;
        synchronized (this) {
            this.p2 |= 1;
        }
        notifyPropertyChanged(34);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p2 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityCameraPreviewCloudVideoServerBinding
    public void i(@Nullable MutableLiveData<Boolean> mutableLiveData) {
        updateLiveDataRegistration(1, mutableLiveData);
        this.z = mutableLiveData;
        synchronized (this) {
            this.p2 |= 2;
        }
        notifyPropertyChanged(48);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (34 == i) {
            h((MutableLiveData) obj);
        } else if (48 != i) {
            return false;
        } else {
            i((MutableLiveData) obj);
        }
        return true;
    }

    private ActivityCameraPreviewCloudVideoServerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageView) objArr[4], (LinearLayout) objArr[0], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[1]);
        this.p2 = -1L;
        this.f6519d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
