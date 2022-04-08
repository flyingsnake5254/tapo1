package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class ViewVideoSurfaceLayoutBindingImpl extends ViewVideoSurfaceLayoutBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts W3 = null;
    @Nullable
    private static final SparseIntArray X3;
    @NonNull
    private final ConstraintLayout Y3;
    @NonNull
    private final LinearLayout Z3;
    @NonNull
    private final TextView a4;
    @NonNull
    private final TextView b4;
    private long c4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        X3 = sparseIntArray;
        sparseIntArray.put(R.id.live_surface_view, 15);
        sparseIntArray.put(R.id.touch_mask, 16);
        sparseIntArray.put(R.id.network_speed, 17);
    }

    public ViewVideoSurfaceLayoutBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 18, W3, X3));
    }

    private boolean A(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 32;
        }
        return true;
    }

    private boolean B(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 16;
        }
        return true;
    }

    private boolean C(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 512;
        }
        return true;
    }

    private boolean D(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 64;
        }
        return true;
    }

    private boolean E(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 8;
        }
        return true;
    }

    private boolean F(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 256;
        }
        return true;
    }

    private boolean v(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean w(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 2;
        }
        return true;
    }

    private boolean x(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 4;
        }
        return true;
    }

    private boolean y(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 1;
        }
        return true;
    }

    private boolean z(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 128;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:267:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:310:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1072
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ViewVideoSurfaceLayoutBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void h(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(10, observableBoolean);
        this.O3 = observableBoolean;
        synchronized (this) {
            this.c4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(30);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.c4 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void i(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(1, observableBoolean);
        this.V3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 2;
        }
        notifyPropertyChanged(33);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.c4 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void l(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(2, observableBoolean);
        this.T3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 4;
        }
        notifyPropertyChanged(38);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void m(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(0, observableBoolean);
        this.K3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 1;
        }
        notifyPropertyChanged(41);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void n(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(7, observableBoolean);
        this.L3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 128;
        }
        notifyPropertyChanged(42);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void o(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(5, observableBoolean);
        this.N3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 32;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return y((ObservableBoolean) obj, i2);
            case 1:
                return w((ObservableBoolean) obj, i2);
            case 2:
                return x((ObservableBoolean) obj, i2);
            case 3:
                return E((ObservableBoolean) obj, i2);
            case 4:
                return B((ObservableBoolean) obj, i2);
            case 5:
                return A((ObservableBoolean) obj, i2);
            case 6:
                return D((ObservableBoolean) obj, i2);
            case 7:
                return z((ObservableBoolean) obj, i2);
            case 8:
                return F((ObservableField) obj, i2);
            case 9:
                return C((ObservableBoolean) obj, i2);
            case 10:
                return v((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void p(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(4, observableBoolean);
        this.M3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 16;
        }
        notifyPropertyChanged(45);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void q(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(9, observableBoolean);
        this.P3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 512;
        }
        notifyPropertyChanged(49);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void r(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(6, observableBoolean);
        this.S3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 64;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void s(@Nullable ObservableBoolean observableBoolean) {
        updateRegistration(3, observableBoolean);
        this.Q3 = observableBoolean;
        synchronized (this) {
            this.c4 |= 8;
        }
        notifyPropertyChanged(52);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (41 == i) {
            m((ObservableBoolean) obj);
        } else if (33 == i) {
            i((ObservableBoolean) obj);
        } else if (38 == i) {
            l((ObservableBoolean) obj);
        } else if (52 == i) {
            s((ObservableBoolean) obj);
        } else if (45 == i) {
            p((ObservableBoolean) obj);
        } else if (44 == i) {
            o((ObservableBoolean) obj);
        } else if (50 == i) {
            r((ObservableBoolean) obj);
        } else if (42 == i) {
            n((ObservableBoolean) obj);
        } else if (85 == i) {
            u((ObservableField) obj);
        } else if (49 == i) {
            q((ObservableBoolean) obj);
        } else if (30 == i) {
            h((ObservableBoolean) obj);
        } else if (56 != i) {
            return false;
        } else {
            t((Boolean) obj);
        }
        return true;
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void t(@Nullable Boolean bool) {
        this.U3 = bool;
        synchronized (this) {
            this.c4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(56);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.ViewVideoSurfaceLayoutBinding
    public void u(@Nullable ObservableField<String> observableField) {
        updateRegistration(8, observableField);
        this.R3 = observableField;
        synchronized (this) {
            this.c4 |= 256;
        }
        notifyPropertyChanged(85);
        super.requestRebind();
    }

    private ViewVideoSurfaceLayoutBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (View) objArr[13], (ImageView) objArr[3], (View) objArr[5], (FrameLayout) objArr[15], (LinearLayout) objArr[14], (LottieAnimationView) objArr[4], (View) objArr[8], (TextView) objArr[17], (TextView) objArr[10], (ImageView) objArr[11], (ImageView) objArr[6], (TextView) objArr[7], (TextView) objArr[9], (View) objArr[16]);
        this.c4 = -1L;
        this.f7360c.setTag(null);
        this.f7361d.setTag(null);
        this.f7362f.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.Y3 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.Z3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.a4 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b4 = textView2;
        textView2.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        this.I3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
