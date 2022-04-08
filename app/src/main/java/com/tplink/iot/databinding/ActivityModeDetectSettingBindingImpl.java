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
import com.tplink.iot.viewmodel.ipcamera.play.ModeDetectionSettingsViewModel;

/* loaded from: classes2.dex */
public class ActivityModeDetectSettingBindingImpl extends ActivityModeDetectSettingBinding {
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
            boolean isChecked = ActivityModeDetectSettingBindingImpl.this.H3.isChecked();
            ModeDetectionSettingsViewModel modeDetectionSettingsViewModel = ActivityModeDetectSettingBindingImpl.this.M3;
            boolean z = true;
            if (modeDetectionSettingsViewModel != null) {
                ObservableBoolean observableBoolean = modeDetectionSettingsViewModel.w;
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

    public ActivityModeDetectSettingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 30, P3, Q3));
    }

    private boolean A(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean B(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return true;
    }

    private boolean C(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 8;
        }
        return true;
    }

    private boolean D(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= 256;
        }
        return true;
    }

    private boolean E(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g4 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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
            this.g4 |= 64;
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
            this.g4 |= 128;
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
            this.g4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
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
            this.g4 |= 512;
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
            this.g4 |= 32;
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

    /* JADX WARN: Removed duplicated region for block: B:102:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0583  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0666  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:442:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityModeDetectSettingBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityModeDetectSettingBinding
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

    @Override // com.tplink.iot.databinding.ActivityModeDetectSettingBinding
    public void i(@Nullable ModeDetectionSettingsViewModel modeDetectionSettingsViewModel) {
        this.M3 = modeDetectionSettingsViewModel;
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
                return C((ObservableBoolean) obj, i2);
            case 4:
                return l((ObservableField) obj, i2);
            case 5:
                return x((ObservableBoolean) obj, i2);
            case 6:
                return G((ObservableBoolean) obj, i2);
            case 7:
                return p((ObservableBoolean) obj, i2);
            case 8:
                return D((ObservableField) obj, i2);
            case 9:
                return t((ObservableBoolean) obj, i2);
            case 10:
                return r((ObservableBoolean) obj, i2);
            case 11:
                return A((ObservableField) obj, i2);
            case 12:
                return E((ObservableBoolean) obj, i2);
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
                return B((ObservableBoolean) obj, i2);
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
            i((ModeDetectionSettingsViewModel) obj);
        }
        return true;
    }

    private ActivityModeDetectSettingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 22, (LinearLayout) objArr[3], (RelativeLayout) objArr[19], (TextView) objArr[20], (TextView) objArr[28], (CameraLoadingView) objArr[25], (LinearLayout) objArr[9], (LinearLayout) objArr[6], (LinearLayout) objArr[1], (LinearLayout) objArr[12], (Toolbar) objArr[26], (LinearLayout) objArr[14], (CheckBox) objArr[16], (RelativeLayout) objArr[22], (TextView) objArr[23], (TextView) objArr[29], (TextView) objArr[27]);
        this.f4 = new a();
        this.g4 = -1L;
        this.f6624c.setTag(null);
        this.f6625d.setTag(null);
        this.f6626f.setTag(null);
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
