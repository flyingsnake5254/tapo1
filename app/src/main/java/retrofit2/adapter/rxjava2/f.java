package retrofit2.adapter.rxjava2;

import io.reactivex.w;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxJava2CallAdapter.java */
/* loaded from: classes4.dex */
public final class f<R> implements c<R, Object> {
    private final Type a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final w f17560b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17561c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17562d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17563e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17564f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Type type, @Nullable w wVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = type;
        this.f17560b = wVar;
        this.f17561c = z;
        this.f17562d = z2;
        this.f17563e = z3;
        this.f17564f = z4;
        this.g = z5;
        this.h = z6;
        this.i = z7;
    }

    @Override // retrofit2.c
    public Type a() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // retrofit2.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(retrofit2.b<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.f17561c
            if (r0 == 0) goto L_0x000a
            retrofit2.adapter.rxjava2.b r0 = new retrofit2.adapter.rxjava2.b
            r0.<init>(r2)
            goto L_0x000f
        L_0x000a:
            retrofit2.adapter.rxjava2.c r0 = new retrofit2.adapter.rxjava2.c
            r0.<init>(r2)
        L_0x000f:
            boolean r2 = r1.f17562d
            if (r2 == 0) goto L_0x001a
            retrofit2.adapter.rxjava2.e r2 = new retrofit2.adapter.rxjava2.e
            r2.<init>(r0)
        L_0x0018:
            r0 = r2
            goto L_0x0024
        L_0x001a:
            boolean r2 = r1.f17563e
            if (r2 == 0) goto L_0x0024
            retrofit2.adapter.rxjava2.a r2 = new retrofit2.adapter.rxjava2.a
            r2.<init>(r0)
            goto L_0x0018
        L_0x0024:
            io.reactivex.w r2 = r1.f17560b
            if (r2 == 0) goto L_0x002c
            io.reactivex.q r0 = r0.L0(r2)
        L_0x002c:
            boolean r2 = r1.f17564f
            if (r2 == 0) goto L_0x0037
            io.reactivex.BackpressureStrategy r2 = io.reactivex.BackpressureStrategy.LATEST
            io.reactivex.h r2 = r0.Y0(r2)
            return r2
        L_0x0037:
            boolean r2 = r1.g
            if (r2 == 0) goto L_0x0040
            io.reactivex.x r2 = r0.C0()
            return r2
        L_0x0040:
            boolean r2 = r1.h
            if (r2 == 0) goto L_0x0049
            io.reactivex.m r2 = r0.B0()
            return r2
        L_0x0049:
            boolean r2 = r1.i
            if (r2 == 0) goto L_0x0052
            io.reactivex.a r2 = r0.Z()
            return r2
        L_0x0052:
            io.reactivex.q r2 = io.reactivex.j0.a.n(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.adapter.rxjava2.f.b(retrofit2.b):java.lang.Object");
    }
}
