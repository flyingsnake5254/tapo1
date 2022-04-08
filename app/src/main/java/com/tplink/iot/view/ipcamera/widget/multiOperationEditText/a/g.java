package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f;
import java.util.ArrayList;

/* compiled from: ValueAnimatorCompatImplGingerbread.java */
/* loaded from: classes2.dex */
class g extends f.d {
    private static final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private long f9385b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9386c;

    /* renamed from: d  reason: collision with root package name */
    private float f9387d;
    private Interpolator h;
    private ArrayList<f.d.a> i;
    private ArrayList<f.d.b> j;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f9388e = new int[2];

    /* renamed from: f  reason: collision with root package name */
    private final float[] f9389f = new float[2];
    private long g = 200;
    private final Runnable k = new a();

    /* compiled from: ValueAnimatorCompatImplGingerbread.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.o();
        }
    }

    private void i() {
        ArrayList<f.d.a> arrayList = this.i;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.i.get(i).onAnimationCancel();
            }
        }
    }

    private void j() {
        ArrayList<f.d.a> arrayList = this.i;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.i.get(i).onAnimationEnd();
            }
        }
    }

    private void k() {
        ArrayList<f.d.a> arrayList = this.i;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.i.get(i).a();
            }
        }
    }

    private void l() {
        ArrayList<f.d.b> arrayList = this.j;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.j.get(i).a();
            }
        }
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void a(f.d.b bVar) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(bVar);
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void b() {
        this.f9386c = false;
        a.removeCallbacks(this.k);
        i();
        j();
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public float c() {
        float[] fArr = this.f9389f;
        return a.a(fArr[0], fArr[1], m());
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public boolean d() {
        return this.f9386c;
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void e(long j) {
        this.g = j;
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void f(float f2, float f3) {
        float[] fArr = this.f9389f;
        fArr[0] = f2;
        fArr[1] = f3;
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void g(Interpolator interpolator) {
        this.h = interpolator;
    }

    @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d
    public void h() {
        if (!this.f9386c) {
            if (this.h == null) {
                this.h = new AccelerateDecelerateInterpolator();
            }
            this.f9386c = true;
            this.f9387d = 0.0f;
            n();
        }
    }

    public float m() {
        return this.f9387d;
    }

    final void n() {
        this.f9385b = SystemClock.uptimeMillis();
        l();
        k();
        a.postDelayed(this.k, 10L);
    }

    final void o() {
        if (this.f9386c) {
            float a2 = d.a(((float) (SystemClock.uptimeMillis() - this.f9385b)) / ((float) this.g), 0.0f, 1.0f);
            Interpolator interpolator = this.h;
            if (interpolator != null) {
                a2 = interpolator.getInterpolation(a2);
            }
            this.f9387d = a2;
            l();
            if (SystemClock.uptimeMillis() >= this.f9385b + this.g) {
                this.f9386c = false;
                j();
            }
        }
        if (this.f9386c) {
            a.postDelayed(this.k, 10L);
        }
    }
}
