package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

/* loaded from: classes2.dex */
public class ActivityDailySummaryBindingImpl extends ActivityDailySummaryBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts S3;
    @Nullable
    private static final SparseIntArray T3;
    @NonNull
    private final ConstraintLayout U3;
    @NonNull
    private final TextView V3;
    private long W3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(23);
        S3 = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_daily_summary_settings"}, new int[]{17}, new int[]{R.layout.layout_daily_summary_settings});
        SparseIntArray sparseIntArray = new SparseIntArray();
        T3 = sparseIntArray;
        sparseIntArray.put(R.id.toolbar_daily_summary, 18);
        sparseIntArray.put(R.id.btn_daily_summary_back, 19);
        sparseIntArray.put(R.id.toolbar_daily_summary_title, 20);
        sparseIntArray.put(R.id.refresh_layout_summary_home, 21);
        sparseIntArray.put(R.id.guideline_horizontal, 22);
    }

    public ActivityDailySummaryBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 23, S3, T3));
    }

    private boolean i(LayoutDailySummarySettingsBinding layoutDailySummarySettingsBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 1;
        }
        return true;
    }

    private boolean l(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 64;
        }
        return true;
    }

    private boolean m(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 8;
        }
        return true;
    }

    private boolean n(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 128;
        }
        return true;
    }

    private boolean o(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 4;
        }
        return true;
    }

    private boolean p(MutableLiveData<d> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 16;
        }
        return true;
    }

    private boolean q(LiveData<b> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 2;
        }
        return true;
    }

    private boolean r(LiveData<String> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.W3 |= 32;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0161  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 940
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivityDailySummaryBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivityDailySummaryBinding
    public void h(@Nullable DailySummaryViewModel dailySummaryViewModel) {
        this.R3 = dailySummaryViewModel;
        synchronized (this) {
            this.W3 |= 256;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.W3 != 0) {
                return true;
            }
            return this.p1.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.W3 = 512L;
        }
        this.p1.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return i((LayoutDailySummarySettingsBinding) obj, i2);
            case 1:
                return q((LiveData) obj, i2);
            case 2:
                return o((LiveData) obj, i2);
            case 3:
                return m((LiveData) obj, i2);
            case 4:
                return p((MutableLiveData) obj, i2);
            case 5:
                return r((LiveData) obj, i2);
            case 6:
                return l((MutableLiveData) obj, i2);
            case 7:
                return n((LiveData) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.p1.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((DailySummaryViewModel) obj);
        return true;
    }

    private ActivityDailySummaryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (TextView) objArr[9], (TextView) objArr[10], (ImageView) objArr[19], (ImageView) objArr[6], (TextView) objArr[13], (ImageView) objArr[1], (CardView) objArr[2], (Guideline) objArr[22], (LayoutDailySummarySettingsBinding) objArr[17], (ImageView) objArr[5], (ImageView) objArr[3], (ImageView) objArr[15], (ConstraintLayout) objArr[12], (RecyclerView) objArr[14], (TPSmartRefreshLayout) objArr[21], (ConstraintLayout) objArr[18], (TextView) objArr[20], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[11], (TextView) objArr[16]);
        this.W3 = -1L;
        this.f6533c.setTag(null);
        this.f6534d.setTag(null);
        this.q.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        setContainedBinding(this.p1);
        this.p2.setTag(null);
        this.p3.setTag(null);
        this.H3.setTag(null);
        this.I3.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.U3 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.V3 = textView;
        textView.setTag(null);
        this.J3.setTag(null);
        this.N3.setTag(null);
        this.O3.setTag(null);
        this.P3.setTag(null);
        this.Q3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
