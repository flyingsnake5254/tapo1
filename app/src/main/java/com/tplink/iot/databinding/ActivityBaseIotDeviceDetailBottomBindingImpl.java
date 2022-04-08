package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.a;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.yinglan.scrolllayout.content.ContentScrollView;

/* loaded from: classes2.dex */
public class ActivityBaseIotDeviceDetailBottomBindingImpl extends ActivityBaseIotDeviceDetailBottomBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts J3 = null;
    @Nullable
    private static final SparseIntArray K3;
    private long L3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K3 = sparseIntArray;
        sparseIntArray.put(R.id.fl_bottom_ext, 7);
        sparseIntArray.put(R.id.arrow_share, 8);
        sparseIntArray.put(R.id.arrow_help, 9);
        sparseIntArray.put(R.id.view_white_stub, 10);
    }

    public ActivityBaseIotDeviceDetailBottomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, J3, K3));
    }

    private boolean l(LiveData<Integer> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 16;
        }
        return true;
    }

    private boolean m(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 8;
        }
        return true;
    }

    private boolean n(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 4;
        }
        return true;
    }

    private boolean o(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 2;
        }
        return true;
    }

    private boolean p(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.L3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        float f2;
        float f3;
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        float f4;
        boolean z6;
        boolean z7;
        long j2;
        synchronized (this) {
            j = this.L3;
            this.L3 = 0L;
        }
        IoTDetailBaseViewModel ioTDetailBaseViewModel = this.I3;
        View.OnClickListener onClickListener = this.H3;
        float f5 = 0.0f;
        if ((191 & j) != 0) {
            if ((j & 161) != 0) {
                LiveData<Boolean> A = ioTDetailBaseViewModel != null ? ioTDetailBaseViewModel.A() : null;
                updateLiveDataRegistration(0, A);
                z4 = ViewDataBinding.safeUnbox(Boolean.valueOf(!ViewDataBinding.safeUnbox(A != null ? A.getValue() : null)));
            } else {
                z4 = false;
            }
            z3 = ((j & 160) == 0 || ioTDetailBaseViewModel == null) ? false : ioTDetailBaseViewModel.C();
            f5 = 0.5f;
            int i = ((j & 162) > 0L ? 1 : ((j & 162) == 0L ? 0 : -1));
            if (i != 0) {
                LiveData<Boolean> z8 = ioTDetailBaseViewModel != null ? ioTDetailBaseViewModel.z() : null;
                updateLiveDataRegistration(1, z8);
                boolean safeUnbox = ViewDataBinding.safeUnbox(z8 != null ? z8.getValue() : null);
                if (i != 0) {
                    j |= safeUnbox ? 512L : 256L;
                }
                f4 = safeUnbox ? 0.5f : 1.0f;
                z6 = ViewDataBinding.safeUnbox(Boolean.valueOf(!safeUnbox));
            } else {
                z6 = false;
                f4 = 0.0f;
            }
            int i2 = ((j & 164) > 0L ? 1 : ((j & 164) == 0L ? 0 : -1));
            if (i2 != 0) {
                LiveData<Boolean> w = ioTDetailBaseViewModel != null ? ioTDetailBaseViewModel.w() : null;
                updateLiveDataRegistration(2, w);
                z = ViewDataBinding.safeUnbox(w != null ? w.getValue() : null);
                if (i2 != 0) {
                    j |= z ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
                }
                if (z) {
                    f5 = 1.0f;
                }
            } else {
                z = false;
            }
            if ((j & 168) != 0) {
                LiveData<Boolean> v = ioTDetailBaseViewModel != null ? ioTDetailBaseViewModel.v() : null;
                updateLiveDataRegistration(3, v);
                z7 = ViewDataBinding.safeUnbox(v != null ? v.getValue() : null);
                j2 = 176;
            } else {
                j2 = 176;
                z7 = false;
            }
            if ((j & j2) != 0) {
                LiveData<Integer> l = ioTDetailBaseViewModel != null ? ioTDetailBaseViewModel.l() : null;
                updateLiveDataRegistration(4, l);
                str = String.valueOf(ViewDataBinding.safeUnbox(l != null ? l.getValue() : null));
                z5 = z6;
                f3 = f5;
                z2 = z7;
                f2 = f4;
            } else {
                z5 = z6;
                f3 = f5;
                z2 = z7;
                f2 = f4;
                str = null;
            }
        } else {
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            str = null;
            z = false;
            f3 = 0.0f;
            f2 = 0.0f;
        }
        int i3 = ((j & 192) > 0L ? 1 : ((j & 192) == 0L ? 0 : -1));
        if ((j & 168) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f6505f, z2);
        }
        if ((j & 164) != 0) {
            this.f6505f.setEnabled(z);
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.p0.setAlpha(f3);
            }
        }
        if ((162 & j) != 0) {
            if (ViewDataBinding.getBuildSdkInt() >= 11) {
                this.x.setAlpha(f2);
            }
            this.x.setEnabled(z5);
        }
        if (i3 != 0) {
            this.x.setOnClickListener(onClickListener);
            this.y.setOnClickListener(onClickListener);
            this.z.setOnClickListener(onClickListener);
        }
        if ((j & 161) != 0) {
            a.h(this.x, z4);
        }
        if ((160 & j) != 0) {
            a.h(this.p0, z3);
        }
        if ((j & 176) != 0) {
            TextViewBindingAdapter.setText(this.p2, str);
        }
    }

    @Override // com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBottomBinding
    public void h(@Nullable IoTDetailBaseViewModel ioTDetailBaseViewModel) {
        this.I3 = ioTDetailBaseViewModel;
        synchronized (this) {
            this.L3 |= 32;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.L3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBottomBinding
    public void i(@Nullable View.OnClickListener onClickListener) {
        this.H3 = onClickListener;
        synchronized (this) {
            this.L3 |= 64;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.L3 = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((LiveData) obj, i2);
        }
        if (i == 1) {
            return o((LiveData) obj, i2);
        }
        if (i == 2) {
            return n((LiveData) obj, i2);
        }
        if (i == 3) {
            return m((LiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return l((LiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (15 == i) {
            h((IoTDetailBaseViewModel) obj);
        } else if (69 != i) {
            return false;
        } else {
            i((View.OnClickListener) obj);
        }
        return true;
    }

    private ActivityBaseIotDeviceDetailBottomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageView) objArr[9], (ImageView) objArr[8], (TPSwitchCompat) objArr[3], (FrameLayout) objArr[7], (RelativeLayout) objArr[4], (RelativeLayout) objArr[6], (ImageView) objArr[1], (RelativeLayout) objArr[2], (ContentScrollView) objArr[0], (TextView) objArr[5], (View) objArr[10]);
        this.L3 = -1L;
        this.f6505f.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
