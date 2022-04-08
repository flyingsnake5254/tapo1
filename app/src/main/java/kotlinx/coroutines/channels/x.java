package kotlinx.coroutines.channels;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class x<T> {
    public static final b a = new b(null);

    /* renamed from: b  reason: collision with root package name */
    private final Object f16447b;

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && j.a(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    private /* synthetic */ x(Object obj) {
        this.f16447b = obj;
    }

    public static final /* synthetic */ x a(Object obj) {
        return new x(obj);
    }

    public static Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof x) && j.a(obj, ((x) obj2).f());
    }

    public static int d(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String e(Object obj) {
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f16447b, obj);
    }

    public final /* synthetic */ Object f() {
        return this.f16447b;
    }

    public int hashCode() {
        return d(this.f16447b);
    }

    public String toString() {
        return e(this.f16447b);
    }
}
