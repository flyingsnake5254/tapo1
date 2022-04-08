package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

/* loaded from: classes2.dex */
public class LayoutPlaybackToolbarTopBindingImpl extends LayoutPlaybackToolbarTopBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z = null;
    @NonNull
    private final RelativeLayout p0;
    @Nullable
    private final View.OnClickListener p1;
    private long p2;

    public LayoutPlaybackToolbarTopBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, y, z));
    }

    private boolean m(ObservableField<VideoDisplayMode> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 1;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 2;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 8;
        }
        return true;
    }

    private boolean p(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 16;
        }
        return true;
    }

    private boolean q(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p2 |= 4;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        g gVar = this.f7288f;
        if (gVar != null) {
            gVar.onClick(view);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0139  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.LayoutPlaybackToolbarTopBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.LayoutPlaybackToolbarTopBinding
    public void h(@Nullable g gVar) {
        this.f7288f = gVar;
        synchronized (this) {
            this.p2 |= 32;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p2 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutPlaybackToolbarTopBinding
    public void i(@Nullable PlaybackMainViewModel playbackMainViewModel) {
        this.x = playbackMainViewModel;
        synchronized (this) {
            this.p2 |= 64;
        }
        notifyPropertyChanged(100);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p2 = 256L;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutPlaybackToolbarTopBinding
    public void l(@Nullable VodViewModel vodViewModel) {
        this.q = vodViewModel;
        synchronized (this) {
            this.p2 |= 128;
        }
        notifyPropertyChanged(107);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((ObservableField) obj, i2);
        }
        if (i == 1) {
            return n((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return q((ObservableField) obj, i2);
        }
        if (i == 3) {
            return o((ObservableBoolean) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return p((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            h((g) obj);
        } else if (100 == i) {
            i((PlaybackMainViewModel) obj);
        } else if (107 != i) {
            return false;
        } else {
            l((VodViewModel) obj);
        }
        return true;
    }

    private LayoutPlaybackToolbarTopBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (TextView) objArr[2], (TextView) objArr[1]);
        this.p2 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.p0 = relativeLayout;
        relativeLayout.setTag(null);
        this.f7286c.setTag(null);
        this.f7287d.setTag(null);
        setRootTag(view);
        this.p1 = new a(this, 1);
        invalidateAll();
    }
}
