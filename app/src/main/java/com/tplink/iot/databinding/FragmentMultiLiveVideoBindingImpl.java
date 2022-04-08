package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CloudTerraceControlPanel;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.play.CloudTerraceControlViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

/* loaded from: classes2.dex */
public class FragmentMultiLiveVideoBindingImpl extends FragmentMultiLiveVideoBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts M3;
    @Nullable
    private static final SparseIntArray N3;
    @NonNull
    private final RelativeLayout O3;
    @NonNull
    private final View P3;
    @NonNull
    private final TextView Q3;
    @NonNull
    private final RelativeLayout R3;
    @Nullable
    private final View.OnClickListener S3;
    private long T3;
    private long U3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        M3 = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_multi_live_toolbar_bottom", "layout_full_screen_control", "layout_day_night_mode", "layout_full_screen_quality", "layout_full_screen_bottom_bar", "layout_voice_talk_panel"}, new int[]{7, 8, 9, 10, 11, 12}, new int[]{R.layout.layout_multi_live_toolbar_bottom, R.layout.layout_full_screen_control, R.layout.layout_day_night_mode, R.layout.layout_full_screen_quality, R.layout.layout_full_screen_bottom_bar, R.layout.layout_voice_talk_panel});
        SparseIntArray sparseIntArray = new SparseIntArray();
        N3 = sparseIntArray;
        sparseIntArray.put(R.id.live_surface_list_view, 13);
        sparseIntArray.put(R.id.tips_bar, 14);
    }

    public FragmentMultiLiveVideoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, M3, N3));
    }

    private boolean A(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 2;
        }
        return true;
    }

    private boolean B(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 1;
        }
        return true;
    }

    private boolean C(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 16384;
        }
        return true;
    }

    private boolean D(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 64;
        }
        return true;
    }

    private boolean E(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean F(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        return true;
    }

    private boolean G(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 512;
        }
        return true;
    }

    private boolean H(LayoutMultiLiveToolbarBottomBinding layoutMultiLiveToolbarBottomBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    private boolean o(LayoutFullScreenBottomBarBinding layoutFullScreenBottomBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        return true;
    }

    private boolean p(LayoutFullScreenControlBinding layoutFullScreenControlBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean q(LayoutDayNightModeBinding layoutDayNightModeBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 256;
        }
        return true;
    }

    private boolean r(LayoutFullScreenQualityBinding layoutFullScreenQualityBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 8192;
        }
        return true;
    }

    private boolean s(LayoutVoiceTalkPanelBinding layoutVoiceTalkPanelBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 128;
        }
        return true;
    }

    private boolean u(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean v(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 8;
        }
        return true;
    }

    private boolean w(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 4;
        }
        return true;
    }

    private boolean x(MutableLiveData<String> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean y(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 16;
        }
        return true;
    }

    private boolean z(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.T3 |= 32;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.H3;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:296:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x04bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0659  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:536:0x06f8  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:545:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:559:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0758 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0767  */
    /* JADX WARN: Removed duplicated region for block: B:575:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x07af  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x07d3  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:590:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0844  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x085a  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0869  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x0898  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x08a1  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x08b0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 2268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentMultiLiveVideoBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentMultiLiveVideoBinding
    public void h(@Nullable CloudTerraceControlViewModel cloudTerraceControlViewModel) {
        this.L3 = cloudTerraceControlViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.T3 == 0 && this.U3 == 0) {
                return this.p3.hasPendingBindings() || this.f7037f.hasPendingBindings() || this.q.hasPendingBindings() || this.x.hasPendingBindings() || this.f7036d.hasPendingBindings() || this.y.hasPendingBindings();
            }
            return true;
        }
    }

    @Override // com.tplink.iot.databinding.FragmentMultiLiveVideoBinding
    public void i(@Nullable MultiLiveVideoViewModel multiLiveVideoViewModel) {
        this.K3 = multiLiveVideoViewModel;
        synchronized (this) {
            this.T3 |= 8388608;
        }
        notifyPropertyChanged(66);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.T3 = 33554432L;
            this.U3 = 0L;
        }
        this.p3.invalidateAll();
        this.f7037f.invalidateAll();
        this.q.invalidateAll();
        this.x.invalidateAll();
        this.f7036d.invalidateAll();
        this.y.invalidateAll();
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentMultiLiveVideoBinding
    public void l(@Nullable VideoPlayViewModel videoPlayViewModel) {
        this.I3 = videoPlayViewModel;
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        notifyPropertyChanged(74);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentMultiLiveVideoBinding
    public void m(@Nullable g gVar) {
        this.H3 = gVar;
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentMultiLiveVideoBinding
    public void n(@Nullable TalkViewModel talkViewModel) {
        this.J3 = talkViewModel;
        synchronized (this) {
            this.T3 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        notifyPropertyChanged(96);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return B((ObservableBoolean) obj, i2);
            case 1:
                return A((ObservableBoolean) obj, i2);
            case 2:
                return w((ObservableBoolean) obj, i2);
            case 3:
                return v((ObservableBoolean) obj, i2);
            case 4:
                return y((ObservableBoolean) obj, i2);
            case 5:
                return z((ObservableBoolean) obj, i2);
            case 6:
                return D((ObservableBoolean) obj, i2);
            case 7:
                return t((ObservableBoolean) obj, i2);
            case 8:
                return q((LayoutDayNightModeBinding) obj, i2);
            case 9:
                return G((ObservableField) obj, i2);
            case 10:
                return s((LayoutVoiceTalkPanelBinding) obj, i2);
            case 11:
                return E((ObservableBoolean) obj, i2);
            case 12:
                return p((LayoutFullScreenControlBinding) obj, i2);
            case 13:
                return r((LayoutFullScreenQualityBinding) obj, i2);
            case 14:
                return C((ObservableBoolean) obj, i2);
            case 15:
                return u((ObservableBoolean) obj, i2);
            case 16:
                return H((LayoutMultiLiveToolbarBottomBinding) obj, i2);
            case 17:
                return x((MutableLiveData) obj, i2);
            case 18:
                return F((ObservableBoolean) obj, i2);
            case 19:
                return o((LayoutFullScreenBottomBarBinding) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.p3.setLifecycleOwner(lifecycleOwner);
        this.f7037f.setLifecycleOwner(lifecycleOwner);
        this.q.setLifecycleOwner(lifecycleOwner);
        this.x.setLifecycleOwner(lifecycleOwner);
        this.f7036d.setLifecycleOwner(lifecycleOwner);
        this.y.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (74 == i) {
            l((VideoPlayViewModel) obj);
        } else if (79 == i) {
            m((g) obj);
        } else if (96 == i) {
            n((TalkViewModel) obj);
        } else if (66 == i) {
            i((MultiLiveVideoViewModel) obj);
        } else if (11 != i) {
            return false;
        } else {
            h((CloudTerraceControlViewModel) obj);
        }
        return true;
    }

    private FragmentMultiLiveVideoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 20, (ImageView) objArr[5], (LayoutFullScreenBottomBarBinding) objArr[11], (LayoutFullScreenControlBinding) objArr[8], (LayoutDayNightModeBinding) objArr[9], (LayoutFullScreenQualityBinding) objArr[10], (LayoutVoiceTalkPanelBinding) objArr[12], (RecyclerView) objArr[13], (TextView) objArr[1], (CloudTerraceControlPanel) objArr[6], (TipsBar) objArr[14], (LayoutMultiLiveToolbarBottomBinding) objArr[7]);
        this.T3 = -1L;
        this.U3 = -1L;
        this.f7035c.setTag(null);
        setContainedBinding(this.f7036d);
        setContainedBinding(this.f7037f);
        setContainedBinding(this.q);
        setContainedBinding(this.x);
        setContainedBinding(this.y);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.O3 = relativeLayout;
        relativeLayout.setTag(null);
        View view2 = (View) objArr[2];
        this.P3 = view2;
        view2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.Q3 = textView;
        textView.setTag(null);
        RelativeLayout relativeLayout2 = (RelativeLayout) objArr[4];
        this.R3 = relativeLayout2;
        relativeLayout2.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        setContainedBinding(this.p3);
        setRootTag(view);
        this.S3 = new a(this, 1);
        invalidateAll();
    }
}
