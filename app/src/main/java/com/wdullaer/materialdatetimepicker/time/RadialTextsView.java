package com.wdullaer.materialdatetimepicker.time;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import com.google.firebase.messaging.ServiceStarter;

/* loaded from: classes3.dex */
public class RadialTextsView extends View {
    private boolean H3;
    private boolean I3;
    private float J3;
    private float K3;
    private float L3;
    private float M3;
    private float N3;
    private float O3;
    private int P3;
    private int Q3;
    private float R3;
    private boolean S3;
    private float T3;
    private float U3;
    private float[] V3;
    private float[] W3;
    private float[] X3;
    private float[] Y3;
    private float Z3;
    private float a4;
    private float b4;
    ObjectAnimator c4;
    ObjectAnimator d4;
    private a e4;
    private Typeface p0;
    private Typeface p1;
    private String[] p2;
    private String[] p3;
    private boolean q;
    private b z;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f15321c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private final Paint f15322d = new Paint();

    /* renamed from: f  reason: collision with root package name */
    private final Paint f15323f = new Paint();
    private int y = -1;
    private boolean x = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        boolean a(int i);
    }

    public RadialTextsView(Context context) {
        super(context);
    }

    private Paint[] a(String[] strArr) {
        Paint[] paintArr = new Paint[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            int parseInt = Integer.parseInt(strArr[i]);
            if (parseInt == this.y) {
                paintArr[i] = this.f15322d;
            } else if (this.z.a(parseInt)) {
                paintArr[i] = this.f15321c;
            } else {
                paintArr[i] = this.f15323f;
            }
        }
        return paintArr;
    }

    private void b(float f2, float f3, float f4, float f5, float[] fArr, float[] fArr2) {
        float sqrt = (((float) Math.sqrt(3.0d)) * f2) / 2.0f;
        float f6 = f2 / 2.0f;
        this.f15321c.setTextSize(f5);
        this.f15322d.setTextSize(f5);
        this.f15323f.setTextSize(f5);
        float descent = f4 - ((this.f15321c.descent() + this.f15321c.ascent()) / 2.0f);
        fArr[0] = descent - f2;
        fArr2[0] = f3 - f2;
        fArr[1] = descent - sqrt;
        fArr2[1] = f3 - sqrt;
        fArr[2] = descent - f6;
        fArr2[2] = f3 - f6;
        fArr[3] = descent;
        fArr2[3] = f3;
        fArr[4] = descent + f6;
        fArr2[4] = f6 + f3;
        fArr[5] = descent + sqrt;
        fArr2[5] = sqrt + f3;
        fArr[6] = descent + f2;
        fArr2[6] = f3 + f2;
    }

    private void c(Canvas canvas, float f2, Typeface typeface, String[] strArr, float[] fArr, float[] fArr2) {
        this.f15321c.setTextSize(f2);
        this.f15321c.setTypeface(typeface);
        Paint[] a2 = a(strArr);
        canvas.drawText(strArr[0], fArr[3], fArr2[0], a2[0]);
        canvas.drawText(strArr[1], fArr[4], fArr2[1], a2[1]);
        canvas.drawText(strArr[2], fArr[5], fArr2[2], a2[2]);
        canvas.drawText(strArr[3], fArr[6], fArr2[3], a2[3]);
        canvas.drawText(strArr[4], fArr[5], fArr2[4], a2[4]);
        canvas.drawText(strArr[5], fArr[4], fArr2[5], a2[5]);
        canvas.drawText(strArr[6], fArr[3], fArr2[6], a2[6]);
        canvas.drawText(strArr[7], fArr[2], fArr2[5], a2[7]);
        canvas.drawText(strArr[8], fArr[1], fArr2[4], a2[8]);
        canvas.drawText(strArr[9], fArr[0], fArr2[3], a2[9]);
        canvas.drawText(strArr[10], fArr[1], fArr2[2], a2[10]);
        canvas.drawText(strArr[11], fArr[2], fArr2[1], a2[11]);
    }

    private void d() {
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.2f, this.a4), Keyframe.ofFloat(1.0f, this.b4)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f))).setDuration((long) ServiceStarter.ERROR_UNKNOWN);
        this.c4 = duration;
        duration.addUpdateListener(this.e4);
        float f2 = (float) ServiceStarter.ERROR_UNKNOWN;
        int i = (int) (1.25f * f2);
        float f3 = (f2 * 0.25f) / i;
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe("animationRadiusMultiplier", Keyframe.ofFloat(0.0f, this.b4), Keyframe.ofFloat(f3, this.b4), Keyframe.ofFloat(1.0f - ((1.0f - f3) * 0.2f), this.a4), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe("alpha", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(f3, 0.0f), Keyframe.ofFloat(1.0f, 1.0f))).setDuration(i);
        this.d4 = duration2;
        duration2.addUpdateListener(this.e4);
    }

    public ObjectAnimator getDisappearAnimator() {
        ObjectAnimator objectAnimator;
        if (this.x && this.q && (objectAnimator = this.c4) != null) {
            return objectAnimator;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }

    public ObjectAnimator getReappearAnimator() {
        ObjectAnimator objectAnimator;
        if (this.x && this.q && (objectAnimator = this.d4) != null) {
            return objectAnimator;
        }
        Log.e("RadialTextsView", "RadialTextView was not ready for animation.");
        return null;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (getWidth() != 0 && this.x) {
            if (!this.q) {
                this.P3 = getWidth() / 2;
                int height = getHeight() / 2;
                this.Q3 = height;
                float min = Math.min(this.P3, height) * this.J3;
                this.R3 = min;
                if (!this.H3) {
                    this.Q3 = (int) (this.Q3 - ((this.K3 * min) * 0.75d));
                }
                this.T3 = this.N3 * min;
                if (this.I3) {
                    this.U3 = min * this.O3;
                }
                d();
                this.S3 = true;
                this.q = true;
            }
            if (this.S3) {
                b(this.R3 * this.L3 * this.Z3, this.P3, this.Q3, this.T3, this.V3, this.W3);
                if (this.I3) {
                    b(this.R3 * this.M3 * this.Z3, this.P3, this.Q3, this.U3, this.X3, this.Y3);
                }
                this.S3 = false;
            }
            c(canvas, this.T3, this.p0, this.p2, this.W3, this.V3);
            if (this.I3) {
                c(canvas, this.U3, this.p1, this.p3, this.Y3, this.X3);
            }
        }
    }

    public void setAnimationRadiusMultiplier(float f2) {
        this.Z3 = f2;
        this.S3 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelection(int i) {
        this.y = i;
    }
}
