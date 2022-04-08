package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.ipcamera.base.b;

/* loaded from: classes2.dex */
public class LayoutCameraMenuButtonWhiteLampBindingImpl extends LayoutCameraMenuButtonWhiteLampBinding {
    @Nullable
    private static final SparseIntArray p0 = null;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @NonNull
    private final LinearLayout p1;
    private long p2;

    public LayoutCameraMenuButtonWhiteLampBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, z, p0));
    }

    private boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 8;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 2;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 1;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 4;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.p2;
            this.p2 = 0L;
        }
        ObservableBoolean observableBoolean = this.q;
        float f2 = 0.0f;
        ObservableBoolean observableBoolean2 = this.y;
        Boolean bool = null;
        ObservableBoolean observableBoolean3 = this.f7216f;
        MutableLiveData<Boolean> mutableLiveData = this.f7215d;
        ObservableBoolean observableBoolean4 = this.x;
        boolean z5 = false;
        int i = ((j & 47) > 0L ? 1 : ((j & 47) == 0L ? 0 : -1));
        if (i != 0) {
            z2 = !(observableBoolean2 != null ? observableBoolean2.get() : false);
            if (i != 0) {
                j = z2 ? j | 512 : j | 256;
            }
        } else {
            z2 = false;
        }
        boolean z6 = ((j & 48) == 0 || observableBoolean4 == null) ? false : observableBoolean4.get();
        boolean z7 = ((j & 512) == 0 || observableBoolean3 == null) ? false : observableBoolean3.get();
        if ((j & 47) != 0) {
            if (!z2) {
                z7 = false;
            }
            if ((j & 39) != 0) {
                j = z7 ? j | 8192 : j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            if ((j & 47) != 0) {
                j = z7 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : j | 16384;
            }
        } else {
            z7 = false;
        }
        if ((j & 8192) != 0) {
            z3 = observableBoolean != null ? observableBoolean.get() : false;
            z5 = !z3;
        } else {
            z3 = false;
            z5 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
            if (mutableLiveData != null) {
                bool = mutableLiveData.getValue();
            }
            z4 = !ViewDataBinding.safeUnbox(bool);
        } else {
            z4 = false;
        }
        boolean z8 = ((j & 39) == 0 || !z7) ? false : z5;
        int i2 = ((j & 47) > 0L ? 1 : ((j & 47) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (!z7) {
                z4 = false;
            }
            if (i2 != 0) {
                j = z4 ? j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
        } else {
            z4 = false;
        }
        if ((j & PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != 0) {
            if (observableBoolean != null) {
                z3 = observableBoolean.get();
            }
            z5 = !z3;
        }
        int i3 = ((j & 47) > 0L ? 1 : ((j & 47) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (z4) {
            }
            if (i3 != 0) {
                j |= z5 ? 128L : 64L;
            }
            f2 = z5 ? 1.0f : 0.4f;
        }
        if ((j & 47) != 0 && ViewDataBinding.getBuildSdkInt() >= 11) {
            this.f7214c.setAlpha(f2);
        }
        if ((j & 39) != 0) {
            this.f7214c.setEnabled(z8);
        }
        if ((j & 48) != 0) {
            b.Q(this.f7214c, z6);
        }
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBinding
    public void h(@Nullable MutableLiveData<Boolean> mutableLiveData) {
        updateLiveDataRegistration(3, mutableLiveData);
        this.f7215d = mutableLiveData;
        synchronized (this) {
            this.p2 |= 8;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p2 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBinding
    public void i(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.y = observableBoolean;
        synchronized (this) {
            this.p2 |= 2;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 32L;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBinding
    public void l(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.q = observableBoolean;
        synchronized (this) {
            this.p2 |= 1;
        }
        notifyPropertyChanged(57);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBinding
    public void m(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(2, observableBoolean);
        this.f7216f = observableBoolean;
        synchronized (this) {
            this.p2 |= 4;
        }
        notifyPropertyChanged(73);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutCameraMenuButtonWhiteLampBinding
    public void n(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(4, observableBoolean);
        this.x = observableBoolean;
        synchronized (this) {
            this.p2 |= 16;
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

    private LayoutCameraMenuButtonWhiteLampBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageView) objArr[1]);
        this.p2 = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.p1 = linearLayout;
        linearLayout.setTag(null);
        this.f7214c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
