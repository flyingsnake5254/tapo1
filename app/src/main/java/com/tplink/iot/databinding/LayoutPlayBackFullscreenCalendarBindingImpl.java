package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes2.dex */
public class LayoutPlayBackFullscreenCalendarBindingImpl extends LayoutPlayBackFullscreenCalendarBinding implements a.AbstractC0211a {
    @Nullable
    private static final SparseIntArray H3;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p3 = null;
    @NonNull
    private final LinearLayout I3;
    @Nullable
    private final View.OnClickListener J3;
    @Nullable
    private final View.OnClickListener K3;
    @Nullable
    private final View.OnClickListener L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H3 = sparseIntArray;
        sparseIntArray.put(R.id.widget_scroll_calendar_weekday, 6);
    }

    public LayoutPlayBackFullscreenCalendarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, p3, H3));
    }

    private boolean n(ObservableField<d> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 128;
        }
        return true;
    }

    private boolean o(ObservableField<Calendar> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 16;
        }
        return true;
    }

    private boolean p(ObservableField<List<d>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 64;
        }
        return true;
    }

    private boolean q(ObservableField<d> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 4;
        }
        return true;
    }

    private boolean r(ObservableField<d> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 32;
        }
        return true;
    }

    private boolean s(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 2;
        }
        return true;
    }

    private boolean t(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 8;
        }
        return true;
    }

    private boolean u(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 1;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        boolean z = false;
        if (i == 1) {
            g gVar = this.z;
            if (gVar != null) {
                z = true;
            }
            if (z) {
                gVar.onClick(view);
            }
        } else if (i == 2) {
            g gVar2 = this.z;
            if (gVar2 != null) {
                z = true;
            }
            if (z) {
                gVar2.onClick(view);
            }
        } else if (i == 3) {
            g gVar3 = this.z;
            if (gVar3 != null) {
                z = true;
            }
            if (z) {
                gVar3.onClick(view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.LayoutPlayBackFullscreenCalendarBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.LayoutPlayBackFullscreenCalendarBinding
    public void h(@Nullable b bVar) {
        this.p0 = bVar;
        synchronized (this) {
            this.M3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(63);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.LayoutPlayBackFullscreenCalendarBinding
    public void i(@Nullable c cVar) {
        this.p2 = cVar;
        synchronized (this) {
            this.M3 |= 256;
        }
        notifyPropertyChanged(64);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutPlayBackFullscreenCalendarBinding
    public void l(@Nullable g gVar) {
        this.z = gVar;
        synchronized (this) {
            this.M3 |= 512;
        }
        notifyPropertyChanged(79);
        super.requestRebind();
    }

    @Override // com.tplink.iot.databinding.LayoutPlayBackFullscreenCalendarBinding
    public void m(@Nullable PlayBackControlViewModel playBackControlViewModel) {
        this.p1 = playBackControlViewModel;
        synchronized (this) {
            this.M3 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return u((ObservableBoolean) obj, i2);
            case 1:
                return s((ObservableField) obj, i2);
            case 2:
                return q((ObservableField) obj, i2);
            case 3:
                return t((ObservableBoolean) obj, i2);
            case 4:
                return o((ObservableField) obj, i2);
            case 5:
                return r((ObservableField) obj, i2);
            case 6:
                return p((ObservableField) obj, i2);
            case 7:
                return n((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (64 == i) {
            i((c) obj);
        } else if (79 == i) {
            l((g) obj);
        } else if (63 == i) {
            h((b) obj);
        } else if (105 != i) {
            return false;
        } else {
            m((PlayBackControlViewModel) obj);
        }
        return true;
    }

    private LayoutPlayBackFullscreenCalendarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (TextView) objArr[1], (ImageView) objArr[2], (ImageView) objArr[3], (TextView) objArr[4], (ScrollCalendar) objArr[5], (WeekdayView) objArr[6]);
        this.M3 = -1L;
        this.f7274c.setTag(null);
        this.f7275d.setTag(null);
        this.f7276f.setTag(null);
        this.q.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.I3 = linearLayout;
        linearLayout.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        this.J3 = new a(this, 2);
        this.K3 = new a(this, 3);
        this.L3 = new a(this, 1);
        invalidateAll();
    }
}
