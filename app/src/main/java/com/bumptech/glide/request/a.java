package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.h;
import com.bumptech.glide.request.a;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.Map;

/* compiled from: BaseRequestOptions.java */
/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private boolean I3;
    @Nullable
    private Drawable K3;
    private int L3;
    private boolean P3;
    @Nullable
    private Resources.Theme Q3;
    private boolean R3;
    private boolean S3;
    private boolean T3;
    private boolean V3;

    /* renamed from: c  reason: collision with root package name */
    private int f1714c;
    private int p0;
    @Nullable
    private Drawable x;
    private int y;
    @Nullable
    private Drawable z;

    /* renamed from: d  reason: collision with root package name */
    private float f1715d = 1.0f;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private j f1716f = j.f1462e;
    @NonNull
    private Priority q = Priority.NORMAL;
    private boolean p1 = true;
    private int p2 = -1;
    private int p3 = -1;
    @NonNull
    private c H3 = com.bumptech.glide.o.a.c();
    private boolean J3 = true;
    @NonNull
    private f M3 = new f();
    @NonNull
    private Map<Class<?>, i<?>> N3 = new CachedHashCodeArrayMap();
    @NonNull
    private Class<?> O3 = Object.class;
    private boolean U3 = true;

    private boolean I(int i) {
        return J(this.f1714c, i);
    }

    private static boolean J(int i, int i2) {
        return (i & i2) != 0;
    }

    @NonNull
    private T S(@NonNull DownsampleStrategy downsampleStrategy, @NonNull i<Bitmap> iVar) {
        return Y(downsampleStrategy, iVar, false);
    }

    @NonNull
    private T X(@NonNull DownsampleStrategy downsampleStrategy, @NonNull i<Bitmap> iVar) {
        return Y(downsampleStrategy, iVar, true);
    }

    @NonNull
    private T Y(@NonNull DownsampleStrategy downsampleStrategy, @NonNull i<Bitmap> iVar, boolean z) {
        T t;
        if (z) {
            t = h0(downsampleStrategy, iVar);
        } else {
            t = T(downsampleStrategy, iVar);
        }
        t.U3 = true;
        return t;
    }

    private T Z() {
        return this;
    }

    @Nullable
    public final Resources.Theme A() {
        return this.Q3;
    }

    @NonNull
    public final Map<Class<?>, i<?>> B() {
        return this.N3;
    }

    public final boolean C() {
        return this.V3;
    }

    public final boolean D() {
        return this.S3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean E() {
        return this.R3;
    }

    public final boolean F() {
        return this.p1;
    }

    public final boolean G() {
        return I(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H() {
        return this.U3;
    }

    public final boolean K() {
        return this.J3;
    }

    public final boolean L() {
        return this.I3;
    }

    public final boolean M() {
        return I(2048);
    }

    public final boolean N() {
        return com.bumptech.glide.util.j.u(this.p3, this.p2);
    }

    @NonNull
    public T O() {
        this.P3 = true;
        return Z();
    }

    @NonNull
    @CheckResult
    public T P() {
        return T(DownsampleStrategy.f1618e, new com.bumptech.glide.load.resource.bitmap.i());
    }

    @NonNull
    @CheckResult
    public T Q() {
        return S(DownsampleStrategy.f1617d, new com.bumptech.glide.load.resource.bitmap.j());
    }

    @NonNull
    @CheckResult
    public T R() {
        return S(DownsampleStrategy.f1616c, new o());
    }

    @NonNull
    final T T(@NonNull DownsampleStrategy downsampleStrategy, @NonNull i<Bitmap> iVar) {
        if (this.R3) {
            return (T) clone().T(downsampleStrategy, iVar);
        }
        h(downsampleStrategy);
        return g0(iVar, false);
    }

    @NonNull
    @CheckResult
    public T U(int i, int i2) {
        if (this.R3) {
            return (T) clone().U(i, i2);
        }
        this.p3 = i;
        this.p2 = i2;
        this.f1714c |= 512;
        return a0();
    }

    @NonNull
    @CheckResult
    public T V(@DrawableRes int i) {
        if (this.R3) {
            return (T) clone().V(i);
        }
        this.p0 = i;
        int i2 = this.f1714c | 128;
        this.f1714c = i2;
        this.z = null;
        this.f1714c = i2 & (-65);
        return a0();
    }

    @NonNull
    @CheckResult
    public T W(@NonNull Priority priority) {
        if (this.R3) {
            return (T) clone().W(priority);
        }
        this.q = (Priority) com.bumptech.glide.util.i.d(priority);
        this.f1714c |= 8;
        return a0();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull a<?> aVar) {
        if (this.R3) {
            return (T) clone().a(aVar);
        }
        if (J(aVar.f1714c, 2)) {
            this.f1715d = aVar.f1715d;
        }
        if (J(aVar.f1714c, 262144)) {
            this.S3 = aVar.S3;
        }
        if (J(aVar.f1714c, 1048576)) {
            this.V3 = aVar.V3;
        }
        if (J(aVar.f1714c, 4)) {
            this.f1716f = aVar.f1716f;
        }
        if (J(aVar.f1714c, 8)) {
            this.q = aVar.q;
        }
        if (J(aVar.f1714c, 16)) {
            this.x = aVar.x;
            this.y = 0;
            this.f1714c &= -33;
        }
        if (J(aVar.f1714c, 32)) {
            this.y = aVar.y;
            this.x = null;
            this.f1714c &= -17;
        }
        if (J(aVar.f1714c, 64)) {
            this.z = aVar.z;
            this.p0 = 0;
            this.f1714c &= -129;
        }
        if (J(aVar.f1714c, 128)) {
            this.p0 = aVar.p0;
            this.z = null;
            this.f1714c &= -65;
        }
        if (J(aVar.f1714c, 256)) {
            this.p1 = aVar.p1;
        }
        if (J(aVar.f1714c, 512)) {
            this.p3 = aVar.p3;
            this.p2 = aVar.p2;
        }
        if (J(aVar.f1714c, 1024)) {
            this.H3 = aVar.H3;
        }
        if (J(aVar.f1714c, 4096)) {
            this.O3 = aVar.O3;
        }
        if (J(aVar.f1714c, 8192)) {
            this.K3 = aVar.K3;
            this.L3 = 0;
            this.f1714c &= -16385;
        }
        if (J(aVar.f1714c, 16384)) {
            this.L3 = aVar.L3;
            this.K3 = null;
            this.f1714c &= -8193;
        }
        if (J(aVar.f1714c, 32768)) {
            this.Q3 = aVar.Q3;
        }
        if (J(aVar.f1714c, 65536)) {
            this.J3 = aVar.J3;
        }
        if (J(aVar.f1714c, 131072)) {
            this.I3 = aVar.I3;
        }
        if (J(aVar.f1714c, 2048)) {
            this.N3.putAll(aVar.N3);
            this.U3 = aVar.U3;
        }
        if (J(aVar.f1714c, 524288)) {
            this.T3 = aVar.T3;
        }
        if (!this.J3) {
            this.N3.clear();
            int i = this.f1714c & (-2049);
            this.f1714c = i;
            this.I3 = false;
            this.f1714c = i & (-131073);
            this.U3 = true;
        }
        this.f1714c |= aVar.f1714c;
        this.M3.d(aVar.M3);
        return a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public final T a0() {
        if (!this.P3) {
            return Z();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    public T b() {
        if (!this.P3 || this.R3) {
            this.R3 = true;
            return O();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    @NonNull
    @CheckResult
    public <Y> T b0(@NonNull e<Y> eVar, @NonNull Y y) {
        if (this.R3) {
            return (T) clone().b0(eVar, y);
        }
        com.bumptech.glide.util.i.d(eVar);
        com.bumptech.glide.util.i.d(y);
        this.M3.e(eVar, y);
        return a0();
    }

    @NonNull
    @CheckResult
    public T c() {
        return h0(DownsampleStrategy.f1618e, new com.bumptech.glide.load.resource.bitmap.i());
    }

    @NonNull
    @CheckResult
    public T c0(@NonNull c cVar) {
        if (this.R3) {
            return (T) clone().c0(cVar);
        }
        this.H3 = (c) com.bumptech.glide.util.i.d(cVar);
        this.f1714c |= 1024;
        return a0();
    }

    @CheckResult
    /* renamed from: d */
    public T clone() {
        try {
            T t = (T) ((a) super.clone());
            f fVar = new f();
            t.M3 = fVar;
            fVar.d(this.M3);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.N3 = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.N3);
            t.P3 = false;
            t.R3 = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    @CheckResult
    public T d0(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.R3) {
            return (T) clone().d0(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f1715d = f2;
        this.f1714c |= 2;
        return a0();
    }

    @NonNull
    @CheckResult
    public T e(@NonNull Class<?> cls) {
        if (this.R3) {
            return (T) clone().e(cls);
        }
        this.O3 = (Class) com.bumptech.glide.util.i.d(cls);
        this.f1714c |= 4096;
        return a0();
    }

    @NonNull
    @CheckResult
    public T e0(boolean z) {
        if (this.R3) {
            return (T) clone().e0(true);
        }
        this.p1 = !z;
        this.f1714c |= 256;
        return a0();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(aVar.f1715d, this.f1715d) == 0 && this.y == aVar.y && com.bumptech.glide.util.j.d(this.x, aVar.x) && this.p0 == aVar.p0 && com.bumptech.glide.util.j.d(this.z, aVar.z) && this.L3 == aVar.L3 && com.bumptech.glide.util.j.d(this.K3, aVar.K3) && this.p1 == aVar.p1 && this.p2 == aVar.p2 && this.p3 == aVar.p3 && this.I3 == aVar.I3 && this.J3 == aVar.J3 && this.S3 == aVar.S3 && this.T3 == aVar.T3 && this.f1716f.equals(aVar.f1716f) && this.q == aVar.q && this.M3.equals(aVar.M3) && this.N3.equals(aVar.N3) && this.O3.equals(aVar.O3) && com.bumptech.glide.util.j.d(this.H3, aVar.H3) && com.bumptech.glide.util.j.d(this.Q3, aVar.Q3);
    }

    @NonNull
    @CheckResult
    public T f(@NonNull j jVar) {
        if (this.R3) {
            return (T) clone().f(jVar);
        }
        this.f1716f = (j) com.bumptech.glide.util.i.d(jVar);
        this.f1714c |= 4;
        return a0();
    }

    @NonNull
    @CheckResult
    public T f0(@NonNull i<Bitmap> iVar) {
        return g0(iVar, true);
    }

    @NonNull
    @CheckResult
    public T g() {
        return b0(h.f1684b, Boolean.TRUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T g0(@NonNull i<Bitmap> iVar, boolean z) {
        if (this.R3) {
            return (T) clone().g0(iVar, z);
        }
        m mVar = new m(iVar, z);
        i0(Bitmap.class, iVar, z);
        i0(Drawable.class, mVar, z);
        i0(BitmapDrawable.class, mVar.c(), z);
        i0(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(iVar), z);
        return a0();
    }

    @NonNull
    @CheckResult
    public T h(@NonNull DownsampleStrategy downsampleStrategy) {
        return b0(DownsampleStrategy.h, com.bumptech.glide.util.i.d(downsampleStrategy));
    }

    @NonNull
    @CheckResult
    final T h0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull i<Bitmap> iVar) {
        if (this.R3) {
            return (T) clone().h0(downsampleStrategy, iVar);
        }
        h(downsampleStrategy);
        return f0(iVar);
    }

    public int hashCode() {
        return com.bumptech.glide.util.j.p(this.Q3, com.bumptech.glide.util.j.p(this.H3, com.bumptech.glide.util.j.p(this.O3, com.bumptech.glide.util.j.p(this.N3, com.bumptech.glide.util.j.p(this.M3, com.bumptech.glide.util.j.p(this.q, com.bumptech.glide.util.j.p(this.f1716f, com.bumptech.glide.util.j.q(this.T3, com.bumptech.glide.util.j.q(this.S3, com.bumptech.glide.util.j.q(this.J3, com.bumptech.glide.util.j.q(this.I3, com.bumptech.glide.util.j.o(this.p3, com.bumptech.glide.util.j.o(this.p2, com.bumptech.glide.util.j.q(this.p1, com.bumptech.glide.util.j.p(this.K3, com.bumptech.glide.util.j.o(this.L3, com.bumptech.glide.util.j.p(this.z, com.bumptech.glide.util.j.o(this.p0, com.bumptech.glide.util.j.p(this.x, com.bumptech.glide.util.j.o(this.y, com.bumptech.glide.util.j.l(this.f1715d)))))))))))))))))))));
    }

    @NonNull
    <Y> T i0(@NonNull Class<Y> cls, @NonNull i<Y> iVar, boolean z) {
        if (this.R3) {
            return (T) clone().i0(cls, iVar, z);
        }
        com.bumptech.glide.util.i.d(cls);
        com.bumptech.glide.util.i.d(iVar);
        this.N3.put(cls, iVar);
        int i = this.f1714c | 2048;
        this.f1714c = i;
        this.J3 = true;
        int i2 = i | 65536;
        this.f1714c = i2;
        this.U3 = false;
        if (z) {
            this.f1714c = i2 | 131072;
            this.I3 = true;
        }
        return a0();
    }

    @NonNull
    @CheckResult
    public T j(@DrawableRes int i) {
        if (this.R3) {
            return (T) clone().j(i);
        }
        this.y = i;
        int i2 = this.f1714c | 32;
        this.f1714c = i2;
        this.x = null;
        this.f1714c = i2 & (-17);
        return a0();
    }

    @NonNull
    @CheckResult
    public T j0(@NonNull i<Bitmap>... iVarArr) {
        if (iVarArr.length > 1) {
            return g0(new d(iVarArr), true);
        }
        if (iVarArr.length == 1) {
            return f0(iVarArr[0]);
        }
        return a0();
    }

    @NonNull
    @CheckResult
    public T k() {
        return X(DownsampleStrategy.f1616c, new o());
    }

    @NonNull
    @CheckResult
    public T k0(boolean z) {
        if (this.R3) {
            return (T) clone().k0(z);
        }
        this.V3 = z;
        this.f1714c |= 1048576;
        return a0();
    }

    @NonNull
    public final j l() {
        return this.f1716f;
    }

    public final int m() {
        return this.y;
    }

    @Nullable
    public final Drawable n() {
        return this.x;
    }

    @Nullable
    public final Drawable o() {
        return this.K3;
    }

    public final int p() {
        return this.L3;
    }

    public final boolean q() {
        return this.T3;
    }

    @NonNull
    public final f r() {
        return this.M3;
    }

    public final int s() {
        return this.p2;
    }

    public final int t() {
        return this.p3;
    }

    @Nullable
    public final Drawable u() {
        return this.z;
    }

    public final int v() {
        return this.p0;
    }

    @NonNull
    public final Priority w() {
        return this.q;
    }

    @NonNull
    public final Class<?> x() {
        return this.O3;
    }

    @NonNull
    public final c y() {
        return this.H3;
    }

    public final float z() {
        return this.f1715d;
    }
}
