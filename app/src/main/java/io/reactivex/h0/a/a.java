package io.reactivex.h0.a;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: Functions.java */
/* loaded from: classes4.dex */
public final class a {
    static final io.reactivex.g0.j<Object, Object> a = new n();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f15634b = new j();

    /* renamed from: c  reason: collision with root package name */
    public static final io.reactivex.g0.a f15635c = new g();

    /* renamed from: d  reason: collision with root package name */
    static final io.reactivex.g0.g<Object> f15636d = new h();

    /* renamed from: e  reason: collision with root package name */
    public static final io.reactivex.g0.g<Throwable> f15637e = new k();

    /* renamed from: f  reason: collision with root package name */
    public static final io.reactivex.g0.g<Throwable> f15638f = new s();
    public static final io.reactivex.g0.k g = new i();
    static final io.reactivex.g0.l<Object> h = new t();
    static final io.reactivex.g0.l<Object> i = new l();
    static final Callable<Object> j = new r();
    static final Comparator<Object> k = new q();
    public static final io.reactivex.g0.g<e.b.c> l = new p();

    /* compiled from: Functions.java */
    /* renamed from: io.reactivex.h0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0292a<T> implements io.reactivex.g0.g<T> {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.g0.a f15639c;

        C0292a(io.reactivex.g0.a aVar) {
            this.f15639c = aVar;
        }

        @Override // io.reactivex.g0.g
        public void accept(T t) throws Exception {
            this.f15639c.run();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class b<T1, T2, R> implements io.reactivex.g0.j<Object[], R> {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.g0.c<? super T1, ? super T2, ? extends R> f15640c;

        b(io.reactivex.g0.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f15640c = cVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return (R) this.f15640c.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class c<T1, T2, T3, R> implements io.reactivex.g0.j<Object[], R> {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.g0.h<T1, T2, T3, R> f15641c;

        c(io.reactivex.g0.h<T1, T2, T3, R> hVar) {
            this.f15641c = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.f15641c.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class d<T1, T2, T3, T4, R> implements io.reactivex.g0.j<Object[], R> {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.g0.i<T1, T2, T3, T4, R> f15642c;

        d(io.reactivex.g0.i<T1, T2, T3, T4, R> iVar) {
            this.f15642c = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.f15642c.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class e<T> implements Callable<List<T>> {

        /* renamed from: c  reason: collision with root package name */
        final int f15643c;

        e(int i) {
            this.f15643c = i;
        }

        /* renamed from: a */
        public List<T> call() throws Exception {
            return new ArrayList(this.f15643c);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class f<T, U> implements io.reactivex.g0.j<T, U> {

        /* renamed from: c  reason: collision with root package name */
        final Class<U> f15644c;

        f(Class<U> cls) {
            this.f15644c = cls;
        }

        @Override // io.reactivex.g0.j
        public U apply(T t) throws Exception {
            return this.f15644c.cast(t);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class g implements io.reactivex.g0.a {
        g() {
        }

        @Override // io.reactivex.g0.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class h implements io.reactivex.g0.g<Object> {
        h() {
        }

        @Override // io.reactivex.g0.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class i implements io.reactivex.g0.k {
        i() {
        }

        @Override // io.reactivex.g0.k
        public void a(long j) {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class k implements io.reactivex.g0.g<Throwable> {
        k() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            io.reactivex.j0.a.r(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class l implements io.reactivex.g0.l<Object> {
        l() {
        }

        @Override // io.reactivex.g0.l
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    enum m implements Callable<Set<Object>> {
        INSTANCE;

        /* renamed from: a */
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class n implements io.reactivex.g0.j<Object, Object> {
        n() {
        }

        @Override // io.reactivex.g0.j
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class o<T, U> implements Callable<U>, io.reactivex.g0.j<T, U> {

        /* renamed from: c  reason: collision with root package name */
        final U f15647c;

        o(U u) {
            this.f15647c = u;
        }

        @Override // io.reactivex.g0.j
        public U apply(T t) throws Exception {
            return this.f15647c;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f15647c;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class p implements io.reactivex.g0.g<e.b.c> {
        p() {
        }

        /* renamed from: a */
        public void accept(e.b.c cVar) throws Exception {
            cVar.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class q implements Comparator<Object> {
        q() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class r implements Callable<Object> {
        r() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class s implements io.reactivex.g0.g<Throwable> {
        s() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            io.reactivex.j0.a.r(new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes4.dex */
    static final class t implements io.reactivex.g0.l<Object> {
        t() {
        }

        @Override // io.reactivex.g0.l
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> io.reactivex.g0.g<T> a(io.reactivex.g0.a aVar) {
        return new C0292a(aVar);
    }

    public static <T> io.reactivex.g0.l<T> b() {
        return (io.reactivex.g0.l<T>) h;
    }

    public static <T, U> io.reactivex.g0.j<T, U> c(Class<U> cls) {
        return new f(cls);
    }

    public static <T> Callable<List<T>> d(int i2) {
        return new e(i2);
    }

    public static <T> Callable<Set<T>> e() {
        return m.INSTANCE;
    }

    public static <T> io.reactivex.g0.g<T> f() {
        return (io.reactivex.g0.g<T>) f15636d;
    }

    public static <T> io.reactivex.g0.j<T, T> g() {
        return (io.reactivex.g0.j<T, T>) a;
    }

    public static <T> Callable<T> h(T t2) {
        return new o(t2);
    }

    public static <T, U> io.reactivex.g0.j<T, U> i(U u) {
        return new o(u);
    }

    public static <T1, T2, R> io.reactivex.g0.j<Object[], R> j(io.reactivex.g0.c<? super T1, ? super T2, ? extends R> cVar) {
        b.e(cVar, "f is null");
        return new b(cVar);
    }

    public static <T1, T2, T3, R> io.reactivex.g0.j<Object[], R> k(io.reactivex.g0.h<T1, T2, T3, R> hVar) {
        b.e(hVar, "f is null");
        return new c(hVar);
    }

    public static <T1, T2, T3, T4, R> io.reactivex.g0.j<Object[], R> l(io.reactivex.g0.i<T1, T2, T3, T4, R> iVar) {
        b.e(iVar, "f is null");
        return new d(iVar);
    }
}
