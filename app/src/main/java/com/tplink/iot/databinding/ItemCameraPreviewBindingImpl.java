package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;
import com.tplink.iot.widget.RoundImageView;
import com.tplink.iot.widget.camerapreview.PreviewDisplayView;
import com.tplink.iot.widget.camerapreview.g;

/* loaded from: classes2.dex */
public class ItemCameraPreviewBindingImpl extends ItemCameraPreviewBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray x = null;
    private long p0;
    @NonNull
    private final ConstraintLayout y;
    @NonNull
    private final PreviewDisplayView z;

    public ItemCameraPreviewBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, q, x));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.p0;
            this.p0 = 0L;
        }
        String str = null;
        String str2 = this.f7148d;
        CameraPreviewInfo cameraPreviewInfo = this.f7149f;
        int i = ((5 & j) > 0L ? 1 : ((5 & j) == 0L ? 0 : -1));
        int i2 = ((j & 6) > 0L ? 1 : ((j & 6) == 0L ? 0 : -1));
        if (!(i2 == 0 || cameraPreviewInfo == null)) {
            str = cameraPreviewInfo.e();
        }
        if (i2 != 0) {
            b.E(this.f7147c, str, false);
            g.b(this.z, cameraPreviewInfo);
        }
        if (i != 0) {
            g.a(this.z, str2);
        }
    }

    public void h(@Nullable String str) {
        this.f7148d = str;
        synchronized (this) {
            this.p0 |= 1;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p0 != 0;
        }
    }

    public void i(@Nullable CameraPreviewInfo cameraPreviewInfo) {
        this.f7149f = cameraPreviewInfo;
        synchronized (this) {
            this.p0 |= 2;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p0 = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (3 == i) {
            h((String) obj);
        } else if (6 != i) {
            return false;
        } else {
            i((CameraPreviewInfo) obj);
        }
        return true;
    }

    private ItemCameraPreviewBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundImageView) objArr[1]);
        this.p0 = -1L;
        this.f7147c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.y = constraintLayout;
        constraintLayout.setTag(null);
        PreviewDisplayView previewDisplayView = (PreviewDisplayView) objArr[2];
        this.z = previewDisplayView;
        previewDisplayView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
