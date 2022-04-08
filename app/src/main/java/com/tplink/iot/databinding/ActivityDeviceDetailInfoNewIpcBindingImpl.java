package com.tplink.iot.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceDetailInfoViewModel;

/* loaded from: classes2.dex */
public class ActivityDeviceDetailInfoNewIpcBindingImpl extends ActivityDeviceDetailInfoNewIpcBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts b4 = null;
    @Nullable
    private static final SparseIntArray c4;
    @NonNull
    private final FrameLayout d4;
    @NonNull
    private final View e4;
    @NonNull
    private final RelativeLayout f4;
    @NonNull
    private final TextView g4;
    @NonNull
    private final ImageView h4;
    @NonNull
    private final View i4;
    @NonNull
    private final FrameLayout j4;
    @NonNull
    private final ImageView k4;
    @NonNull
    private final TextView l4;
    @NonNull
    private final View m4;
    @NonNull
    private final LinearLayout n4;
    private long o4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        c4 = sparseIntArray;
        sparseIntArray.put(R.id.content, 28);
        sparseIntArray.put(R.id.toolbar, 29);
        sparseIntArray.put(R.id.main_info, 30);
        sparseIntArray.put(R.id.icon_title, 31);
        sparseIntArray.put(R.id.img_icon, 32);
        sparseIntArray.put(R.id.name_title, 33);
        sparseIntArray.put(R.id.wifi_title, 34);
        sparseIntArray.put(R.id.ip_address_title, 35);
        sparseIntArray.put(R.id.mac_address_title, 36);
        sparseIntArray.put(R.id.hardware_title, 37);
        sparseIntArray.put(R.id.firmware_title, 38);
        sparseIntArray.put(R.id.firmware_next, 39);
    }

    public ActivityDeviceDetailInfoNewIpcBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 40, b4, c4));
    }

    private boolean A(ObservableField<Drawable> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 1;
        }
        return true;
    }

    private boolean B(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 128;
        }
        return true;
    }

    private boolean C(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 32;
        }
        return true;
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 16384;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean o(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 2;
        }
        return true;
    }

    private boolean p(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 8;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 16;
        }
        return true;
    }

    private boolean r(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 512;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 4;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 8192;
        }
        return true;
    }

    private boolean u(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 64;
        }
        return true;
    }

    private boolean v(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean w(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= 256;
        }
        return true;
    }

    private boolean x(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean y(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean z(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0201 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011b  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityDeviceDetailInfoNewIpcBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityDeviceDetailInfoNewIpcBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.a4 = onClickListener;
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o4 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityDeviceDetailInfoNewIpcBinding
    public void i(@Nullable DeviceDetailInfoViewModel deviceDetailInfoViewModel) {
        this.Z3 = deviceDetailInfoViewModel;
        synchronized (this) {
            this.o4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o4 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return A((ObservableField) obj, i2);
            case 1:
                return o((ObservableField) obj, i2);
            case 2:
                return s((ObservableBoolean) obj, i2);
            case 3:
                return p((ObservableField) obj, i2);
            case 4:
                return q((ObservableBoolean) obj, i2);
            case 5:
                return C((ObservableField) obj, i2);
            case 6:
                return u((ObservableBoolean) obj, i2);
            case 7:
                return B((ObservableField) obj, i2);
            case 8:
                return w((ObservableBoolean) obj, i2);
            case 9:
                return r((ObservableField) obj, i2);
            case 10:
                return n((ObservableBoolean) obj, i2);
            case 11:
                return l((ObservableBoolean) obj, i2);
            case 12:
                return x((ObservableField) obj, i2);
            case 13:
                return t((ObservableBoolean) obj, i2);
            case 14:
                return m((ObservableField) obj, i2);
            case 15:
                return v((ObservableBoolean) obj, i2);
            case 16:
                return y((ObservableField) obj, i2);
            case 17:
                return z((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (2 == i) {
            h((View.OnClickListener) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((DeviceDetailInfoViewModel) obj);
        }
        return true;
    }

    private ActivityDeviceDetailInfoNewIpcBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 18, (RelativeLayout) objArr[4], (RelativeLayout) objArr[6], (LinearLayout) objArr[28], (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[24], (ImageView) objArr[39], (TextView) objArr[38], (RelativeLayout) objArr[23], (TextView) objArr[22], (TextView) objArr[37], (RelativeLayout) objArr[21], (TextView) objArr[31], (ImageView) objArr[32], (RelativeLayout) objArr[17], (TextView) objArr[18], (TextView) objArr[35], (CameraLoadingView) objArr[27], (RelativeLayout) objArr[19], (TextView) objArr[20], (TextView) objArr[36], (LinearLayout) objArr[30], (TextView) objArr[7], (TextView) objArr[33], (FrameLayout) objArr[13], (Toolbar) objArr[29], (TextView) objArr[10], (RelativeLayout) objArr[9], (TextView) objArr[34]);
        this.o4 = -1L;
        this.f6542c.setTag(null);
        this.f6543d.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.H3.setTag(null);
        this.K3.setTag(null);
        this.L3.setTag(null);
        this.N3.setTag(null);
        this.O3.setTag(null);
        this.P3.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.d4 = frameLayout;
        frameLayout.setTag(null);
        View view2 = (View) objArr[11];
        this.e4 = view2;
        view2.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[12];
        this.f4 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[14];
        this.g4 = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[15];
        this.h4 = imageView;
        imageView.setTag(null);
        View view3 = (View) objArr[16];
        this.i4 = view3;
        view3.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[2];
        this.j4 = frameLayout2;
        frameLayout2.setTag(null);
        ImageView imageView2 = (ImageView) objArr[25];
        this.k4 = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) objArr[26];
        this.l4 = textView2;
        textView2.setTag(null);
        View view4 = (View) objArr[5];
        this.m4 = view4;
        view4.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[8];
        this.n4 = linearLayout;
        linearLayout.setTag(null);
        this.S3.setTag(null);
        this.U3.setTag(null);
        this.W3.setTag(null);
        this.X3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
