package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.tplink.iot.adapter.databinding.d;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.b;
import com.tplink.iot.view.ipcamera.preview.CameraPreviewInfo;

/* loaded from: classes2.dex */
public class ItemHomeAwayModeFailBindingImpl extends ItemHomeAwayModeFailBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3 = null;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final ConstraintLayout I3;
    @Nullable
    private final View.OnClickListener J3;
    private long K3;

    public ItemHomeAwayModeFailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, p3, H3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        d dVar = this.p1;
        Integer num = this.p2;
        if (dVar != null) {
            dVar.a(view, ViewDataBinding.safeUnbox(num));
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        String str;
        String str2;
        boolean z2;
        boolean z3;
        boolean z4;
        String str3;
        boolean z5;
        int i;
        CameraPreviewInfo cameraPreviewInfo;
        long j2;
        long j3;
        synchronized (this) {
            j = this.K3;
            this.K3 = 0L;
        }
        com.tplink.iot.view.ipcamera.preview.d dVar = this.p0;
        int i2 = ((j & 9) > 0L ? 1 : ((j & 9) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (dVar != null) {
                z4 = dVar.b();
                cameraPreviewInfo = dVar.a();
            } else {
                cameraPreviewInfo = null;
                z4 = false;
            }
            if (i2 != 0) {
                if (z4) {
                    j3 = j | 512;
                    j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                } else {
                    j3 = j | 256;
                    j2 = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                }
                j = j3 | j2;
            }
            z3 = !z4;
            if ((j & 9) != 0) {
                j |= z3 ? 128L : 64L;
            }
            if (cameraPreviewInfo != null) {
                z2 = cameraPreviewInfo.m();
                str2 = cameraPreviewInfo.i();
                str = cameraPreviewInfo.l();
                str3 = cameraPreviewInfo.e();
            } else {
                str3 = null;
                str2 = null;
                str = null;
                z2 = false;
            }
            z = !z2;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        int i3 = ((j & 9) > 0L ? 1 : ((j & 9) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean z6 = z3 ? z2 : false;
            z5 = z4 ? true : z;
            if (!z4) {
                z2 = false;
            }
            if (i3 != 0) {
                j |= z6 ? 32L : 16L;
            }
            i = z6 ? 0 : 4;
        } else {
            i = 0;
            z2 = false;
            z5 = false;
        }
        if ((9 & j) != 0) {
            b.Q(this.f7175c, z2);
            b.Q(this.f7176d, z);
            b.E(this.f7177f, str3, false);
            this.q.setVisibility(i);
            b.Q(this.x, z5);
            TextViewBindingAdapter.setText(this.y, str);
            TextViewBindingAdapter.setText(this.z, str2);
        }
        if ((j & 8) != 0) {
            this.x.setOnClickListener(this.J3);
        }
    }

    public void h(@Nullable d dVar) {
        this.p1 = dVar;
        synchronized (this) {
            this.K3 |= 4;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.K3 != 0;
        }
    }

    public void i(@Nullable com.tplink.iot.view.ipcamera.preview.d dVar) {
        this.p0 = dVar;
        synchronized (this) {
            this.K3 |= 1;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K3 = 8L;
        }
        requestRebind();
    }

    public void l(@Nullable Integer num) {
        this.p2 = num;
        synchronized (this) {
            this.K3 |= 2;
        }
        notifyPropertyChanged(76);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (31 == i) {
            i((com.tplink.iot.view.ipcamera.preview.d) obj);
        } else if (76 == i) {
            l((Integer) obj);
        } else if (9 != i) {
            return false;
        } else {
            h((d) obj);
        }
        return true;
    }

    private ItemHomeAwayModeFailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[6], (ImageView) objArr[7], (TextView) objArr[4], (TextView) objArr[5]);
        this.K3 = -1L;
        this.f7175c.setTag(null);
        this.f7176d.setTag(null);
        this.f7177f.setTag(null);
        this.q.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.I3 = constraintLayout;
        constraintLayout.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        setRootTag(view);
        this.J3 = new a(this, 1);
        invalidateAll();
    }
}
