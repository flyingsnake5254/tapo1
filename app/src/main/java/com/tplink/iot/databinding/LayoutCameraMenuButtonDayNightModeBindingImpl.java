package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;

/* loaded from: classes2.dex */
public class LayoutCameraMenuButtonDayNightModeBindingImpl extends LayoutCameraMenuButtonDayNightModeBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p0 = null;
    @Nullable
    private static final SparseIntArray p1 = null;
    @NonNull
    private final LinearLayout p2;
    private long p3;

    public LayoutCameraMenuButtonDayNightModeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, p0, p1));
    }

    private boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 8;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 2;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 1;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 4;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.p3;
            this.p3 = 0L;
        }
        ObservableBoolean observableBoolean = this.x;
        float f2 = 0.0f;
        ObservableBoolean observableBoolean2 = this.z;
        Boolean bool = null;
        ObservableBoolean observableBoolean3 = this.q;
        MutableLiveData<Boolean> mutableLiveData = this.f7213f;
        ObservableBoolean observableBoolean4 = this.y;
        boolean z4 = false;
        int i = ((j & 47) > 0L ? 1 : ((j & 47) == 0L ? 0 : -1));
        if (i != 0) {
            z = !(observableBoolean2 != null ? observableBoolean2.get() : false);
            if (i != 0) {
                j = z ? j | 512 : j | 256;
            }
        } else {
            z = false;
        }
        boolean z5 = ((j & 48) == 0 || observableBoolean4 == null) ? false : observableBoolean4.get();
        boolean z6 = ((j & 512) == 0 || observableBoolean3 == null) ? false : observableBoolean3.get();
        if ((j & 47) != 0) {
            if (!z) {
                z6 = false;
            }
            if ((j & 39) != 0) {
                j = z6 ? j | 8192 : j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            if ((j & 47) != 0) {
                j = z6 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : j | 16384;
            }
        } else {
            z6 = false;
        }
        if ((j & 8192) != 0) {
            z2 = observableBoolean != null ? observableBoolean.get() : false;
            z4 = !z2;
        } else {
            z2 = false;
            z4 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
            if (mutableLiveData != null) {
                bool = mutableLiveData.getValue();
            }
            z3 = !ViewDataBinding.safeUnbox(bool);
        } else {
            z3 = false;
        }
        boolean z7 = ((j & 39) == 0 || !z6) ? false : z4;
        int i2 = ((j & 47) > 0L ? 1 : ((j & 47) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (!z6) {
                z3 = false;
            }
            if (i2 != 0) {
                j = z3 ? j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
        } else {
            z3 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != 0) {
            if (observableBoolean != null) {
                z2 = observableBoolean.get();
            }
            z4 = !z2;
        }
        int i3 = ((j & 47) > 0L ? 1 : ((j & 47) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (z3) {
            }
            if (i3 != 0) {
                j |= z4 ? 128L : 64L;
            }
            f2 = z4 ? 1.0f : 0.4f;
        }
        if ((j & 47) != 0 && ViewDataBinding.getBuildSdkInt() >= 11) {
            this.f7211c.setAlpha(f2);
            this.f7212d.setAlpha(f2);
        }
        if ((j & 39) != 0) {
            this.f7211c.setEnabled(z7);
            this.f7212d.setEnabled(z7);
        }
        if ((j & 48) != 0) {
            b.Q(this.p2, z5);
        }
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBinding
    public void h(@Nullable MutableLiveData<Boolean> mutableLiveData) {
        updateLiveDataRegistration(3, mutableLiveData);
        this.f7213f = mutableLiveData;
        synchronized (this) {
            this.p3 |= 8;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBinding
    public void i(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.z = observableBoolean;
        synchronized (this) {
            this.p3 |= 2;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = 32L;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBinding
    public void l(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.x = observableBoolean;
        synchronized (this) {
            this.p3 |= 1;
        }
        notifyPropertyChanged(57);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBinding
    public void m(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(2, observableBoolean);
        this.q = observableBoolean;
        synchronized (this) {
            this.p3 |= 4;
        }
        notifyPropertyChanged(73);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonDayNightModeBinding
    public void n(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(4, observableBoolean);
        this.y = observableBoolean;
        synchronized (this) {
            this.p3 |= 16;
        }
        notifyPropertyChanged(106);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return p((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return r((ObservableBoolean) obj, i2);
        }
        if (i == 3) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return s((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (57 == i) {
            l((ObservableBoolean) obj);
        } else if (33 == i) {
            i((ObservableBoolean) obj);
        } else if (73 == i) {
            m((ObservableBoolean) obj);
        } else if (17 == i) {
            h((MutableLiveData) obj);
        } else if (106 != i) {
            return false;
        } else {
            n((ObservableBoolean) obj);
        }
        return true;
    }

    private LayoutCameraMenuButtonDayNightModeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageView) objArr[2], (TextView) objArr[1]);
        this.p3 = -1L;
        this.f7211c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p2 = linearLayout;
        linearLayout.setTag(null);
        this.f7212d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
