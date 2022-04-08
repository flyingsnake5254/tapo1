package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

/* loaded from: classes2.dex */
public class PlayBackBottomBarBindingImpl extends PlayBackBottomBarBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    private InverseBindingListener H3;
    private long I3;
    @NonNull
    private final RelativeLayout p0;
    @Nullable
    private final View.OnClickListener p1;
    @Nullable
    private final View.OnClickListener p2;
    private InverseBindingListener p3;

    /* loaded from: classes2.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            boolean isChecked = PlayBackBottomBarBindingImpl.this.f7331c.isChecked();
            PlayBackControlViewModel playBackControlViewModel = PlayBackBottomBarBindingImpl.this.x;
            boolean z = true;
            if (playBackControlViewModel != null) {
                ObservableBoolean observableBoolean = playBackControlViewModel.a4;
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
            boolean isChecked = PlayBackBottomBarBindingImpl.this.f7332d.isChecked();
            PlayBackControlViewModel playBackControlViewModel = PlayBackBottomBarBindingImpl.this.x;
            boolean z = true;
            if (playBackControlViewModel != null) {
                ObservableBoolean observableBoolean = playBackControlViewModel.c4;
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
        z = sparseIntArray;
        sparseIntArray.put(R.id.guide_line, 3);
    }

    public PlayBackBottomBarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, y, z));
    }

    private boolean l(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 2;
        }
        return true;
    }

    private boolean m(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 4;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 1;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.I3 |= 8;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            g gVar = this.q;
            if (gVar != null) {
                z2 = true;
            }
            if (z2) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.q;
            if (gVar2 != null) {
                z2 = true;
            }
            if (z2) {
                gVar2.onClick(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.PlayBackBottomBarBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.PlayBackBottomBarBinding
    public void h(@Nullable g gVar) {
        this.q = gVar;
        synchronized (this) {
            this.I3 |= 16;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.I3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.PlayBackBottomBarBinding
    public void i(@Nullable PlayBackControlViewModel playBackControlViewModel) {
        this.x = playBackControlViewModel;
        synchronized (this) {
            this.I3 |= 32;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.I3 = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return l((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return m((ObservableBoolean) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return o((ObservableBoolean) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            h((g) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((PlayBackControlViewModel) obj);
        }
        return true;
    }

    private PlayBackBottomBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (CheckBox) objArr[1], (CheckBox) objArr[2], (View) objArr[3]);
        this.p3 = new a();
        this.H3 = new b();
        this.I3 = -1L;
        this.f7331c.setTag(null);
        this.f7332d.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.p0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        this.p1 = new com.tplink.iot.generated.callback.a(this, 1);
        this.p2 = new com.tplink.iot.generated.callback.a(this, 2);
        invalidateAll();
    }
}
