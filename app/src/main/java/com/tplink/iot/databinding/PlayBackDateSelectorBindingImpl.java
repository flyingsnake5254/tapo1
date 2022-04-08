package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes2.dex */
public class PlayBackDateSelectorBindingImpl extends PlayBackDateSelectorBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts y = null;
    @Nullable
    private static final SparseIntArray z;
    @NonNull
    private final ScrollView p0;
    private long p1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z = sparseIntArray;
        sparseIntArray.put(R.id.widget_scroll_calendar_weekday, 2);
    }

    public PlayBackDateSelectorBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, y, z));
    }

    private boolean m(ObservableField<d> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p1 |= 2;
        }
        return true;
    }

    private boolean n(ObservableField<Calendar> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p1 |= 4;
        }
        return true;
    }

    private boolean o(ObservableField<List<d>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p1 |= 8;
        }
        return true;
    }

    private boolean p(ObservableField<d> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p1 |= 16;
        }
        return true;
    }

    private boolean q(ObservableField<d> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p1 |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.PlayBackDateSelectorBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.PlayBackDateSelectorBinding
    public void h(@Nullable b bVar) {
        this.f7336f = bVar;
        synchronized (this) {
            this.p1 |= 128;
        }
        notifyPropertyChanged(63);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p1 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.PlayBackDateSelectorBinding
    public void i(@Nullable c cVar) {
        this.x = cVar;
        synchronized (this) {
            this.p1 |= 32;
        }
        notifyPropertyChanged(64);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p1 = 256L;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.PlayBackDateSelectorBinding
    public void l(@Nullable PlayBackControlViewModel playBackControlViewModel) {
        this.q = playBackControlViewModel;
        synchronized (this) {
            this.p1 |= 64;
        }
        notifyPropertyChanged(75);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((ObservableField) obj, i2);
        }
        if (i == 1) {
            return m((ObservableField) obj, i2);
        }
        if (i == 2) {
            return n((ObservableField) obj, i2);
        }
        if (i == 3) {
            return o((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return p((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (64 == i) {
            i((c) obj);
        } else if (75 == i) {
            l((PlayBackControlViewModel) obj);
        } else if (63 != i) {
            return false;
        } else {
            h((b) obj);
        }
        return true;
    }

    private PlayBackDateSelectorBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ScrollCalendar) objArr[1], (WeekdayView) objArr[2]);
        this.p1 = -1L;
        ScrollView scrollView = (ScrollView) objArr[0];
        this.p0 = scrollView;
        scrollView.setTag(null);
        this.f7334c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
