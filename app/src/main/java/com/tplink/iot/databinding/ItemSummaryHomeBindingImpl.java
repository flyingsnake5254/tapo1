package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.model.d;
import com.tplink.iot.dailysummary.network.bean.common.SummaryImage;
import com.tplink.iot.dailysummary.view.adapter.a;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;

/* loaded from: classes2.dex */
public class ItemSummaryHomeBindingImpl extends ItemSummaryHomeBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts H3 = null;
    @Nullable
    private static final SparseIntArray I3;
    @NonNull
    private final CardView J3;
    @NonNull
    private final ImageView K3;
    @NonNull
    private final CardView L3;
    private long M3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I3 = sparseIntArray;
        sparseIntArray.put(R.id.card_daily_summary_thumbnail, 10);
        sparseIntArray.put(R.id.guideline_vertical, 11);
    }

    public ItemSummaryHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, H3, I3));
    }

    private boolean l(MutableLiveData<d> mutableLiveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.M3 |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        long j2;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        long j3;
        SummaryImage summaryImage;
        int i11;
        long j4;
        long j5;
        synchronized (this) {
            j = this.M3;
            this.M3 = 0L;
        }
        b bVar = this.p3;
        DailySummaryViewModel dailySummaryViewModel = this.p2;
        d dVar = null;
        if ((j & 15) != 0) {
            int i12 = ((j & 10) > 0L ? 1 : ((j & 10) == 0L ? 0 : -1));
            if (i12 != 0) {
                if (bVar != null) {
                    i9 = bVar.g();
                    i8 = bVar.a();
                    i5 = bVar.f();
                    i4 = bVar.m();
                    summaryImage = bVar.k();
                    i2 = bVar.e();
                    str = bVar.d();
                    i = bVar.h();
                    i11 = bVar.j();
                } else {
                    summaryImage = null;
                    str = null;
                    i9 = 0;
                    i8 = 0;
                    i11 = 0;
                    i5 = 0;
                    i4 = 0;
                    i2 = 0;
                    i = 0;
                }
                boolean z3 = summaryImage == null;
                boolean z4 = i11 == 1;
                if (i12 != 0) {
                    if (z3) {
                        j5 = j | 128;
                        j4 = 512;
                    } else {
                        j5 = j | 64;
                        j4 = 256;
                    }
                    j = j5 | j4;
                }
                if ((j & 10) != 0) {
                    j |= z4 ? 8192L : PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                }
                i6 = z3 ? 8 : 0;
                i3 = z3 ? 0 : 8;
                i7 = z4 ? 0 : 8;
            } else {
                str = null;
                i9 = 0;
                i8 = 0;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            }
            z = bVar != null ? bVar.b() : false;
            if ((j & 15) == 0) {
                j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            } else if (z) {
                j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                j |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            } else {
                j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                j |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
        } else {
            j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            str = null;
            i9 = 0;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            z = false;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((j & j2) != 0) {
            MutableLiveData<d> Z = dailySummaryViewModel != null ? dailySummaryViewModel.Z() : null;
            updateLiveDataRegistration(0, Z);
            if (Z != null) {
                dVar = Z.getValue();
            }
            z2 = !(dVar != null ? dVar.b() : false);
        } else {
            z2 = false;
        }
        int i13 = ((j & 15) > 0L ? 1 : ((j & 15) == 0L ? 0 : -1));
        if (i13 != 0) {
            if (!z) {
                z2 = false;
            }
            if (i13 != 0) {
                j |= z2 ? 32L : 16L;
            }
            i10 = z2 ? 0 : 8;
            j3 = 10;
        } else {
            j3 = 10;
            i10 = 0;
        }
        if ((j3 & j) != 0) {
            this.f7205c.setVisibility(i8);
            this.f7207f.setVisibility(i4);
            a.b(this.y, bVar);
            this.y.setVisibility(i6);
            this.K3.setVisibility(i3);
            this.L3.setVisibility(i7);
            TextViewBindingAdapter.setText(this.z, str);
            com.tplink.iot.dailysummary.view.adapter.b.b(this.p0, i2);
            this.p0.setVisibility(i5);
            com.tplink.iot.dailysummary.view.adapter.b.c(this.p1, i9);
            this.p1.setVisibility(i);
        }
        if ((j & 15) != 0) {
            this.f7206d.setVisibility(i10);
        }
    }

    @Override // com.tplink.iot.databinding.ItemSummaryHomeBinding
    public void h(@Nullable b bVar) {
        this.p3 = bVar;
        synchronized (this) {
            this.M3 |= 2;
        }
        notifyPropertyChanged(95);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.M3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.ItemSummaryHomeBinding
    public void i(@Nullable DailySummaryViewModel dailySummaryViewModel) {
        this.p2 = dailySummaryViewModel;
        synchronized (this) {
            this.M3 |= 4;
        }
        notifyPropertyChanged(103);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.M3 = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (95 == i) {
            h((b) obj);
        } else if (103 != i) {
            return false;
        } else {
            i((DailySummaryViewModel) obj);
        }
        return true;
    }

    private ItemSummaryHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[8], (CardView) objArr[10], (Guideline) objArr[11], (ImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[9]);
        this.M3 = -1L;
        this.f7205c.setTag(null);
        this.f7206d.setTag(null);
        this.f7207f.setTag(null);
        this.y.setTag(null);
        CardView cardView = (CardView) objArr[0];
        this.J3 = cardView;
        cardView.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.K3 = imageView;
        imageView.setTag(null);
        CardView cardView2 = (CardView) objArr[3];
        this.L3 = cardView2;
        cardView2.setTag(null);
        this.z.setTag(null);
        this.p0.setTag(null);
        this.p1.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
