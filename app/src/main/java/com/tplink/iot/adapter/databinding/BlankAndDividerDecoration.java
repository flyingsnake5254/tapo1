package com.tplink.iot.adapter.databinding;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.collections.i;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: BlankAndDividerDecoration.kt */
/* loaded from: classes2.dex */
public final class BlankAndDividerDecoration extends RecyclerView.ItemDecoration {
    private final Paint a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f5427b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f5428c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f5429d;

    /* renamed from: e  reason: collision with root package name */
    private float f5430e;

    /* renamed from: f  reason: collision with root package name */
    private final float f5431f;
    private float g;
    private int[] h;
    private float i;
    private float j;
    private boolean k;

    public BlankAndDividerDecoration() {
        this(0.0f, 0.0f, 0.0f, null, 0.0f, 0.0f, 0, 0, 0, 0, false, 2047, null);
    }

    public /* synthetic */ BlankAndDividerDecoration(float f2, float f3, float f4, int[] iArr, float f5, float f6, int i, int i2, int i3, int i4, boolean z, int i5, f fVar) {
        this((i5 & 1) != 0 ? 16.0f : f2, (i5 & 2) != 0 ? 0.0f : f3, (i5 & 4) == 0 ? f4 : 16.0f, (i5 & 8) != 0 ? new int[0] : iArr, (i5 & 16) != 0 ? 1.0f : f5, (i5 & 32) == 0 ? f6 : 0.0f, (i5 & 64) != 0 ? Color.parseColor("#F0F0F0") : i, (i5 & 128) != 0 ? Color.parseColor("#1A000000") : i2, (i5 & 256) != 0 ? Color.parseColor("#FFFFFF") : i3, (i5 & 512) != 0 ? Color.parseColor("#FFFFFF") : i4, (i5 & 1024) == 0 ? z : false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int i;
        int i2;
        boolean i3;
        int i4;
        float f2;
        j.e(outRect, "outRect");
        j.e(view, "view");
        j.e(parent, "parent");
        j.e(state, "state");
        int i5 = (int) this.i;
        if (parent.getChildAdapterPosition(view) == 0) {
            i4 = (int) this.f5430e;
            f2 = this.i;
        } else {
            if (this.k) {
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                RecyclerView.Adapter adapter = parent.getAdapter();
                if (childAdapterPosition == (adapter != null ? adapter.getItemCount() : -1)) {
                    return;
                }
            }
            int childAdapterPosition2 = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter2 = parent.getAdapter();
            if (adapter2 != null) {
                i2 = adapter2.getItemCount();
            } else {
                i2 = 0 - (this.k ? 2 : 1);
            }
            if (childAdapterPosition2 == i2) {
                i5 += (int) this.g;
            } else {
                i3 = i.i(this.h, parent.getChildAdapterPosition(view));
                if (i3) {
                    i4 = (int) this.f5431f;
                    f2 = this.i;
                }
            }
            i = 0;
            outRect.set(0, i, 0, i5);
        }
        i = i4 + ((int) f2);
        outRect.set(0, i, 0, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
        if (r3 == (r5 != null ? r5.getItemCount() : -1)) goto L_0x0168;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDrawOver(android.graphics.Canvas r13, androidx.recyclerview.widget.RecyclerView r14, androidx.recyclerview.widget.RecyclerView.State r15) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.adapter.databinding.BlankAndDividerDecoration.onDrawOver(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public BlankAndDividerDecoration(float f2, float f3, float f4, int[] subListStartIndex, float f5, float f6, int i, int i2, int i3, int i4, boolean z) {
        j.e(subListStartIndex, "subListStartIndex");
        this.f5430e = f2;
        this.f5431f = f3;
        this.g = f4;
        this.h = subListStartIndex;
        this.i = f5;
        this.j = f6;
        this.k = z;
        Paint paint = new Paint();
        this.a = paint;
        Paint paint2 = new Paint();
        this.f5427b = paint2;
        Paint paint3 = new Paint();
        this.f5428c = paint3;
        Paint paint4 = new Paint();
        this.f5429d = paint4;
        paint.setColor(i);
        paint2.setColor(i2);
        paint3.setColor(i3);
        paint4.setColor(i4);
        i.t(this.h);
    }
}
