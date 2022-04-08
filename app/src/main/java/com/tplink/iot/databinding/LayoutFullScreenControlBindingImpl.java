package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.play.MultiLiveVideoViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import com.tplink.iot.widget.FullScreenControlShowView;

/* loaded from: classes2.dex */
public class LayoutFullScreenControlBindingImpl extends LayoutFullScreenControlBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p2 = null;
    @Nullable
    private static final SparseIntArray p3 = null;
    @NonNull
    private final FullScreenControlShowView H3;
    @Nullable
    private final View.OnClickListener I3;
    @Nullable
    private final View.OnClickListener J3;
    @Nullable
    private final View.OnClickListener K3;
    @Nullable
    private final View.OnClickListener L3;
    @Nullable
    private final View.OnClickListener M3;
    private long N3;

    public LayoutFullScreenControlBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, p2, p3));
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 8;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 2;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 64;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 4;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 1;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 16;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.N3 |= 32;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.y;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.y;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.y;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        } else if (i == 4) {
            g gVar4 = this.y;
            if (gVar4 != null) {
                z = true;
            }
            if (z) {
                gVar4.onClick(view);
            }
        } else if (i == 5) {
            g gVar5 = this.y;
            if (gVar5 != null) {
                z = true;
            }
            if (z) {
                gVar5.onClick(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:233:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 935
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.LayoutFullScreenControlBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.LayoutFullScreenControlBinding
    public void h(@Nullable MultiLiveVideoViewModel multiLiveVideoViewModel) {
        this.z = multiLiveVideoViewModel;
        synchronized (this) {
            this.N3 |= 512;
        }
        notifyPropertyChanged(66);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.N3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutFullScreenControlBinding
    public void i(@Nullable VideoPlayViewModel videoPlayViewModel) {
        this.p0 = videoPlayViewModel;
        synchronized (this) {
            this.N3 |= 128;
        }
        notifyPropertyChanged(74);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.N3 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutFullScreenControlBinding
    public void l(@Nullable g gVar) {
        this.y = gVar;
        synchronized (this) {
            this.N3 |= 256;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutFullScreenControlBinding
    public void m(@Nullable TalkViewModel talkViewModel) {
        this.p1 = talkViewModel;
        synchronized (this) {
            this.N3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(96);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return r((ObservableBoolean) obj, i2);
            case 1:
                return o((ObservableBoolean) obj, i2);
            case 2:
                return q((ObservableBoolean) obj, i2);
            case 3:
                return n((ObservableBoolean) obj, i2);
            case 4:
                return s((ObservableBoolean) obj, i2);
            case 5:
                return t((ObservableBoolean) obj, i2);
            case 6:
                return p((ObservableBoolean) obj, i2);
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

    private LayoutFullScreenControlBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (ImageView) objArr[3], (ImageView) objArr[1], (ImageView) objArr[4], (ImageView) objArr[2], (ImageView) objArr[5]);
        this.N3 = -1L;
        this.f7235c.setTag(null);
        this.f7236d.setTag(null);
        this.f7237f.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        FullScreenControlShowView fullScreenControlShowView = (FullScreenControlShowView) objArr[0];
        this.H3 = fullScreenControlShowView;
        fullScreenControlShowView.setTag(null);
        setRootTag(view);
        this.I3 = new a(this, 3);
        this.J3 = new a(this, 4);
        this.K3 = new a(this, 5);
        this.L3 = new a(this, 1);
        this.M3 = new a(this, 2);
        invalidateAll();
    }
}
