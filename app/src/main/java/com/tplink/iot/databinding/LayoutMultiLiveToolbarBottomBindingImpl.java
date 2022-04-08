package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoDisplayMode;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

/* loaded from: classes2.dex */
public class LayoutMultiLiveToolbarBottomBindingImpl extends LayoutMultiLiveToolbarBottomBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts N3 = null;
    @Nullable
    private static final SparseIntArray O3;
    @NonNull
    private final ConstraintLayout P3;
    @Nullable
    private final View.OnClickListener Q3;
    @Nullable
    private final View.OnClickListener R3;
    @Nullable
    private final View.OnClickListener S3;
    @Nullable
    private final View.OnClickListener T3;
    @Nullable
    private final View.OnClickListener U3;
    @Nullable
    private final View.OnClickListener V3;
    @Nullable
    private final View.OnClickListener W3;
    private long X3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O3 = sparseIntArray;
        sparseIntArray.put(R.id.guideline_1, 8);
        sparseIntArray.put(R.id.guideline_2, 9);
        sparseIntArray.put(R.id.guideline_3, 10);
        sparseIntArray.put(R.id.guideline_4, 11);
        sparseIntArray.put(R.id.guideline_5, 12);
        sparseIntArray.put(R.id.guideline_6, 13);
    }

    public LayoutMultiLiveToolbarBottomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, N3, O3));
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 8;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 64;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 256;
        }
        return true;
    }

    private boolean q(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 16;
        }
        return true;
    }

    private boolean r(ObservableField<VideoDisplayMode> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 32;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 512;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 4;
        }
        return true;
    }

    private boolean u(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 2;
        }
        return true;
    }

    private boolean v(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 1;
        }
        return true;
    }

    private boolean w(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.X3 |= 128;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = true;
        switch (i) {
            case 1:
                g gVar = this.J3;
                if (gVar == null) {
                    z = false;
                }
                if (z) {
                    gVar.onClick(view);
                    return;
                }
                return;
            case 2:
                g gVar2 = this.J3;
                if (gVar2 == null) {
                    z = false;
                }
                if (z) {
                    gVar2.onClick(view);
                    return;
                }
                return;
            case 3:
                g gVar3 = this.J3;
                if (gVar3 == null) {
                    z = false;
                }
                if (z) {
                    gVar3.onClick(view);
                    return;
                }
                return;
            case 4:
                g gVar4 = this.J3;
                if (gVar4 == null) {
                    z = false;
                }
                if (z) {
                    gVar4.onClick(view);
                    return;
                }
                return;
            case 5:
                g gVar5 = this.J3;
                if (gVar5 == null) {
                    z = false;
                }
                if (z) {
                    gVar5.onClick(view);
                    return;
                }
                return;
            case 6:
                g gVar6 = this.J3;
                if (gVar6 == null) {
                    z = false;
                }
                if (z) {
                    gVar6.onClick(view);
                    return;
                }
                return;
            case 7:
                g gVar7 = this.J3;
                if (gVar7 == null) {
                    z = false;
                }
                if (z) {
                    gVar7.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 869
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.LayoutMultiLiveToolbarBottomBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.LayoutMultiLiveToolbarBottomBinding
    public void h(@Nullable MultiLiveVideoViewModel multiLiveVideoViewModel) {
        this.L3 = multiLiveVideoViewModel;
        synchronized (this) {
            this.X3 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        notifyPropertyChanged(66);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.X3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutMultiLiveToolbarBottomBinding
    public void i(@Nullable VideoPlayViewModel videoPlayViewModel) {
        this.K3 = videoPlayViewModel;
        synchronized (this) {
            this.X3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(74);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.X3 = 16384L;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutMultiLiveToolbarBottomBinding
    public void l(@Nullable g gVar) {
        this.J3 = gVar;
        synchronized (this) {
            this.X3 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutMultiLiveToolbarBottomBinding
    public void m(@Nullable TalkViewModel talkViewModel) {
        this.M3 = talkViewModel;
        synchronized (this) {
            this.X3 |= 8192;
        }
        notifyPropertyChanged(96);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return v((ObservableBoolean) obj, i2);
            case 1:
                return u((ObservableInt) obj, i2);
            case 2:
                return t((ObservableBoolean) obj, i2);
            case 3:
                return n((ObservableBoolean) obj, i2);
            case 4:
                return q((ObservableField) obj, i2);
            case 5:
                return r((ObservableField) obj, i2);
            case 6:
                return o((ObservableBoolean) obj, i2);
            case 7:
                return w((ObservableBoolean) obj, i2);
            case 8:
                return p((ObservableBoolean) obj, i2);
            case 9:
                return s((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (74 == i) {
            i((VideoPlayViewModel) obj);
        } else if (79 == i) {
            l((g) obj);
        } else if (66 == i) {
            h((MultiLiveVideoViewModel) obj);
        } else if (96 != i) {
            return false;
        } else {
            m((TalkViewModel) obj);
        }
        return true;
    }

    private LayoutMultiLiveToolbarBottomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (Guideline) objArr[8], (Guideline) objArr[9], (Guideline) objArr[10], (Guideline) objArr[11], (Guideline) objArr[12], (Guideline) objArr[13], (TextView) objArr[5], (ImageView) objArr[7], (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[6], (ImageView) objArr[4], (ImageView) objArr[1]);
        this.X3 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.P3 = constraintLayout;
        constraintLayout.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        this.I3.setTag(null);
        setRootTag(view);
        this.Q3 = new a(this, 2);
        this.R3 = new a(this, 5);
        this.S3 = new a(this, 3);
        this.T3 = new a(this, 7);
        this.U3 = new a(this, 6);
        this.V3 = new a(this, 4);
        this.W3 = new a(this, 1);
        invalidateAll();
    }
}
