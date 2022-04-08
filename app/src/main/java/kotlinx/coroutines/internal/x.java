package kotlinx.coroutines.internal;

import kotlin.TypeCastException;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.w1;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class x {
    private static final t a = new t("ZERO");

    /* renamed from: b  reason: collision with root package name */
    private static final p<Object, f.b, Object> f16495b = a.f16499c;

    /* renamed from: c  reason: collision with root package name */
    private static final p<w1<?>, f.b, w1<?>> f16496c = b.f16500c;

    /* renamed from: d  reason: collision with root package name */
    private static final p<a0, f.b, a0> f16497d = d.f16502c;

    /* renamed from: e  reason: collision with root package name */
    private static final p<a0, f.b, a0> f16498e = c.f16501c;

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes4.dex */
    static final class a extends Lambda implements p<Object, f.b, Object> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f16499c = new a();

        a() {
            super(2);
        }

        /* renamed from: a */
        public final Object invoke(Object obj, f.b element) {
            j.f(element, "element");
            if (!(element instanceof w1)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? element : Integer.valueOf(intValue + 1);
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes4.dex */
    static final class b extends Lambda implements p<w1<?>, f.b, w1<?>> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f16500c = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final w1<?> invoke(w1<?> w1Var, f.b element) {
            j.f(element, "element");
            if (w1Var != null) {
                return w1Var;
            }
            if (!(element instanceof w1)) {
                element = null;
            }
            return (w1) element;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes4.dex */
    static final class c extends Lambda implements p<a0, f.b, a0> {

        /* renamed from: c  reason: collision with root package name */
        public static final c f16501c = new c();

        c() {
            super(2);
        }

        /* renamed from: a */
        public final a0 invoke(a0 state, f.b element) {
            j.f(state, "state");
            j.f(element, "element");
            if (element instanceof w1) {
                ((w1) element).k(state.b(), state.d());
            }
            return state;
        }
    }

    /* compiled from: ThreadContext.kt */
    /* loaded from: classes4.dex */
    static final class d extends Lambda implements p<a0, f.b, a0> {

        /* renamed from: c  reason: collision with root package name */
        public static final d f16502c = new d();

        d() {
            super(2);
        }

        /* renamed from: a */
        public final a0 invoke(a0 state, f.b element) {
            j.f(state, "state");
            j.f(element, "element");
            if (element instanceof w1) {
                state.a(((w1) element).s(state.b()));
            }
            return state;
        }
    }

    public static final void a(f context, Object obj) {
        j.f(context, "context");
        if (obj != a) {
            if (obj instanceof a0) {
                ((a0) obj).c();
                context.fold(obj, f16498e);
                return;
            }
            Object fold = context.fold(null, f16496c);
            if (fold != null) {
                ((w1) fold).k(context, obj);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }

    public static final Object b(f context) {
        j.f(context, "context");
        Object fold = context.fold(0, f16495b);
        if (fold == null) {
            j.n();
        }
        return fold;
    }

    public static final Object c(f context, Object obj) {
        j.f(context, "context");
        if (obj == null) {
            obj = b(context);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return context.fold(new a0(context, ((Number) obj).intValue()), f16497d);
        }
        if (obj != null) {
            return ((w1) obj).s(context);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
    }
}
