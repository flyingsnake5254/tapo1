package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;

/* compiled from: OrientationListener.java */
/* loaded from: classes.dex */
final class g implements SensorEventListener {
    private final float[] a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f4041b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final float[] f4042c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    private final float[] f4043d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    private final Display f4044e;

    /* renamed from: f  reason: collision with root package name */
    private final a[] f4045f;
    private boolean g;

    /* compiled from: OrientationListener.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(float[] fArr, float f2);
    }

    public g(Display display, a... aVarArr) {
        this.f4044e = display;
        this.f4045f = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f4041b);
        SensorManager.getOrientation(this.f4041b, this.f4043d);
        return this.f4043d[2];
    }

    private void b(float[] fArr, float f2) {
        for (a aVar : this.f4045f) {
            aVar.a(fArr, f2);
        }
    }

    private void c(float[] fArr) {
        if (!this.g) {
            f.a(this.f4042c, fArr);
            this.g = true;
        }
        float[] fArr2 = this.f4041b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f4041b, 0, this.f4042c, 0);
    }

    private void d(float[] fArr, int i) {
        if (i != 0) {
            int i2 = 130;
            int i3 = 129;
            if (i == 1) {
                i2 = 2;
            } else if (i == 2) {
                i2 = 129;
                i3 = 130;
            } else if (i == 3) {
                i3 = 1;
            } else {
                throw new IllegalStateException();
            }
            float[] fArr2 = this.f4041b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f4041b, i2, i3, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.a, sensorEvent.values);
        d(this.a, this.f4044e.getRotation());
        float a2 = a(this.a);
        e(this.a);
        c(this.a);
        b(this.a, a2);
    }
}
