package com.tplink.iot.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;

/* loaded from: classes2.dex */
public class LayoutDailySummarySettingsBindingImpl extends LayoutDailySummarySettingsBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts Y3 = null;
    @Nullable
    private static final SparseIntArray Z3;
    @NonNull
    private final ImageView a4;
    @NonNull
    private final ImageView b4;
    private long c4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Z3 = sparseIntArray;
        sparseIntArray.put(R.id.layout_summary_setting_background, 9);
        sparseIntArray.put(R.id.tv_summary_setting_title, 10);
        sparseIntArray.put(R.id.btn_summary_setting_back, 11);
        sparseIntArray.put(R.id.tv_auto_rotation, 12);
        sparseIntArray.put(R.id.divide_line1, 13);
        sparseIntArray.put(R.id.divide_line2, 14);
        sparseIntArray.put(R.id.tv_notify, 15);
        sparseIntArray.put(R.id.divide_line3, 16);
        sparseIntArray.put(R.id.divide_line4, 17);
        sparseIntArray.put(R.id.divide_bar, 18);
        sparseIntArray.put(R.id.tv_video_combination_title, 19);
        sparseIntArray.put(R.id.divide_line5, 20);
        sparseIntArray.put(R.id.tv_video_combination_recommended, 21);
        sparseIntArray.put(R.id.btn_video_combination_recommended, 22);
        sparseIntArray.put(R.id.divide_line6, 23);
        sparseIntArray.put(R.id.tv_video_combination_all, 24);
        sparseIntArray.put(R.id.btn_video_combination_all, 25);
        sparseIntArray.put(R.id.divide_line7, 26);
        sparseIntArray.put(R.id.guideline_start, 27);
        sparseIntArray.put(R.id.guideline_end, 28);
    }

    public LayoutDailySummarySettingsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 29, Y3, Z3));
    }

    private boolean i(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 2;
        }
        return true;
    }

    private boolean l(MutableLiveData<d> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 1;
        }
        return true;
    }

    private boolean m(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.c4 |= 4;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f2  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.LayoutDailySummarySettingsBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.LayoutDailySummarySettingsBinding
    public void h(@Nullable DailySummaryViewModel dailySummaryViewModel) {
        this.X3 = dailySummaryViewModel;
        synchronized (this) {
            this.c4 |= 8;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.c4 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.c4 = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return l((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return i((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (103 != i) {
            return false;
        }
        h((DailySummaryViewModel) obj);
        return true;
    }

    private LayoutDailySummarySettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[1], (ImageView) objArr[11], (View) objArr[25], (View) objArr[22], (View) objArr[18], (View) objArr[13], (View) objArr[14], (View) objArr[16], (View) objArr[17], (View) objArr[20], (View) objArr[23], (View) objArr[26], (Guideline) objArr[28], (Guideline) objArr[27], (ConstraintLayout) objArr[9], (ConstraintLayout) objArr[0], (SwitchCompat) objArr[2], (SwitchCompat) objArr[4], (TextView) objArr[12], (TextView) objArr[3], (TextView) objArr[15], (TextView) objArr[5], (TextView) objArr[10], (TextView) objArr[24], (TextView) objArr[21], (TextView) objArr[19], (TextView) objArr[8]);
        this.c4 = -1L;
        this.f7226c.setTag(null);
        this.L3.setTag(null);
        ImageView imageView = (ImageView) objArr[6];
        this.a4 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[7];
        this.b4 = imageView2;
        imageView2.setTag(null);
        this.M3.setTag(null);
        this.N3.setTag(null);
        this.P3.setTag(null);
        this.R3.setTag(null);
        this.W3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
