package com.hitomi.cslibrary.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;

/* loaded from: classes2.dex */
public class EdgeShadowView extends View {

    /* renamed from: c  reason: collision with root package name */
    private Paint f5096c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f5097d;

    /* renamed from: f  reason: collision with root package name */
    private float f5098f;
    private float q;
    private float x;
    private int y;

    /* loaded from: classes2.dex */
    public static class b {
        private Context a;

        /* renamed from: b  reason: collision with root package name */
        private int[] f5099b;

        /* renamed from: c  reason: collision with root package name */
        private float f5100c;

        /* renamed from: d  reason: collision with root package name */
        private float f5101d;

        /* renamed from: e  reason: collision with root package name */
        private float f5102e;

        /* renamed from: f  reason: collision with root package name */
        private int f5103f;

        public EdgeShadowView a() {
            EdgeShadowView edgeShadowView = new EdgeShadowView(this.a);
            edgeShadowView.setShadowColor(this.f5099b);
            edgeShadowView.setShadowRadius(this.f5100c);
            edgeShadowView.setShadowSize(this.f5101d);
            edgeShadowView.setCornerRadius(this.f5102e);
            edgeShadowView.setDirection(this.f5103f);
            edgeShadowView.c();
            return edgeShadowView;
        }

        public b b(Context context) {
            this.a = context;
            return this;
        }

        public b c(float f2) {
            this.f5102e = f2;
            return this;
        }

        public b d(int i) {
            this.f5103f = i;
            return this;
        }

        public b e(int[] iArr) {
            this.f5099b = iArr;
            return this;
        }

        public b f(float f2) {
            this.f5100c = f2;
            return this;
        }

        public b g(float f2) {
            this.f5101d = f2;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Paint paint = new Paint();
        this.f5096c = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = this.f5096c;
        float f2 = this.x;
        float f3 = this.f5098f;
        paint2.setShader(new LinearGradient(0.0f, (-f2) + f3, 0.0f, (-f2) - f3, this.f5097d, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShadowColor(int[] iArr) {
        this.f5097d = iArr;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        int i = this.y;
        if (i == 1) {
            canvas.translate(this.x + this.f5098f, this.q);
            canvas.rotate(270.0f);
        } else if (i == 2) {
            canvas.translate(0.0f, this.x + this.f5098f);
        } else if (i == 4) {
            canvas.translate(-this.x, 0.0f);
            canvas.rotate(90.0f);
        } else if (i == 8) {
            canvas.translate(this.q, -this.x);
            canvas.rotate(180.0f);
        }
        float f2 = this.x;
        canvas.drawRect(0.0f, (-f2) - this.f5098f, this.q, -f2, this.f5096c);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = this.y;
        if (i5 == 1 || i5 == 4) {
            i4 = Math.round(this.f5098f);
            i3 = Math.round(this.q);
        } else {
            i4 = Math.round(this.q);
            i3 = Math.round(this.f5098f);
        }
        setMeasuredDimension(i4, i3);
    }

    public void setCornerRadius(float f2) {
        this.x = f2;
    }

    public void setDirection(int i) {
        this.y = i;
    }

    public void setShadowColors(int[] iArr) {
        this.f5097d = iArr;
        c();
        invalidate();
    }

    public void setShadowRadius(float f2) {
        this.f5098f = f2;
    }

    public void setShadowSize(float f2) {
        this.q = f2;
    }

    private EdgeShadowView(Context context) {
        super(context);
    }
}
