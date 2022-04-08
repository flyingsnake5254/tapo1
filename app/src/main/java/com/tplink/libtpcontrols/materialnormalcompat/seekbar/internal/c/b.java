package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;

/* compiled from: MarkerDrawable.java */
/* loaded from: classes3.dex */
public class b extends c implements Animatable {
    private float H3;
    private int I3;
    private int J3;
    private int K3;
    private AbstractC0253b O3;
    private float p3;
    private long z;
    private float x = 0.0f;
    private boolean p0 = false;
    private boolean p1 = false;
    private int p2 = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    Path L3 = new Path();
    RectF M3 = new RectF();
    Matrix N3 = new Matrix();
    private final Runnable P3 = new a();
    private Interpolator y = new AccelerateDecelerateInterpolator();

    /* compiled from: MarkerDrawable.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = uptimeMillis - b.this.z;
            if (j < b.this.p2) {
                float interpolation = b.this.y.getInterpolation(((float) j) / b.this.p2);
                b bVar = b.this;
                bVar.scheduleSelf(bVar.P3, uptimeMillis + 16);
                b.this.u(interpolation);
                return;
            }
            b bVar2 = b.this;
            bVar2.unscheduleSelf(bVar2.P3);
            b.this.p1 = false;
            b.this.u(1.0f);
            b.this.q();
        }
    }

    /* compiled from: MarkerDrawable.java */
    /* renamed from: com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface AbstractC0253b {
        void a();

        void b();
    }

    public b(@NonNull ColorStateList colorStateList, int i) {
        super(colorStateList);
        this.p3 = i;
        this.J3 = colorStateList.getColorForState(new int[]{16842919}, colorStateList.getDefaultColor());
        this.K3 = colorStateList.getDefaultColor();
    }

    private static int n(int i, int i2, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f3)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f3)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f3)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f3)));
    }

    private void o(Rect rect) {
        float f2 = this.x;
        Path path = this.L3;
        RectF rectF = this.M3;
        Matrix matrix = this.N3;
        path.reset();
        int min = Math.min(rect.width(), rect.height());
        float f3 = this.p3;
        float f4 = f3 + ((min - f3) * f2);
        float f5 = f4 / 2.0f;
        float f6 = 1.0f - f2;
        float f7 = f5 * f6;
        float[] fArr = {f5, f5, f5, f5, f5, f5, f7, f7};
        int i = rect.left;
        int i2 = rect.top;
        rectF.set(i, i2, i + f4, i2 + f4);
        path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        matrix.reset();
        matrix.postRotate(-45.0f, rect.left + f5, rect.top + f5);
        matrix.postTranslate((rect.width() - f4) / 2.0f, 0.0f);
        matrix.postTranslate(0.0f, ((rect.bottom - f4) - this.I3) * f6);
        path.transform(matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        AbstractC0253b bVar = this.O3;
        if (bVar == null) {
            return;
        }
        if (this.p0) {
            bVar.a();
        } else {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f2) {
        float f3 = this.H3;
        this.x = f3 + (((this.p0 ? 0.0f : 1.0f) - f3) * f2);
        o(getBounds());
        invalidateSelf();
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.c
    void a(Canvas canvas, Paint paint) {
        if (!this.L3.isEmpty()) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(n(this.J3, this.K3, this.x));
            canvas.drawPath(this.L3, paint);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.p1;
    }

    public void l() {
        this.p0 = true;
        unscheduleSelf(this.P3);
        float f2 = this.x;
        if (f2 > 0.0f) {
            this.p1 = true;
            this.H3 = f2;
            this.p2 = 250 - ((int) ((1.0f - f2) * 250.0f));
            long uptimeMillis = SystemClock.uptimeMillis();
            this.z = uptimeMillis;
            scheduleSelf(this.P3, uptimeMillis + 16);
            return;
        }
        q();
    }

    public void m() {
        unscheduleSelf(this.P3);
        this.p0 = false;
        float f2 = this.x;
        if (f2 < 1.0f) {
            this.p1 = true;
            this.H3 = f2;
            this.p2 = (int) ((1.0f - f2) * 250.0f);
            long uptimeMillis = SystemClock.uptimeMillis();
            this.z = uptimeMillis;
            scheduleSelf(this.P3, uptimeMillis + 16);
            return;
        }
        q();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        o(rect);
    }

    public Path p() {
        return this.L3;
    }

    public void r(int i, int i2) {
        this.J3 = i;
        this.K3 = i2;
    }

    public void s(int i) {
        this.I3 = i;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        unscheduleSelf(this.P3);
    }

    public void t(AbstractC0253b bVar) {
        this.O3 = bVar;
    }
}
