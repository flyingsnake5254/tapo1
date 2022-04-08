package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

/* loaded from: classes2.dex */
public class FragmentPlayBackControlBindingImpl extends FragmentPlayBackControlBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts I3;
    @Nullable
    private static final SparseIntArray J3;
    private long K3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        I3 = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"play_back_top_bar", "play_back_ruler_layout", "play_back_date_selector"}, new int[]{4, 5, 6}, new int[]{R.layout.play_back_top_bar, R.layout.play_back_ruler_layout, R.layout.play_back_date_selector});
        SparseIntArray sparseIntArray = new SparseIntArray();
        J3 = sparseIntArray;
        sparseIntArray.put(R.id.snapshot_list, 2);
        sparseIntArray.put(R.id.record_type_hint, 3);
    }

    public FragmentPlayBackControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, I3, J3));
    }

    private boolean o(PlayBackDateSelectorBinding playBackDateSelectorBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 64;
        }
        return true;
    }

    private boolean p(PlayBackRulerLayoutBinding playBackRulerLayoutBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 1;
        }
        return true;
    }

    private boolean q(PlayBackTopBarBinding playBackTopBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 16;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 4;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 8;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 2;
        }
        return true;
    }

    private boolean u(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.K3 |= 32;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.FragmentPlayBackControlBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackControlBinding
    public void h(@Nullable b bVar) {
        this.p1 = bVar;
        synchronized (this) {
            this.K3 |= 512;
        }
        notifyPropertyChanged(63);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.K3 != 0) {
                return true;
            }
            return this.q.hasPendingBindings() || this.f7046f.hasPendingBindings() || this.f7045d.hasPendingBindings();
        }
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackControlBinding
    public void i(@Nullable c cVar) {
        this.H3 = cVar;
        synchronized (this) {
            this.K3 |= 128;
        }
        notifyPropertyChanged(64);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.K3 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        this.q.invalidateAll();
        this.f7046f.invalidateAll();
        this.f7045d.invalidateAll();
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackControlBinding
    public void l(@Nullable g gVar) {
        this.p0 = gVar;
        synchronized (this) {
            this.K3 |= 256;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackControlBinding
    public void m(@Nullable TimeAxisLayout.b bVar) {
        this.p3 = bVar;
        synchronized (this) {
            this.K3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(99);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.FragmentPlayBackControlBinding
    public void n(@Nullable PlayBackControlViewModel playBackControlViewModel) {
        this.p2 = playBackControlViewModel;
        synchronized (this) {
            this.K3 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return p((PlayBackRulerLayoutBinding) obj, i2);
            case 1:
                return t((ObservableBoolean) obj, i2);
            case 2:
                return r((ObservableBoolean) obj, i2);
            case 3:
                return s((ObservableBoolean) obj, i2);
            case 4:
                return q((PlayBackTopBarBinding) obj, i2);
            case 5:
                return u((ObservableBoolean) obj, i2);
            case 6:
                return o((PlayBackDateSelectorBinding) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.q.setLifecycleOwner(lifecycleOwner);
        this.f7046f.setLifecycleOwner(lifecycleOwner);
        this.f7045d.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (64 == i) {
            i((c) obj);
        } else if (79 == i) {
            l((g) obj);
        } else if (63 == i) {
            h((b) obj);
        } else if (99 == i) {
            m((TimeAxisLayout.b) obj);
        } else if (105 != i) {
            return false;
        } else {
            n((PlayBackControlViewModel) obj);
        }
        return true;
    }

    private FragmentPlayBackControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (CameraLoadingView) objArr[1], (PlayBackDateSelectorBinding) objArr[6], (PlayBackRulerLayoutBinding) objArr[5], (PlayBackTopBarBinding) objArr[4], (View) objArr[3], (RelativeLayout) objArr[0], (View) objArr[2]);
        this.K3 = -1L;
        this.f7044c.setTag(null);
        setContainedBinding(this.f7045d);
        setContainedBinding(this.f7046f);
        setContainedBinding(this.q);
        this.y.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
