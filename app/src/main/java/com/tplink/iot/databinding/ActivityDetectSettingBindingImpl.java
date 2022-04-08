package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.detection.DetectionSettingsViewModel;

/* loaded from: classes2.dex */
public class ActivityDetectSettingBindingImpl extends ActivityDetectSettingBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts P3 = null;
    @Nullable
    private static final SparseIntArray Q3;
    @NonNull
    private final RelativeLayout R3;
    @NonNull
    private final TextView S3;
    @NonNull
    private final View T3;
    @NonNull
    private final TextView U3;
    @NonNull
    private final TextView V3;
    @NonNull
    private final ImageView W3;
    @NonNull
    private final View X3;
    @NonNull
    private final TextView Y3;
    @NonNull
    private final View Z3;
    @NonNull
    private final TextView a4;
    @NonNull
    private final TextView b4;
    @NonNull
    private final View c4;
    @NonNull
    private final TextView d4;
    @NonNull
    private final View e4;
    private InverseBindingListener f4;
    private long g4;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = ActivityDetectSettingBindingImpl.this.H3.isChecked();
            DetectionSettingsViewModel detectionSettingsViewModel = ActivityDetectSettingBindingImpl.this.M3;
            boolean z = true;
            if (detectionSettingsViewModel != null) {
                ObservableBoolean observableBoolean = detectionSettingsViewModel.o;
                if (observableBoolean == null) {
                    z = false;
                }
                if (z) {
                    observableBoolean.set(isChecked);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Q3 = sparseIntArray;
        sparseIntArray.put(R.id.mtb, 26);
        sparseIntArray.put(R.id.title, 27);
        sparseIntArray.put(R.id.alert_title, 28);
        sparseIntArray.put(R.id.target_track_title, 29);
    }

    public ActivityDetectSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 30, P3, Q3));
    }

    private boolean A(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean B(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 32;
        }
        return true;
    }

    private boolean C(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return true;
    }

    private boolean D(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 8;
        }
        return true;
    }

    private boolean E(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 512;
        }
        return true;
    }

    private boolean F(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean G(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 128;
        }
        return true;
    }

    private boolean l(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 16;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 1;
        }
        return true;
    }

    private boolean n(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 2;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 16384;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 256;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean u(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean v(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean w(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 8192;
        }
        return true;
    }

    private boolean x(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 64;
        }
        return true;
    }

    private boolean y(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 4;
        }
        return true;
    }

    private boolean z(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    public void H(@Nullable SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch) {
        this.O3 = onStopTrackingTouch;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0633  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:438:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e5  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1740
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityDetectSettingBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityDetectSettingBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.N3 = onClickListener;
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g4 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityDetectSettingBinding
    public void i(@Nullable DetectionSettingsViewModel detectionSettingsViewModel) {
        this.M3 = detectionSettingsViewModel;
        synchronized (this) {
            this.g4 |= 16777216;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g4 = 33554432L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return m((ObservableField) obj, i2);
            case 1:
                return n((ObservableField) obj, i2);
            case 2:
                return y((ObservableBoolean) obj, i2);
            case 3:
                return D((ObservableBoolean) obj, i2);
            case 4:
                return l((ObservableField) obj, i2);
            case 5:
                return B((ObservableBoolean) obj, i2);
            case 6:
                return x((ObservableBoolean) obj, i2);
            case 7:
                return G((ObservableBoolean) obj, i2);
            case 8:
                return p((ObservableBoolean) obj, i2);
            case 9:
                return E((ObservableField) obj, i2);
            case 10:
                return t((ObservableBoolean) obj, i2);
            case 11:
                return r((ObservableBoolean) obj, i2);
            case 12:
                return A((ObservableField) obj, i2);
            case 13:
                return w((ObservableBoolean) obj, i2);
            case 14:
                return o((ObservableBoolean) obj, i2);
            case 15:
                return F((ObservableBoolean) obj, i2);
            case 16:
                return s((ObservableBoolean) obj, i2);
            case 17:
                return v((ObservableBoolean) obj, i2);
            case 18:
                return z((ObservableField) obj, i2);
            case 19:
                return u((ObservableBoolean) obj, i2);
            case 20:
                return C((ObservableBoolean) obj, i2);
            case 21:
                return q((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (93 == i) {
            H((SeekBarBindingAdapter.OnStopTrackingTouch) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((DetectionSettingsViewModel) obj);
        }
        return true;
    }

    private ActivityDetectSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 22, (LinearLayout) objArr[3], (RelativeLayout) objArr[19], (TextView) objArr[20], (TextView) objArr[28], (CameraLoadingView) objArr[25], (LinearLayout) objArr[9], (LinearLayout) objArr[6], (LinearLayout) objArr[1], (LinearLayout) objArr[12], (Toolbar) objArr[26], (LinearLayout) objArr[14], (CheckBox) objArr[16], (RelativeLayout) objArr[22], (TextView) objArr[23], (TextView) objArr[29], (TextView) objArr[27]);
        this.f4 = new a();
        this.g4 = -1L;
        this.f6539c.setTag(null);
        this.f6540d.setTag(null);
        this.f6541f.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.R3 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.S3 = textView;
        textView.setTag(null);
        View view2 = (View) objArr[11];
        this.T3 = view2;
        view2.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.U3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.V3 = textView3;
        textView3.setTag(null);
        ImageView imageView = (ImageView) objArr[17];
        this.W3 = imageView;
        imageView.setTag(null);
        View view3 = (View) objArr[18];
        this.X3 = view3;
        view3.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.Y3 = textView4;
        textView4.setTag(null);
        View view4 = (View) objArr[21];
        this.Z3 = view4;
        view4.setTag(null);
        TextView textView5 = (TextView) objArr[24];
        this.a4 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[4];
        this.b4 = textView6;
        textView6.setTag(null);
        View view5 = (View) objArr[5];
        this.c4 = view5;
        view5.setTag(null);
        TextView textView7 = (TextView) objArr[7];
        this.d4 = textView7;
        textView7.setTag(null);
        View view6 = (View) objArr[8];
        this.e4 = view6;
        view6.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        this.I3.setTag(null);
        this.J3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
