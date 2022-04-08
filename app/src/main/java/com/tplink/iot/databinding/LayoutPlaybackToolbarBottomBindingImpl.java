package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.PlaybackMainViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.iot.viewmodel.ipcamera.play.VodViewModel;

/* loaded from: classes2.dex */
public class LayoutPlaybackToolbarBottomBindingImpl extends LayoutPlaybackToolbarBottomBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts K3 = null;
    @Nullable
    private static final SparseIntArray L3;
    @NonNull
    private final ConstraintLayout M3;
    @Nullable
    private final View.OnClickListener N3;
    @Nullable
    private final View.OnClickListener O3;
    @Nullable
    private final View.OnClickListener P3;
    @Nullable
    private final View.OnClickListener Q3;
    @Nullable
    private final View.OnClickListener R3;
    private long S3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L3 = sparseIntArray;
        sparseIntArray.put(R.id.guideline_1, 6);
        sparseIntArray.put(R.id.guideline_2, 7);
        sparseIntArray.put(R.id.guideline_3, 8);
        sparseIntArray.put(R.id.guideline_4, 9);
        sparseIntArray.put(R.id.guideline_5, 10);
        sparseIntArray.put(R.id.guideline_6, 11);
    }

    public LayoutPlaybackToolbarBottomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, K3, L3));
    }

    private boolean m(ObservableField<VideoDisplayMode> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 4;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 1;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 8;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.S3 |= 2;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.H3;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.H3;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.H3;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.H3;
            if (gVar4 != null) {
                z = true;
            }
            if (z) {
                gVar4.onClick(view);
            }
        } else if (i == 5) {
            g gVar5 = this.H3;
            if (gVar5 != null) {
                z = true;
            }
            if (z) {
                gVar5.onClick(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0144  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.LayoutPlaybackToolbarBottomBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.LayoutPlaybackToolbarBottomBinding
    public void h(@Nullable g gVar) {
        this.H3 = gVar;
        synchronized (this) {
            this.S3 |= 16;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.S3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutPlaybackToolbarBottomBinding
    public void i(@Nullable PlaybackMainViewModel playbackMainViewModel) {
        this.J3 = playbackMainViewModel;
        synchronized (this) {
            this.S3 |= 32;
        }
        notifyPropertyChanged(100);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.S3 = 128L;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutPlaybackToolbarBottomBinding
    public void l(@Nullable VodViewModel vodViewModel) {
        this.I3 = vodViewModel;
        synchronized (this) {
            this.S3 |= 64;
        }
        notifyPropertyChanged(107);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return p((ObservableBoolean) obj, i2);
        }
        if (i == 2) {
            return m((ObservableField) obj, i2);
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
        } else if (100 == i) {
            i((PlaybackMainViewModel) obj);
        } else if (107 != i) {
            return false;
        } else {
            l((VodViewModel) obj);
        }
        return true;
    }

    private LayoutPlaybackToolbarBottomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Guideline) objArr[6], (Guideline) objArr[7], (Guideline) objArr[8], (Guideline) objArr[9], (Guideline) objArr[10], (Guideline) objArr[11], (ImageView) objArr[5], (ImageView) objArr[2], (ImageView) objArr[1], (ImageView) objArr[4], (ImageView) objArr[3]);
        this.S3 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.M3 = constraintLayout;
        constraintLayout.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.p3.setTag(null);
        setRootTag(view);
        this.N3 = new a(this, 5);
        this.O3 = new a(this, 3);
        this.P3 = new a(this, 1);
        this.Q3 = new a(this, 4);
        this.R3 = new a(this, 2);
        invalidateAll();
    }
}
