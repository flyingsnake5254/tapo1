package com.tplink.iot.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.timeaxis.TimeAxisLayout;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PlayBackTimeRulerBindingImpl extends PlayBackTimeRulerBinding {
    @Nullable
    private static final SparseIntArray p0;
    @Nullable
    private static final ViewDataBinding.IncludedLayouts z = null;
    @NonNull
    private final RelativeLayout p1;
    @NonNull
    private final TextView p2;
    private long p3;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p0 = sparseIntArray;
        sparseIntArray.put(R.id.play_back_center_caribration, 4);
    }

    public PlayBackTimeRulerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, z, p0));
    }

    private boolean m(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 256;
        }
        return true;
    }

    private boolean n(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 8;
        }
        return true;
    }

    private boolean o(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 1;
        }
        return true;
    }

    private boolean p(ObservableField<List<ArrayList<int[]>>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 2;
        }
        return true;
    }

    private boolean q(ObservableBoolean observableBoolean, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 4;
        }
        return true;
    }

    private boolean r(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 32;
        }
        return true;
    }

    private boolean s(ObservableInt observableInt, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 16;
        }
        return true;
    }

    private boolean t(ObservableField<Pair<ArrayList<int[]>, ArrayList<int[]>>> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 128;
        }
        return true;
    }

    private boolean u(ObservableFloat observableFloat, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.p3 |= 64;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0123  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.databinding.PlayBackTimeRulerBindingImpl.executeBindings():void");
    }

    @Override // com.tplink.iot.databinding.PlayBackTimeRulerBinding
    public void h(@Nullable g gVar) {
        this.x = gVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p3 != 0;
        }
    }

    @Override // com.tplink.iot.databinding.PlayBackTimeRulerBinding
    public void i(@Nullable TimeAxisLayout.b bVar) {
        this.y = bVar;
        synchronized (this) {
            this.p3 |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        }
        notifyPropertyChanged(99);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p3 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        requestRebind();
    }

    @Override // com.tplink.iot.databinding.PlayBackTimeRulerBinding
    public void l(@Nullable PlayBackControlViewModel playBackControlViewModel) {
        this.q = playBackControlViewModel;
        synchronized (this) {
            this.p3 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(105);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return o((ObservableInt) obj, i2);
            case 1:
                return p((ObservableField) obj, i2);
            case 2:
                return q((ObservableBoolean) obj, i2);
            case 3:
                return n((ObservableBoolean) obj, i2);
            case 4:
                return s((ObservableInt) obj, i2);
            case 5:
                return r((ObservableInt) obj, i2);
            case 6:
                return u((ObservableFloat) obj, i2);
            case 7:
                return t((ObservableField) obj, i2);
            case 8:
                return m((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (79 == i) {
            h((g) obj);
        } else if (99 == i) {
            i((TimeAxisLayout.b) obj);
        } else if (105 != i) {
            return false;
        } else {
            l((PlayBackControlViewModel) obj);
        }
        return true;
    }

    private PlayBackTimeRulerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (ImageView) objArr[4], (TextView) objArr[2], (TimeAxisLayout) objArr[1]);
        this.p3 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.p1 = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.p2 = textView;
        textView.setTag(null);
        this.f7341d.setTag(null);
        this.f7342f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
