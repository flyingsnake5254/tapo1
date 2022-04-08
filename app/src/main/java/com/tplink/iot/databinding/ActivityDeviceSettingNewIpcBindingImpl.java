package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
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
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.viewmodel.ipcamera.setting.DeviceSettingNewViewModel;

/* loaded from: classes2.dex */
public class ActivityDeviceSettingNewIpcBindingImpl extends ActivityDeviceSettingNewIpcBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts A4 = null;
    @Nullable
    private static final SparseIntArray B4;
    @NonNull
    private final FrameLayout C4;
    @NonNull
    private final LinearLayout D4;
    @NonNull
    private final LinearLayout E4;
    @NonNull
    private final FrameLayout F4;
    @NonNull
    private final View G4;
    @NonNull
    private final FrameLayout H4;
    @NonNull
    private final View I4;
    @NonNull
    private final FrameLayout J4;
    @NonNull
    private final View K4;
    @NonNull
    private final View L4;
    @NonNull
    private final View M4;
    @NonNull
    private final ImageView N4;
    private InverseBindingListener O4;
    private InverseBindingListener P4;
    private InverseBindingListener Q4;
    private long R4;
    private long S4;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = ActivityDeviceSettingNewIpcBindingImpl.this.K3.isChecked();
            DeviceSettingNewViewModel deviceSettingNewViewModel = ActivityDeviceSettingNewIpcBindingImpl.this.y4;
            boolean z = true;
            if (deviceSettingNewViewModel != null) {
                ObservableBoolean observableBoolean = deviceSettingNewViewModel.k;
                if (observableBoolean == null) {
                    z = false;
                }
                if (z) {
                    observableBoolean.set(isChecked);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements InverseBindingListener {
        b() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = ActivityDeviceSettingNewIpcBindingImpl.this.c4.isChecked();
            DeviceSettingNewViewModel deviceSettingNewViewModel = ActivityDeviceSettingNewIpcBindingImpl.this.y4;
            boolean z = true;
            if (deviceSettingNewViewModel != null) {
                ObservableBoolean observableBoolean = deviceSettingNewViewModel.l;
                if (observableBoolean == null) {
                    z = false;
                }
                if (z) {
                    observableBoolean.set(isChecked);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements InverseBindingListener {
        c() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = ActivityDeviceSettingNewIpcBindingImpl.this.f4.isChecked();
            DeviceSettingNewViewModel deviceSettingNewViewModel = ActivityDeviceSettingNewIpcBindingImpl.this.y4;
            boolean z = true;
            if (deviceSettingNewViewModel != null) {
                ObservableBoolean observableBoolean = deviceSettingNewViewModel.j;
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
        B4 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 52);
        sparseIntArray.put(R.id.title, 53);
        sparseIntArray.put(R.id.preview, 54);
        sparseIntArray.put(R.id.arrow, 55);
        sparseIntArray.put(R.id.timezone_title, 56);
        sparseIntArray.put(R.id.trial_title, 57);
        sparseIntArray.put(R.id.night_vision_title, 58);
        sparseIntArray.put(R.id.iv_night_vision, 59);
        sparseIntArray.put(R.id.nv_white_lamp_config_title, 60);
        sparseIntArray.put(R.id.iv_nv_white_lamp_config, 61);
        sparseIntArray.put(R.id.detect_title, 62);
        sparseIntArray.put(R.id.sdcard_title, 63);
        sparseIntArray.put(R.id.video_quality_title, 64);
        sparseIntArray.put(R.id.auto_reboot_title, 65);
    }

    public ActivityDeviceSettingNewIpcBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 66, A4, B4));
    }

    private boolean A(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 8589934592L;
        }
        return true;
    }

    private boolean B(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        return true;
    }

    private boolean C(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 268435456;
        }
        return true;
    }

    private boolean D(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 2147483648L;
        }
        return true;
    }

    private boolean E(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 1;
        }
        return true;
    }

    private boolean F(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 33554432;
        }
        return true;
    }

    private boolean G(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean H(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 34359738368L;
        }
        return true;
    }

    private boolean I(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 1073741824;
        }
        return true;
    }

    private boolean J(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 16384;
        }
        return true;
    }

    private boolean K(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean L(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean M(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean N(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return true;
    }

    private boolean O(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 8192;
        }
        return true;
    }

    private boolean P(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 134217728;
        }
        return true;
    }

    private boolean Q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean R(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 256;
        }
        return true;
    }

    private boolean S(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 536870912;
        }
        return true;
    }

    private boolean T(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 68719476736L;
        }
        return true;
    }

    private boolean U(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean V(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 64;
        }
        return true;
    }

    private boolean W(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 274877906944L;
        }
        return true;
    }

    private boolean X(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 128;
        }
        return true;
    }

    private boolean Y(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 32;
        }
        return true;
    }

    private boolean Z(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 8;
        }
        return true;
    }

    private boolean a0(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 17179869184L;
        }
        return true;
    }

    private boolean l(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 2199023255552L;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 67108864;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 4294967296L;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean q(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 1099511627776L;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 4;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 16;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean u(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 137438953472L;
        }
        return true;
    }

    private boolean v(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 512;
        }
        return true;
    }

    private boolean w(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 8388608;
        }
        return true;
    }

    private boolean x(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 2;
        }
        return true;
    }

    private boolean y(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 549755813888L;
        }
        return true;
    }

    private boolean z(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.R4 |= 16777216;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0617  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0678  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0711  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0762  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0793  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x07bb  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:557:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0967  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0993  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x099d  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x09b3  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x09c1  */
    /* JADX WARN: Removed duplicated region for block: B:634:0x09ff  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0a09  */
    /* JADX WARN: Removed duplicated region for block: B:649:0x0a32  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0a5b  */
    /* JADX WARN: Removed duplicated region for block: B:677:0x0a85  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0a91  */
    /* JADX WARN: Removed duplicated region for block: B:683:0x0a9f  */
    /* JADX WARN: Removed duplicated region for block: B:694:0x0abb  */
    /* JADX WARN: Removed duplicated region for block: B:697:0x0ac5  */
    /* JADX WARN: Removed duplicated region for block: B:702:0x0ad9  */
    /* JADX WARN: Removed duplicated region for block: B:714:0x0b02  */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0b0d  */
    /* JADX WARN: Removed duplicated region for block: B:725:0x0b27  */
    /* JADX WARN: Removed duplicated region for block: B:728:0x0b33 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:732:0x0b42  */
    /* JADX WARN: Removed duplicated region for block: B:734:0x0b46  */
    /* JADX WARN: Removed duplicated region for block: B:737:0x0b52  */
    /* JADX WARN: Removed duplicated region for block: B:745:0x0b67  */
    /* JADX WARN: Removed duplicated region for block: B:747:0x0b6b  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0b74  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0b8a  */
    /* JADX WARN: Removed duplicated region for block: B:760:0x0b94  */
    /* JADX WARN: Removed duplicated region for block: B:763:0x0ba3  */
    /* JADX WARN: Removed duplicated region for block: B:766:0x0c05  */
    /* JADX WARN: Removed duplicated region for block: B:767:0x0c9b  */
    /* JADX WARN: Removed duplicated region for block: B:770:0x0cac  */
    /* JADX WARN: Removed duplicated region for block: B:773:0x0cb7  */
    /* JADX WARN: Removed duplicated region for block: B:776:0x0ccb  */
    /* JADX WARN: Removed duplicated region for block: B:779:0x0cda  */
    /* JADX WARN: Removed duplicated region for block: B:782:0x0ce9  */
    /* JADX WARN: Removed duplicated region for block: B:785:0x0cf8  */
    /* JADX WARN: Removed duplicated region for block: B:788:0x0d07  */
    /* JADX WARN: Removed duplicated region for block: B:791:0x0d18  */
    /* JADX WARN: Removed duplicated region for block: B:794:0x0d3a  */
    /* JADX WARN: Removed duplicated region for block: B:797:0x0d49  */
    /* JADX WARN: Removed duplicated region for block: B:799:0x0d68  */
    /* JADX WARN: Removed duplicated region for block: B:801:0x0d7d  */
    /* JADX WARN: Removed duplicated region for block: B:804:0x0d8e  */
    /* JADX WARN: Removed duplicated region for block: B:807:0x0d9f  */
    /* JADX WARN: Removed duplicated region for block: B:810:0x0db0  */
    /* JADX WARN: Removed duplicated region for block: B:813:0x0dbd  */
    /* JADX WARN: Removed duplicated region for block: B:816:0x0dce  */
    /* JADX WARN: Removed duplicated region for block: B:819:0x0ddf  */
    /* JADX WARN: Removed duplicated region for block: B:821:0x0de8  */
    /* JADX WARN: Removed duplicated region for block: B:824:0x0e00  */
    /* JADX WARN: Removed duplicated region for block: B:827:0x0e11  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:830:0x0e22  */
    /* JADX WARN: Removed duplicated region for block: B:833:0x0e33  */
    /* JADX WARN: Removed duplicated region for block: B:836:0x0e44  */
    /* JADX WARN: Removed duplicated region for block: B:839:0x0e56  */
    /* JADX WARN: Removed duplicated region for block: B:842:0x0e6a  */
    /* JADX WARN: Removed duplicated region for block: B:845:0x0e7b  */
    /* JADX WARN: Removed duplicated region for block: B:848:0x0e88  */
    /* JADX WARN: Removed duplicated region for block: B:850:0x0e91  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x0ea4  */
    /* JADX WARN: Removed duplicated region for block: B:856:0x0eb5  */
    /* JADX WARN: Removed duplicated region for block: B:859:0x0ec6  */
    /* JADX WARN: Removed duplicated region for block: B:862:0x0ed9  */
    /* JADX WARN: Removed duplicated region for block: B:865:0x0eea  */
    /* JADX WARN: Removed duplicated region for block: B:868:0x0efe  */
    /* JADX WARN: Removed duplicated region for block: B:871:0x0f0f  */
    /* JADX WARN: Removed duplicated region for block: B:874:0x0f20  */
    /* JADX WARN: Removed duplicated region for block: B:877:0x0f31  */
    /* JADX WARN: Removed duplicated region for block: B:880:0x0f42  */
    /* JADX WARN: Removed duplicated region for block: B:882:0x0f4b  */
    /* JADX WARN: Removed duplicated region for block: B:885:0x0f5e  */
    /* JADX WARN: Removed duplicated region for block: B:888:0x0f6f  */
    /* JADX WARN: Removed duplicated region for block: B:895:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0184  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 3962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityDeviceSettingNewIpcBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityDeviceSettingNewIpcBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.z4 = onClickListener;
        synchronized (this) {
            this.R4 |= 4398046511104L;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.R4 == 0 && this.S4 == 0) {
                return false;
            }
            return true;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityDeviceSettingNewIpcBinding
    public void i(@Nullable DeviceSettingNewViewModel deviceSettingNewViewModel) {
        this.y4 = deviceSettingNewViewModel;
        synchronized (this) {
            this.R4 |= 8796093022208L;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.R4 = 17592186044416L;
            this.S4 = 0L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return E((ObservableBoolean) obj, i2);
            case 1:
                return x((ObservableBoolean) obj, i2);
            case 2:
                return r((ObservableBoolean) obj, i2);
            case 3:
                return Z((ObservableBoolean) obj, i2);
            case 4:
                return s((ObservableBoolean) obj, i2);
            case 5:
                return Y((ObservableField) obj, i2);
            case 6:
                return V((ObservableBoolean) obj, i2);
            case 7:
                return X((ObservableField) obj, i2);
            case 8:
                return R((ObservableBoolean) obj, i2);
            case 9:
                return v((ObservableBoolean) obj, i2);
            case 10:
                return p((ObservableBoolean) obj, i2);
            case 11:
                return U((ObservableBoolean) obj, i2);
            case 12:
                return Q((ObservableBoolean) obj, i2);
            case 13:
                return O((ObservableBoolean) obj, i2);
            case 14:
                return J((ObservableBoolean) obj, i2);
            case 15:
                return t((ObservableBoolean) obj, i2);
            case 16:
                return o((ObservableBoolean) obj, i2);
            case 17:
                return L((ObservableBoolean) obj, i2);
            case 18:
                return M((ObservableBoolean) obj, i2);
            case 19:
                return K((ObservableBoolean) obj, i2);
            case 20:
                return N((ObservableBoolean) obj, i2);
            case 21:
                return G((ObservableField) obj, i2);
            case 22:
                return B((ObservableBoolean) obj, i2);
            case 23:
                return w((ObservableBoolean) obj, i2);
            case 24:
                return z((ObservableBoolean) obj, i2);
            case 25:
                return F((ObservableField) obj, i2);
            case 26:
                return m((ObservableField) obj, i2);
            case 27:
                return P((ObservableField) obj, i2);
            case 28:
                return C((ObservableBoolean) obj, i2);
            case 29:
                return S((ObservableBoolean) obj, i2);
            case 30:
                return I((ObservableField) obj, i2);
            case 31:
                return D((ObservableBoolean) obj, i2);
            case 32:
                return n((ObservableBoolean) obj, i2);
            case 33:
                return A((ObservableBoolean) obj, i2);
            case 34:
                return a0((ObservableBoolean) obj, i2);
            case 35:
                return H((ObservableBoolean) obj, i2);
            case 36:
                return T((ObservableField) obj, i2);
            case 37:
                return u((ObservableBoolean) obj, i2);
            case 38:
                return W((ObservableBoolean) obj, i2);
            case 39:
                return y((ObservableBoolean) obj, i2);
            case 40:
                return q((ObservableField) obj, i2);
            case 41:
                return l((ObservableField) obj, i2);
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
            i((DeviceSettingNewViewModel) obj);
        }
        return true;
    }

    private ActivityDeviceSettingNewIpcBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 42, (FrameLayout) objArr[43], (ImageView) objArr[55], (RelativeLayout) objArr[46], (TextView) objArr[47], (TextView) objArr[65], (FrameLayout) objArr[20], (ImageView) objArr[2], (TextView) objArr[33], (TextView) objArr[62], (RelativeLayout) objArr[32], (TextView) objArr[5], (TextView) objArr[4], (ImageView) objArr[59], (ImageView) objArr[61], (CheckBox) objArr[27], (CameraLoadingView) objArr[51], (RelativeLayout) objArr[7], (RelativeLayout) objArr[11], (RelativeLayout) objArr[1], (RelativeLayout) objArr[29], (TextView) objArr[30], (TextView) objArr[58], (RelativeLayout) objArr[31], (TextView) objArr[60], (TextView) objArr[9], (TextView) objArr[8], (TextView) objArr[50], (TextView) objArr[13], (TextView) objArr[12], (ImageView) objArr[54], (FrameLayout) objArr[22], (FrameLayout) objArr[36], (CheckBox) objArr[37], (FrameLayout) objArr[40], (TextView) objArr[48], (CheckBox) objArr[24], (RelativeLayout) objArr[34], (TextView) objArr[35], (TextView) objArr[63], (FrameLayout) objArr[45], (RelativeLayout) objArr[14], (TextView) objArr[15], (TextView) objArr[56], (TextView) objArr[53], (Toolbar) objArr[52], (RelativeLayout) objArr[17], (TextView) objArr[18], (CheckBox) objArr[19], (TextView) objArr[57], (TextView) objArr[16], (TextView) objArr[49], (RelativeLayout) objArr[41], (TextView) objArr[42], (TextView) objArr[64]);
        this.O4 = new a();
        this.P4 = new b();
        this.Q4 = new c();
        this.R4 = -1L;
        this.S4 = -1L;
        this.f6548c.setTag(null);
        this.f6550f.setTag(null);
        this.q.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p2.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        this.K3.setTag(null);
        this.L3.setTag(null);
        this.M3.setTag(null);
        this.N3.setTag(null);
        this.O3.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.C4 = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[10];
        this.D4 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[21];
        this.E4 = linearLayout2;
        linearLayout2.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[23];
        this.F4 = frameLayout2;
        frameLayout2.setTag(null);
        View view2 = (View) objArr[25];
        this.G4 = view2;
        view2.setTag(null);
        FrameLayout frameLayout3 = (FrameLayout) objArr[26];
        this.H4 = frameLayout3;
        frameLayout3.setTag(null);
        View view3 = (View) objArr[28];
        this.I4 = view3;
        view3.setTag(null);
        FrameLayout frameLayout4 = (FrameLayout) objArr[3];
        this.J4 = frameLayout4;
        frameLayout4.setTag(null);
        View view4 = (View) objArr[38];
        this.K4 = view4;
        view4.setTag(null);
        View view5 = (View) objArr[39];
        this.L4 = view5;
        view5.setTag(null);
        View view6 = (View) objArr[44];
        this.M4 = view6;
        view6.setTag(null);
        ImageView imageView = (ImageView) objArr[6];
        this.N4 = imageView;
        imageView.setTag(null);
        this.P3.setTag(null);
        this.Q3.setTag(null);
        this.S3.setTag(null);
        this.U3.setTag(null);
        this.V3.setTag(null);
        this.W3.setTag(null);
        this.X3.setTag(null);
        this.Y3.setTag(null);
        this.a4.setTag(null);
        this.b4.setTag(null);
        this.c4.setTag(null);
        this.d4.setTag(null);
        this.e4.setTag(null);
        this.f4.setTag(null);
        this.g4.setTag(null);
        this.h4.setTag(null);
        this.j4.setTag(null);
        this.k4.setTag(null);
        this.l4.setTag(null);
        this.p4.setTag(null);
        this.q4.setTag(null);
        this.r4.setTag(null);
        this.t4.setTag(null);
        this.u4.setTag(null);
        this.v4.setTag(null);
        this.w4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
