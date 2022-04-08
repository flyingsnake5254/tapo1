package com.tplink.iot.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.scollitem.ScrollPlayRatePicker;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerRelativeLayout;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

/* loaded from: classes2.dex */
public class FragmentPlayBackVideoBindingImpl extends FragmentPlayBackVideoBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts X3;
    @Nullable
    private static final SparseIntArray Y3;
    @NonNull
    private final FrameLayout Z3;
    @NonNull
    private final RelativeLayout a4;
    @NonNull
    private final RelativeLayout b4;
    @NonNull
    private final TextView c4;
    @NonNull
    private final ScrollPlayRatePicker d4;
    @NonNull
    private final RelativeLayout e4;
    @NonNull
    private final ScrollPlayRatePicker f4;
    @Nullable
    private final View.OnClickListener g4;
    @Nullable
    private final View.OnClickListener h4;
    private long i4;
    private long j4;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(25);
        X3 = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_playback_toolbar_top", "layout_playback_toolbar_bottom", "layout_playback_toolbar_popup", "layout_palyback_full_bottom", "layout_play_back_fullscreen_filter", "layout_play_back_fullscreen_calendar"}, new int[]{15, 16, 17, 18, 19, 20}, new int[]{R.layout.layout_playback_toolbar_top, R.layout.layout_playback_toolbar_bottom, R.layout.layout_playback_toolbar_popup, R.layout.layout_palyback_full_bottom, R.layout.layout_play_back_fullscreen_filter, R.layout.layout_play_back_fullscreen_calendar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        Y3 = sparseIntArray;
        sparseIntArray.put(R.id.live_surface_view, 21);
        sparseIntArray.put(R.id.no_record_icon, 22);
        sparseIntArray.put(R.id.live_network_error, 23);
        sparseIntArray.put(R.id.tap_btn, 24);
    }

    public FragmentPlayBackVideoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 25, X3, Y3));
    }

    private boolean A(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean B(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return true;
    }

    private boolean C(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 64;
        }
        return true;
    }

    private boolean D(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean E(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 16384;
        }
        return true;
    }

    private boolean F(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 2;
        }
        return true;
    }

    private boolean G(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 32;
        }
        return true;
    }

    private boolean H(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    private boolean I(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean J(ObservableField<VodPlayRate> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean K(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 256;
        }
        return true;
    }

    private boolean L(ObservableField<Drawable> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 1;
        }
        return true;
    }

    private boolean M(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 128;
        }
        return true;
    }

    private boolean N(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean O(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean s(LayoutPalybackFullBottomBinding layoutPalybackFullBottomBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 8;
        }
        return true;
    }

    private boolean t(LayoutPlayBackFullscreenCalendarBinding layoutPlayBackFullscreenCalendarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 8192;
        }
        return true;
    }

    private boolean u(LayoutPlayBackFullscreenFilterBinding layoutPlayBackFullscreenFilterBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean v(LayoutPlaybackToolbarBottomBinding layoutPlaybackToolbarBottomBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 16;
        }
        return true;
    }

    private boolean w(LayoutPlaybackToolbarTopBinding layoutPlaybackToolbarTopBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 512;
        }
        return true;
    }

    private boolean x(LayoutPlaybackToolbarPopupBinding layoutPlaybackToolbarPopupBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean y(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= 4;
        }
        return true;
    }

    private boolean z(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i4 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.O3;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.O3;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:455:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x079d  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x07ac  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x07b8  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x07e8  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x080a  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:525:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0851  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0862  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x08b0  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x08d2  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x08ef  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:552:0x0911  */
    /* JADX WARN: Removed duplicated region for block: B:555:0x091e  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x0940  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentPlayBackVideoBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void h(@Nullable com.tplink.iot.view.ipcamera.widget.a.a aVar) {
        this.S3 = aVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.i4 == 0 && this.j4 == 0) {
                return this.L3.hasPendingBindings() || this.K3.hasPendingBindings() || this.M3.hasPendingBindings() || this.H3.hasPendingBindings() || this.J3.hasPendingBindings() || this.I3.hasPendingBindings();
            }
            return true;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void i(@Nullable b bVar) {
        this.U3 = bVar;
        synchronized (this) {
            this.i4 |= 33554432;
        }
        notifyPropertyChanged(63);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i4 = 4294967296L;
            this.j4 = 0L;
        }
        this.L3.invalidateAll();
        this.K3.invalidateAll();
        this.M3.invalidateAll();
        this.H3.invalidateAll();
        this.J3.invalidateAll();
        this.I3.invalidateAll();
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void l(@Nullable c cVar) {
        this.W3 = cVar;
        synchronized (this) {
            this.i4 |= 8388608;
        }
        notifyPropertyChanged(64);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void m(@Nullable ScrollPlayRatePicker.a aVar) {
        this.T3 = aVar;
        synchronized (this) {
            this.i4 |= 536870912;
        }
        notifyPropertyChanged(70);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void n(@Nullable PlayBackControlViewModel playBackControlViewModel) {
        this.R3 = playBackControlViewModel;
        synchronized (this) {
            this.i4 |= 1073741824;
        }
        notifyPropertyChanged(75);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void o(@Nullable g gVar) {
        this.O3 = gVar;
        synchronized (this) {
            this.i4 |= 16777216;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return L((ObservableField) obj, i2);
            case 1:
                return F((ObservableBoolean) obj, i2);
            case 2:
                return y((ObservableBoolean) obj, i2);
            case 3:
                return s((LayoutPalybackFullBottomBinding) obj, i2);
            case 4:
                return v((LayoutPlaybackToolbarBottomBinding) obj, i2);
            case 5:
                return G((ObservableBoolean) obj, i2);
            case 6:
                return C((ObservableBoolean) obj, i2);
            case 7:
                return M((ObservableBoolean) obj, i2);
            case 8:
                return K((ObservableField) obj, i2);
            case 9:
                return w((LayoutPlaybackToolbarTopBinding) obj, i2);
            case 10:
                return u((LayoutPlayBackFullscreenFilterBinding) obj, i2);
            case 11:
                return D((ObservableBoolean) obj, i2);
            case 12:
                return A((ObservableBoolean) obj, i2);
            case 13:
                return t((LayoutPlayBackFullscreenCalendarBinding) obj, i2);
            case 14:
                return E((ObservableBoolean) obj, i2);
            case 15:
                return N((ObservableField) obj, i2);
            case 16:
                return J((ObservableField) obj, i2);
            case 17:
                return O((ObservableBoolean) obj, i2);
            case 18:
                return I((ObservableBoolean) obj, i2);
            case 19:
                return x((LayoutPlaybackToolbarPopupBinding) obj, i2);
            case 20:
                return B((ObservableBoolean) obj, i2);
            case 21:
                return H((ObservableBoolean) obj, i2);
            case 22:
                return z((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void p(@Nullable TimeAxisLayout.b bVar) {
        this.V3 = bVar;
        synchronized (this) {
            this.i4 |= 134217728;
        }
        notifyPropertyChanged(99);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void q(@Nullable PlaybackMainViewModel playbackMainViewModel) {
        this.P3 = playbackMainViewModel;
        synchronized (this) {
            this.i4 |= 268435456;
        }
        notifyPropertyChanged(100);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackVideoBinding
    public void r(@Nullable VodViewModel vodViewModel) {
        this.Q3 = vodViewModel;
        synchronized (this) {
            this.i4 |= 67108864;
        }
        notifyPropertyChanged(107);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.L3.setLifecycleOwner(lifecycleOwner);
        this.K3.setLifecycleOwner(lifecycleOwner);
        this.M3.setLifecycleOwner(lifecycleOwner);
        this.H3.setLifecycleOwner(lifecycleOwner);
        this.J3.setLifecycleOwner(lifecycleOwner);
        this.I3.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (64 == i) {
            l((c) obj);
        } else if (79 == i) {
            o((g) obj);
        } else if (63 == i) {
            i((b) obj);
        } else if (107 == i) {
            r((VodViewModel) obj);
        } else if (99 == i) {
            p((TimeAxisLayout.b) obj);
        } else if (100 == i) {
            q((PlaybackMainViewModel) obj);
        } else if (70 == i) {
            m((ScrollPlayRatePicker.a) obj);
        } else if (75 == i) {
            n((PlayBackControlViewModel) obj);
        } else if (19 != i) {
            return false;
        } else {
            h((com.tplink.iot.view.ipcamera.widget.a.a) obj);
        }
        return true;
    }

    private FragmentPlayBackVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 23, (ImageView) objArr[12], (RelativeLayout) objArr[2], (View) objArr[23], (FrameLayout) objArr[21], (ImageView) objArr[22], (ConstraintLayout) objArr[3], (TextView) objArr[8], (ImageView) objArr[7], (FrameLayout) objArr[6], (ImageView) objArr[24], (TextView) objArr[4], (LayoutPalybackFullBottomBinding) objArr[18], (LayoutPlayBackFullscreenCalendarBinding) objArr[20], (LayoutPlayBackFullscreenFilterBinding) objArr[19], (LayoutPlaybackToolbarBottomBinding) objArr[16], (LayoutPlaybackToolbarTopBinding) objArr[15], (LayoutPlaybackToolbarPopupBinding) objArr[17], (TouchListenerRelativeLayout) objArr[1]);
        this.i4 = -1L;
        this.j4 = -1L;
        this.f7047c.setTag(null);
        this.f7048d.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.Z3 = frameLayout;
        frameLayout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[10];
        this.a4 = relativeLayout;
        relativeLayout.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[11];
        this.b4 = relativeLayout2;
        relativeLayout2.setTag(null);
        TextView textView = (TextView) objArr[13];
        this.c4 = textView;
        textView.setTag(null);
        ScrollPlayRatePicker scrollPlayRatePicker = (ScrollPlayRatePicker) objArr[14];
        this.d4 = scrollPlayRatePicker;
        scrollPlayRatePicker.setTag(null);
        RelativeLayout relativeLayout3 = (RelativeLayout) objArr[5];
        this.e4 = relativeLayout3;
        relativeLayout3.setTag(null);
        ScrollPlayRatePicker scrollPlayRatePicker2 = (ScrollPlayRatePicker) objArr[9];
        this.f4 = scrollPlayRatePicker2;
        scrollPlayRatePicker2.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p3.setTag(null);
        setContainedBinding(this.H3);
        setContainedBinding(this.I3);
        setContainedBinding(this.J3);
        setContainedBinding(this.K3);
        setContainedBinding(this.L3);
        setContainedBinding(this.M3);
        this.N3.setTag(null);
        setRootTag(view);
        this.g4 = new a(this, 1);
        this.h4 = new a(this, 2);
        invalidateAll();
    }
}
