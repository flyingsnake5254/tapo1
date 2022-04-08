package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.b;
import com.bumptech.glide.request.c;
import com.bumptech.glide.request.d;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.i;
import com.bumptech.glide.request.k.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class h<TranscodeType> extends com.bumptech.glide.request.a<h<TranscodeType>> implements Cloneable {
    protected static final g W3 = new g().f(j.f1460c).W(Priority.LOW).e0(true);
    private final Context X3;
    private final i Y3;
    private final Class<TranscodeType> Z3;
    private final c a4;
    private final e b4;
    @NonNull
    private j<?, ? super TranscodeType> c4;
    @Nullable
    private Object d4;
    @Nullable
    private List<f<TranscodeType>> e4;
    @Nullable
    private h<TranscodeType> f4;
    @Nullable
    private h<TranscodeType> g4;
    @Nullable
    private Float h4;
    private boolean i4 = true;
    private boolean j4;
    private boolean k4;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RequestBuilder.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1296b;

        static {
            int[] iArr = new int[Priority.values().length];
            f1296b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1296b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1296b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1296b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public h(@NonNull c cVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.a4 = cVar;
        this.Y3 = iVar;
        this.Z3 = cls;
        this.X3 = context;
        this.c4 = iVar.p(cls);
        this.b4 = cVar.i();
        s0(iVar.n());
        a(iVar.o());
    }

    @NonNull
    private h<TranscodeType> C0(@Nullable Object obj) {
        if (E()) {
            return d().C0(obj);
        }
        this.d4 = obj;
        this.j4 = true;
        return a0();
    }

    private d D0(Object obj, com.bumptech.glide.request.k.j<TranscodeType> jVar, f<TranscodeType> fVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar2, Priority priority, int i, int i2, Executor executor) {
        Context context = this.X3;
        e eVar = this.b4;
        return i.v(context, eVar, obj, this.d4, this.Z3, aVar, i, i2, priority, jVar, fVar, this.e4, requestCoordinator, eVar.f(), jVar2.b(), executor);
    }

    private d n0(com.bumptech.glide.request.k.j<TranscodeType> jVar, @Nullable f<TranscodeType> fVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return o0(new Object(), jVar, fVar, null, this.c4, aVar.w(), aVar.t(), aVar.s(), aVar, executor);
    }

    private d o0(Object obj, com.bumptech.glide.request.k.j<TranscodeType> jVar, @Nullable f<TranscodeType> fVar, @Nullable RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar2, Priority priority, int i, int i2, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        b bVar;
        b bVar2;
        if (this.g4 != null) {
            bVar2 = new b(obj, requestCoordinator);
            bVar = bVar2;
        } else {
            bVar = null;
            bVar2 = requestCoordinator;
        }
        d p0 = p0(obj, jVar, fVar, bVar2, jVar2, priority, i, i2, aVar, executor);
        if (bVar == null) {
            return p0;
        }
        int t = this.g4.t();
        int s = this.g4.s();
        if (com.bumptech.glide.util.j.u(i, i2) && !this.g4.N()) {
            t = aVar.t();
            s = aVar.s();
        }
        h<TranscodeType> hVar = this.g4;
        bVar.m(p0, hVar.o0(obj, jVar, fVar, bVar, hVar.c4, hVar.w(), t, s, this.g4, executor));
        return bVar;
    }

    private d p0(Object obj, com.bumptech.glide.request.k.j<TranscodeType> jVar, f<TranscodeType> fVar, @Nullable RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar2, Priority priority, int i, int i2, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        Priority priority2;
        h<TranscodeType> hVar = this.f4;
        if (hVar != null) {
            if (!this.k4) {
                j<?, ? super TranscodeType> jVar3 = hVar.i4 ? jVar2 : hVar.c4;
                if (hVar.G()) {
                    priority2 = this.f4.w();
                } else {
                    priority2 = r0(priority);
                }
                int t = this.f4.t();
                int s = this.f4.s();
                if (com.bumptech.glide.util.j.u(i, i2) && !this.f4.N()) {
                    t = aVar.t();
                    s = aVar.s();
                }
                com.bumptech.glide.request.j jVar4 = new com.bumptech.glide.request.j(obj, requestCoordinator);
                d D0 = D0(obj, jVar, fVar, aVar, jVar4, jVar2, priority, i, i2, executor);
                this.k4 = true;
                h<TranscodeType> hVar2 = this.f4;
                d o0 = hVar2.o0(obj, jVar, fVar, jVar4, jVar3, priority2, t, s, hVar2, executor);
                this.k4 = false;
                jVar4.l(D0, o0);
                return jVar4;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.h4 == null) {
            return D0(obj, jVar, fVar, aVar, requestCoordinator, jVar2, priority, i, i2, executor);
        } else {
            com.bumptech.glide.request.j jVar5 = new com.bumptech.glide.request.j(obj, requestCoordinator);
            jVar5.l(D0(obj, jVar, fVar, aVar, jVar5, jVar2, priority, i, i2, executor), D0(obj, jVar, fVar, aVar.clone().d0(this.h4.floatValue()), jVar5, jVar2, r0(priority), i, i2, executor));
            return jVar5;
        }
    }

    @NonNull
    private Priority r0(@NonNull Priority priority) {
        int i = a.f1296b[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + w());
    }

    @SuppressLint({"CheckResult"})
    private void s0(List<f<Object>> list) {
        for (f<Object> fVar : list) {
            l0(fVar);
        }
    }

    private <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y v0(@NonNull Y y, @Nullable f<TranscodeType> fVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        com.bumptech.glide.util.i.d(y);
        if (this.j4) {
            d n0 = n0(y, fVar, aVar, executor);
            d c2 = y.c();
            if (!n0.g(c2) || y0(aVar, c2)) {
                this.Y3.m(y);
                y.f(n0);
                this.Y3.y(y, n0);
                return y;
            }
            if (!((d) com.bumptech.glide.util.i.d(c2)).isRunning()) {
                c2.begin();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean y0(com.bumptech.glide.request.a<?> aVar, d dVar) {
        return !aVar.F() && dVar.isComplete();
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> A0(@Nullable Object obj) {
        return C0(obj);
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> B0(@Nullable String str) {
        return C0(str);
    }

    @NonNull
    public c<TranscodeType> E0() {
        return F0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public c<TranscodeType> F0(int i, int i2) {
        e eVar = new e(i, i2);
        return (c) w0(eVar, eVar, com.bumptech.glide.util.d.a());
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> l0(@Nullable f<TranscodeType> fVar) {
        if (E()) {
            return d().l0(fVar);
        }
        if (fVar != null) {
            if (this.e4 == null) {
                this.e4 = new ArrayList();
            }
            this.e4.add(fVar);
        }
        return a0();
    }

    @NonNull
    @CheckResult
    /* renamed from: m0 */
    public h<TranscodeType> a(@NonNull com.bumptech.glide.request.a<?> aVar) {
        com.bumptech.glide.util.i.d(aVar);
        return (h) super.a(aVar);
    }

    @CheckResult
    /* renamed from: q0 */
    public h<TranscodeType> d() {
        h<TranscodeType> hVar = (h) super.clone();
        hVar.c4 = hVar.c4.clone();
        if (hVar.e4 != null) {
            hVar.e4 = new ArrayList(hVar.e4);
        }
        h<TranscodeType> hVar2 = hVar.f4;
        if (hVar2 != null) {
            hVar.f4 = hVar2.d();
        }
        h<TranscodeType> hVar3 = hVar.g4;
        if (hVar3 != null) {
            hVar.g4 = hVar3.d();
        }
        return hVar;
    }

    @Deprecated
    public c<TranscodeType> t0(int i, int i2) {
        return F0(i, i2);
    }

    @NonNull
    public <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y u0(@NonNull Y y) {
        return (Y) w0(y, null, com.bumptech.glide.util.d.b());
    }

    @NonNull
    <Y extends com.bumptech.glide.request.k.j<TranscodeType>> Y w0(@NonNull Y y, @Nullable f<TranscodeType> fVar, Executor executor) {
        return (Y) v0(y, fVar, this, executor);
    }

    @NonNull
    public k<ImageView, TranscodeType> x0(@NonNull ImageView imageView) {
        h<TranscodeType> hVar;
        com.bumptech.glide.util.j.b();
        com.bumptech.glide.util.i.d(imageView);
        if (!M() && K() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    hVar = clone().P();
                    break;
                case 2:
                    hVar = clone().Q();
                    break;
                case 3:
                case 4:
                case 5:
                    hVar = clone().R();
                    break;
                case 6:
                    hVar = clone().Q();
                    break;
            }
            return (k) v0(this.b4.a(imageView, this.Z3), null, hVar, com.bumptech.glide.util.d.b());
        }
        hVar = this;
        return (k) v0(this.b4.a(imageView, this.Z3), null, hVar, com.bumptech.glide.util.d.b());
    }

    @NonNull
    @CheckResult
    public h<TranscodeType> z0(@Nullable File file) {
        return C0(file);
    }
}
