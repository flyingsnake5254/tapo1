package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.SeekBarBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.ChipGroup;
import com.tplink.iot.R;
import com.tplink.iot.devices.lightstrip.view.effects.LightingEffectDebugViewModel;

/* loaded from: classes2.dex */
public class ActivityLightingEffectDebugBindingImpl extends ActivityLightingEffectDebugBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts U3 = null;
    @Nullable
    private static final SparseIntArray V3;
    @NonNull
    private final LinearLayout A4;
    @NonNull
    private final Button B4;
    @NonNull
    private final TextView C4;
    @NonNull
    private final Button D4;
    @NonNull
    private final TextView E4;
    @NonNull
    private final LinearLayout F4;
    @NonNull
    private final Button G4;
    @NonNull
    private final Button H4;
    @NonNull
    private final TextView I4;
    @NonNull
    private final TextView J4;
    @NonNull
    private final TextView K4;
    @NonNull
    private final TextView L4;
    private OnStopTrackingTouchImpl M4;
    private InverseBindingListener N4;
    private InverseBindingListener O4;
    private InverseBindingListener P4;
    private InverseBindingListener Q4;
    private InverseBindingListener R4;
    private InverseBindingListener S4;
    private InverseBindingListener T4;
    private InverseBindingListener U4;
    private InverseBindingListener V4;
    @NonNull
    private final LinearLayout W3;
    private InverseBindingListener W4;
    @NonNull
    private final TextView X3;
    private InverseBindingListener X4;
    @NonNull
    private final TextView Y3;
    private long Y4;
    @NonNull
    private final TextView Z3;
    @NonNull
    private final TextView a4;
    @NonNull
    private final TextView b4;
    @NonNull
    private final TextView c4;
    @NonNull
    private final TextView d4;
    @NonNull
    private final TextView e4;
    @NonNull
    private final TextView f4;
    @NonNull
    private final TextView g4;
    @NonNull
    private final TextView h4;
    @NonNull
    private final LinearLayout i4;
    @NonNull
    private final Button j4;
    @NonNull
    private final Button k4;
    @NonNull
    private final LinearLayout l4;
    @NonNull
    private final LinearLayout m4;
    @NonNull
    private final TextView n4;
    @NonNull
    private final TextView o4;
    @NonNull
    private final TextView p4;
    @NonNull
    private final TextView q4;
    @NonNull
    private final TextView r4;
    @NonNull
    private final TextView s4;
    @NonNull
    private final TextView t4;
    @NonNull
    private final SeekBar u4;
    @NonNull
    private final TextView v4;
    @NonNull
    private final LinearLayout w4;
    @NonNull
    private final Button x4;
    @NonNull
    private final Button y4;
    @NonNull
    private final TextView z4;

    /* loaded from: classes2.dex */
    public static class OnStopTrackingTouchImpl implements SeekBarBindingAdapter.OnStopTrackingTouch {

        /* renamed from: c  reason: collision with root package name */
        private LightingEffectDebugViewModel f6608c;

        public OnStopTrackingTouchImpl a(LightingEffectDebugViewModel lightingEffectDebugViewModel) {
            this.f6608c = lightingEffectDebugViewModel;
            if (lightingEffectDebugViewModel == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch
        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f6608c.W(seekBar);
        }
    }

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int selectedItemPosition = ActivityLightingEffectDebugBindingImpl.this.P3.getSelectedItemPosition();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt u = lightingEffectDebugViewModel.u();
                if (u == null) {
                    z = false;
                }
                if (z) {
                    u.set(selectedItemPosition);
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
            int selectedItemPosition = ActivityLightingEffectDebugBindingImpl.this.Q3.getSelectedItemPosition();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt w = lightingEffectDebugViewModel.w();
                if (w == null) {
                    z = false;
                }
                if (z) {
                    w.set(selectedItemPosition);
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
            int progress = ActivityLightingEffectDebugBindingImpl.this.u4.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt H = lightingEffectDebugViewModel.H();
                if (H == null) {
                    z = false;
                }
                if (z) {
                    H.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements InverseBindingListener {
        d() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int progress = ActivityLightingEffectDebugBindingImpl.this.H3.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt r = lightingEffectDebugViewModel.r();
                if (r == null) {
                    z = false;
                }
                if (z) {
                    r.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class e implements InverseBindingListener {
        e() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int progress = ActivityLightingEffectDebugBindingImpl.this.I3.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt y = lightingEffectDebugViewModel.y();
                if (y == null) {
                    z = false;
                }
                if (z) {
                    y.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class f implements InverseBindingListener {
        f() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int progress = ActivityLightingEffectDebugBindingImpl.this.J3.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt J = lightingEffectDebugViewModel.J();
                if (J == null) {
                    z = false;
                }
                if (z) {
                    J.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements InverseBindingListener {
        g() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int progress = ActivityLightingEffectDebugBindingImpl.this.K3.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt P = lightingEffectDebugViewModel.P();
                if (P == null) {
                    z = false;
                }
                if (z) {
                    P.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class h implements InverseBindingListener {
        h() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int progress = ActivityLightingEffectDebugBindingImpl.this.L3.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt R = lightingEffectDebugViewModel.R();
                if (R == null) {
                    z = false;
                }
                if (z) {
                    R.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class i implements InverseBindingListener {
        i() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int progress = ActivityLightingEffectDebugBindingImpl.this.M3.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt S = lightingEffectDebugViewModel.S();
                if (S == null) {
                    z = false;
                }
                if (z) {
                    S.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class j implements InverseBindingListener {
        j() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int progress = ActivityLightingEffectDebugBindingImpl.this.N3.getProgress();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt T = lightingEffectDebugViewModel.T();
                if (T == null) {
                    z = false;
                }
                if (z) {
                    T.set(progress);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class k implements InverseBindingListener {
        k() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            int selectedItemPosition = ActivityLightingEffectDebugBindingImpl.this.O3.getSelectedItemPosition();
            LightingEffectDebugViewModel lightingEffectDebugViewModel = ActivityLightingEffectDebugBindingImpl.this.T3;
            boolean z = true;
            if (lightingEffectDebugViewModel != null) {
                ObservableInt o = lightingEffectDebugViewModel.o();
                if (o == null) {
                    z = false;
                }
                if (z) {
                    o.set(selectedItemPosition);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        V3 = sparseIntArray;
        sparseIntArray.put(R.id.rv_predefined_effects, 61);
        sparseIntArray.put(R.id.tv_filter_params, 62);
        sparseIntArray.put(R.id.chip_group_params, 63);
    }

    public ActivityLightingEffectDebugBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 64, U3, V3));
    }

    private boolean A(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 64;
        }
        return true;
    }

    private boolean B(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 16777216;
        }
        return true;
    }

    private boolean C(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 2;
        }
        return true;
    }

    private boolean D(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 67108864;
        }
        return true;
    }

    private boolean E(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 134217728;
        }
        return true;
    }

    private boolean F(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return true;
    }

    private boolean G(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 128;
        }
        return true;
    }

    private boolean H(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 8589934592L;
        }
        return true;
    }

    private boolean I(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean J(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 4;
        }
        return true;
    }

    private boolean K(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean L(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 268435456;
        }
        return true;
    }

    private boolean M(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean N(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean O(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 536870912;
        }
        return true;
    }

    private boolean P(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 2147483648L;
        }
        return true;
    }

    private boolean Q(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 4294967296L;
        }
        return true;
    }

    private boolean R(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 8192;
        }
        return true;
    }

    private boolean S(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean T(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 8;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 32;
        }
        return true;
    }

    private boolean n(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 16384;
        }
        return true;
    }

    private boolean o(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 16;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 512;
        }
        return true;
    }

    private boolean q(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 8388608;
        }
        return true;
    }

    private boolean s(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 1073741824;
        }
        return true;
    }

    private boolean u(ObservableField<String> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 256;
        }
        return true;
    }

    private boolean v(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean w(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        return true;
    }

    private boolean x(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 33554432;
        }
        return true;
    }

    private boolean y(ObservableBoolean observableBoolean, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean z(ObservableInt observableInt, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.Y4 |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x05c8  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0613  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0191  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2758
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityLightingEffectDebugBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityLightingEffectDebugBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.S3 = onClickListener;
        synchronized (this) {
            this.Y4 |= 17179869184L;
        }
        notifyPropertyChanged(69);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.Y4 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityLightingEffectDebugBinding
    public void i(@Nullable LightingEffectDebugViewModel lightingEffectDebugViewModel) {
        this.T3 = lightingEffectDebugViewModel;
        synchronized (this) {
            this.Y4 |= 34359738368L;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.Y4 = 68719476736L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return z((ObservableInt) obj, i3);
            case 1:
                return C((ObservableInt) obj, i3);
            case 2:
                return J((ObservableInt) obj, i3);
            case 3:
                return T((ObservableBoolean) obj, i3);
            case 4:
                return o((ObservableInt) obj, i3);
            case 5:
                return m((ObservableBoolean) obj, i3);
            case 6:
                return A((ObservableBoolean) obj, i3);
            case 7:
                return G((ObservableBoolean) obj, i3);
            case 8:
                return u((ObservableField) obj, i3);
            case 9:
                return p((ObservableBoolean) obj, i3);
            case 10:
                return N((ObservableInt) obj, i3);
            case 11:
                return K((ObservableInt) obj, i3);
            case 12:
                return v((ObservableInt) obj, i3);
            case 13:
                return R((ObservableInt) obj, i3);
            case 14:
                return n((ObservableInt) obj, i3);
            case 15:
                return S((ObservableBoolean) obj, i3);
            case 16:
                return y((ObservableBoolean) obj, i3);
            case 17:
                return s((ObservableInt) obj, i3);
            case 18:
                return q((ObservableInt) obj, i3);
            case 19:
                return I((ObservableBoolean) obj, i3);
            case 20:
                return F((ObservableInt) obj, i3);
            case 21:
                return M((ObservableBoolean) obj, i3);
            case 22:
                return w((ObservableBoolean) obj, i3);
            case 23:
                return r((ObservableBoolean) obj, i3);
            case 24:
                return B((ObservableInt) obj, i3);
            case 25:
                return x((ObservableInt) obj, i3);
            case 26:
                return D((ObservableBoolean) obj, i3);
            case 27:
                return E((ObservableBoolean) obj, i3);
            case 28:
                return L((ObservableBoolean) obj, i3);
            case 29:
                return O((ObservableBoolean) obj, i3);
            case 30:
                return t((ObservableBoolean) obj, i3);
            case 31:
                return P((ObservableInt) obj, i3);
            case 32:
                return Q((ObservableInt) obj, i3);
            case 33:
                return H((ObservableInt) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (69 == i2) {
            h((View.OnClickListener) obj);
        } else if (103 != i2) {
            return false;
        } else {
            i((LightingEffectDebugViewModel) obj);
        }
        return true;
    }

    private ActivityLightingEffectDebugBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 34, (Button) objArr[56], (Button) objArr[46], (Button) objArr[38], (Button) objArr[60], (Button) objArr[20], (Button) objArr[51], (ChipGroup) objArr[63], (RecyclerView) objArr[37], (RecyclerView) objArr[59], (RecyclerView) objArr[61], (RecyclerView) objArr[19], (SeekBar) objArr[16], (SeekBar) objArr[34], (SeekBar) objArr[6], (SeekBar) objArr[23], (SeekBar) objArr[13], (SeekBar) objArr[31], (SeekBar) objArr[29], (AppCompatSpinner) objArr[8], (AppCompatSpinner) objArr[3], (AppCompatSpinner) objArr[10], (TextView) objArr[62]);
        this.N4 = new c();
        this.O4 = new d();
        this.P4 = new e();
        this.Q4 = new f();
        this.R4 = new g();
        this.S4 = new h();
        this.T4 = new i();
        this.U4 = new j();
        this.V4 = new k();
        this.W4 = new a();
        this.X4 = new b();
        this.Y4 = -1L;
        this.f6605c.setTag(null);
        this.f6606d.setTag(null);
        this.f6607f.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.W3 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.X3 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[11];
        this.Y3 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[12];
        this.Z3 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[14];
        this.a4 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[15];
        this.b4 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[17];
        this.c4 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[18];
        this.d4 = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[2];
        this.e4 = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[21];
        this.f4 = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[22];
        this.g4 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[24];
        this.h4 = textView11;
        textView11.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[25];
        this.i4 = linearLayout2;
        linearLayout2.setTag(null);
        Button button = (Button) objArr[26];
        this.j4 = button;
        button.setTag(null);
        Button button2 = (Button) objArr[27];
        this.k4 = button2;
        button2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[28];
        this.l4 = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[30];
        this.m4 = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView12 = (TextView) objArr[32];
        this.n4 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[33];
        this.o4 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[35];
        this.p4 = textView14;
        textView14.setTag(null);
        TextView textView15 = (TextView) objArr[36];
        this.q4 = textView15;
        textView15.setTag(null);
        TextView textView16 = (TextView) objArr[39];
        this.r4 = textView16;
        textView16.setTag(null);
        TextView textView17 = (TextView) objArr[4];
        this.s4 = textView17;
        textView17.setTag(null);
        TextView textView18 = (TextView) objArr[40];
        this.t4 = textView18;
        textView18.setTag(null);
        SeekBar seekBar = (SeekBar) objArr[41];
        this.u4 = seekBar;
        seekBar.setTag(null);
        TextView textView19 = (TextView) objArr[42];
        this.v4 = textView19;
        textView19.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[43];
        this.w4 = linearLayout5;
        linearLayout5.setTag(null);
        Button button3 = (Button) objArr[44];
        this.x4 = button3;
        button3.setTag(null);
        Button button4 = (Button) objArr[45];
        this.y4 = button4;
        button4.setTag(null);
        TextView textView20 = (TextView) objArr[47];
        this.z4 = textView20;
        textView20.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[48];
        this.A4 = linearLayout6;
        linearLayout6.setTag(null);
        Button button5 = (Button) objArr[49];
        this.B4 = button5;
        button5.setTag(null);
        TextView textView21 = (TextView) objArr[5];
        this.C4 = textView21;
        textView21.setTag(null);
        Button button6 = (Button) objArr[50];
        this.D4 = button6;
        button6.setTag(null);
        TextView textView22 = (TextView) objArr[52];
        this.E4 = textView22;
        textView22.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) objArr[53];
        this.F4 = linearLayout7;
        linearLayout7.setTag(null);
        Button button7 = (Button) objArr[54];
        this.G4 = button7;
        button7.setTag(null);
        Button button8 = (Button) objArr[55];
        this.H4 = button8;
        button8.setTag(null);
        TextView textView23 = (TextView) objArr[57];
        this.I4 = textView23;
        textView23.setTag(null);
        TextView textView24 = (TextView) objArr[58];
        this.J4 = textView24;
        textView24.setTag(null);
        TextView textView25 = (TextView) objArr[7];
        this.K4 = textView25;
        textView25.setTag(null);
        TextView textView26 = (TextView) objArr[9];
        this.L4 = textView26;
        textView26.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        this.I3.setTag(null);
        this.J3.setTag(null);
        this.K3.setTag(null);
        this.L3.setTag(null);
        this.M3.setTag(null);
        this.N3.setTag(null);
        this.O3.setTag(null);
        this.P3.setTag(null);
        this.Q3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
