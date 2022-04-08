package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.model.c;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.viewmodel.SummaryPlayViewModel;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout;
import com.tplink.iot.generated.callback.a;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class ActivitySummaryPlayBindingLandImpl extends ActivitySummaryPlayBinding implements a.AbstractC0211a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts n4 = null;
    @Nullable
    private static final SparseIntArray o4;
    @NonNull
    private final ConstraintLayout p4;
    @NonNull
    private final ConstraintLayout q4;
    @Nullable
    private final View.OnClickListener r4;
    private long s4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        o4 = sparseIntArray;
        sparseIntArray.put(R.id.btn_summary_toolbar_back_full, 19);
        sparseIntArray.put(R.id.btn_summary_toolbar_download, 20);
        sparseIntArray.put(R.id.btn_summary_toolbar_share, 21);
        sparseIntArray.put(R.id.btn_summary_toolbar_calendar, 22);
        sparseIntArray.put(R.id.layout_summary_data_selector_calendar, 23);
        sparseIntArray.put(R.id.btn_summary_date_selector_last_month, 24);
        sparseIntArray.put(R.id.view_summary_date_selector_weekday, 25);
        sparseIntArray.put(R.id.layout_summary_data_selector_scroll_calendar, 26);
        sparseIntArray.put(R.id.btn_summary_player_float_indicator, 27);
        sparseIntArray.put(R.id.iv_tap_refresh, 28);
        sparseIntArray.put(R.id.tv_tap_refresh, 29);
        sparseIntArray.put(R.id.iv_player_no_recording, 30);
        sparseIntArray.put(R.id.btn_player_view_other_date, 31);
    }

    public ActivitySummaryPlayBindingLandImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 32, n4, o4));
    }

    private boolean A(MutableLiveData<Long> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 32;
        }
        return true;
    }

    private boolean B(MutableLiveData<b> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        return true;
    }

    private boolean C(MutableLiveData<LinkedList<c>> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 512;
        }
        return true;
    }

    private boolean l(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 8;
        }
        return true;
    }

    private boolean m(MutableLiveData<String> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        return true;
    }

    private boolean n(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 1;
        }
        return true;
    }

    private boolean o(MutableLiveData<d> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        return true;
    }

    private boolean p(MutableLiveData<Long> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 16384;
        }
        return true;
    }

    private boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 64;
        }
        return true;
    }

    private boolean r(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 2;
        }
        return true;
    }

    private boolean s(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 4;
        }
        return true;
    }

    private boolean t(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean u(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 128;
        }
        return true;
    }

    private boolean v(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 8192;
        }
        return true;
    }

    private boolean w(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        return true;
    }

    private boolean x(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 16;
        }
        return true;
    }

    private boolean y(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= 256;
        }
        return true;
    }

    private boolean z(MutableLiveData<ArrayList<Long>> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        return true;
    }

    @Override // com.tplink.iot.generated.callback.a.AbstractC0211a
    public final void d(int i, View view) {
        SummaryPlayViewModel summaryPlayViewModel = this.l4;
        if (summaryPlayViewModel != null) {
            summaryPlayViewModel.b0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0680  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0711  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:440:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0162  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 1855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivitySummaryPlayBindingLandImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivitySummaryPlayBinding
    public void h(@Nullable SummaryTimeAxisLayout.b bVar) {
        this.m4 = bVar;
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        notifyPropertyChanged(72);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.s4 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ActivitySummaryPlayBinding
    public void i(@Nullable SummaryPlayViewModel summaryPlayViewModel) {
        this.l4 = summaryPlayViewModel;
        synchronized (this) {
            this.s4 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.s4 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return n((LiveData) obj, i2);
            case 1:
                return r((MutableLiveData) obj, i2);
            case 2:
                return s((MutableLiveData) obj, i2);
            case 3:
                return l((MutableLiveData) obj, i2);
            case 4:
                return x((MutableLiveData) obj, i2);
            case 5:
                return A((MutableLiveData) obj, i2);
            case 6:
                return q((MutableLiveData) obj, i2);
            case 7:
                return u((MutableLiveData) obj, i2);
            case 8:
                return y((MutableLiveData) obj, i2);
            case 9:
                return C((MutableLiveData) obj, i2);
            case 10:
                return t((MutableLiveData) obj, i2);
            case 11:
                return o((MutableLiveData) obj, i2);
            case 12:
                return m((MutableLiveData) obj, i2);
            case 13:
                return v((MutableLiveData) obj, i2);
            case 14:
                return p((MutableLiveData) obj, i2);
            case 15:
                return w((MutableLiveData) obj, i2);
            case 16:
                return z((MutableLiveData) obj, i2);
            case 17:
                return B((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (72 == i) {
            h((SummaryTimeAxisLayout.b) obj);
        } else if (105 != i) {
            return false;
        } else {
            i((SummaryPlayViewModel) obj);
        }
        return true;
    }

    private ActivitySummaryPlayBindingLandImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 18, (LottieAnimationView) objArr[14], (TextView) objArr[18], (TextView) objArr[31], null, (ImageView) objArr[24], null, (ImageView) objArr[9], (TextView) objArr[10], (CardView) objArr[12], (ImageView) objArr[27], null, (ImageView) objArr[19], (ImageView) objArr[22], null, (ImageView) objArr[20], null, (ImageView) objArr[3], (ImageView) objArr[2], (ImageView) objArr[21], (ConstraintLayout) objArr[15], (TextView) objArr[4], (ImageView) objArr[30], null, (ImageView) objArr[28], (ConstraintLayout) objArr[7], null, (ConstraintLayout) objArr[23], (ScrollCalendar) objArr[26], null, null, (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[0], null, (SummaryTimeAxisLayout) objArr[6], (PlayerView) objArr[13], (TextView) objArr[5], (TextView) objArr[17], null, (TextView) objArr[8], (TextView) objArr[29], (WeekdayView) objArr[25]);
        this.s4 = -1L;
        this.f6711c.setTag(null);
        this.f6712d.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        this.M3.setTag(null);
        this.N3.setTag(null);
        this.P3.setTag(null);
        this.Q3.setTag(null);
        this.U3.setTag(null);
        this.a4.setTag(null);
        this.b4.setTag(null);
        this.d4.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[11];
        this.p4 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[16];
        this.q4 = constraintLayout2;
        constraintLayout2.setTag(null);
        this.e4.setTag(null);
        this.f4.setTag(null);
        this.g4.setTag(null);
        this.i4.setTag(null);
        setRootTag(view);
        this.r4 = new a(this, 1);
        invalidateAll();
    }
}
