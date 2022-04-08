package com.tplink.iot.databinding;

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
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

/* loaded from: classes2.dex */
public class ActivitySummaryHistoryBindingImpl extends ActivitySummaryHistoryBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts K3 = null;
    @Nullable
    private static final SparseIntArray L3;
    @NonNull
    private final ConstraintLayout M3;
    @NonNull
    private final ConstraintLayout N3;
    @NonNull
    private final View O3;
    private long P3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L3 = sparseIntArray;
        sparseIntArray.put(R.id.btn_summary_history_back, 11);
        sparseIntArray.put(R.id.toolbar_summary_history_title, 12);
        sparseIntArray.put(R.id.btn_summary_edit_close, 13);
        sparseIntArray.put(R.id.refresh_layout_summary_history, 14);
        sparseIntArray.put(R.id.btn_delete_summary, 15);
    }

    public ActivitySummaryHistoryBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, K3, L3));
    }

    private boolean i(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 8;
        }
        return true;
    }

    private boolean l(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 64;
        }
        return true;
    }

    private boolean m(LiveData<Boolean> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 16;
        }
        return true;
    }

    private boolean n(MutableLiveData<d> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 4;
        }
        return true;
    }

    private boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 1;
        }
        return true;
    }

    private boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 32;
        }
        return true;
    }

    private boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.P3 |= 2;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x0219, code lost:
        r38.f6709d.setEnabled(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0143  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.ActivitySummaryHistoryBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.ActivitySummaryHistoryBinding
    public void h(@Nullable SummaryHistoryViewModel summaryHistoryViewModel) {
        this.J3 = summaryHistoryViewModel;
        synchronized (this) {
            this.P3 |= 128;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P3 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P3 = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return o((MutableLiveData) obj, i2);
            case 1:
                return q((MutableLiveData) obj, i2);
            case 2:
                return n((MutableLiveData) obj, i2);
            case 3:
                return i((MutableLiveData) obj, i2);
            case 4:
                return m((LiveData) obj, i2);
            case 5:
                return p((MutableLiveData) obj, i2);
            case 6:
                return l((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((SummaryHistoryViewModel) obj);
        return true;
    }

    private ActivitySummaryHistoryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (CardView) objArr[15], (TextView) objArr[2], (ImageView) objArr[13], (ImageView) objArr[5], (ImageView) objArr[11], (ImageView) objArr[9], (RecyclerView) objArr[7], (TPSmartRefreshLayout) objArr[14], (ConstraintLayout) objArr[3], (TextView) objArr[4], (ConstraintLayout) objArr[1], (TextView) objArr[12], (TextView) objArr[6]);
        this.P3 = -1L;
        this.f6709d.setTag(null);
        this.q.setTag(null);
        this.y.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.M3 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[10];
        this.N3 = constraintLayout2;
        constraintLayout2.setTag(null);
        View view2 = (View) objArr[8];
        this.O3 = view2;
        view2.setTag(null);
        this.z.setTag(null);
        this.p1.setTag(null);
        this.p2.setTag(null);
        this.p3.setTag(null);
        this.I3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
