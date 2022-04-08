package io.reactivex.internal.util;

import io.reactivex.v;
import java.io.Serializable;

/* loaded from: classes4.dex */
public enum NotificationLite {
    COMPLETE;

    /* loaded from: classes4.dex */
    static final class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.e0.c f16234c;

        a(io.reactivex.e0.c cVar) {
            this.f16234c = cVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f16234c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class b implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final Throwable f16235c;

        b(Throwable th) {
            this.f16235c = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return io.reactivex.h0.a.b.c(this.f16235c, ((b) obj).f16235c);
            }
            return false;
        }

        public int hashCode() {
            return this.f16235c.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f16235c + "]";
        }
    }

    /* loaded from: classes4.dex */
    static final class c implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        final e.b.c f16236c;

        c(e.b.c cVar) {
            this.f16236c = cVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.f16236c + "]";
        }
    }

    public static <T> boolean accept(Object obj, e.b.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            bVar.onError(((b) obj).f16235c);
            return true;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, e.b.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            bVar.onError(((b) obj).f16235c);
            return true;
        } else if (obj instanceof c) {
            bVar.onSubscribe(((c) obj).f16236c);
            return false;
        } else {
            bVar.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(io.reactivex.e0.c cVar) {
        return new a(cVar);
    }

    public static Object error(Throwable th) {
        return new b(th);
    }

    public static io.reactivex.e0.c getDisposable(Object obj) {
        return ((a) obj).f16234c;
    }

    public static Throwable getError(Object obj) {
        return ((b) obj).f16235c;
    }

    public static e.b.c getSubscription(Object obj) {
        return ((c) obj).f16236c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof a;
    }

    public static boolean isError(Object obj) {
        return obj instanceof b;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(e.b.c cVar) {
        return new c(cVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, v<? super T> vVar) {
        if (obj == COMPLETE) {
            vVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            vVar.onError(((b) obj).f16235c);
            return true;
        } else {
            vVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, v<? super T> vVar) {
        if (obj == COMPLETE) {
            vVar.onComplete();
            return true;
        } else if (obj instanceof b) {
            vVar.onError(((b) obj).f16235c);
            return true;
        } else if (obj instanceof a) {
            vVar.onSubscribe(((a) obj).f16234c);
            return false;
        } else {
            vVar.onNext(obj);
            return false;
        }
    }
}
