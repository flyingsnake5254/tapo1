package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;

/* loaded from: classes3.dex */
public class TPLoadingView extends View {
    private int H3;
    private Paint I3;
    private a J3;
    private a K3;
    private a L3;
    private a M3;
    private a N3;
    private a O3;
    private a P3;
    private a Q3;
    private a R3;
    private a S3;
    private a T3;
    private int U3;

    /* renamed from: c  reason: collision with root package name */
    private float f12131c;

    /* renamed from: d  reason: collision with root package name */
    private float f12132d;

    /* renamed from: f  reason: collision with root package name */
    private float f12133f;
    private double p0;
    private float p1;
    private boolean p2;
    private boolean p3;
    private float q;
    private float x;
    private double y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f12134b;

        public a(float f2, float f3) {
            this.a = f2;
            this.f12134b = f3;
        }
    }

    public TPLoadingView(Context context) {
        this(context, null);
    }

    private void c() {
        this.y = 91.0d;
        this.z = 20L;
        this.p0 = 2.2d;
        this.p1 = 3.2f;
        this.x = 10.0f;
        this.f12131c = getPaddingLeft() + (getWidth() / 2.0f);
        this.f12132d = getPaddingTop() + (getHeight() / 2.0f);
        float f2 = this.f12131c;
        this.f12133f = 0.4f * f2;
        this.q = 0.88f * f2;
        this.x = f2 * 0.1f;
        f();
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPLoadingView);
        this.U3 = obtainStyledAttributes.getColor(x0.TPLoadingView_load_color, ContextCompat.getColor(context, p0.common_tplink_teal));
        obtainStyledAttributes.recycle();
    }

    private int g(int i, boolean z) {
        int i2;
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (z) {
            i3 = getPaddingLeft();
            i2 = getPaddingRight();
        } else {
            i3 = getPaddingTop();
            i2 = getPaddingBottom();
        }
        int i4 = i3 + i2;
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumWidth = (z ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight()) + i4;
        if (mode != Integer.MIN_VALUE) {
            return suggestedMinimumWidth;
        }
        if (z) {
            return Math.max(suggestedMinimumWidth, size);
        }
        return Math.min(suggestedMinimumWidth, size);
    }

    private void h() {
        float sin = (float) (this.q * Math.sin(Math.toRadians(this.y / 2.0d)));
        float cos = (float) (this.q * Math.cos(Math.toRadians(this.y / 2.0d)));
        float sin2 = (float) (this.f12133f * Math.sin(Math.toRadians(this.y / 2.0d)));
        float cos2 = (float) (this.f12133f * Math.cos(Math.toRadians(this.y / 2.0d)));
        float sin3 = (float) (this.x * Math.sin(Math.toRadians(this.y / 2.0d)));
        float cos3 = (float) (this.x * Math.cos(Math.toRadians(this.y / 2.0d)));
        a aVar = this.K3;
        a aVar2 = this.J3;
        aVar.a = aVar2.a - sin;
        aVar.f12134b = aVar2.f12134b + cos;
        a aVar3 = this.L3;
        aVar3.a = (aVar2.a - sin) + cos2;
        aVar3.f12134b = aVar2.f12134b + cos + sin2;
        a aVar4 = this.M3;
        aVar4.a = ((aVar2.a - sin) + cos2) - cos3;
        aVar4.f12134b = ((aVar2.f12134b + cos) + sin2) - sin3;
        a aVar5 = this.N3;
        aVar5.a = (aVar2.a - sin) + cos2 + sin3;
        aVar5.f12134b = ((aVar2.f12134b + cos) + sin2) - cos3;
        a aVar6 = this.O3;
        aVar6.a = aVar2.a + cos2;
        aVar6.f12134b = aVar2.f12134b + sin2;
        a aVar7 = this.P3;
        aVar7.a = aVar2.a - cos2;
        aVar7.f12134b = aVar2.f12134b + sin2;
        a aVar8 = this.Q3;
        aVar8.a = (aVar2.a + sin) - cos2;
        aVar8.f12134b = aVar2.f12134b + cos + sin2;
        a aVar9 = this.R3;
        aVar9.a = ((aVar2.a + sin) - cos2) - sin3;
        aVar9.f12134b = ((aVar2.f12134b + cos) + sin2) - cos3;
        a aVar10 = this.S3;
        aVar10.a = ((aVar2.a + sin) - cos2) + cos3;
        aVar10.f12134b = ((aVar2.f12134b + cos) + sin2) - sin3;
        a aVar11 = this.T3;
        aVar11.a = aVar2.a + sin;
        aVar11.f12134b = aVar2.f12134b + cos;
    }

    public void a() {
        int i = this.H3;
        if (i < 10) {
            if (i < 5) {
                this.y += this.p0;
                this.J3.f12134b += this.p1;
            } else {
                this.y -= this.p0;
                this.J3.f12134b -= this.p1;
            }
            h();
            this.H3++;
        } else {
            this.H3 = 0;
        }
        postInvalidateDelayed(this.z);
    }

    protected void b(Canvas canvas) {
        Path path = new Path();
        if (this.J3 == null) {
            f();
        }
        a aVar = this.J3;
        path.moveTo(aVar.a, aVar.f12134b);
        a aVar2 = this.K3;
        path.lineTo(aVar2.a, aVar2.f12134b);
        a aVar3 = this.M3;
        path.lineTo(aVar3.a, aVar3.f12134b);
        a aVar4 = this.M3;
        float f2 = aVar4.a;
        a aVar5 = this.N3;
        float f3 = aVar5.a;
        a aVar6 = this.L3;
        float f4 = aVar4.f12134b;
        float f5 = aVar5.f12134b;
        path.quadTo((((f2 + f3) / 2.0f) + aVar6.a) / 2.0f, (((f4 + f5) / 2.0f) + aVar6.f12134b) / 2.0f, f3, f5);
        a aVar7 = this.O3;
        path.lineTo(aVar7.a, aVar7.f12134b);
        path.close();
        canvas.drawPath(path, this.I3);
        Path path2 = new Path();
        a aVar8 = this.J3;
        path2.moveTo(aVar8.a, aVar8.f12134b);
        a aVar9 = this.P3;
        path2.lineTo(aVar9.a, aVar9.f12134b);
        a aVar10 = this.R3;
        path2.lineTo(aVar10.a, aVar10.f12134b);
        a aVar11 = this.R3;
        float f6 = aVar11.a;
        a aVar12 = this.S3;
        float f7 = aVar12.a;
        a aVar13 = this.Q3;
        float f8 = aVar11.f12134b;
        float f9 = aVar12.f12134b;
        path2.quadTo((((f6 + f7) / 2.0f) + aVar13.a) / 2.0f, (((f8 + f9) / 2.0f) + aVar13.f12134b) / 2.0f, f7, f9);
        a aVar14 = this.T3;
        path2.lineTo(aVar14.a, aVar14.f12134b);
        path2.close();
        canvas.drawPath(path2, this.I3);
    }

    protected void e() {
        Paint paint = new Paint();
        this.I3 = paint;
        paint.setAntiAlias(true);
        this.I3.setStyle(Paint.Style.FILL);
        this.I3.setColor(this.U3);
    }

    protected void f() {
        float sin = (float) (this.q * Math.sin(Math.toRadians(this.y / 2.0d)));
        float cos = (float) (this.q * Math.cos(Math.toRadians(this.y / 2.0d)));
        float sin2 = (float) (this.f12133f * Math.sin(Math.toRadians(this.y / 2.0d)));
        float cos2 = (float) (this.f12133f * Math.cos(Math.toRadians(this.y / 2.0d)));
        float sin3 = (float) (this.x * Math.sin(Math.toRadians(this.y / 2.0d)));
        float cos3 = (float) (this.x * Math.cos(Math.toRadians(this.y / 2.0d)));
        a aVar = new a(this.f12131c, this.f12132d * 0.4f);
        this.J3 = aVar;
        this.K3 = new a(aVar.a - sin, aVar.f12134b + cos);
        a aVar2 = this.J3;
        this.L3 = new a((aVar2.a - sin) + cos2, aVar2.f12134b + cos + sin2);
        a aVar3 = this.J3;
        this.M3 = new a(((aVar3.a - sin) + cos2) - cos3, ((aVar3.f12134b + cos) + sin2) - sin3);
        a aVar4 = this.J3;
        this.N3 = new a((aVar4.a - sin) + cos2 + sin3, ((aVar4.f12134b + cos) + sin2) - cos3);
        a aVar5 = this.J3;
        this.O3 = new a(aVar5.a + cos2, aVar5.f12134b + sin2);
        a aVar6 = this.J3;
        this.P3 = new a(aVar6.a - cos2, aVar6.f12134b + sin2);
        a aVar7 = this.J3;
        this.Q3 = new a((aVar7.a + sin) - cos2, aVar7.f12134b + cos + sin2);
        a aVar8 = this.J3;
        this.R3 = new a(((aVar8.a + sin) - cos2) - sin3, ((aVar8.f12134b + cos) + sin2) - cos3);
        a aVar9 = this.J3;
        this.S3 = new a(((aVar9.a + sin) - cos2) + cos3, ((aVar9.f12134b + cos) + sin2) - sin3);
        a aVar10 = this.J3;
        this.T3 = new a(aVar10.a + sin, aVar10.f12134b + cos);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.p2) {
            this.p2 = false;
            c();
        }
        b(canvas);
        if (this.p3) {
            a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(g(i, true), g(i2, false));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f12131c = bundle.getFloat("x");
            this.f12132d = bundle.getFloat("y");
            this.f12133f = bundle.getFloat("rect_radius_width");
            this.q = bundle.getFloat("rect_radius_height");
            this.x = bundle.getFloat("small_rect_height");
            this.y = bundle.getDouble("angle");
            this.p2 = bundle.getBoolean("is_first");
            this.p3 = bundle.getBoolean("is_animating");
            this.H3 = bundle.getInt("count");
            super.onRestoreInstanceState(bundle.getParcelable("instance_state"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instance_state", super.onSaveInstanceState());
        bundle.putFloat("x", this.f12131c);
        bundle.putFloat("y", this.f12132d);
        bundle.putFloat("rect_radius_width", this.f12133f);
        bundle.putFloat("rect_radius_height", this.q);
        bundle.putFloat("small_rect_height", this.x);
        bundle.putDouble("angle", this.y);
        bundle.putBoolean("is_first", this.p2);
        bundle.putBoolean("is_animating", this.p3);
        bundle.putInt("count", this.H3);
        return bundle;
    }

    public TPLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TPLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12131c = 550.0f;
        this.f12132d = 550.0f;
        this.f12133f = 50.0f;
        this.q = 110.0f;
        this.x = 10.0f;
        this.p2 = true;
        this.p3 = false;
        this.H3 = 0;
        this.U3 = -1;
        d(context, attributeSet);
        e();
    }
}
