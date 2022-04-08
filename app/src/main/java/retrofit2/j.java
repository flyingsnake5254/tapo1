package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.i;

/* compiled from: KotlinExtensions.kt */
/* loaded from: classes4.dex */
public final class j {

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes4.dex */
    static final class a extends Lambda implements l<Throwable, p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f17591c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(1);
            this.f17591c = bVar;
        }

        public final void a(Throwable th) {
            this.f17591c.cancel();
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(Throwable th) {
            a(th);
            return p.a;
        }
    }

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes4.dex */
    static final class b extends Lambda implements l<Throwable, p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f17592c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(b bVar) {
            super(1);
            this.f17592c = bVar;
        }

        public final void a(Throwable th) {
            this.f17592c.cancel();
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(Throwable th) {
            a(th);
            return p.a;
        }
    }

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes4.dex */
    public static final class c implements d<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.h f17593c;

        c(kotlinx.coroutines.h hVar) {
            this.f17593c = hVar;
        }

        @Override // retrofit2.d
        public void a(b<T> call, Throwable t) {
            kotlin.jvm.internal.j.f(call, "call");
            kotlin.jvm.internal.j.f(t, "t");
            kotlinx.coroutines.h hVar = this.f17593c;
            Result.a aVar = Result.Companion;
            hVar.resumeWith(Result.m1constructorimpl(k.a(t)));
        }

        @Override // retrofit2.d
        public void b(b<T> call, q<T> response) {
            kotlin.jvm.internal.j.f(call, "call");
            kotlin.jvm.internal.j.f(response, "response");
            if (response.e()) {
                Object a = response.a();
                if (a == null) {
                    Object tag = call.request().tag(i.class);
                    if (tag == null) {
                        kotlin.jvm.internal.j.n();
                    }
                    kotlin.jvm.internal.j.b(tag, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((i) tag).a();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Response from ");
                    kotlin.jvm.internal.j.b(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    kotlin.jvm.internal.j.b(declaringClass, "method.declaringClass");
                    sb.append(declaringClass.getName());
                    sb.append('.');
                    sb.append(method.getName());
                    sb.append(" was null but response body type was declared as non-null");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                    kotlinx.coroutines.h hVar = this.f17593c;
                    Result.a aVar = Result.Companion;
                    hVar.resumeWith(Result.m1constructorimpl(k.a(kotlinNullPointerException)));
                    return;
                }
                kotlinx.coroutines.h hVar2 = this.f17593c;
                Result.a aVar2 = Result.Companion;
                hVar2.resumeWith(Result.m1constructorimpl(a));
                return;
            }
            kotlinx.coroutines.h hVar3 = this.f17593c;
            HttpException httpException = new HttpException(response);
            Result.a aVar3 = Result.Companion;
            hVar3.resumeWith(Result.m1constructorimpl(k.a(httpException)));
        }
    }

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes4.dex */
    public static final class d implements d<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.h f17594c;

        d(kotlinx.coroutines.h hVar) {
            this.f17594c = hVar;
        }

        @Override // retrofit2.d
        public void a(b<T> call, Throwable t) {
            kotlin.jvm.internal.j.f(call, "call");
            kotlin.jvm.internal.j.f(t, "t");
            kotlinx.coroutines.h hVar = this.f17594c;
            Result.a aVar = Result.Companion;
            hVar.resumeWith(Result.m1constructorimpl(k.a(t)));
        }

        @Override // retrofit2.d
        public void b(b<T> call, q<T> response) {
            kotlin.jvm.internal.j.f(call, "call");
            kotlin.jvm.internal.j.f(response, "response");
            if (response.e()) {
                kotlinx.coroutines.h hVar = this.f17594c;
                Object a = response.a();
                Result.a aVar = Result.Companion;
                hVar.resumeWith(Result.m1constructorimpl(a));
                return;
            }
            kotlinx.coroutines.h hVar2 = this.f17594c;
            HttpException httpException = new HttpException(response);
            Result.a aVar2 = Result.Companion;
            hVar2.resumeWith(Result.m1constructorimpl(k.a(httpException)));
        }
    }

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes4.dex */
    static final class e extends Lambda implements l<Throwable, p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f17595c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(b bVar) {
            super(1);
            this.f17595c = bVar;
        }

        public final void a(Throwable th) {
            this.f17595c.cancel();
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(Throwable th) {
            a(th);
            return p.a;
        }
    }

    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes4.dex */
    public static final class f implements d<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.h f17596c;

        f(kotlinx.coroutines.h hVar) {
            this.f17596c = hVar;
        }

        @Override // retrofit2.d
        public void a(b<T> call, Throwable t) {
            kotlin.jvm.internal.j.f(call, "call");
            kotlin.jvm.internal.j.f(t, "t");
            kotlinx.coroutines.h hVar = this.f17596c;
            Result.a aVar = Result.Companion;
            hVar.resumeWith(Result.m1constructorimpl(k.a(t)));
        }

        @Override // retrofit2.d
        public void b(b<T> call, q<T> response) {
            kotlin.jvm.internal.j.f(call, "call");
            kotlin.jvm.internal.j.f(response, "response");
            kotlinx.coroutines.h hVar = this.f17596c;
            Result.a aVar = Result.Companion;
            hVar.resumeWith(Result.m1constructorimpl(response));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KotlinExtensions.kt */
    /* loaded from: classes4.dex */
    public static final class g implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.coroutines.c f17597c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Exception f17598d;

        g(kotlin.coroutines.c cVar, Exception exc) {
            this.f17597c = cVar;
            this.f17598d = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kotlin.coroutines.c c2;
            c2 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f17597c);
            Exception exc = this.f17598d;
            Result.a aVar = Result.Companion;
            c2.resumeWith(Result.m1constructorimpl(k.a(exc)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: KotlinExtensions.kt */
    @kotlin.coroutines.jvm.internal.d(c = "retrofit2/KotlinExtensions", f = "KotlinExtensions.kt", l = {112, 119}, m = "suspendAndThrow")
    /* loaded from: classes4.dex */
    public static final class h extends ContinuationImpl {

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f17599c;

        /* renamed from: d  reason: collision with root package name */
        int f17600d;

        /* renamed from: f  reason: collision with root package name */
        Object f17601f;

        h(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f17599c = obj;
            this.f17600d |= Integer.MIN_VALUE;
            return j.d(null, this);
        }
    }

    public static final <T> Object a(b<T> bVar, kotlin.coroutines.c<? super T> cVar) {
        kotlin.coroutines.c c2;
        Object d2;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        i iVar = new i(c2, 1);
        iVar.f(new a(bVar));
        bVar.i(new c(iVar));
        Object q = iVar.q();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (q == d2) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return q;
    }

    public static final <T> Object b(b<T> bVar, kotlin.coroutines.c<? super T> cVar) {
        kotlin.coroutines.c c2;
        Object d2;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        i iVar = new i(c2, 1);
        iVar.f(new b(bVar));
        bVar.i(new d(iVar));
        Object q = iVar.q();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (q == d2) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return q;
    }

    public static final <T> Object c(b<T> bVar, kotlin.coroutines.c<? super q<T>> cVar) {
        kotlin.coroutines.c c2;
        Object d2;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        i iVar = new i(c2, 1);
        iVar.f(new e(bVar));
        bVar.i(new f(iVar));
        Object q = iVar.q();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (q == d2) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return q;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(java.lang.Exception r4, kotlin.coroutines.c<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.j.h
            if (r0 == 0) goto L_0x0013
            r0 = r5
            retrofit2.j$h r0 = (retrofit2.j.h) r0
            int r1 = r0.f17600d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f17600d = r1
            goto L_0x0018
        L_0x0013:
            retrofit2.j$h r0 = new retrofit2.j$h
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f17599c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.f17600d
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.f17601f
            java.lang.Exception r4 = (java.lang.Exception) r4
            boolean r4 = r5 instanceof kotlin.Result.Failure
            if (r4 != 0) goto L_0x002e
            goto L_0x0063
        L_0x002e:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            boolean r2 = r5 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L_0x0066
            r0.f17601f = r4
            r0.f17600d = r3
            kotlinx.coroutines.y r5 = kotlinx.coroutines.n0.a()
            kotlin.coroutines.f r2 = r0.getContext()
            retrofit2.j$g r3 = new retrofit2.j$g
            r3.<init>(r0, r4)
            r5.dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.a.d()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.d()
            if (r4 != r5) goto L_0x0060
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x0060:
            if (r4 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.p r4 = kotlin.p.a
            return r4
        L_0x0066:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.j.d(java.lang.Exception, kotlin.coroutines.c):java.lang.Object");
    }
}
