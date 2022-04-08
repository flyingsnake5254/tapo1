package com.tplink.iot.dailysummary.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.ConnectionResult;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisHorizontalScrollView;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisScaleView;
import com.tplink.iot.databinding.LayoutSummaryTimeAxisBinding;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SummaryTimeAxisLayout.kt */
/* loaded from: classes2.dex */
public final class SummaryTimeAxisLayout extends FrameLayout implements SummaryTimeAxisHorizontalScrollView.a, SummaryTimeAxisScaleView.b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f6473c = new a(null);
    private long H3;

    /* renamed from: d  reason: collision with root package name */
    private LayoutSummaryTimeAxisBinding f6474d;

    /* renamed from: f  reason: collision with root package name */
    private SummaryTimeAxisHorizontalScrollView f6475f;
    private boolean p0;
    private long p1;
    private boolean p2;
    private boolean p3;
    private SummaryTimeAxisScaleView q;
    private Handler x;
    private b y;
    private boolean z;

    /* compiled from: SummaryTimeAxisLayout.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SummaryTimeAxisLayout.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void K0(long j);

        void x(long j, boolean z);
    }

    /* compiled from: SummaryTimeAxisLayout.kt */
    /* loaded from: classes2.dex */
    public final class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            j.e(msg, "msg");
            super.handleMessage(msg);
            if (msg.what == 0 && msg.arg1 == SummaryTimeAxisLayout.this.f6475f.getScrollX()) {
                removeCallbacksAndMessages(null);
                int i = msg.arg2;
                b bVar = SummaryTimeAxisLayout.this.y;
                if (bVar != null) {
                    bVar.K0(i * 1000);
                }
                SummaryTimeAxisLayout.this.z = false;
            }
        }
    }

    public SummaryTimeAxisLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public SummaryTimeAxisLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SummaryTimeAxisLayout(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void f(long j) {
        this.p1 = j;
        this.q.e(this.p2, j);
    }

    private final void setTimeByPlayer(long j) {
        f(j);
        if (!this.z) {
            int c2 = this.q.c(this.p1);
            if (c2 == this.f6475f.getScrollX()) {
                b bVar = this.y;
                if (bVar != null) {
                    bVar.x(this.p1, false);
                    return;
                }
                return;
            }
            this.p0 = true;
            this.f6475f.scrollTo(c2, 0);
        }
    }

    @Override // com.tplink.iot.dailysummary.widget.SummaryTimeAxisScaleView.b
    public void a() {
        this.f6475f.scrollTo(this.q.c(this.p1), 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        j.e(ev, "ev");
        int action = ev.getAction();
        if (action == 0) {
            this.p3 = true;
        } else if (action == 1 || action == 3) {
            this.p3 = false;
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void e(boolean z) {
        this.p2 = z;
        this.q.e(z, this.p1);
    }

    public final long getPlayerCurrentTime() {
        return this.H3;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 0) {
            this.q.setBlankWidth(size / 2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View, com.tplink.iot.dailysummary.widget.SummaryTimeAxisHorizontalScrollView.a
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.z = true;
        f(this.q.b(i));
        if (this.p0) {
            this.p0 = false;
            b bVar = this.y;
            if (bVar != null) {
                bVar.x(this.p1, false);
            }
            this.z = false;
            return;
        }
        b bVar2 = this.y;
        if (bVar2 != null) {
            bVar2.x(this.p1, true);
        }
        int i5 = this.p3 ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        Handler handler = this.x;
        handler.sendMessageDelayed(handler.obtainMessage(0, i, (int) (this.p1 / 1000)), i5);
    }

    public final void setClipSplitPointList(ArrayList<Long> splitPointList) {
        j.e(splitPointList, "splitPointList");
        this.q.setClipSplitPointList(splitPointList);
    }

    public final void setOnTimeChangedListener(b bVar) {
        if (bVar != null) {
            this.y = bVar;
        }
    }

    public final void setPlayerCurrentTime(long j) {
        setTimeByPlayer(j);
    }

    public final void setSummaryDuration(long j) {
        this.q.setSummaryDuration(j);
    }

    public final void setThumbnailList(LinkedList<com.tplink.iot.dailysummary.model.c> thumbnailList) {
        j.e(thumbnailList, "thumbnailList");
        this.q.setThumbnailList(thumbnailList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SummaryTimeAxisLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_summary_time_axis, this, true);
        LayoutSummaryTimeAxisBinding layoutSummaryTimeAxisBinding = (LayoutSummaryTimeAxisBinding) inflate;
        SummaryTimeAxisHorizontalScrollView timeAxisScrollview = layoutSummaryTimeAxisBinding.f7293d;
        j.d(timeAxisScrollview, "timeAxisScrollview");
        this.f6475f = timeAxisScrollview;
        SummaryTimeAxisScaleView timeAxisScaleview = layoutSummaryTimeAxisBinding.f7292c;
        j.d(timeAxisScaleview, "timeAxisScaleview");
        this.q = timeAxisScaleview;
        p pVar = p.a;
        j.d(inflate, "DataBindingUtil.inflate<…meAxisScaleview\n        }");
        this.f6474d = layoutSummaryTimeAxisBinding;
        this.x = new c();
        this.f6475f.setScrollViewListener(this);
        this.q.setScaleViewListener(this);
    }
}
