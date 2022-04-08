package io.codetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.a.a.a;

/* loaded from: classes3.dex */
public class RevealLinearLayout extends LinearLayout implements a {

    /* renamed from: c  reason: collision with root package name */
    private Path f15604c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f15605d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15606f;
    private float q;

    public RevealLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (!this.f15606f) {
            return super.drawChild(canvas, view, j);
        }
        throw null;
    }

    @Override // c.a.a.a
    public float getRevealRadius() {
        return this.q;
    }

    @Override // c.a.a.a
    public void setRevealRadius(float f2) {
        this.q = f2;
        throw null;
    }

    public RevealLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RevealLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f15605d = new Rect();
        this.f15604c = new Path();
    }
}
