package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

/* compiled from: ValueAnimatorCompat.java */
/* loaded from: classes2.dex */
public class f {
    private final d a;

    /* compiled from: ValueAnimatorCompat.java */
    /* loaded from: classes2.dex */
    class a implements d.b {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.d.b
        public void a() {
            this.a.a(f.this);
        }
    }

    /* compiled from: ValueAnimatorCompat.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(f fVar);
    }

    /* compiled from: ValueAnimatorCompat.java */
    /* loaded from: classes2.dex */
    interface c {
        @NonNull
        f createAnimator();
    }

    /* compiled from: ValueAnimatorCompat.java */
    /* loaded from: classes2.dex */
    static abstract class d {

        /* compiled from: ValueAnimatorCompat.java */
        /* loaded from: classes2.dex */
        interface a {
            void a();

            void onAnimationCancel();

            void onAnimationEnd();
        }

        /* compiled from: ValueAnimatorCompat.java */
        /* loaded from: classes2.dex */
        interface b {
            void a();
        }

        abstract void a(b bVar);

        abstract void b();

        abstract float c();

        abstract boolean d();

        abstract void e(long j);

        abstract void f(float f2, float f3);

        abstract void g(Interpolator interpolator);

        abstract void h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.a = dVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.a.a(new a(bVar));
        } else {
            this.a.a(null);
        }
    }

    public void b() {
        this.a.b();
    }

    public float c() {
        return this.a.c();
    }

    public boolean d() {
        return this.a.d();
    }

    public void e(long j) {
        this.a.e(j);
    }

    public void f(float f2, float f3) {
        this.a.f(f2, f3);
    }

    public void g(Interpolator interpolator) {
        this.a.g(interpolator);
    }

    public void h() {
        this.a.h();
    }
}
