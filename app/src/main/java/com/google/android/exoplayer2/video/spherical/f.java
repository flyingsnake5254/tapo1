package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.k0;

/* compiled from: FrameRotationQueue.java */
/* loaded from: classes.dex */
final class f {
    private final float[] a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f4038b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final k0<float[]> f4039c = new k0<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f4040d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float sqrt = (float) Math.sqrt((fArr2[10] * fArr2[10]) + (fArr2[8] * fArr2[8]));
        fArr[0] = fArr2[10] / sqrt;
        fArr[2] = fArr2[8] / sqrt;
        fArr[8] = (-fArr2[8]) / sqrt;
        fArr[10] = fArr2[10] / sqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f2 = fArr2[0];
        float f3 = -fArr2[1];
        float f4 = -fArr2[2];
        float length = Matrix.length(f2, f3, f4);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f2 / length, f3 / length, f4 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean c(float[] fArr, long j) {
        float[] j2 = this.f4039c.j(j);
        if (j2 == null) {
            return false;
        }
        b(this.f4038b, j2);
        if (!this.f4040d) {
            a(this.a, this.f4038b);
            this.f4040d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.a, 0, this.f4038b, 0);
        return true;
    }

    public void d() {
        this.f4039c.c();
        this.f4040d = false;
    }

    public void e(long j, float[] fArr) {
        this.f4039c.a(j, fArr);
    }
}
