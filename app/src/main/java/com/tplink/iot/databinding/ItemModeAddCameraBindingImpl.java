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
public class ItemModeAddCameraBindingImpl extends ItemModeAddCameraBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I3 = null;
    @Nullable
    private static final SparseIntArray J3 = null;
    @NonNull
    private final ConstraintLayout K3;
    @NonNull
    private final ImageView L3;
    @Nullable
    private final View.OnClickListener M3;
    private long N3;

    public ItemModeAddCameraBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, I3, J3));
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        d dVar = this.p2;
        Integer num = this.p1;
        if (dVar != null) {
            dVar.a(view, ViewDataBinding.safeUnbox(num));
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        float f2;
        String str;
        boolean z6;
        int i;
        boolean z7;
        synchronized (this) {
            j = this.N3;
            this.N3 = 0L;
        }
        Boolean bool = this.p3;
        Integer num = this.H3;
        CameraPreviewInfo cameraPreviewInfo = this.z;
        Integer num2 = this.p1;
        String str2 = this.p0;
        int i2 = ((j & 69) > 0L ? 1 : ((j & 69) == 0L ? 0 : -1));
        if (i2 != 0) {
            z2 = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                j |= z2 ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512L;
            }
            z = !z2;
            if ((j & 69) != 0) {
                j |= z ? 256L : 128L;
            }
        } else {
            z2 = false;
            z = false;
        }
        int i3 = ((j & 74) > 0L ? 1 : ((j & 74) == 0L ? 0 : -1));
        if (i3 != 0) {
            z3 = !(num != null ? num.equals(0) : false);
            if (i3 != 0) {
                j = z3 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
        } else {
            z3 = false;
        }
        String str3 = null;
        int i4 = ((j & 68) > 0L ? 1 : ((j & 68) == 0L ? 0 : -1));
        if (i4 != 0) {
            if (cameraPreviewInfo != null) {
                z7 = cameraPreviewInfo.m();
                str = cameraPreviewInfo.e();
                str3 = cameraPreviewInfo.l();
            } else {
                str = null;
                z7 = false;
            }
            if (i4 != 0) {
                j = z7 ? j | 16384 : j | 8192;
            }
            f2 = z7 ? 1.0f : 0.5f;
            z4 = !z7;
            z5 = z7;
        } else {
            str = null;
            str3 = null;
            f2 = 0.0f;
            z5 = false;
            z4 = false;
        }
        if ((j & 1280) != 0) {
            if (cameraPreviewInfo != null) {
                z5 = cameraPreviewInfo.m();
            }
            if ((j & 68) != 0) {
                j = z5 ? j | 16384 : j | 8192;
            }
        }
        boolean z8 = ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0 || num == null) ? false : num.equals(num2);
        int i5 = ((j & 69) > 0L ? 1 : ((j & 69) == 0L ? 0 : -1));
        if (i5 != 0) {
            z6 = z ? z5 : false;
            if (!z2) {
                z5 = false;
            }
            if (i5 != 0) {
                j |= z5 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            i = z5 ? 0 : 4;
        } else {
            i = 0;
            z6 = false;
        }
        int i6 = ((j & 74) > 0L ? 1 : ((j & 74) == 0L ? 0 : -1));
        if (i6 == 0) {
            z8 = false;
        } else if (!z3) {
            z8 = false;
        }
        if (i6 != 0) {
            b.Q(this.f7181c, z8);
        }
        if ((j & 68) != 0) {
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.f7182d.setAlpha(f2);
                this.x.setAlpha(f2);
                this.y.setAlpha(f2);
            }
            b.E(this.f7182d, str, true);
            b.Q(this.L3, z4);
            TextViewBindingAdapter.setText(this.x, str3);
        }
        if ((j & 69) != 0) {
            this.f7183f.setVisibility(i);
            b.Q(this.q, z6);
        }
        if ((64 & j) != 0) {
            this.K3.setOnClickListener(this.M3);
        }
        if ((j & 80) != 0) {
            TextViewBindingAdapter.setText(this.y, str2);
        }
    }

    public void h(@Nullable d dVar) {
        this.p2 = dVar;
        synchronized (this) {
            this.N3 |= 32;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.N3 != 0;
        }
    }

    public void i(@Nullable Integer num) {
        this.H3 = num;
        synchronized (this) {
            this.N3 |= 2;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.N3 = 64L;
        }
        requestRebind();
    }

    public void l(@Nullable CameraPreviewInfo cameraPreviewInfo) {
        this.z = cameraPreviewInfo;
        synchronized (this) {
            this.N3 |= 4;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    public void m(@Nullable Boolean bool) {
        this.p3 = bool;
        synchronized (this) {
            this.N3 |= 1;
        }
        notifyPropertyChanged(51);
        super.requestRebind();
    }

    public void n(@Nullable String str) {
        this.p0 = str;
        synchronized (this) {
            this.N3 |= 16;
        }
        notifyPropertyChanged(58);
        super.requestRebind();
    }

    public void o(@Nullable Integer num) {
        this.p1 = num;
        synchronized (this) {
            this.N3 |= 8;
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
        if (51 == i) {
            m((Boolean) obj);
        } else if (24 == i) {
            i((Integer) obj);
        } else if (31 == i) {
            l((CameraPreviewInfo) obj);
        } else if (76 == i) {
            o((Integer) obj);
        } else if (58 == i) {
            n((String) obj);
        } else if (9 != i) {
            return false;
        } else {
            h((d) obj);
        }
        return true;
    }

    private ItemModeAddCameraBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[1], (ImageView) objArr[2], (ImageView) objArr[6], (ImageView) objArr[7], (TextView) objArr[4], (TextView) objArr[5]);
        this.N3 = -1L;
        this.f7181c.setTag(null);
        this.f7182d.setTag(null);
        this.f7183f.setTag(null);
        this.q.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.K3 = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.L3 = imageView;
        imageView.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        setRootTag(view);
        this.M3 = new a(this, 1);
        invalidateAll();
    }
}
