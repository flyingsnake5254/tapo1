package io.codetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import c.a.a.a;

/* loaded from: classes3.dex */
public class RevealFrameLayout extends FrameLayout implements a {

    /* renamed from: c  reason: collision with root package name */
    private Path f15601c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f15602d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15603f;
    private float q;

    public RevealFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (!this.f15603f) {
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

    public RevealFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15602d = new Rect();
        this.f15601c = new Path();
    }
}
