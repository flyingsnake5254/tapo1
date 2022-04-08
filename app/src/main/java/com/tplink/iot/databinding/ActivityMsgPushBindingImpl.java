package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.ScheduleWeekdayTextView;
import com.tplink.iot.viewmodel.ipcamera.setting.MsgPushViewModel;
import com.tplink.iot.widget.NoninteractiveCheckBox;

/* loaded from: classes2.dex */
public class ActivityMsgPushBindingImpl extends ActivityMsgPushBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts L3 = null;
    @Nullable
    private static final SparseIntArray M3;
    @NonNull
    private final RelativeLayout N3;
    @NonNull
    private final LinearLayout O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar_divider, 11);
        sparseIntArray.put(R.id.notification_setting, 12);
        sparseIntArray.put(R.id.schedule_mode, 13);
        sparseIntArray.put(R.id.time_text, 14);
    }

    public ActivityMsgPushBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, L3, M3));
    }

    private boolean l(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 128;
        }
        return true;
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 64;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 32;
        }
        return true;
    }

    private boolean o(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 8;
        }
        return true;
    }

    private boolean p(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 16;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 2;
        }
        return true;
    }

    private boolean r(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 256;
        }
        return true;
    }

    private boolean s(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 4;
        }
        return true;
    }

    private boolean t(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityMsgPushBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityMsgPushBinding
    public void h(@Nullable View.OnClickListener onClickListener) {
        this.J3 = onClickListener;
        synchronized (this) {
            this.P3 |= 512;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivityMsgPushBinding
    public void i(@Nullable MsgPushViewModel msgPushViewModel) {
        this.K3 = msgPushViewModel;
        synchronized (this) {
            this.P3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return t((ObservableField) obj, i2);
            case 1:
                return q((ObservableBoolean) obj, i2);
            case 2:
                return s((ObservableBoolean) obj, i2);
            case 3:
                return o((ObservableBoolean) obj, i2);
            case 4:
                return p((ObservableBoolean) obj, i2);
            case 5:
                return n((ObservableBoolean) obj, i2);
            case 6:
                return m((ObservableField) obj, i2);
            case 7:
                return l((ObservableInt) obj, i2);
            case 8:
                return r((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (55 == i) {
            h((View.OnClickListener) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((MsgPushViewModel) obj);
        }
        return true;
    }

    private ActivityMsgPushBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (RadioButton) objArr[4], (RadioButton) objArr[5], (RelativeLayout) objArr[6], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[7], (LinearLayout) objArr[12], (CheckBox) objArr[1], (NoninteractiveCheckBox) objArr[3], (RadioGroup) objArr[13], (LinearLayout) objArr[14], (View) objArr[11], (ScheduleWeekdayTextView) objArr[10]);
        this.P3 = -1L;
        this.f6633c.setTag(null);
        this.f6634d.setTag(null);
        this.f6635f.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.N3 = relativeLayout;
        relativeLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.O3 = linearLayout;
        linearLayout.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.I3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
