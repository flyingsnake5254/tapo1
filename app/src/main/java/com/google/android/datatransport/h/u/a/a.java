package com.google.android.datatransport.h.u.a;

/* compiled from: DoubleCheck.java */
/* loaded from: classes.dex */
public final class a<T> implements d.a.a<T> {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private volatile d.a.a<T> f1894b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f1895c = a;

    private a(d.a.a<T> aVar) {
        this.f1894b = aVar;
    }

    public static <P extends d.a.a<T>, T> d.a.a<T> a(P p) {
        d.b(p);
        return p instanceof a ? p : new a(p);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // d.a.a
    public T get() {
        T t = (T) this.f1895c;
        Object obj = a;
        if (t == obj) {
            synchronized (this) {
                t = this.f1895c;
                if (t == obj) {
                    t = this.f1894b.get();
                    this.f1895c = b(this.f1895c, t);
                    this.f1894b = null;
                }
            }
        }
        return t;
    }
}
